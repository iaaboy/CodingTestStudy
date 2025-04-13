package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine();
        String b = bf.readLine();
        if (a.contentEquals("null")) {
            System.out.println("NullPointerException\nNullPointerException");
        } else {
            if (b.contentEquals("null")) {
                b = null;
            }
            System.out.println(a.equals(b));
            System.out.println(a.equalsIgnoreCase(b));
        }
    }
}
