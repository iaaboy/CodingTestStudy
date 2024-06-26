package prog72415;

import java.util.*;

/* 카드 짝 맞추기
 * https://school.programmers.co.kr/learn/courses/30/lessons/72415
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] board = {
                { { 1, 0, 0, 3 },
                        { 2, 0, 0, 0 },
                        { 0, 0, 0, 2 },
                        { 3, 0, 1, 0 } }, // 14
                { { 3, 0, 0, 2 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 2, 0, 0, 3 } } // 16
        };
        int[] r = { 1, 0 };
        int[] c = { 0, 1 };
        Solution mSol = new Solution();

        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(board[i], r[i], c[i]));
        }
    }
}

class Solution {
    int[][] board;
    int BD_MAX = 4;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        mCount = 0;
        HashMap<Integer, Card> card = new HashMap<>();
        for (int j = 0; j < BD_MAX; j++) {
            for (int i = 0; i < BD_MAX; i++) {
                if (board[j][i] != 0) {
                    if (!card.containsKey(board[j][i])) {
                        card.put(board[j][i], new Card());
                    }
                    card.get(board[j][i]).put(j, i);
                }
            }
        }

        System.out.println(card);

        mCount = Integer.MAX_VALUE;
        dfs(card, r, c, 0, new ArrayList<>());
        return mCount;
    }

    int mCount = 0;

    private void dfs(HashMap<Integer, Card> card, int r, int c, int curCount, ArrayList<Log> log) {
        // System.out.println("Cur: " + r + "," + c);
        // printAll(card, board);
        if (checkAll(board)) {
            System.out.println("curCount" + curCount + ": " + log);
            mCount = Math.min(mCount, curCount);
            return;
        }

        for (int j = 0; j < BD_MAX; j++) {
            for (int i = 0; i < BD_MAX; i++) {
                if (board[j][i] > 0 && board[j][i] < 7) {
                    // 한번에 두개를 뒤집는다.
                    if (log.size() == 0 && board[j][i] == 2) {
                        System.out.println("check 2 start");
                    }
                    // check clear
                    Card cCard = card.get(board[j][i]);

                    // 1 이동
                    int moveCount = 0;
                    int nextR = 0;
                    int nextC = 0;
                    if (cCard.r1 == j && cCard.c1 == i) {
                        moveCount += move(r, c, cCard.r1, cCard.c1);
                        moveCount += move(cCard.r1, cCard.c1, cCard.r2, cCard.c2);
                        nextR = cCard.r2;
                        nextC = cCard.c2;
                    } else {
                        moveCount += move(r, c, cCard.r2, cCard.c2);
                        moveCount += move(cCard.r2, cCard.c2, cCard.r1, cCard.c1);
                        nextR = cCard.r1;
                        nextC = cCard.c1;
                    }
                    int savedCardId = board[j][i];
                    board[cCard.r1][cCard.c1] = 0;
                    board[cCard.r2][cCard.c2] = 0;

                    // 2 뒤집기
                    moveCount += 2;

                    // 3 콜 dfs
                    Log mLog = new Log(savedCardId, moveCount);
                    log.add(mLog);
                    dfs(card, nextR, nextC, curCount + moveCount, log);
                    log.remove(mLog);

                    // 4 원복
                    board[cCard.r1][cCard.c1] = savedCardId;
                    board[cCard.r2][cCard.c2] = savedCardId;
                }
            }
        }
    }

    private void printAll(HashMap<Integer, Card> card, int[][] bd) {
        System.out.println("---------");
        for (int j = 0; j < BD_MAX; j++) {
            for (int i = 0; i < BD_MAX; i++) {
                System.out.print(bd[j][i] + " ");
            }
            System.out.println();
        }
    }

    private void printAll(int[][] bd) {
        System.out.println("---------");
        for (int j = 0; j < BD_MAX; j++) {
            for (int i = 0; i < BD_MAX; i++) {
                System.out.print(bd[j][i] + " ");
            }
            System.out.println();
        }
    }

    private int move(int r, int c, int targetR, int targetC) {
        PriorityQueue<Curser> mQ = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int[][] map = new int[BD_MAX][BD_MAX];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 20000);
        }

        map[r][c] = 0;
        mQ.add(new Curser(r, c, 0));
        while (!mQ.isEmpty()) {
            Curser cur = mQ.poll();
            if (cur.r == targetR && cur.c == targetC) {
                return cur.cost;
            }

            int nextC = 0;
            int nextR = 0;
            for (int i = 0; i < 4; i++) {
                nextC = cur.c + pC[i];
                nextR = cur.r + pR[i];
                if (nextC < 0 || nextC > 3 || nextR < 0 || nextR > 3)
                    continue;
                if (cur.cost + 1 < map[nextR][nextC]) {
                    map[nextR][nextC] = cur.cost + 1;
                    mQ.add(new Curser(nextR, nextC, map[nextR][nextC]));
                }
            }

            // 4방향 control 키
            // 가장 가까운 카드 , 카드가 없으면 맨 끝
            boolean hasJump = false;
            if (cur.r == 0) {
                if (board[1][cur.c] == 0 && board[2][cur.c] == 0) {
                    nextC = cur.c;
                    nextR = 3;
                    hasJump = true;
                }
            }
            if (cur.r == 3) {
                if (board[1][cur.c] == 0 && board[2][cur.c] == 0) {
                    nextC = cur.c;
                    nextR = 0;
                    hasJump = true;
                }
            }
            if (hasJump) {
                if (cur.cost + 2 < map[nextR][nextC]) {
                    map[nextR][nextC] = cur.cost + 2;
                    mQ.add(new Curser(nextR, nextC, map[nextR][nextC]));
                }
                hasJump = false;
            }
            if (cur.c == 0) {
                if (board[cur.r][1] == 0 && board[cur.r][2] == 0) {
                    nextC = 3;
                    nextR = cur.r;
                    hasJump = true;
                }
            }
            if (cur.c == 3) {
                if (board[cur.r][1] == 0 && board[cur.r][2] == 0) {
                    nextC = 0;
                    nextR = cur.r;
                    hasJump = true;
                }
            }
            if (hasJump) {
                if (cur.cost + 2 < map[nextR][nextC]) {
                    map[nextR][nextC] = cur.cost + 2;
                    mQ.add(new Curser(nextR, nextC, map[nextR][nextC]));
                }
            }
        }

        return -1;
    }

    class Log {
        int id;
        int cost;

        public Log(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return id + "," + cost;
        }
    }

    class JumpResult {
        int nextR;
        int nextC;
    }

    private boolean hasNocard(int curR, int curC, int direction, JumpResult jump) {
        if (curR == 0 && (direction == 1 || direction == -1)) {
            for (int j = curR + 1; j < BD_MAX; j++) {
                if (board[j][curC] != 0) {
                    return false;
                }
            }
            jump.nextR = BD_MAX - 1;
            jump.nextC = curC;
            return true;
        } else if (curR == BD_MAX - 1 && (direction == 3 || direction == -1)) {
            for (int j = curR - 1; j >= 0; j--) {
                if (board[j][curC] != 0) {
                    return false;
                }
            }
            jump.nextR = 0;
            jump.nextC = curC;
            return true;
        } else if (curC == curC + 1 && (direction == 0 || direction == -1)) {
            for (int i = curC - 1; i >= 0; i--) {
                if (board[curR][i] != 0) {
                    return false;
                }
            }
            jump.nextR = curR;
            jump.nextC = 0;
            return true;
        } else if (curC == 0 && (direction == 2 || direction == -1)) {
            for (int i = curC + 1; i < BD_MAX; i++) {
                if (board[curR][i] != 0) {
                    return false;
                }
            }
            jump.nextR = curR;
            jump.nextC = BD_MAX - 1;
            return true;
        }
        return false;
    }

    private boolean isSwitch(int d1, int d2) {
        if (d1 == 0 && d2 == 2) {
            return true;
        } else if (d1 == 2 && d2 == 0) {
            return true;
        } else if (d1 == 1 && d2 == 3) {
            return true;
        } else if (d1 == 3 && d2 == 1) {
            return true;
        }
        return false;
    }

    int[] pC = { 1, 0, -1, 0 };
    int[] pR = { 0, 1, 0, -1 };

    private boolean checkAll(int[][] board) {
        // TODO map 확인하는거로 수정
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[j][i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    class Curser {
        int c;
        int r;
        int cost;

        public Curser(int r, int c, int cost) {
            this.c = c;
            this.r = r;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return r + "," + c + "," + cost;
        }
    }

    class Card {
        int c1 = -1;
        int r1 = -1;
        int c2 = -1;
        int r2 = -1;
        boolean isClear = false;

        void put(int r, int c) {
            if (c1 == -1) {
                r1 = r;
                c1 = c;
            } else {
                r2 = r;
                c2 = c;
            }
        }

        @Override
        public String toString() {
            return r1 + "," + c1 + ":" + r2 + "," + c2 + "," + isClear;
        }
    }
}