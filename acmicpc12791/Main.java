package acmicpc12791;

import java.io.*;
import java.util.StringTokenizer;

/* Starman
 * https://www.acmicpc.net/problem/12791
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = {
                "1967 DavidBowie",
                "1969 SpaceOddity",
                "1970 TheManWhoSoldTheWorld",
                "1971 HunkyDory",
                "1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars",
                "1973 AladdinSane",
                "1973 PinUps",
                "1974 DiamondDogs",
                "1975 YoungAmericans",
                "1976 StationToStation",
                "1977 Low",
                "1977 Heroes",
                "1979 Lodger",
                "1980 ScaryMonstersAndSuperCreeps",
                "1983 LetsDance",
                "1984 Tonight",
                "1987 NeverLetMeDown",
                "1993 BlackTieWhiteNoise",
                "1995 1.Outside",
                "1997 Earthling",
                "1999 Hours",
                "2002 Heathen",
                "2003 Reality",
                "2013 TheNextDay",
                "2016 BlackStar",
        };
        int[] year = new int[25];
        String[] name = new String[25];
        for (int data2 = 0; data2 < data.length; data2++) {
            String[] d = data[data2].split(" ");
            year[data2] = Integer.parseInt(d[0]);
            name[data2] = d[1];
        }

        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = 0; j < 25; j++) {
                if (year[j] >= from && year[j] <= to) {
                    count++;
                }
            }
            sb.append(count).append("\n");

            for (int j = 0; j < 25; j++) {
                if (year[j] >= from && year[j] <= to) {
                    sb.append(Integer.toString(year[j])).append(" ").append(name[j]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
