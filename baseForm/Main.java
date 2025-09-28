package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int [] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (arr[0] != 0 && arr[1] !=0 && arr[2] != 0) {
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == arr[2]) {
                sb.append("Equilateral").append("\n");
            } else if (arr[2] >= arr[0] + arr[1]){
                sb.append("Invalid").append("\n");
            } else if (arr[2] == arr[1] || arr[2] == arr[0] || arr[0] == arr[1]) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }

            st = new StringTokenizer(bf.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
}
