// the total comparison time is 3*n/2
public class findMinMax {
    public int max;
    public int min;

    public void findMinAndMax(int[] nums){
        int n = nums.length;
        if (n < 2){
            this.max = nums[0];
            this.min = nums[0];
            return;
        }

        if (n % 2 == 0){    //n is even
            this.max = Math.max(nums[0],nums[1]);
            this.min = Math.min(nums[0],nums[1]);
        }else{
            this.max = this.min = nums[0];
        }
        for (int i = n % 2 == 0? 2 : 1; i < n - 1; i += 2){
            if (nums[i] > nums[i+1]){
                this.max = Math.max(this.max,nums[i]);
            }else{
                this.min = Math.min(this.min,nums[i+1]);
            }
        }
    }
}
