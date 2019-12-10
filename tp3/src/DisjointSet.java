public class DisjointSet {
    private int[] array;
    public DisjointSet(int nElts){
        array = new int[nElts];
        for(int i = 0; i< array.length; i++){
            array[i] = -1;
        }
    }

    public void union(int root1, int root2){
        if (array[root2] < array[root1]) {
            array[root1] = root2;
        }else {
            if(array[root1] == array[root2]){ array[root1]--;}
            array[root2]=root1;
        }
    }
    public int find(int x){
        if(array[x] < 0){
            return x;
        }
        int next = x;
        while(array[next]>0){
            next = array[next];
        }
        return next;
    }
    public int[] getArray() {
        return array;
    }
}
