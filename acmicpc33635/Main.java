package acmicpc33635;

import java.io.*;
import java.util.*;

/* ─점심시간─
 * https://www.acmicpc.net/problem/33635
각 책의 index를 bit로 처리해서 검색 성능을 높임.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> dict = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            dict.put(st.nextToken(), i);
        }
        int M = Integer.parseInt(bf.readLine());
        BitSet[] books = new BitSet[M];
        for (int i = 0; i < M; i++) {
            books[i] = new BitSet(N);
            st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());
            String bookName = st.nextToken();
            for (int j = 0; j < K; j++) {
                books[i].set(dict.get(st.nextToken()));
            }
        }
        // StringBuilder debugsb = new StringBuilder();
        // for (int j = 0; j < M; j++) {
        // debugsb.append(books[j]).append("\n");
        // }
        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            BitSet book = new BitSet(N);
            st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                book.set(dict.get(st.nextToken()));
            }
            // debugsb.append(book).append(" -> ");
            int count = 0;
            for (int j = 0; j < M; j++) {
                // bit compare
                BitSet comp = new BitSet();
                comp.or(book);
                comp.and(books[j]);
                if (comp.equals(book)) {
                    count++;
                    // debugsb.append(comp).append(" ");
                }
            }
            // debugsb.append("\n");
            sb.append(count).append("\n");
        }
        // System.out.print(debugsb);
        System.out.print(sb);
    }
}