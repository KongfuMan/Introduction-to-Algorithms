public class moveZeros {
    public static void movezeroes(int[] a){
        int len = a.length;
        int i = 0, j = 0;
        while(i < len && j < len){
            if (a[i] != 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
    }

    public static void partitionArray(int[] a, int pivot){
        int len = a.length;
        int i = 0, j = 0;
        while(i < len ){
            if (a[i] <= pivot){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
    }

}
