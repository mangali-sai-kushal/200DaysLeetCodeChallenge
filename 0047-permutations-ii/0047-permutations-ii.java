class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,ans,visited);
        return res;
    }
    void backtrack(int[] nums,List<Integer> ans,boolean[] visited)
    {
        if(ans.size()==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i])
            {
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1])
            {
                continue;
            }
            visited[i]=true;
            ans.add(nums[i]);
            backtrack(nums,ans,visited);
            visited[i]=false;
            ans.remove(ans.size()-1);
        }
    }
}