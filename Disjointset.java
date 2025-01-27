public class  Disjointset{
    int size[];
    int parent [];
    int vertices;
    Disjointset (int vertices){
        this.vertices=vertices;
        size = new int[vertices];
        parent = new int[vertices];
        for( int i = 0 ; i < vertices; i++){
            parent[i ]=-1;
        }
    }

   //  void addEdge (u, v){
   // matrix 
   //}

    void findCycle(int u , int v){
        int uabsroot = find(u);
        int vabsroot = find (v);
        if(uabsroot == vabsroot){
            System.out.println("cycle detected");
        }else{
        // add edge to grah
            union (uabsroot, vabsroot);
        }
    }

        void union (int uabsroot, int vabsroot){
            if(size [uabsroot] > size[vabsroot]){
                parent[vabsroot] =uabsroot;

            }else if (size[uabsroot]<size [vabsroot]){
                parent [uabsroot] =vabsroot;
            }
            else{
                parent[uabsroot] = vabsroot;
                size[vabsroot]++;
            }
        
        


        } 

    int find (int u ){
        if(parent[u]==-1){
            return u;
        }
        return parent[u] = find (parent [u]);
    }


    public static void main(String[] args) {
        Disjointset d = new Disjointset(4);
        d.findCycle(1, 3);
        d.findCycle(3, 2);
        d.findCycle(0, 2);
    }
}


