package prog17686;

import java.util.Arrays;

/* 파일명 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */

public class MyMain {
    public static void main(String[] args) {
        String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(files)));
    }
}

class Solution {
    public String[] solution(String[] files) {
        KeyInfo[] index = new KeyInfo[files.length];
        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            index[i] = getNum(files[i], i);
        }

        Arrays.sort(index, (a, b) -> {
            if (Arrays.equals(a.head, b.head)) {
                if (a.num == b.num) {
                    return a.index - b.index;
                } else {
                    return a.num - b.num;
                }
            } else {
                int count = Math.min(a.head.length, b.head.length);
                for (int i = 0; i < count; i++) {
                    if (a.head[i] > b.head[i]) {
                        return 1;
                    } else if (a.head[i] < b.head[i]) {
                        return -1;
                    }
                }
                return a.head.length - b.head.length;
            }
        });

        // System.out.println(Arrays.toString(index));

        for (int i = 0; i < answer.length; i++) {
            answer[i] = files[index[i].index];
        }

        return answer;
    }

    private KeyInfo getNum(String file, int index) {
        String[] a = file.split("\\d+");
        String head = a[0].toLowerCase();

        int number = 0;
        for (int i = head.length(); i < file.length(); i++) {
            char ch = file.charAt(i);
            if (ch >= '0' && ch <= '9') {
                number *= 10;
                number += (ch - '0');
            } else {
                break;
            }
        }
        return new KeyInfo(head.toCharArray(), number, index);
    }

    class KeyInfo {
        char[] head;
        int num;
        int index;

        public KeyInfo(char[] head, int num, int index) {
            this.head = head;
            this.num = num;
            this.index = index;
        }

        @Override
        public String toString() {
            return Arrays.toString(head) + ":" + num + "," + index + "\n";
        }
    }
}