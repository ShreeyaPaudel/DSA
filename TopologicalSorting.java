public class TopologicalSorting {

    int toposort(int adjmatrix[][], int v){
        int indegree[]=new int[v];
        Queue q=new Queue(v);

        //calc indegree
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(adjmatrix[i][j]!=0){
                    indegree[j]++;
                }
            }
        }

        //queue ma add garna paryo
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.enqueue(i);
            }
        }

        int cnt =0;

        while(!q.isEmpty()){
            cnt++;
            int x = q.dequeue();
            System.out.println(x); //result
            for (int j=0;j<v;j++){
                if(adjmatrix[x][j]!=0){
                    indegree[j]--;
                    if (indegree[j]==0){
                        q.dequeue();
                    }
                }
            }
        }

        if(cnt!=v){
            System.out.println("cycle detected");
            return 1;
        }
        return- 1;
    }

}
