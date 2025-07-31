package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        String [] words = {
            "","Yakk","Doh","Seh","Ghar","Bang","Sheesh"};
        String [] pair = {
            "", "Habb Yakk", "Dobara" ,"Dousa", "Dorgy", "Dabash", "Dosh"
        };
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == b) {
                sb.append("Case " + i + ": " + pair[a]);
            } else if ((a == 6 && b == 5) || (a == 5 && b == 6)) {
                sb.append("Case " + i + ": " + "Sheesh Beesh");
            } else {
                sb.append("Case " + i + ": " + words[Math.max(a, b)] + " " + words[Math.min(a, b)]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
