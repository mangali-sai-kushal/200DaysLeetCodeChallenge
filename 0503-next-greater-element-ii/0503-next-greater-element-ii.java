class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int n=nums.length;
        stk.push(nums[n-1]);
        int[] res=new int[n];
        for(int i=2*n-1;i>=0;i--)
    {
        while( !stk.isEmpty() && nums[i%n]>=stk.peek())
        {
            stk.pop();
        }
        if(i<n)
        {
            res[i%n]=stk.isEmpty()?-1:stk.peek();
        }
        stk.push(nums[i%n]);


        
    }
    return res;
        
    }
}