package acmicpc20008;

import java.io.*;
import java.util.*;

/* 몬스터를 처치하자!
 * https://www.acmicpc.net/problem/20008
 */

public class Main {
    static Skill[] skill;
    static int N;
    static int hp;
    static int ans = Integer.MAX_VALUE;
    static int[] cool;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        hp = Integer.parseInt(st.nextToken());
        skill = new Skill[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            skill[i] = new Skill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        cool = new int[N];
        bf(0, 0);
        System.out.println(ans);
    }

    static void bf(int time, int damage) {
        // System.out.println(time + ":" + damage);
        if (damage >= hp) {
            ans = Math.min(ans, time);
            return;
        }
        boolean itemUsed = false;
        for (int i = 0; i < N; i++) {
            if (cool[i] <= time) {
                itemUsed = true;
                int tmp = cool[i];
                cool[i] = time + skill[i].delay;
                bf(time + 1, damage + skill[i].damage);
                cool[i] = tmp;
            }
        }
        if (!itemUsed) {
            bf(time + 1, damage);
        }
    }

    static class Skill {
        int delay;
        int damage;

        public Skill(int delay, int damage) {
            this.delay = delay;
            this.damage = damage;
        }
    }
}
