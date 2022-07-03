import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                s.push(Integer.parseInt(token));
            } else {
                int num2 = s.pop();
                int num1 = s.pop();
                switch (token) {
                    case "+":
                        s.push(num1 + num2);
                        break;
                    case "-":
                        s.push(num1 - num2);
                        break;
                    case "*":
                        s.push(num1 * num2);
                        break;
                    case "/":
                        s.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return s.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
