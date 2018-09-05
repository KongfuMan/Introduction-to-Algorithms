import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {
    public static int getTopK(int[] nums, int k){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (integer == t1){
                    return 0;
                }else if (integer < t1){
                    return 1;
                }
                return -1;
            }
        };
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(k,comparator);
        for (int i : nums){
            if (que.size() < k){
                que.offer(i);
            }else if (i < que.peek()){
                que.poll();
                que.offer(i);
            }
        }

        return que.peek();
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(getTopK(nums,2));
        HashMap<Integer,Integer> s;
        Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> integerIntegerEntry, Map.Entry<Integer, Integer> t1) {
                return 0;
            }
        };
    }
}
