import com.sun.tools.javac.util.Pair;

import java.util.*;

public class Test {
    private static int maxCoin = Integer.MIN_VALUE;

    public static int maxCoins(int[] nums) {
        List<Integer> result = new ArrayList();
        boolean[] used = new boolean[nums.length];
        helper(result,0,used,nums);
        return maxCoin;
    }

    private static void helper(List<Integer> result, int curMaxCoin , boolean[] used, int[] nums){
        if (result.size() == nums.length){
            maxCoin = Math.max(maxCoin, curMaxCoin);
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (used[i] == true){
                continue;
            }
            used[i] = true;
            result.add(nums[i]);
            int left = i-1 ,right = i + 1;
            while(left > -1){
                if (used[left] == false){
                    break;
                }
                left--;
            }
            left = left == -1? 1 : nums[left];
            while(right < nums.length){
                if (used[right] == false){
                    break;
                }
                right++;
            }
            right = right == nums.length? 1 : nums[right];
            helper(result, curMaxCoin + left * nums[i] * right, used, nums);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        int[] nums = {3,1,5,8};
        int res = maxCoins(nums);
        System.out.println(res);
    }
}
