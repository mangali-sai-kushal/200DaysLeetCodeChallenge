class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int size = n * n;

        HashMap<Integer, Integer> map = new HashMap<>();

        int repeated = -1;
        int missing = -1;

        // Count frequencies
        for (int[] row : grid) {
            for (int num : row) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        // Find repeated and missing
        for (int i = 1; i <= size; i++) {

            if (map.getOrDefault(i, 0) == 2) {
                repeated = i;
            }

            if (!map.containsKey(i)) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}