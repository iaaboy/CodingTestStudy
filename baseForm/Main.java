package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int prevNum = Integer.parseInt(st.nextToken());
        int hasAsc = 0;
        int hasDsc = 0;
        for (int i = 1; i < 8; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (prevNum > num) {
                hasDsc = 1;
            } else if (prevNum < num) {
                hasAsc = 1;
            }
            prevNum = num;
        }
        if (hasAsc == 1 && hasDsc == 1) {
            System.out.println("mixed");
        } else if (hasAsc == 1) {
            System.out.println("ascending");
        } else if (hasDsc == 1) {
            System.out.println("descending");
        }
    }
}
