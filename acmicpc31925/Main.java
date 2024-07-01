package acmicpc31925;

import java.io.*;
import java.util.*;

/* APC2shake!
 * https://www.acmicpc.net/problem/31925
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = bf.readLine().split(" ");
            if (str[1].charAt(0) == 'j' && str[2].charAt(0) == 'n') {
                int shake = Integer.parseInt(str[3]);
                if (shake < 0 || shake > 3) {
                    players.add(new Player(str[0], Integer.parseInt(str[4])));
                }
            }
        }
        players.sort((a, b) -> a.score - b.score);
        // System.out.print(players);
        ArrayList<Player> selectedPlayers = new ArrayList<>();
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            selectedPlayers.add(players.get(i));
        }
        selectedPlayers.sort((a, b) -> {
            return a.name.compareTo(b.name);
        });
        StringBuilder sb = new StringBuilder();
        sb.append(selectedPlayers.size() + "\n");
        for (int i = 0; i < selectedPlayers.size(); i++) {
            sb.append(selectedPlayers.get(i).name + "\n");
        }
        System.out.print(sb);
    }

    static class Player {
        String name;
        int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + ": " + score;
        }
    }
}

/*
 * 20
 * kim jaehak notyet 5 16
 * park jaehak notyet -1 18
 * choi jaehak notyet 10 17
 * lee jaehak notyet 20 19
 * kimyu jaehak notyet 30 20
 * parkyu jaehak winner -1 15
 * choiyu hewhak notyet 1 14
 * leeyu jaehak notyet 9 12
 * baek jaehak notyet 8 11
 * shin jaehak notyet 4 13
 * han jaehak notyet 4 8
 * oh jaehak notyet 4 9
 * jang hewhak notyet -1 7
 * pang jaehak winner 5 10
 * jaegal jaehak notyet 14 6
 * sunwoo jaehak notyet 11 5
 * yang jaehak notyet -1 3
 * yoon jaehak winner 12 4
 * moon hewhak notyet -1 2
 * no jaehak winner 30 1
 */