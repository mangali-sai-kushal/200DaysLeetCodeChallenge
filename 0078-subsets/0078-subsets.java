class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        backtrack(0,nums,ans);
        return res;
    }
    public void backtrack(int cur,int[] nums,List<Integer> ans)
    {
        if(cur==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[cur]);
        backtrack(cur+1,nums,ans);
        ans.remove(ans.size()-1);
        backtrack(cur+1,nums,ans);


    }
}