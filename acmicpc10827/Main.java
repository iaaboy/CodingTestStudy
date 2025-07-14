package acmicpc10827;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/* a^b
 * https://www.acmicpc.net/problem/10827
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String a = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int dotLocation = a.length() - a.lastIndexOf('.') - 1;

        BigDecimal devider = new BigDecimal(10);
        devider = devider.pow(dotLocation).pow(b);

        a = a.replace(".", "");
        BigDecimal aBig = new BigDecimal(a);
        aBig = aBig.pow(b);

        //받은걸 바로 BigDecimal로 바꿔도 답이 됨.

        // System.out.println(aBig);
        // System.out.println(devider);
        System.out.println(aBig.divide(devider).toPlainString());
    }
}
