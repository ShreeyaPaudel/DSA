import java.util.*;

public class LFUCaching {
    static class Node {
        int key, value, frequency;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCaching(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (keyToNode.size() == capacity) {
                evictLFU();
            }
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFrequency = 1;
        }
    }

    private void updateFrequency(Node node) {
        int freq = node.frequency;
        freqToKeys.get(freq).remove(node.key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFrequency) {
                minFrequency++;
            }
        }
        node.frequency++;
        freqToKeys.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node.key);
    }

    private void evictLFU() {
        LinkedHashSet<Integer> keys = freqToKeys.get(minFrequency);
        int keyToRemove = keys.iterator().next(); // Remove the first key in the set
        keys.remove(keyToRemove);
        if (keys.isEmpty()) {
            freqToKeys.remove(minFrequency);
        }
        keyToNode.remove(keyToRemove);
    }

    public static void main(String[] args) {
        LFUCaching cache = new LFUCaching(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);                  // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        cache.put(4, 4);                  // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
}
}