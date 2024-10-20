package prog60058;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */

public class MyMain {
    public static void main(String[] args) {
        String[] pArr = { "()))((()" /* "(()())()" , ")(", "()))((()" */ };
        Solution mSolution = new Solution();
        for (String p : pArr) {
            System.out.println("final result " + mSolution.solution(p));
        }
    }
}

class Solution {
    public String solution(String p) {
        String answer = "";
        System.out.println(p);
        answer = strHandle(p);
        return answer;
    }

    String strHandle(String w) {
        String result = "";
        String u = "";
        String v = "";

        // System.out.println("strHandle : " + w);

        if (w.length() == 0) { // 1
            // System.out.println(w + " - result: " + result);
            return w;
        } else {
            int braceNum = 0;
            u = "";
            for (char c : w.toCharArray()) {
                if (c == '(') {
                    braceNum++;
                } else if (c == ')') {
                    braceNum--;
                }
                u += c;
                if (braceNum == 0) { // 3
                    v = w.substring(u.length(), w.length());
                    if (isCorrect(u)) {
                        result += u + strHandle(v);
                        // System.out.println(w + " - result: " + result);
                        return result;
                    } else {// 4
                        result += '(' + strHandle(v) + ')' + handleU(u);
                        u = "";
                        return result;
                    }
                }
            }
        }
        v = w.substring(u.length(), w.length());

        // System.out.println(w + " - result: " + result);
        return result;
    }

    String handleU(String u) {
        String result = "";
        if (u.length() < 2) {
            return result;
        }

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                result += ')';
            } else {
                result += '(';
            }
        }

        // System.out.println("handleU : " + result);
        return result;
    }

    boolean isCorrect(String w) {
        int braceNum = 0;
        boolean result = true;
        for (char c : w.toCharArray()) {
            if (c == '(') {
                braceNum++;
            } else if (c == ')') {
                braceNum--;
            }
            if (braceNum < 0) {
                result = false;
                break;
            }
        }

        // System.out.println(w + " isCorrect: " + result);
        return result;
    }
}