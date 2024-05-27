package acmicpc29754;

import java.io.*;
import java.util.*;

/* 세상에는 많은 유튜버가 있고, 그중에서 버츄얼 유튜버도 존재한다
 * https://www.acmicpc.net/problem/29754
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> idMap = new HashMap<>();
        Person[] persons = new Person[100];
        int pIndex = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");
            int startTime = 60 * Integer.parseInt(start[0]) + Integer.parseInt(start[1]);
            int endTime = 60 * Integer.parseInt(end[0]) + Integer.parseInt(end[1]);
            int playTime = endTime - startTime;
            if (!idMap.containsKey(name)) {
                idMap.put(name, pIndex);
                persons[pIndex] = new Person();
                persons[pIndex].name = name;
                persons[pIndex].addInfo(day, playTime);
                pIndex++;
            } else {
                persons[idMap.get(name)].addInfo(day, playTime);
            }
        }
        for (int i = 0; i < pIndex; i++) {
            // System.out.println(persons[i]);
            persons[i].bInfo.sort((a, b) -> a.day - b.day);
            boolean isRealVirtual = checkPerson(persons[i].bInfo, M);
            if (isRealVirtual) {
                persons[i].isReal = true;
            }
        }
        boolean isPrinted = false;
        ArrayList<String> virtuals = new ArrayList<>();
        for (String name : idMap.keySet()) {
            if (persons[idMap.get(name)].isReal) {
                virtuals.add(name);
                isPrinted = true;
            }
        }
        if (!isPrinted) {
            System.out.println(-1);
        } else {
            virtuals.sort(null);
            for (String string : virtuals) {
                System.out.println(string);
            }
        }
    }

    private static boolean checkPerson(ArrayList<BRInfo> bInfo, int M) {
        int weekCount = M / 7 + M % 7;
        int[] date = new int[weekCount];
        int[] playSum = new int[weekCount];

        for (BRInfo bi : bInfo) {
            date[(bi.day - 1) / 7]++;
            playSum[(bi.day - 1) / 7] += bi.playTime;
        }
        for (int i = 0; i < weekCount; i++) {
            if (date[i] < 5 || playSum[i] < 60 * 60) {
                return false;
            }
        }
        return true;
    }

    static class Person {
        String name;
        boolean isReal;
        ArrayList<BRInfo> bInfo;

        public Person() {
            this.bInfo = new ArrayList<>();
        }

        void addInfo(int day, int playTime) {
            bInfo.add(new BRInfo(day, playTime));
        }

        @Override
        public String toString() {
            return name + ":" + bInfo.toString();
        }
    }

    static class BRInfo {
        int day;
        int playTime;

        public BRInfo(int day, int playTime) {
            this.day = day;
            this.playTime = playTime;
        }

        @Override
        public String toString() {
            return day + "/" + playTime;
        }
    }
}
