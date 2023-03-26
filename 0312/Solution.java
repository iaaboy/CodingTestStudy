import java.util.HashSet;

/*
문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42862
        int[] n = { 5, 5, 3, 7 };
        int llost[][] = { { 2, 4 }, { 2, 4 }, { 3 }, { 1, 3, 4, 5 } };
        int sspare[][] = { { 1, 3, 5 }, { 3 }, { 1 }, { 3, 5, 6 } };
 */

public class Solution {

    public int solution(
            int n, int[] lost, int[] spare) {

        HashSet<Integer> coice = new HashSet<Integer>();
        HashSet<Integer> lostJin = new HashSet<Integer>();
        HashSet<Integer> spareJin = new HashSet<Integer>();
        for (int lo : lost) {
            for (int sp : spare) {
                if (lo == sp) {
                    coice.add(sp);
                }
                lostJin.add(lo);
                spareJin.add(sp);
            }
        }

        for(int c : coice) {
            lostJin.remove(c);
            spareJin.remove(c);
        }

        HashSet<Integer> mCandi = new HashSet<Integer>();
        for (int lo : lostJin) {
            for (int sp : spareJin) {
                if (Math.abs(lo - sp) == 1) {
                    mCandi.add(sp);
                }
            }
        }

        System.out.println(coice.toString());
        System.out.println(lostJin.toString());
        System.out.println(mCandi.toString());

        int result = n;

        //result -= coice.size();

        if(lostJin.size() - mCandi.size() > 0) {
            result -= lostJin.size() - mCandi.size();
        }

        // if(spareJin.size() > mCandi.size()) {


        //     result = result - lostJin.size() + spareJin.size();
        // } else {
        //     result = result - lostJin.size() + mCandi.size();
        // }

        System.out.println("result: " + result);

        return result;
    }
}