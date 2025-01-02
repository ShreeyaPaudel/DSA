import java.util.List;
import java.util.ArrayList;

public class AdjMatrix {
    int [][] matrix;
    int vertices;

    AdjMatrix(int vertices){
        this.vertices=vertices;
        matrix=new int [vertices][vertices];
    }

    void addEdges(int u, int v){
        matrix[u][v]=1;
        matrix[v][u]=1;

    }

    void printGraph(){
        for(int i = 0; i<vertices;i++){
            // row
            System.out.print(i+ " is connected to ");
            for (int j = 0; j<vertices;j++){
                // column
                if (matrix[i][j]!=0){
                    // i, j are connected 
                    System.out.print(j+ ",");
                }
            }
            System.out.println();
        }
    }

    List<Integer> getAdjNodes(int i){
    List<Integer> adjNodes = new ArrayList<>();
    for (int j = 0; j<vertices;j++){
        // column
        if (matrix[i][j]!=0){
            // i, j are connected 
            adjNodes.add(j);
        }
    }
    return adjNodes;
   

    }

    //print matrix

    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix(5);
        adj.addEdges(0,1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        adj.printGraph();
    }
    
}
