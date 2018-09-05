import BinarySearch.BinarySearch;
import BinarySearch.ListNode;
import BinarySearch.TreeNode;
//import BinarySearch.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

import BinarySearch.ListNode;
import UDFStack.QueueByTwoStacks;
import UDFStack.minStack;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.corba.se.impl.orbutil.graph.NodeData;
import com.sun.corba.se.impl.orbutil.threadpool.ThreadPoolImpl;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import com.sun.tools.javac.util.Pair;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static BinarySearch.MainClass.*;

public class Main {
    public static void test(List<Integer> lst){
        lst.add(5);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            Solution sol = new Solution();
            boolean res = sol.isValidBST(root);
            int i = 1;
////            int[] heights = {2,1,5,6,2,3};
////            int res = sol.largestRectangleArea(heights);
////            String out = String.valueOf(res);
////            System.out.print(res);
        }
//        int[] arr = new int[2];
//        System.out.print(4^4);
//        Deque<Integer> deque = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        test(list);
        System.out.println(list);


//        int[] a = new int[10];
//        int i = 0;
//        while (i < 10){
//            a[i++] = new Random().nextInt(20);
//        }
//        System.out.print(Arrays.toString(a) + "\n");
//        moveZeros.partitionArray(a,10);
//        System.out.print(Arrays.toString(a));
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(2);
//        map.put("1",11);
//        System.out.println(map.put("1",12));
//        map.put("2", 21);
//        System.out.println(map.put("2",22));
//        map.put("3",31);
//        System.out.println(map.put("3",32));

//        int i = 1;
//        HashMap<Integer, List<Integer>> neighbors = new HashMap();
//        neighbors.put(1,new ArrayList());
//        List<Integer> list = neighbors.get(1);
//        list.add(1);
//        list.add(2);
//        Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
//                return 0;
//            }
//        };
//        String s1 = "lovf", s2 = "love";
//        System.out.println(s2.compareToIgnoreCase(s1));
//    }
    }
}
