package acmicpc12732;

import java.io.*;
import java.util.*;

/* 열차 시간표(Large)
 * https://www.acmicpc.net/problem/12732
시간을 분단위로 환산하고, 
출발시간, 도착시간 + offset(회차시간) , A->B 여부를 데이터 클래스로 저장하고,
출발 시간 기준 sorting,
출발 시간 기준 queue에 대기하고 있는 기차가 없으면, count++
케이스별 전체 기차 시간을 출별
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int offset = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int nA = Integer.parseInt(st.nextToken());
            int nB = Integer.parseInt(st.nextToken());
            ArrayList<Train> trains = new ArrayList<>();
            for (int i = 0; i < nA; i++) {
                st = new StringTokenizer(bf.readLine(), " |:");
                trains.add(
                        new Train(
                                Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) + offset,
                                true));
            }

            for (int i = 0; i < nB; i++) {
                st = new StringTokenizer(bf.readLine(), " |:");
                trains.add(
                        new Train(
                                Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) + offset,
                                false));
            }
            trains.sort((a, b) -> a.start - b.start);
            PriorityQueue<Integer> trqA = new PriorityQueue<>();
            PriorityQueue<Integer> trqB = new PriorityQueue<>();
            int trainCountA = 0;
            int trainCountB = 0;
            for (Train tr : trains) {
                if (tr.isAtoB) { // A에서 B로
                    if (!trqA.isEmpty() && trqA.peek() <= tr.start) {
                        trqA.poll();
                    } else {
                        trainCountA++;
                    }
                    trqB.add(tr.arrive);
                } else { // B에서 A로
                    if (!trqB.isEmpty() && trqB.peek() <= tr.start) {
                        trqB.poll();
                    } else {
                        trainCountB++;
                    }
                    trqA.add(tr.arrive);
                }
            }
            sb.append("Case #" + t + ": " + trainCountA + " " + trainCountB + "\n");
        }
        System.out.print(sb);
    }

    static class Train {
        int start;
        int arrive;
        boolean isAtoB;

        public Train(int start, int arrive, boolean isAtoB) {
            this.start = start;
            this.arrive = arrive;
            this.isAtoB = isAtoB;
        }

        @Override
        public String toString() {
            return start + "-" + arrive + "(" + isAtoB + ")";
        }
    }
}
