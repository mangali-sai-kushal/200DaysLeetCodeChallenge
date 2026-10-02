import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stk = new Stack<>();

        for (int num : asteroids) {

            while (!stk.isEmpty() && stk.peek() > 0 && num < 0) {

                // Stack asteroid is smaller
                if (stk.peek() < -num) {
                    stk.pop();
                }

                // Both are same size
                else if (stk.peek() == -num) {
                    stk.pop();
                    num = 0;
                    break;
                }

                // Current asteroid is smaller
                else {
                    num = 0;
                    break;
                }
            }

            // Current asteroid survived
            if (num != 0) {
                stk.push(num);
            }
        }

        int[] result = new int[stk.size()];

        for (int i = 0; i < stk.size(); i++) {
            result[i] = stk.get(i);
        }

        return result;
    }
}