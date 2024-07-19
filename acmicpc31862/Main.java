package acmicpc31862;

import java.io.*;
import java.util.*;

/* 승리하라
 * https://www.acmicpc.net/problem/31862
 */

public class Main {
    static int[] preTeamWon; //각팀 이긴 수
    static ArrayList<Game> gameLeft; //남은 게임 list
    static int myTeam;//나의 팀
    static int preMax;//남은 게임 제외 , 나의팀 제외 최대 Win
    static int preWinner; // winner

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int gameCount = Integer.parseInt(st.nextToken());
        myTeam = Integer.parseInt(st.nextToken()) - 1;
        preTeamWon = new int[N];
        gameLeft = new ArrayList<>();
        preMax = 0;
        for (int i = 0; i < gameCount; i++) {
            StringTokenizer stL = new StringTokenizer(bf.readLine());
            int t1 = Integer.parseInt(stL.nextToken()) - 1; // 팀 id와 데이터 index를 맞추기 위해 -1
            int t2 = Integer.parseInt(stL.nextToken()) - 1;
            int r = Integer.parseInt(stL.nextToken()); //0, postpone  1, t1 win  2, t2 win
            if (r == 0) {
                gameLeft.add(new Game(t1, t2));
            } else if (r == 1) {
                preTeamWon[t1]++;
                if (t1 != myTeam && preTeamWon[t1] > preMax) {
                    preMax  = preTeamWon[t1];
                    preWinner = t1;
                }
            } else {
                preTeamWon[t2]++;
                if (t2 != myTeam && preTeamWon[t2] > preMax) {
                    preMax  = preTeamWon[t2];
                    preWinner = t2;
                }
            }
        }
        boolean[] result = new boolean[gameLeft.size()];
        checkAll(result, 0);
        System.out.println(myWinCount);
    }

    static int myWinCount = 0;

    private static void checkWin(boolean[] gameResult) {
        HashMap<Integer, Integer> winCountMap = new HashMap<>();
        int maxWin = preMax;
        int myWin = preTeamWon[myTeam];
        for (int i = 0; i < gameLeft.size(); i++) {
            int winner;
            if (gameResult[i]) {
                winner = gameLeft.get(i).t1;
            } else {
                winner = gameLeft.get(i).t2;
            }
            if (winner == myTeam) {
                myWin++;
                continue;
            }
            if (!winCountMap.containsKey(winner)) {
                winCountMap.put(winner, preTeamWon[winner]);
            }
            int win = winCountMap.get(winner) + 1;
            winCountMap.put(winner, win);
            maxWin = Math.max(maxWin, win);
        }
        if (myWin > maxWin) {
            // System.out.println(Arrays.toString(gameResult));
            // System.out.println(winCountMap);
            myWinCount++;
        }
    }

    private static void checkAll(boolean[] gameResult, int depth) {
        if (gameResult.length == depth) {
            checkWin(gameResult);
            return;
        }
        gameResult[depth] = false;
        checkAll(gameResult, depth + 1);
        gameResult[depth] = true;
        checkAll(gameResult, depth + 1);
    }

    static class Game {
        int t1;
        int t2;

        public Game(int t1, int t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }
}
