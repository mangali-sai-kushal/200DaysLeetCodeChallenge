class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s=new Stack<Integer>();
        int n=nums.length;
        int[] ans=new int[n];

        for(int i=2*n-1;i>=0;i--)
        {
            int cur=nums[i%n];
            while(!s.isEmpty() && cur>=s.peek())
            {
                s.pop();
            }
            if(s.isEmpty())
            {
             ans[i%n]=-1;   
            }else{
                ans[i%n]=s.peek();
            }
            s.push(cur);

        }
        return ans;
    }
}