package prog17683;

/* [3차] 방금그곡
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683
 */
public class MyMain {
    public static void main(String[] args) {
        String m = "A";
        String[] musicinfos = {
                "12:00,12:01,Sing,A", "12:00,12:02,Song,A"
        };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(m, musicinfos));
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxLength = 0;
        StringBuilder my = new StringBuilder();

        for (int i = 0; i < m.length(); i++) {
            if (i + 1 < m.length() && m.charAt(i + 1) == '#') {
                my.append(Character.toLowerCase(m.charAt(i)));
                i++;
            } else {
                my.append(m.charAt(i));
            }
        }
        // System.out.println(my);

        for (String mInfo : musicinfos) {
            String[] info = mInfo.split(",");
            int duration = getTime(info[1]) - getTime(info[0]);
            StringBuilder currentMusic = new StringBuilder();
            int cLength = info[3].length();
            int curIndex = 0;

            for (int i = 0; i < duration; i++) {
                if (curIndex + 1 < cLength && info[3].charAt(curIndex + 1) == '#') {
                    currentMusic.append(Character.toLowerCase(info[3].charAt(curIndex)));
                    curIndex += 2;
                } else {
                    currentMusic.append(info[3].charAt(curIndex));
                    curIndex++;
                }
                if (curIndex >= cLength) {
                    curIndex = 0;
                }
            }
            // System.out.println(currentMusic.toString());
            if (currentMusic.toString().contains(my)) {
                if (maxLength < currentMusic.length()) {
                    maxLength = currentMusic.length();
                    answer = info[2];
                }
            }
        }

        return answer;
    }

    private int getTime(String time) {
        String[] t = time.split(":");
        int minute = Integer.parseInt(t[0]) * 60;
        int second = Integer.parseInt(t[1]);
        return minute + second;
    }
}