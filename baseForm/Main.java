package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inchr = bf.readLine().toCharArray();
        
        System.out.println((int)inchr[0]);
        
    }
}
