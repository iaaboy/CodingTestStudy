package prog84512;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] inp = { "AAAE",
                "AAAAE",
                "EIO",
                "I",
        };

        Solution mSol = new Solution();

        for (String inStr : inp) {
            System.out.println(mSol.solution(inStr));
        }
    }
}

// AEIOU AEIOU AEIOU AEIOU AEIOU AEIOU
class Solution {
    public int solution(String word) {
        int answer = 0;

        Trie trie = new Trie();
        trie.generateNode(trie.root, 5);

        trie.dfsTrie();

        answer = trie.searchNum(word);

        return answer;
    }

    private char[] defaultIdx = { 'A', 'E', 'I', 'O', 'U' };

    class Trie {
        Ver root;

        Trie() {
            root = new Ver('r');
        }

        public int searchNum(String word) {
            for (int i = 0; i < 5; i++) {
                if (root.child[i].ch == word.charAt(0)) {
                    return searchNum(root.child[i], word);
                }
            }
            return -1;
        }

        public int searchNum(Ver curVer, String word) {
            // System.out.println("cur: " + curVer.ch + ", word:" + word);
            if (word.length() == 1 && word.charAt(0) == curVer.ch) {
                return curVer.idx;
            } else {
                for (int i = 0; i < 5; i++) {
                    if (curVer.child[i].ch == word.charAt(1)) {
                        return searchNum(curVer.child[i], word.substring(1));
                    }
                }
            }
            return -1;
        }

        public void generateNode(Ver curVer, int depth) {
            if (depth <= 0) {
                return;
            }
            // System.out.print(curVer.ch + " ");
            curVer.child = new Ver[5];
            for (int i = 0; i < 5; i++) {
                curVer.child[i] = new Ver(defaultIdx[i]);
                generateNode(curVer.child[i], depth - 1);
            }
        }

        public void dfsTrie() {
            int idx = 0;
            Stack<Ver> q = new Stack<>();
            q.add(root);

            while (!q.isEmpty()) {
                Ver curVertex = q.pop();
                curVertex.idx = idx++;
                // System.out.println(curVertex.ch + ", " + curVertex.idx);
                if (curVertex.child != null) {
                    for (int k = 4; k >= 0; k--) {
                        q.add(curVertex.child[k]);
                    }
                }
            }
        }

    }

    class Ver {
        char ch;
        int idx;
        Ver[] child = null;

        public Ver(char ch) {
            this.ch = ch;
        }
    }
}
