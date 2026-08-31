class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,ans);
        return res;
    }
    public void backtrack(int cur,int[] nums,List<Integer> ans)
    {
    
            res.add(new ArrayList<>(ans));
            
        for(int i=cur;i<nums.length;i++)
        {
           if(i>cur && nums[i]==nums[i-1])
           {
             continue;
           }
            ans.add(nums[i]);
            backtrack(i+1,nums,ans);
            ans.remove(ans.size()-1);
        }
    }
}