class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s=preorder.split(",");
        int slots=1;
        for(String cur:s)
        {
            slots--;
            if(slots<0)
            {
                return false;
            }
            if(!cur.equals("#"))
            {
             slots+=2;
            }
        }
        return slots==0;
        
    }
}