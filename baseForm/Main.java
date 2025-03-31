package baseForm;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap <String, String> numMap = new HashMap<>();
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                numMap.put((Integer.toString(i) + Integer.toString(j)), Integer.toString(i + j));
            }
        }
        
        System.out.println(numMap.get(bf.readLine()));
    }
}
