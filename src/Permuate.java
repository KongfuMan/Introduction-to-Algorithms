import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permuate {
    public List<List<Integer>> permuate(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuate(result,new ArrayList<Integer>(),nums,new boolean[nums.length]);
        return result;
    }

    private void permuate(List<List<Integer>> result,
                          List<Integer> onepermutation,
                          int[] nums,
                          boolean[] used
                          ){
        if ( onepermutation.size() == nums.length ) {                 // after all elements are added to onepermutation, then can we
            result.add(new ArrayList<Integer>(onepermutation));       // add onepermutation to result
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }

            onepermutation.add(nums[i]);
            used[i] = true;
            permuate(result,onepermutation,nums,used);
            onepermutation.remove(onepermutation.size()-1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ( nums == null || nums.length == 0 ){
            return result;
        }
        Arrays.sort(nums);
        permuteUniquelist(result,new ArrayList<Integer>(),nums,new boolean[nums.length],false);
        return result;
    }


    public void permuteUniquelist(List<List<Integer>> result,
                                  List<Integer> onepermute,
                                  int[] nums,
                                  boolean[] isused,
                                  boolean repeatcheck
                                 ){

        for ( int i = 0; i < nums.length; i++ ){
            if ( isused[i] ){
                continue;
            }
            if ( i > 0 && nums[i] == nums[i-1] && isused[i-1] == false ){   //avoid the repeated elements along the breadth
                continue;                           //, but not avoid along the depth
            }
            isused[i] = true;
            onepermute.add(nums[i]);
            repeatcheck = true;
            permuteUniquelist(result,onepermute,nums,isused,false);
            isused[i] = false;
            onepermute.remove(onepermute.size() - 1);
        }

        if (onepermute.size() == nums.length){
            result.add(new ArrayList<Integer>(onepermute));
            return;
        }
    }
}
