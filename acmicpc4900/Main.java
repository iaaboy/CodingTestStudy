package acmicpc4900;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> numMap = new HashMap<>();
        numMap.put("063", 0);
        numMap.put("010", 1);
        numMap.put("093", 2);
        numMap.put("079", 3);
        numMap.put("106", 4);
        numMap.put("103", 5);
        numMap.put("119", 6);
        numMap.put("011", 7);
        numMap.put("127", 8);
        numMap.put("107", 9);
        HashMap<Character, String> numMap2 = new HashMap<>();
        numMap2.put('0', "063");
        numMap2.put('1', "010");
        numMap2.put('2', "093");
        numMap2.put('3', "079");
        numMap2.put('4', "106");
        numMap2.put('5', "103");
        numMap2.put('6', "119");
        numMap2.put('7', "011");
        numMap2.put('8', "127");
        numMap2.put('9', "107");
        while (true) {
            String str = bf.readLine();
            if (str.contentEquals("BYE")) {
                System.out.println(sb.toString());
                return;
            }
            String[] numbers = str.split("\\+|\\=");
            int num1 = switchNum(numMap, numbers[0], 0);
            int num2 = switchNum(numMap, numbers[1], 0);
            int sum = num1 + num2;
            char[] num = Integer.toString(sum).toCharArray();
            sb.append(str);
            for (int i = 0; i < num.length; i++) {
                sb.append(numMap2.get(num[i]));
            }
            sb.append("\n");
        }
    }

    private static int switchNum(HashMap<String, Integer> numMap, String str, int curNum) {
        String numString = str.substring(0, 3);
        int num = numMap.get(numString);
        if (str.length() == 3) {
            return curNum * 10 + num;
        } else {
            return switchNum(numMap, str.substring(3, str.length()), curNum * 10 + num);
        }
    }
}
