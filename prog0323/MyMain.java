package prog0323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MyMain {

    /*
     * 3 ≤ board의 길이 ≤ 100
    */
    public static void main(String[] args) {
        String[] sample = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] sample2 = {".D.R", "....", ".G..", "...D"};
        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(sample));
        System.out.println(mSolution.solution(sample2));
    }
}

class Node{
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
    int y;
    int x;
}

class Solution {

    Queue <Node> mQ = new LinkedList<>();
    int[][] visited;
    int[][] map;

    public int solution(String[] board) {
        int answer = 0;
        System.out.println(board);
        map = new int[board.length][board[0].length()];

        makeMap(board, map);

        //1. 지금 좌표를 push
        Node robotNode = findR(map);
        mQ.add(robotNode);

        while(mQ.size() !=0) {
            //2. pop해서 후보 스캔
            Node curNode = mQ.peek();
            mQ.remove();

            //3-1 x축 check
            findX(map, curNode);
            //3-2 y축 check

            //3. 다음 후보를 push 

            //4. visited표시

        }
        return answer;
    }

    boolean findX(int [][] map, Node curNode){
        boolean checkR = false;
        boolean checkL = false;
        int i;
        if(curNode.x == 0) { //오른쪽만 체크
            checkR = true;
        } else if(curNode.x == map[curNode.y].length - 1) { //왼쪽만 체크
            checkL = true;
        } else {             //양쪽다 체크
            checkR = checkL = true;
        }

        if(checkR) {
            for(i = curNode.x + 1 ; i < map[curNode.y].length ; i ++) {
                if(map[curNode.y][i] == 3) {
                    break;
                }
            }
            //check i-1
        }

        if(checkL) {
            for(i = curNode.x -1 ; i >= 0 ; i--) {
                if(map[curNode.y][i] == 3) {
                    break;
                }
            }
            //check i+1
        }

        return false;
    }
    boolean finxY(int [][] map, Node curNode){

        return false;
    }

    void makeMap(String[] board, int [][] map){
        int x = 0;
        int y = 0;
        for (String board2 : board) {
            for (char c : board2.toCharArray()) {
                if(c == 'R') {
                    map[y][x] = 5;
                } else if((c == 'D')) {
                    map[y][x] = 3;
                } else if((c == 'G')) {
                    map[y][x] = 1;
                } else {
                    map[y][x] = 0;
                }
                x++;
            }
            System.out.println(Arrays.toString(map[y]));
            y++;
            x = 0;
        }
    }

    private Node findR(int [][] map){
        int x = 0;
        int y = 0;
        for (int [] row : map) {
            for (int c : row) {
                if(c == 5) {
                    return new Node(y,x);
                }
                x++;
            }
            y++;
            x = 0;
        }

        System.out.println("Somthing Wrong");
        return null;
    }
}

