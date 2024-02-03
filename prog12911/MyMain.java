package prog12911;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();

        for (int i = 1; i < 1000; i+=1)
            mSol.solution(i);
    }
}

class Solution {
    static int prevNum = -1;
    static int firstDiff = -1;
    static int index = 0;
    static int[] bitArray;

    public int solution(int n) {
        BitSet inBitSet = BitSet.valueOf(new long[] { n });
        int cardinal = inBitSet.cardinality();
        prevNum = -1;
        firstDiff = -1;
        index = 0;
        bitArray = new int[cardinal];

        inBitSet.stream().forEach(bit1 -> {
            bitArray[index] = bit1;
            if (index != 0 && firstDiff == -1) {
                if (prevNum != bit1 - 1) {
                    firstDiff = index;
                }
            }
            prevNum = bit1;
            index++;
        });

        int isZeroStart = inBitSet.stream().findFirst().getAsInt();
        // System.out.println(n + "->" + numToBinStr(n) + Arrays.toString(bitArray) + ":" + firstDiff + " " + isZeroStart);

        // 값 구하기
        index = 0;
        if (isZeroStart == 0) {
            if (firstDiff == -1) {
                firstDiff = cardinal;
            }
            firstDiff--;
            inBitSet.stream().forEach(bit1 -> {
                if (firstDiff == index) {
                    bitArray[index]++;
                } else {
                }
                index++;
            });
            // System.out.println("  ->" + numToBinStr(oldSol(n)) + Arrays.toString(bitArray));
        } else {
            if(firstDiff == -1) {
                firstDiff = cardinal;
            }
            int count = 0;
            for(int i =0; i < firstDiff - 1 ; i++) {
                bitArray[i] = count++;
            }
            bitArray[firstDiff - 1]++;
            // System.out.println("  *->" + numToBinStr(oldSol(n)) + Arrays.toString(bitArray));
        }
        
        BitSet resultBitSet = new BitSet();
        for(int bIndex : bitArray) {
            resultBitSet.set(bIndex);
        }
        // System.out.println(resultBitSet);
        int result = (int)resultBitSet.toLongArray()[0];

        // if(result != oldSol(n)) {
        //     System.out.println("Something wrong: " + result + " vs " +  oldSol(n));
        //     System.out.println(numToBinStr(result) + " vs " +  numToBinStr(oldSol(n)) + ">" + BitSet.valueOf(new long[] { oldSol(n) }).toString());
        // }

        return result;
    }

    public int oldSol(int n) {
        BitSet inBitSet = BitSet.valueOf(new long[] { n });
        int bitCount = inBitSet.cardinality();
        int numberNext = n + 1;

        for (; numberNext < 1000001; numberNext++) {
            BitSet checkBitSet = BitSet.valueOf(new long[] { numberNext });
            if (checkBitSet.cardinality() == bitCount) {
                break;
            }
        }

        return numberNext;
    }

    static int lastBit;

    String numToBinStr(int n) {
        BitSet testBS = BitSet.valueOf(new long[] { n });

        testBS.stream().forEach((b) -> {
            lastBit = b;
        });
        StringBuffer binString = new StringBuffer();
        for (int i = 0; i <= lastBit; i++) {
            binString.append(testBS.get(i) ? "1" : "0");
        }
        return binString.toString();
    }
}