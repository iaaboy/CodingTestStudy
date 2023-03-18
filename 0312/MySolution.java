public class MySolution {
    public static void main(String[] args) {

        int[] n = { 5, 5, 3, 7 };
        int llost[][] = { { 2, 4 }, { 2, 4 }, { 3 }, { 1, 3, 4, 5 } };
        int sspare[][] = { { 1, 3, 5 }, { 3 }, { 1 }, { 3, 5, 6 } };

        Solution mSol = new Solution();

        for (int i = 0; i < 4; i++) {
            mSol.solution(n[i], llost[i], sspare[i]);
        }
    }
}

