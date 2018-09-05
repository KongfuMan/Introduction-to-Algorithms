package BinarySearch;

// find median of two sorted arrays
public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1 == null || nums2 == null ){
            return 0.0;
        }
        int len = nums1.length + nums2.length;
        if (len % 2 == 0){
            return findkthvalue(nums1,0,nums2,0,len / 2) + findkthvalue(nums1,0,nums2,0,len / 2 + 1);
        }
        else{
            return findkthvalue(nums1,0,nums2,0, (len + 1) / 2);
        }

    }

    public int findkthvalue(int[] nums1, int start1, int[] nums2,int start2,int k){
        if (start1 >= nums1.length){    //nums1 is running out of elements
            return nums2[start2 + k - 1];
        }

        if (start2 >= nums2.length){    //nums2 is runing out of elements
            return nums1[start1 + k - 1];
        }

        if (k == 1){        //termination condition
            return Math.min(nums1[start1], nums2[start2]);
        }

        int nums1_key = k / 2 > nums1.length? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];   // nums1 has less element than k/2
        int nums2_key = k / 2 > nums2.length? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];   // then no matter whether nums[p]
                                                                                               // is larger or smaller than nums[k/2], B[0-k/2] is in the first k
        if(nums1_key <= nums2_key){
            return findkthvalue(nums1,start1 + k / 2, nums2,start2, k - k / 2); //drop the first k elements of nums1
        }
        else{
            return findkthvalue(nums1,start1, nums2,start2+ k / 2, k - k / 2);  //...nums2
        }
    }
}
