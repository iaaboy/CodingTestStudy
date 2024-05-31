package acmicpc31835;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String inStr = bf.readLine();
        boolean tf = bf.readLine().charAt(0) == 'T';
        int count = 0;
        if (tf) { // T and 기준
            String[] s = inStr.split("&");
            for (String wd : s) {
                if (!wd.contains("T")) {

                }
            }
        } else { // F or 기준
            String[] s = inStr.split("|");
            for (String wd : s) {
                if (!wd.contains("F")) {

                }
            }
        }
        System.out.println(count);
    }
}
