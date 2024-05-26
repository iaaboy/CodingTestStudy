package acmicpc31869;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        ArrayList<Person> pList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int W = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            pList.add(new Person(name, W, D, P));
        }
        HashMap<String, Integer> wallet = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());
            wallet.put(name, money);
        }
        HashSet<Integer> daySet = new HashSet<>();
        for (int i = 0; i < pList.size(); i++) {
            Person person = pList.get(i);
            if (person.P <= wallet.get(person.name)) {
                daySet.add(person.D);
            }
        }
        int prev = -1;
        int count = 0;
        int result = 0;
        // System.out.println(daySet);
        for (Integer s : daySet) {
            if (s - prev == 1) {
                count++;
                
            } else {
                count = 1;
            }
            result = Math.max(result, count);
            prev = s;
        }
        System.out.println(result);
    }

    public static class Person {
        String name;
        int D, P;
        boolean isPayable;

        public Person(String name, int w, int d, int p) {
            this.name = name;
            D = w * 7 + d;
            P = p;
        }

        @Override
        public String toString() {
            return name + ":" + D + "," + P + "/" + isPayable;
        }
    }
}
