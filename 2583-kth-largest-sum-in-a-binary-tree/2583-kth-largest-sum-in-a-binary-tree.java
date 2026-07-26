/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        PriorityQueue<Long> pq=new PriorityQueue();
        while (!q.isEmpty()) {

            int n = q.size();
            long sum=0;

            for (int i = 0; i < n; i++) {

                TreeNode cur = q.poll();
              sum+=cur.val;
                
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            pq.add(sum);
            if(pq.size() >k)
            {
                 pq.poll();
            }
        }
        if(pq.size() <k)
        {
            return -1;
        }

        return pq.peek();
        
    }
}