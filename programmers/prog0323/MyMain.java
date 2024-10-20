package prog0323;

import java.util.*;

    //https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class MyMain {

    public static void main(String[] args) {
        String[] sample = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] sample2 = {".D.R", "....", ".G..", "...D"};
        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(sample));
        System.out.println(mSolution.solution(sample2));
    }
}

class Solution {

    PriorityQueue <Node> mQ = new PriorityQueue<>();
    boolean[][] visited;
    int[][] map;

    public int solution(String[] board) {
        int answer = -1;
        System.out.println(board);
        map = new int[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];

        makeMap(board, map);

        //1. 지금 좌표를 push
        Node robotNode = findRobot(map);
        mQ.add(robotNode);
        //System.out.println("robot: " + robotNode);

        //6,1 조에서 y탐색 이상.
        while(mQ.size() !=0) {
            //2. pop해서 후보 스캔
            Node curNode = mQ.peek();
            mQ.remove();

            if(visited[curNode.y][curNode.x])
                continue;

            visited[curNode.y][curNode.x] = true;
            //3-1 x축 check
            int result = findX(map, curNode) ;
            if(result> 0) {
                return result;
            }
            //3-2 y축 check
            result = findY(map, curNode);
            if(result> 0) {
                return result;
            }

            //3. 다음 후보를 enqueue

            //4. visited표시

        }
        return answer;
    }

    int findX(int [][] map, Node curNode){
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
            if(checkGoalAndEnqueue(curNode.y, i-1, curNode.distance)) {
                return curNode.distance + 1;
            }
        }

        //R robot  5
        //D 장애물  3
        //G 목적지  1

        if(checkL) {
            for(i = curNode.x -1 ; i >= 0 ; i--) {
                if(map[curNode.y][i] == 3) {
                    break;
                }
            }
            if(checkGoalAndEnqueue(curNode.y, i+1, curNode.distance)) {
                return curNode.distance + 1;
            }
        }

        return 0;
    }
    int findY(int [][] map, Node curNode){
        boolean checkT = false;
        boolean checkB = false;
        int i;
        if(curNode.y == 0) { //아래만 체크
            checkB = true;
        } else if(curNode.y == map[curNode.y].length - 1) { //위쪽만 체크
            checkT = true;
        } else {             //양쪽다 체크
            checkB = checkT = true;
        }

        if(checkB) {
            for(i = curNode.y + 1 ; i < map.length ; i ++) {
                if(map[i][curNode.x] == 3) {
                    break;
                }
            }
            if(checkGoalAndEnqueue(i-1, curNode.x, curNode.distance)) {
                return curNode.distance +1;
            }
        }

        //R robot  5
        //D 장애물  3
        //G 목적지  1

        if(checkT) {
            for(i = curNode.y -1 ; i >= 0 ; i--) {
                if(map[i][curNode.x] == 3) {
                    break;
                }
            }
            if(checkGoalAndEnqueue(i+1, curNode.x, curNode.distance)) {
                return curNode.distance + 1;
            }
        }

        return 0;
    }

    boolean checkGoalAndEnqueue(int y, int x, int dist){
            //check i-1
            if(map[y][x] == 1) {
                return true;
            } if (visited[y][x]) {
                return false;
            } else {
                Node a = new Node(y, x, dist + 1);
                //System.out.println("add Node" + a);
                mQ.add(a);
            }
            return false;
    }



    void makeMap(String[] board, int [][] map){
        int x = 0;
        int y = 0;
        for (String board2 : board) {
            for (char c : board2.toCharArray()) {
                if(c == 'R') { //robot  5
                    map[y][x] = 5;
                } else if((c == 'D')) { //장애물  3
                    map[y][x] = 3;
                } else if((c == 'G')) { //목적지  1
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

    private Node findRobot(int [][] map){
        int x = 0;
        int y = 0;
        for (int [] row : map) {
            for (int c : row) {
                if(c == 5) {
                    return new Node(y,x, 0);
                }
                x++;
            }
            y++;
            x = 0;
        }

        System.out.println("Somthing Wrong");
        return null;
    }

    class Node implements Comparable<Node> {
        Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
        int y;
        int x;
        int distance;
    
        // @Override
        // public String toString() {
        //     String a = new String();
    
        //     a = "(" + y + "," + x + "): " + distance;
        //     return a;
        // }
    
        @Override
        public int compareTo(Node nd) {
            if(this.distance > nd.distance) {
                return 1;
            } else return 0;
        }
    }

}
