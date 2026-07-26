class Solution {

    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int prev;

            if (level % 2 == 0)
                prev = Integer.MIN_VALUE;
            else
                prev = Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {

                TreeNode cur = q.poll();

                if (level % 2 == 0) {

                    // must be odd
                    if (cur.val % 2 == 0)
                        return false;

                    // strictly increasing
                    if (cur.val <= prev)
                        return false;

                } else {

                    // must be even
                    if (cur.val % 2 == 1)
                        return false;

                    // strictly decreasing
                    if (cur.val >= prev)
                        return false;
                }

                prev = cur.val;

                if (cur.left != null)
                    q.offer(cur.left);

                if (cur.right != null)
                    q.offer(cur.right);
            }

            level++;
        }

        return true;
    }
}