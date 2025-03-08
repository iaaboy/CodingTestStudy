package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        char[] nArr = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());
        int num = (nArr[0] >= '0' && nArr[0] <= '9') ? nArr[0] - '0'
                : nArr[0] - 'A' + 10;
        for (int i = 1; i < nArr.length; i++) {
            int n;
            num *= N;
            if (nArr[i] >= '0' && nArr[i] <= '9') {
                n = nArr[i] - '0';
            } else {
                n = nArr[i] - 'A' + 10;
            }
            num += n;
        }

        System.out.println(num);
    }
}
