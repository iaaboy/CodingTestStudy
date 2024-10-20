package prog81303;

import java.util.*;

/* 표 편집
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */

public class MyMain {
    public static void main(String[] args) {
        String[] cmd2 = { "C" };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(8, 0, cmd2));
    }
}

class Solution {
    int prompt, n;
    Storage[] storage;

    public String solution(int n, int k, String[] cmd) {

        prompt = k;
        this.n = n;

        storage = new Storage[n];
        for (int i = 0; i < n; i++) {
            storage[i] = new Storage(true, i - 1, i + 1, i);
        }
        storage[n - 1].next = -1; // handle last pointer

        for (String c : cmd) {
            // System.out.println(c + "[" + prompt + "]");
            switch (c.charAt(0)) {
                case 'D':
                    String[] com = c.split(" ");
                    int num = Integer.parseInt(com[1]);
                    move(true, num);
                    break;
                case 'U':
                    String[] comU = c.split(" ");
                    int numU = Integer.parseInt(comU[1]);
                    move(false, numU);
                    break;
                case 'C':
                    cut();
                    break;
                case 'Z':
                    undo();
                    break;
                default:
                    break;
            }
            // System.out.println("[" + prompt + "] :" + Arrays.toString(storage));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (storage[i].occupy) {
                sb.append("O");
            } else
                sb.append("X");
        }
        return sb.toString();

    }

    void move(boolean isDown, int num) {
        if (isDown) {
            while (num != 0) {
                if (storage[prompt].next == -1)
                    break;
                prompt = storage[prompt].next;
                num--;
            }
        } else {
            while (num != 0) {
                if (storage[prompt].prev == -1)
                    break;
                prompt = storage[prompt].prev;
                num--;
            }
        }
    }

    Stack<Integer> candiStack = new Stack<>();
    void cut() { //현재 pointer를 stack에 넣고, point를 정리
        candiStack.add(prompt);
        int nextPtr = storage[prompt].next;
        int prePtr = storage[prompt].prev;
        if (prePtr == -1) {
            storage[nextPtr].prev = -1;
            storage[prompt].occupy = false;// todo erase
            prompt = nextPtr;
        } else if (nextPtr == -1) {
            storage[prePtr].next = -1;
            storage[prompt].occupy = false;// todo erase
            prompt = prePtr;
        } else {
            storage[nextPtr].prev = prePtr;
            storage[prePtr].next = nextPtr;
            storage[prompt].occupy = false;// todo erase
            prompt = nextPtr;
        }
    }

    void undo() { //이전 pointer들을 그냥 restore하면 된다.
        if (candiStack.empty()) {
            System.out.println("Something wroing");
            return;
        }
        int restoreNum = candiStack.pop();
        // System.out.println(restoreNum + " stack: " + candiStack);
        int prePtr = storage[restoreNum].prev;
        int nextPtr = storage[restoreNum].next;

        if (prePtr != -1)
            storage[prePtr].next = restoreNum;
        if (nextPtr != -1)
            storage[nextPtr].prev = restoreNum;

        storage[restoreNum].occupy = true; // todo erase
    }
}

class Storage {
    boolean occupy; //업데이트하지 않아도 문제를 풀 수 있음.
    int data; //occupy가 없을 경우 data를 저장
    int prev;
    int next;

    public Storage(boolean occupy, int prev, int next, int data) {
        this.occupy = occupy;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return "<" + (occupy ? "O" : "X") + "," + prev + "," + next + ">";
    }
}