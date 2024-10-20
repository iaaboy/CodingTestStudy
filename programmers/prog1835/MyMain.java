package prog1835;

import java.util.*;

/* 단체사진 찍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/1835
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 2, 2 };
        String[][] data = {
                { "M~C<2", "C~M>1" },
                { "N~F=0", "R~T>2" },
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(mSol.solution(n[i], data[i]));
        }
    }
}

class Solution {
    String[] data;
    List<Character> mem;
    int count;

    public int solution(int n, String[] data) {
        this.data = data;
        count = 0;
        mem = Arrays.asList('A', 'C', 'F', 'J', 'M', 'N', 'R', 'T');
        journey(mem, 0);
        return count;
    }

    void journey(List<Character> sequence, int depth) {
        if (sequence.size() - 1 == depth) {
            // System.out.println(sequence);
            if (checkMember(sequence)) {
                count++;
            }
            // System.out.println("count:" + count + "-");
            return;
        }

        for (int i = depth; i < sequence.size(); i++) {
            swap(sequence, depth, i);
            journey(sequence, depth + 1);
            swap(sequence, depth, i);
        }
    }

    private boolean checkMember(List<Character> sequence) {
        boolean result = true; // { "M~C<2", "C~M>1" },
        for (String d : data) {
            int diff = Math.abs(sequence.indexOf(d.charAt(0)) - sequence.indexOf(d.charAt(2)));
            diff--;
            int givenDiff = d.charAt(4) - '0';
            // System.out.println(diff + ":" + d);
            if (d.charAt(3) == '=') {
                if (diff != givenDiff) {
                    return false;
                }
            } else if (d.charAt(3) == '>') {
                if (!(diff > givenDiff)) {
                    return false;
                }
            } else { // '<'
                if (!(diff < givenDiff)) {
                    return false;
                }
            }
        }
        return result;
    }

    void swap(List<Character> sequence, int a, int b) {
        char temp = sequence.get(a);
        sequence.set(a, sequence.get(b));
        sequence.set(b, temp);
    }
}