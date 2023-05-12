package prog42860;

public class MyMain {
    public static void main(String[] args) {
        String[] inStr = { "LABLPAJM" };
        Solution mSol = new Solution();

        for (String s : inStr) {
            System.out.println("answer:" + mSol.solution(s));
        }
    }
}

class Solution {

    // 커서를 위/아로 누름 계산하는 테이블
    int[] transTable = new int['Z' - 'A' + 1];

    public int solution(String name) {
        int reversNum = 26;// alphabet숫자
        for (int i = 0; i < transTable.length; i++) {
            transTable[i] = i < reversNum ? i : reversNum;
            reversNum--;
        }

        int[] inTable = new int[name.length() * 2];
        int index = 0;
        int targetCount = 0;
        for (char c : name.toCharArray()) {
            inTable[index + name.length()] = inTable[index++] = transTable[c - 'A'];
            if (c != 'A') {
                targetCount++;
            }
        }

        // System.out.println(name + ": " + Arrays.toString(inTable) + "," +
        // targetCount);

        //////////////////////////////
        // 센터에서 오른쪽으로 가는 수 계산.
        int countRight = 0;
        for (int i = 0; i < name.length(); i++) {
            System.out.print(inTable[i] + " ");
            if (inTable[i] > 0) {
                countRight++;
            }
            if (targetCount == countRight) {
                countRight = i;
                // System.out.println("lastIdx R: " + i);
                break;
            }
        }

        // 센터에서 왼쪽으로 가는 수 계산.
        int countLeft = 0;
        for (int i = name.length(); i >= 0; i--) {
            System.out.print(inTable[i + name.length() - 1] + " ");
            if (inTable[i] > 0) {
                countLeft++;
            }
            if (targetCount == countLeft) {
                // System.out.println("lastIdx L: " + (name.length() - i));
                countLeft = name.length() - i;
                break;
            }
        }

        // 센터를 중심으로 가장 먼 수 계산.
        ///////////////////////////////
        int startIdx = name.length() - 1;
        int backPtr = 0;
        int totalCount = 0;
        if (inTable[0] > 0) {
            totalCount++;
        }
        int i = 0;
        int maxR = 0;
        int maxL = 0;
        int count = 0;
        for (i = name.length() + 1; i < inTable.length; i++) {
            System.out.print(inTable[i] + "-");
            // System.out.println(inTable[startIdx + backPtr] + " ");
            count++;
            if (inTable[i] > 0) {
                totalCount++;
                maxR = count;
            }
            if (inTable[startIdx + backPtr] > 0) {
                totalCount++;
                maxL = count;
            }

            backPtr--;
            if (totalCount == targetCount) {
                break;
            }
        }

        // 왼쪽갔다 오른쪽으로 혹은 오른쪽 갔다 왼쪽으로.
        // 둘중 작은 경우 계ㄴ
        if (maxL < maxR) {
            totalCount = maxL * 2 + maxR;
        } else {
            totalCount = maxL + maxR * 2;
        }

        int sum = 0;
        for (i = 0; i < name.length(); i++) {
            sum += inTable[i];
        }
        // System.out.println(i + ", " + totalCount + ":" + " " + countLeft + "," +
        // countLeft);
        // System.out.println(choseMin(totalCount, countLeft, countRight));
        // System.out.println(sum);

        // 위에서 받은 세가지 경우 중 min값을 취함.
        return choseMin(totalCount, countLeft, countRight) + sum;
    }

    private int choseMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}