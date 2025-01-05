import java.util.List;
import java.util.ArrayList;

public class AdjList {
    SingleLinkedList adjlist[];
    int vertices;

    AdjList(int vertices){
        this.vertices = vertices;
        adjlist = new SingleLinkedList[vertices];
        for (int i=0; i<vertices; i++){
            adjlist[i] = new SingleLinkedList();
        }
    }

    void addEdges(int u, int v){
        adjlist[u].addNode(v);
        adjlist[v].addNode(u);
    }

    List<Integer> getAdjNodes(int i){
        List<Integer> adjNodes = new ArrayList<>();
        SingleLinkedList.Node current=adjlist[i].head;
        while (current!=null){
            adjNodes.add(current.data);
            current = current.next;

        }
        return adjNodes;
    }


 

    void printGraph(){
        for (int i = 0; i<vertices ; i++){
            System.out.println(i + " is connected to ");
            SingleLinkedList.Node current=adjlist[i].head;
            while(current!=null){
                System.out.println(current.data);
                current=current.next;

            }
            System.out.println();
        }
    }

    void depthfirstsearch(int source){
        boolean visited[]=new boolean[vertices];
        dfs(source, visited);
    }

    void dfs(int rootnode, boolean [] visited){
        System.out.println(rootnode);
        visited [rootnode]=true;
        // getadjnodes and traverse through list
        SingleLinkedList.Node current=adjlist[rootnode].head;
        while (current!=null){
            if(!visited [current.data]){
                dfs(current.data, visited);
            }
            current = current.next;

        }

    }

    public static void main(String[] args) {
        AdjList adj = new AdjList(5);
        adj.addEdges(0,1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        adj.printGraph();
    }

    
}
