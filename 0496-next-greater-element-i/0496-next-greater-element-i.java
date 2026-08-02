class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        int m=nums2.length;
        map.put(nums2[m-1],-1);
        Stack<Integer> s=new Stack<Integer>();
        s.push(nums2[m-1]);
        int i=m-2;
        while(i >= 0)
{
    int ele = nums2[i];

    while(!s.isEmpty() && ele >= s.peek())
    {
        s.pop();
    }

    if(s.isEmpty())
    {
        map.put(ele, -1);
    }
    else
    {
        map.put(ele, s.peek());
    }

    s.push(ele);
    i--;
}
        for( i=0;i<nums1.length;i++)
        {
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}