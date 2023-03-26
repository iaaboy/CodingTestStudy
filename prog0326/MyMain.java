package prog0326;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/43163

public class MyMain {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] word = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] word2 = {"hot", "dot", "dog", "lot", "log"};        
        Solution mSol = new Solution();
        System.out.println(mSol.solution(begin, target, word));
        mSol.restore();
        System.out.println(mSol.solution(begin, target, word2));
    }
}

class Solution {        

    HashMap <String, Vertex> mMap;
    PriorityQueue<Vertex> pQ;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        mMap = new HashMap<>();
        pQ = new PriorityQueue<>();

        for(int i = 0; i < words.length ; i++ ) {
            Vertex v = new Vertex(words[i]);
            mMap.put(words[i], v);
        }

        Vertex v2 = new Vertex(begin);
        mMap.put(begin, v2);

        for(int i = 0; i < words.length ; i++ ) {
            addNode(begin, words[i]);
        }

        for(int i = 0; i < words.length ; i++ ) {
            for(int j = i ; j < words.length ; j++ ) {
                addNode(words[i], words[j]);
            }
        }

        //printStats();

        mMap.get(begin).visited = true;
        pQ.add(mMap.get(begin));
        while(pQ.size() > 0) {
            Vertex curVertex = pQ.peek();
            pQ.remove();
            if(curVertex.w.contentEquals(target)) {
                return curVertex.distance;
            }
            
            curVertex.nodes.forEach(v -> {
                if(!v.visited) {
                    v.visited = true;
                    v.distance = curVertex.distance + 1;
                    pQ.add(v);
                }
            });
        }

        //word가 변환되는 개수
        return answer;
    }

    public void restore() {
        mMap.values().stream().forEach(
            v -> {
                v.nodes.clear();            
            }
        );
        mMap.clear();
    }

    private void printStats(){
        mMap.values().stream().forEach(
            v -> {
                System.out.println(v + ": d," + v.distance + " v," + v.visited + " n," + v.nodes.size());

                for(int i = 0; i < v.nodes.size(); i++) {
                    System.out.print(v.nodes.get(i) + ",");    
                }
                System.out.println();                
            }
        );
    }

    private boolean addNode(String a, String b){
        //두 단어를 비교
        int diffCount = 0;
        for(int i = 0; i < a.length() ; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diffCount ++;
                if(diffCount >= 2) {
                    break;
                }
            }
        }

        if(diffCount == 1) {
            mMap.get(a).nodes.add(mMap.get(b));
            mMap.get(b).nodes.add(mMap.get(a));
        }
        return false;
    }

    class Vertex implements Comparable <Vertex> {
        String w;
        int distance;
        boolean visited;
        Vector <Vertex> nodes;

        Vertex (String w) {
            this.w = w;
            this.distance = 0;
            this.visited = false;
            nodes = new Vector<>();
        }

        @Override
        public int compareTo(Vertex o) {
            if(this.distance > o.distance) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return w;
        }
    }

}
