class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        StringBuilder ans=new StringBuilder();
        backtrack(0,0,ans,n);
        return res;
    }
    public void backtrack(int open,int close,StringBuilder ans,int n)
    {
        if(ans.length()==2*n)
        {
            res.add(ans.toString());
            return;
        }
          if(open <n)
          {
            ans.append("(");
            backtrack(open+1,close,ans,n);
            ans.deleteCharAt(ans.length()-1);
          }
          if(close<open)
          {
            ans.append(")");
            backtrack(open,close+1,ans,n);
            ans.deleteCharAt(ans.length()-1);
          }
        
    }
}