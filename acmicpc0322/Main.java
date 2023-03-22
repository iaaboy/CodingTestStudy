package acmicpc0322;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inN = Integer.parseInt(br.readLine());

        new Main().solution(inN);
    }

    public void solution(int n) { // N 출력
        // System.out.println("n: " + n);
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < n; i++) {
            num.add(i + 1);
        }
        // System.out.println(num);
        perm(new Vector<>(), num);
    }

    private void perm(Vector<Integer> curArray, Set<Integer> LeftNum) { // LeftNum 는 정렬되어있음.
        if (LeftNum.size() == 1) {

            Vector<Integer> newArrPrint = new Vector<>(curArray);
            newArrPrint.addAll(LeftNum);
            // System.out.println(newArrPrint);

            for (int i : newArrPrint) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
            // 마지막
        }

        for (int n : LeftNum) {
            Vector<Integer> newArr = new Vector<>(curArray);
            Set<Integer> newLeftNum = new HashSet<>(LeftNum);
            newArr.add(n);
            newLeftNum.remove(n);

            // System.out.println("new" + newArr);
            // System.out.println("left" + newLeftNum);

            perm(newArr, newLeftNum);
            newArr.removeElement(n);
            newLeftNum.add(n);
        }
    }
}
