package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    //assume that source is already sorted
    public int binarySearch(int[] source, int target){
        int start = 0, end = source.length - 1;
        while (start + 1 < end){
            int mid = start + ( end - start ) / 2;  // don't use (end + start) / 2, avoid overflow
            if (target == source[mid]){
                return mid;
            }else if (target < source[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (source[start] == target ){
            return start;
        }

        if (source[end] == target ){
            return end;
        }

        return -1;
    }
}
/*
证明：loop-invariant:
initialization: target in is source, and source[left] <= target <= source[right]
Maintenance:If it is true before an iteration of the loop, it remains true before the
next iteration.
Termination: the target must be in source[left,right]. So we check left and right to see if it equals target
 */
