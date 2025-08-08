package acmicpc27495;

import java.io.*;
import java.util.*;

/* 만다라트 만들기
 * https://www.acmicpc.net/problem/27495
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[][] words = new String[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                words[i][j] = st.nextToken();
            }

        }

        Integer[][] check = new Integer[][] {
                { 0, 0 },
                { 0, 1 },
                { 0, 2 },
                { 1, 0 },
                { 1, 2 },
                { 2, 0 },
                { 2, 1 },
                { 2, 2 },
        };

        for (int i = 0; i < check.length; i++) {
            check[i][0] += 3;
            check[i][1] += 3; 
        }
        Arrays.sort(check, (a,b) -> {
            return words[a[0]][a[1]].compareTo(words[b[0]][b[1]]);
        });

        StringBuilder [] sb = new StringBuilder[8];
        for (int i = 0; i < 8; i++) {
            sb[i] = new StringBuilder();
            sb[i].append("#" + (i + 1) + ". " + words[check[i][0]][check[i][1]]).append("\n");
        }

        // for (int i = 0; i < sb.length; i++) {
        //     System.out.print(sb[i]);
        // }

        for (int i = 0; i < check.length; i++) {
            check[i][0] = (check[i][0] - 3) * 3;
            check[i][1] = (check[i][1] - 3) * 3;
        }

        // for (Integer[] c : check) {
        //     System.out.print(c[0]+ " " + c[1] + " .. ");
        // }
        // System.out.println();

        int [] dy = new int[] {0, 0, 0, 1, 1, 2, 2, 2};
        int [] dx = new int[] {0, 1, 2, 0, 2, 0, 1, 2};
        
        for (int i = 0; i < 8; i++) {
            ArrayList<String> wordsAtSmallSet = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                int y = check[i][0] + dy[j];
                int x = check[i][1] + dx[j];
                wordsAtSmallSet.add(new String(words[y][x]));
                // System.out.print(y + "," + x + " " + words[y][x] + "...");
            }
            // System.out.println();
            wordsAtSmallSet.sort(null);
            // System.out.println(wordsAtSmallSet);
            for (int j = 0; j < 8; j++) {
                sb[i].append("#" + (i + 1) + "-" + (j + 1) + ". " + wordsAtSmallSet.get(j)).append("\n");
            }
        }

        for (int i = 0; i < sb.length; i++) {
            System.out.print(sb[i]);
        }
    }
}
