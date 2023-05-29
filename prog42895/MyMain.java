package prog42895;

import java.util.PriorityQueue;

public class MyMain {
    public static void main(String[] args) {
        int N = 5;
        int number = 55  + (5/5);

        Solution mSol = new Solution();
        //System.out.println(mSol.solution(N, number));
    }
}

class Solution {
    int N;
    public int solution(int N, int number) {
        int answer = 0;
        MidResult n0 = new MidResult(N, 1, Integer.toString(N));
        this.N = N;

        if(N == number) {
            return 1;
        }

        PriorityQueue<MidResult> wQ = new PriorityQueue<>();
        wQ.add(n0);
        MidResult n2 = new MidResult(0-N, 1,"-" + Integer.toString(N));
        wQ.add(n2);

        int currCount = 1;
        MidResult n;

        while (!wQ.isEmpty()) {
            n = wQ.poll();
            //System.out.println(n);

            if (n.nCount > currCount) {
                if(n.nCount > 8) {
                    return -1;
                }
                //System.out.println(n.nCount);
                int repeatNumber = repeatN(N, n.nCount);
                if (repeatNumber == number) {
                    answer = n.nCount;
                    //System.out.println(n); 
                    break;
                } else {
                    wQ.add(new MidResult(repeatNumber, n.nCount, Integer.toString(N) + "r" + Integer.toString(n.nCount)));
                }
                currCount = n.nCount;
            }

            // +
            if (n.curVal + N == number) {
                answer = n.nCount + 1;
                //System.out.println(n); 
                break;
            } else {
                wQ.add(new MidResult(n.curVal + N, n.nCount + 1, n.log + "+" + Integer.toString(N)));
            }

            // -
            if (n.curVal - N == number) {
                answer = n.nCount + 1;
                //System.out.println(n); 
                break;
            } else {
                wQ.add(new MidResult(n.curVal - N, n.nCount + 1, n.log + "-" + Integer.toString(N)));
            }
            // x
            if (n.curVal * N == number) {
                answer = n.nCount + 1;
                //System.out.println(n); 
                break;
            } else {
                wQ.add(new MidResult(n.curVal * N, n.nCount + 1, n.log + "*" + Integer.toString(N)));
            }
            // /
            if(n.curVal % N == 0) {
                if (n.curVal / N == number) {
                    answer = n.nCount + 1;
                    //System.out.println(n); 
                    break;
                } else {
                    wQ.add(new MidResult(n.curVal / N, n.nCount + 1, n.log + "/" + Integer.toString(N)));
                }
            } else {
                if (n.curVal - (n.curVal % N) / N == number) {
                    answer = n.nCount + 1;
                    //System.out.println(n); 
                    break;
                } else {
                    wQ.add(new MidResult(n.curVal / N, n.nCount + 1, n.log + "/" + Integer.toString(N)));
                }
            }
        }

        return answer;
    }

    public int repeatN(int n, int count) {
        if (count < 2) {
            return n;
        } else {
            return repeatN(n * 10 + N, count - 1);
        }
    }

    class MidResult implements Comparable<MidResult> {
        int curVal;
        int nCount;
        String log;
    
        public MidResult(int curVal, int nCount, String log) {
            this.curVal = curVal;
            this.nCount = nCount;
            this.log = log;
        }
    
        @Override
        public int compareTo(MidResult o) {
            if(nCount == o.nCount) {
                return Math.abs(N-curVal) - Math.abs(N-o.curVal);
            } else
            return nCount - o.nCount;
        }
    
        @Override
        public String toString() {
            return "cur: " + curVal + ", nCount: " + nCount + ", log: " + log;
        }
    }
}

