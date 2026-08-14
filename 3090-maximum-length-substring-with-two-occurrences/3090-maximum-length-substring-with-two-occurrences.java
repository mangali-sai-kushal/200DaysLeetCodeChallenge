class Solution {
    public int maximumLengthSubstring(String s) {
        int l=0,r=0;
        int n=s.length();
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<n)
        {
            char ch=s.charAt(r);
           map.put(ch,map.getOrDefault(ch,0)+1);
           while(map.get(ch)>2)
           {
              char left=s.charAt(l);
              if(map.get(left)==1)
              {
                map.remove(left);
              }
              else{
                map.put(left,map.get(left)-1);
              }
              l++;
              
           }   
           
           max=Math.max(max,r-l+1);
           r++;
        }
        return max;
        
    }
}