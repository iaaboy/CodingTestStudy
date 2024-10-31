package acmicpc5635;

import java.io.*;
import java.util.*;

/* 생일
 * https://www.acmicpc.net/problem/5635
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Student[] mc = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            mc[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < mc.length; i++) {

            if (mc[max].year == mc[i].year) {
                if (mc[max].month == mc[i].month) {
                    if (mc[max].day < mc[i].day) {
                        max = i;
                    }
                } else if (mc[max].month < mc[i].month) {
                    max = i; 
                }
            } else if (mc[max].year < mc[i].year) {
                max = i; 
            }

            if (mc[min].year == mc[i].year) {
                if (mc[min].month == mc[i].month) {
                    if (mc[min].day > mc[i].day) {
                        min = i;
                    }
                } else if (mc[min].month > mc[i].month) {
                    min = i; 
                }
            } else if (mc[min].year > mc[i].year) {
                min = i; 
            }
        }
        System.out.println(mc[max].name + "\n" + mc[min].name);
    }

    static class Student {
        String name;
        int day;
        int month;
        int year;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}
