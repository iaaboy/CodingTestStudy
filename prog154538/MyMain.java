package prog154538;

public class MyMain {
    public static void main(String[] args) {
        int[][] numbers = { { 2, 100, 4} };

        Solution mSol = new Solution();

        for (int[] num : numbers) {
            System.out.println(mSol.solution(num[0], num[1], num[2]));
            System.out.println();
        }
    }
}

class Solution {
    int Y, X, N;
    int curN ;
    int cur2 ;
    int cur3 ;
    public int solution(int x, int y, int n) {
        this.Y = y;
        this.X = x;
        this.N = n;
        curN = cur2 = cur3 = X;
        if(x==y)
            return 0;

        int rN = checkN(x, y, n);
        int result = Math.min(rN, checkNext(1));

        if(result == Integer.MAX_VALUE) {
            return -1;
        } else 
        return result;
    }

    private int checkN(int x, int y, int n) {
        if (((y - x) % n != 0)) {
            return Integer.MAX_VALUE;
        } else {
            return (y - x) / n;
        }
    }
    
    private int checkNext(int n){
        if((cur2 == Integer.MAX_VALUE) && (cur3 == Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        } else {
            if(cur2 != Integer.MAX_VALUE && cur2 < Y) {
                cur2 = cur2*2;
            } else if(cur2 != Integer.MAX_VALUE && cur2 > Y) {
                cur2 = Integer.MAX_VALUE;
            }

            if(cur3 != Integer.MAX_VALUE && cur3 < Y) {
                cur3 = cur3*3;
            } else if(cur2 != Integer.MAX_VALUE && cur3 > Y) {
                cur3 = Integer.MAX_VALUE;
            }

            System.out.println("nums:" + curN + "," + cur2 + "," + cur3);
            if((cur2 == Y) || (cur3 == Y)) {
                return n;
            }

            return checkNext(n + 1);
        }
    }
}


