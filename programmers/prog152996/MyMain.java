package prog152996;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] weights = { 100, 180, 360, 100, 270 };

        Solution mSol = new Solution();
        System.out.println("retult : " + mSol.solution(weights));
    }
}

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        //각 배율 값을 기록해두는 테이블.
        double[] multi = { 2.0 / 4, 3.0 / 4, 2.0 / 3, 4.0 / 3, 3.0 / 2, 1.0, 2.0 };

        //각 배수를 가고 있는 map 
        //key 값, value count
        HashMap<Double, Double> map = new HashMap<>();

        //먼저 count만큼 저장
        for (double weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0.0) + 1);
        }


        //System.out.println(map);

        for (double weight : weights) {
            map.put(weight, map.get(weight) - 1);

            for (double gob : multi) {
                double targetVal = weight * gob;
                if (targetVal >= 100.0 && targetVal <= 1000.0) {
                    //count만큼 더하기, 없으면 0 허사나.
                    double cnt = map.getOrDefault(targetVal, 0.0);
                    answer += cnt;
                }
            }
        }

        return answer;
    }
}



/**
 * 
 * class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        //각 배율 값을 기록해두는 테이블.
        double[] multi = { 2.0 / 4, 3.0 / 4, 2.0 / 3, 4.0 / 3, 3.0 / 2, 1.0, 2.0 };

        //각 배수를 가고 있는 map 
        //key 값, value count
        HashMap<Double, Double> map = new HashMap<>();

        //먼저 count만큼 저장
        for (double weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0.0) + 1);
        }


        //System.out.println(map);

        for (double weight : weights) {
            map.put(weight, map.get(weight) - 1);

            for (double gob : multi) {
                double targetVal = weight * gob;
                if (targetVal >= 100.0 && targetVal <= 1000.0) {
                    //count만큼 더하기, 없으면 0 허사나.
                    double cnt = map.getOrDefault(targetVal, 0.0);
                    answer += cnt;
                }
            }
        }

        return answer;
    }
}
 */