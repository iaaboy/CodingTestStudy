package prog42628;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[][] operations = { { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" }
                ,
                { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" }
        };

        Solution mSol = new Solution();
        for (String[] op : operations) {
            System.out.println("anwer:" + Arrays.toString(mSol.solution(op)));
        }
    }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Tower> tQ = new PriorityQueue<>((a, b) -> {
            return a.val < b.val ? 1 : -1;
        });
        PriorityQueue<Tower> tReverseQ = new PriorityQueue<>((a, b) -> {
            return a.val > b.val ? 1 : -1;
        });

        for (String inp : operations) {
            String[] ops = inp.split(" ");
            //System.out.println(ops[0] + ":" + ops[1]);
            int val = Integer.parseInt(ops[1]);
            //System.out.println(val);

            char op = ops[0].charAt(0);
            if (op == 'I') { // 큐에 삽입
                Tower tw = new Tower(val, false);
                System.out.println("push: " + tw);
                tQ.add(tw);
                tReverseQ.add(tw);
            } else if (op == 'D') {
                if (val > 0) { // 최대값 삭제
                    while (!tQ.isEmpty()) {
                        if(tQ.peek().isRemoved) {
                            tQ.poll();
                        } else {
                            System.out.println("pop: " + tQ.peek());
                            tQ.poll().isRemoved = true;
                            break;
                        }
                    }
                } else { // 최소값 삭제
                    while (!tReverseQ.isEmpty()) {
                        if(tReverseQ.peek().isRemoved) {
                            tReverseQ.poll();
                        } else {
                            System.out.println("pop: " + tQ.peek());
                            tReverseQ.poll().isRemoved = true;
                            break;
                        }
                    }
                }
            } else {
                // Something wroing
            }
        }

        while (!tQ.isEmpty()) {
            if(tQ.peek().isRemoved) {
                tQ.poll();
            } else {
                break;
            }
        }

        while (!tReverseQ.isEmpty()) {
            if(tReverseQ.peek().isRemoved) {
                tReverseQ.poll();
            } else {
                break;
            }
        }

        System.out.println("tq: " + tQ);
        System.out.println("tReverse : " + tReverseQ);

        if(tQ.size() != 0) {
            answer[0] = tQ.peek().val;
            answer[1] = tReverseQ.peek().val;
        }
        return answer;
    }
}

class Tower {
    int val;
    boolean isRemoved;

    public Tower(int val, boolean isRemoved) {
        this.val = val;
        this.isRemoved = isRemoved;
    }

    @Override
    public String toString() {
        return "v: " + val + ", isRemoved: " + isRemoved;
    }
}