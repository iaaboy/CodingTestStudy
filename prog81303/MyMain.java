package prog81303;

import java.util.*;

/* 표 편집
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */

public class MyMain {
    public static void main(String[] args) {
        String[] cmd2 = { "C", "U 2", "C", "C", "Z", "D 4", "C", "U 2", "Z", "Z" };

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
            storage[i] = new Storage(true, i - 1, i + 1);
        }
        storage[n - 1].next = -1; // handle last pointer

        System.out.println("Start[" + prompt + "] :" + Arrays.toString(storage));

        for (String c : cmd) {
            System.out.println(c + "[" + prompt + "]");
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
            System.out.println("[" + prompt + "] :" + Arrays.toString(storage));
        }

        String answer = "";
        for (int i = 0; i < n; i++) {
            if (storage[i].occupy) {
                answer += 'O';
            } else {
                answer += 'X';
            }
        }
        return answer;
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

    void cut() {
        candiStack.add(prompt);
        int nextPtr = storage[prompt].next;
        int prePtr = storage[prompt].prev;
        if (prePtr == -1) {
            storage[nextPtr].prev = -1;
            storage[prompt].occupy = false;
            prompt = nextPtr;
        } else if (nextPtr == -1) {
            storage[prePtr].next = -1;
            storage[prompt].occupy = false;
            prompt = prePtr;
        } else {
            storage[nextPtr].prev = prePtr;
            storage[prePtr].next = nextPtr;
            storage[prompt].occupy = false;
            prompt = nextPtr;
        }
    }

    void undo() {
        if (candiStack.empty()) {
            System.out.println("Something wroing");
            return;
        }
        System.out.println("stack: " + candiStack);
        int restoreNum = candiStack.pop();
        int prePtr = storage[restoreNum].prev;
        while (prePtr != -1 && !storage[prePtr].occupy) {
            prePtr = storage[prePtr].prev;
            if (prePtr == -1)
                break;
        }
        int nextPtr = storage[restoreNum].next;
        while (nextPtr != -1 && !storage[nextPtr].occupy) {
            nextPtr = storage[nextPtr].prev;
            if (nextPtr == -1)
                break;
        }
        storage[restoreNum].prev = prePtr;
        if (nextPtr != -1) {
            storage[nextPtr].prev = restoreNum;
        }
        storage[restoreNum].next = nextPtr;
        if (prePtr != -1) {
            storage[prePtr].next = restoreNum;
        }
        storage[restoreNum].occupy = true;
    }
}

class Storage {
    boolean occupy;
    int prev;
    int next;

    public Storage(boolean occupy, int prev, int next) {
        this.occupy = occupy;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return "<" + (occupy ? "O" : "X") + "," + prev + "," + next + ">";
    }
}