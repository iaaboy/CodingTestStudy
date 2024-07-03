package acmicpc5397;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder []sb = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            char[] cArr = bf.readLine().toCharArray();
            int cursor = 0;
            sb[i] = new StringBuilder();
            for (int j = 0; j < cArr.length; j++) {
                switch (cArr[j]) {
                    case '>':
                        cursor++;
                        cursor = Math.min(cursor, sb[i].length());
                        break;
                    case '-':
                        if(cursor != 0)
                            sb[i].deleteCharAt(cursor - 1);
                    case '<':
                        cursor--;
                        cursor = Math.max(0, cursor);
                        break;
                    default:
                        sb[i].insert(cursor, cArr[j]);
                        cursor++;
                        cursor = Math.min(cursor, sb[i].length());
                        break;
                }
            }
            
        }
        for (int i = 0; i < sb.length; i++) {
            System.out.println(sb[i]);
        }
    }
}
