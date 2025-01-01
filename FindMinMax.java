public class FindMinMax {

    public class Pair{
        int min;
        int max;
        Pair(int min, int max){
            this.min = min;
            this.max = max;
        }

    }



    Pair findMinMax(int a[], int s , int e){
        if(s==e){
            // single element
            return new Pair(a[s], a[s]);

        }
        if(s+1==e){
            // teo elements
            if(a[s]>a[e]){
                return new Pair(a[e], a[s]);
            }
            else{
                return new Pair(a[s], a[e]);
            }
        }
        int mid = (s+e)/2;
        Pair leftpair= findMinMax(a, s, mid);
        Pair rightpair = findMinMax(a, mid+1, e);
        int overallmin = Math.min(leftpair.min, rightpair.min);
        int overallmax = Math.max(leftpair.max, rightpair.max); 
        return new Pair(overallmin, overallmax);


    }
    
}
