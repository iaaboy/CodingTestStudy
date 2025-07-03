package acmicpc12904;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static StringBuilder current = new StringBuilder();
    static StringBuilder end = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (char c : bf.readLine().toCharArray()) {
            current.append(c);
        }

        end = new StringBuilder(bf.readLine());

        boolean isPossible = goNext(true, current.length());
        System.out.println((isPossible ? 1 : 0));
    }

    static boolean isPossible = false;
    static HashSet<String> visited = new HashSet<>();

    private static boolean goNext(boolean isFoward, int size) {
        if (isFoward) {
            System.out.println(current);
        } else {
            System.out.println(current.reverse());
        }
        if (end.length() == size) {
            // if (size == 3) {
            // check

            return false;
        }

        // if (visited.contains(current.toString())) {
        // return false;
        // }

        // 문자열의 뒤에 A를 추가한다.
        if (isFoward) {
            current.append('A');
            visited.add(current.toString());
            if (goNext(isFoward, size + 1)) {
                return true;
            }
            current.deleteCharAt(current.length() - 1);

        } else {
            current.insert(0, 'A');
            visited.add(current.toString());
            if (goNext(isFoward, size + 1)) {
                return true;
            }
            current.deleteCharAt(0);
        }

        // 문자열을 뒤집고 뒤에 B를 추가한다.
        if (isFoward) {
            current.insert(0, 'B');
            if (goNext(!isFoward, size + 1)) {
                return true;
            }
            current.deleteCharAt(0);
        } else {
            current.append('B');
            if (goNext(!isFoward, size + 1)) {
                return true;
            }
            current.deleteCharAt(current.length() - 1);
        }
        return false;
    }
}
