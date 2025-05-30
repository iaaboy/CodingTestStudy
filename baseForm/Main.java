package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] inArr = bf.readLine().toCharArray();
        if (inArr[0] == inArr[2]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
