import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class findAllSubsets {

    public void repeatedsubsetHelper(ArrayList<Integer> subset,
                                     ArrayList<ArrayList<Integer>> result,
                                     int[] nums,
                                     int pos
                                    ){
        Arrays.sort(nums);
        subsetHelper(subset,result,nums,pos);
    }

    /*param: subset: store the subset represented by the recursion tree node
                     initial value is empty
             nums: store the original list. (must be sorted if nums have repeated elements)
             pos: index that loop begin with. guarantee that
    */
    private void subsetHelper(ArrayList<Integer> subset,
                             ArrayList<ArrayList<Integer>> result,
                             int[] nums,
                             int pos
                                    ){
        result.add(new ArrayList<Integer>(subset));
        for ( int i = pos; i < nums.length; i++ ){
            if (i != pos && nums[i] == nums[i-1]){  // the first element must be used, if k repeated elements used at
                continue;                           // the same time, only the first k elements can be used
            }
            subset.add(nums[i]);
            subsetHelper(subset, result, nums,i+1);
            subset.remove(subset.size()-1);
        }
    }

    /*
        basic idea: the subset of [a0,a1,a2,,,,ak] must also be the subset of [a0,a1,a2,,,,ak,ak+1]
     */
    public ArrayList<ArrayList<Integer>> findsubsetsimple(int[] nums){
        if (nums.length == 1){
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            result.add(new ArrayList<Integer>(nums[0]));
            return result;
        }

        Integer last = nums[nums.length-1];
        int[] newnums = Arrays.copyOfRange(nums,0,nums.length-1);
        ArrayList<ArrayList<Integer>> result = findsubsetsimple(newnums);
        int resultlen = result.size();
        for ( int i = 0; i < resultlen; i++ ){
            ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
            temp.add(last);
            result.add(temp);
        }

        return result;
    }
}
