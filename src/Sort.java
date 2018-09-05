import java.util.List;
import java.util.Random;

public class Sort {
    public Random rand;
    public void sortIntegers2(int[] A) {
        rand = new Random();
        quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] list, int start, int end){
        if (start >= end){  //termination condition
            return;
        }

        int index = rand.nextInt(end - start + 1)  + start;
        int pivot = list[index];     //find the middle element
        int left = start, right = end;
        while(left <= right){
            while (left <= right && list[left] < pivot){
                left++;
            }

            while (left <= right && list[right] > pivot){
                right--;
            }

            if (left <= right){
                int temp = list[left];
                list[left] = list[right];
                list[right] = temp;
                left++;
                right--;
            }
        }

        //最后left和right的关系有两种情况，要么left == right 要么 right+1 == left
        quickSort(list,start,right);
        quickSort(list,left,end);
    }
}
