package acmicpc33516;

import java.io.*;
import java.util.*;

/* skeep 문자열
 * https://www.acmicpc.net/problem/33516
 */

/*
1. 문자를 스택에 넣는다. (뒤에서부터 풀기 위해)
2. 문자를 하나씩 꺼내서 'peeks' 순으로 비교, 맞으면 'X' 로 치환,
  (peek는 치환된 문자여도 되니까, oring해서 'X'도 맞으면 같은 문자로 취급)
  맞지 않으면 saved 스택에 저장
3. peeks순서가 아닌데 s를 만나면 이미 치환된게 있는지 확인
4, 2와3에서 count된 수를 출력.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] skeep = bf.readLine().toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < skeep.length; i++) {
            st.push(skeep[i]);
        }
        int step = 0;
        char[] schar = { 'p', 'e', 'e', 'k', 's' };
        int count = 0;
        Stack<Character> saved = new Stack<>();
        while (!st.isEmpty()) {
            if (st.peek() == schar[step] || st.peek() == 'X' && step < 4) {
                step++;
                if (step == 5) {
                    step = 0;
                    count++;
                    st.pop(); // 를 꺼낸다,
                    st.push('X');
                    for (int i = 0; i < 4; i++) {
                        saved.pop();
                    }
                    // System.out.println(saved);
                    // System.out.println(st);
                }
            } else {
                if (st.peek() == 's') {
                    // System.out.println(saved);
                    // System.out.println(st);
                    boolean isPeek = true;
                    for (int i = 3; i >= 0; i--) {
                        if (!saved.isEmpty()) {
                            char savedTopChar = saved.pop();
                            if (savedTopChar != 'X' && savedTopChar != schar[i]) {
                                isPeek = false;
                                break;
                            }
                        } else {
                            isPeek = false;
                            break;
                        }
                    }
                    if (isPeek) {
                        step = 0;
                        count++;
                        st.pop(); // 를 꺼낸다,
                        st.push('X');
                    }
                }
                step = 0;

            }
            saved.push(st.pop());
        }
        System.out.println(count);
    }
}
