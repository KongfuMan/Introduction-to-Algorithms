package BinarySearch;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    public List<TreeNode> bfs(TreeNode head){
        List<TreeNode> result = new ArrayList();
        if (head == null){
            return result;
        }

        Queue<TreeNode> que = new LinkedList();
        que.offer(head);
        while(!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++){
                TreeNode node = que.poll();
                result.add(node);
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
            }
        }

        return result;
    }

}
