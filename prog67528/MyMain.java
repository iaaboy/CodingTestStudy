package prog67528;

import java.util.*;

/* 보석 쇼핑
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] gemArr = {
            {"a", "a", "b", "a", "c", "c","d","d","b","a"},
                { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" }, // {3, 7}
                { "AA", "AB", "AC", "AA", "AC" }, // {1, 3}
                { "XYZ", "XYZ", "XYZ" }, // {1, 1}
                { "ZZZ", "YYY", "NNNN", "YYY", "BBB" }// {1, 5}
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++)
            System.out.println("Sol result: " + Arrays.toString(mSol.solution(gemArr[i])));
    }
}

class Solution {
    HashMap<String, ArrayList<Integer>> nameMap;
    String[] gems;

    public int[] solution(String[] gems) {
        nameMap = new HashMap<>();
        this.gems = gems;

        int index = 0;
        for (String gem : gems) {
            if (nameMap.containsKey(gem)) {
                nameMap.get(gem).add(index);
            } else {
                ArrayList<Integer> mList = new ArrayList<>();
                mList.add(index);
                nameMap.put(gem, mList);
            }
            index++;
        }

        Queue<Shopping> leftQ = new LinkedList<>();
        Queue<Shopping> rigthQ = new LinkedList<>();
        leftQ.add(new Shopping(0, gems.length - 1));
        rigthQ.add(new Shopping(0, gems.length - 1));

        Shopping bestPosition = new Shopping(0, gems.length);

        while (!leftQ.isEmpty() && !rigthQ.isEmpty()) {
            if (!leftQ.isEmpty()) {
                Shopping curPosition = leftQ.poll();
                // System.out.println("handleLeft: " + curPosition);
                int resultLeft = checkLtoR(curPosition);
                if (resultLeft != -1) {
                    curPosition.left = resultLeft;
                    System.out.println("right q add : " + curPosition);
                    rigthQ.add(curPosition);
                } else {
                    // System.out.println("result " + curPosition);
                    if(checkPosition(bestPosition, curPosition)) {
                        bestPosition = curPosition;
                    }
                }
            }

            if (!rigthQ.isEmpty()) {
                Shopping curPosition = rigthQ.poll();
                int resultRight = checkRtoL(curPosition);
                // System.out.println("handleRight: " + curPosition);
                if (resultRight != -1) {
                    curPosition.right = resultRight;
                    System.out.println("left q add : " + curPosition);
                    leftQ.add(curPosition);
                } else {
                    // System.out.println("result " + curPosition);
                    if(checkPosition(bestPosition, curPosition)) {
                        bestPosition = curPosition;
                    }
                }
            }

        }

        // System.out.println(nameMap);

        int[] answer = {bestPosition.left + 1, bestPosition.right +1};
        return answer;
    }

    private boolean checkPosition(Shopping bestPosition, Shopping curPosition) {
        System.out.println("candidate: " + curPosition);
        int lengthbest = bestPosition.right - bestPosition.left;
        int lengthcur = curPosition.right - curPosition.left;

        if(lengthbest > lengthcur) {
            return true;
        } else if(lengthbest == lengthcur) {
            return curPosition.left < bestPosition.left;
        } else {
            return false;
        }
    }

    private int checkLtoR(Shopping position) {
        int curLeft = position.left;
        while (curLeft < position.right) {
            if (checkItemExist(gems[curLeft], curLeft, position.right, true)) {
                curLeft++;
            } else {
                break;
            }
        }
        if (curLeft == position.left) {
            // 이동 안함
            return -1;
        } else {
            // 이동함
            return curLeft;
        }
    }

    private int checkRtoL(Shopping position) {
        int curRight = position.right;
        while (curRight > position.left) {
            if (checkItemExist(gems[curRight], position.left, curRight, false)) {
                curRight--;
            } else {
                break;
            }
        }
        if (curRight == position.right) {
            return -1;
        } else {
            return curRight;
        }
    }

    private boolean checkItemExist(String gem, int left, int right, boolean fromLeft) {
        ArrayList<Integer> mList = nameMap.get(gem);
        int indexOfIndex = fromLeft ? mList.indexOf(left) + 1 : mList.indexOf(right) - 1;
        if (indexOfIndex < mList.size() && indexOfIndex >= 0) {
            int item = mList.get(indexOfIndex);
            if (item >= left && item <= right) {
                return true;
            }
        }

        return false;
    }

    class Shopping {
        int left;
        int right;

        public Shopping(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "<" + left + "," + right + ">";
        }
    }
}