package prog60058;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */
/*

"균형잡힌 괄호 문자열"
"올바른 괄호 문자열"

1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 
  단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 

3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 

4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
 4-3. ')'를 다시 붙입니다. 
 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
 4-5. 생성된 문자열을 반환합니다.
 */

public class MyMain {
    public static void main(String[] args) {
        String[] pArr = {"()))((()" /* "(()())()" , ")(", "()))((()" */ };
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

        for (int i = 1; i < u.length() - 1 ; i++) {
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