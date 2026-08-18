class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: Only one subarray exists
        if (k == n) {
            int max = -1;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Case 2: Every element itself is a subarray
        if (k == 1) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int ans = -1;

            for (int num : nums) {
                if (map.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 3: 1 < k < n
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;

        // First element
        if (map.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        // Last element
        if (map.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}