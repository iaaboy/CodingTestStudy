package prog84021;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] game_board = {
                { 1, 1, 0 },
                { 0, 0, 0 },
                { 1, 1, 1 } };
        int[][] table = {
                { 1, 1, 1 },
                { 1, 0, 0 },
                { 0, 0, 0 } };

        // int m = 7;
        // int[][] game_board = new int[m][m];
        // int[][] table = new int[m][m];

        // Random random = new Random();
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < m; j++) {
        // game_board[i][j] = random.nextInt(2);
        // table[i][j] = random.nextInt(2);
        // }
        // }

        Solution mSol = new Solution();
        System.out.println(mSol.solution(game_board, table));
    }
}

class Solution {
    int[][] game_board;
    int[][] table;
    int idIdx = 2;
    int n;
    HashMap<Integer, Figure> boarddShapes;
    HashMap<Integer, Figure> tableShapes;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        this.game_board = game_board;
        this.table = table;
        n = game_board.length;
        boarddShapes = new HashMap<>();
        tableShapes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (game_board[i][k] == 0) {
                    Figure fg;
                    if (boarddShapes.containsKey(idIdx)) {
                        fg = boarddShapes.get(idIdx);
                    } else {
                        fg = new Figure(false, idIdx);
                        boarddShapes.put(idIdx, fg);
                    }
                    findPuzzle(game_board, i, k, 0, idIdx++, fg);
                }
            }
        }

        idIdx = 2;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (table[i][k] == 1) {
                    Figure fg;
                    if (tableShapes.containsKey(idIdx)) {
                        fg = tableShapes.get(idIdx);
                    } else {
                        fg = new Figure(true, idIdx);
                        tableShapes.put(idIdx, fg);
                    }
                    findPuzzle(table, i, k, 1, idIdx++, fg);

                }
            }
        }

        // base보정
        for (Figure f : boarddShapes.values()) {
            f.nodes = rebaseYX(f.nodes);
        }

        for (Figure f : tableShapes.values()) {
            f.nodes = rebaseYX(f.nodes);

            for (Node node : f.nodes) {
                f.nodes90.add(new Node(node.x, -node.y));
            }
            f.nodes90 = rebaseYX(f.nodes90);

            for (Node node : f.nodes90) {
                f.nodes180.add(new Node(node.x, -node.y));
            }
            f.nodes180 = rebaseYX(f.nodes180);

            for (Node node : f.nodes180) {
                f.nodes270.add(new Node(node.x, -node.y));
            }
            f.nodes270 = rebaseYX(f.nodes270);
        }

        // printBoard(game_board);
        // System.out.println(boarddShapes);
        // printBoard(table);
        // System.out.println(tableShapes);

        for (Figure boardFigure : boarddShapes.values()) {
            for (Figure tablFigure : tableShapes.values()) {
                if (tablFigure.isHandled)
                    continue;
                if (boardFigure.boardEqualsTable(tablFigure)) {
                    tablFigure.isHandled = true;
                    answer += tablFigure.nodes.size();
                    break;
                }
            }
        }
        return answer;
    }

    ArrayList<Node> rebaseYX(ArrayList<Node> nodes) {
        int baseX = Integer.MAX_VALUE;
        int baseY = Integer.MAX_VALUE;
        ArrayList<Node> newNodes = new ArrayList<>();

        // baseX와 baseY를 구한다.
        for (Node n : nodes) {
            if (n.x < baseX) {
                baseX = n.x;
            }
            if (n.y < baseY) {
                baseY = n.y;
            }
        }

        for (Node node : nodes) {
            node.y -= baseY;
            node.x -= baseX;
            newNodes.add(node);
        }

        newNodes.sort(null);

        return newNodes;
    }

    void findPuzzle(int[][] findFrom, int baseY, int baseX, int mark, int id, Figure fg) {
        Queue<Node> nodes = new LinkedList<>();
        findFrom[baseY][baseX] = id;
        nodes.add(new Node(baseY, baseX));

        while (!nodes.isEmpty()) {
            Node curNode = nodes.poll();
            int x = curNode.x;
            int y = curNode.y;
            fg.nodes.add(new Node(y, x));

            // 위
            if (y - 1 >= 0) {
                if (findFrom[y - 1][x] == mark) {
                    findFrom[y - 1][x] = id;
                    nodes.add(new Node(y - 1, x));
                }
            }

            // 아래
            if (y + 1 < n) {
                if (findFrom[y + 1][x] == mark) {
                    findFrom[y + 1][x] = id;
                    nodes.add(new Node(y + 1, x));
                }
            }

            // 좌
            if (x - 1 >= 0) {
                if (findFrom[y][x - 1] == mark) {
                    findFrom[y][x - 1] = id;
                    nodes.add(new Node(y, x - 1));
                }
            }

            // 우
            if (x + 1 < n) {
                if (findFrom[y][x + 1] == mark) {
                    findFrom[y][x + 1] = id;
                    nodes.add(new Node(y, x + 1));
                }
            }
        }
    }

    void printBoard(int[][] board) {
        for (int[] bd : board) {
            for (int b : bd) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}

class Figure {
    boolean isHandled;
    boolean isTable;
    int index;
    ArrayList<Node> nodes;
    ArrayList<Node> nodes90;
    ArrayList<Node> nodes180;
    ArrayList<Node> nodes270;

    Figure(boolean isTable, int index) {
        nodes = new ArrayList<>();
        this.isTable = isTable;
        this.index = index;
        if (isTable) {
            nodes90 = new ArrayList<>();
            nodes180 = new ArrayList<>();
            nodes270 = new ArrayList<>();
        }
    }

    public boolean boardEqualsTable(Figure table) {
        if (this.nodes.size() != table.nodes.size()) {
            return false;
        }

        boolean isMatched = true;
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).compareValues(table.nodes.get(i))) {
                isMatched = false;
                break;
            }
        }
        if (isMatched)
            return true;

        isMatched = true;
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).compareValues(table.nodes90.get(i))) {
                isMatched = false;
                break;
            }
        }

        if (isMatched)
            return true;
        isMatched = true;
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).compareValues(table.nodes180.get(i))) {
                isMatched = false;
                break;
            }
        }

        if (isMatched)
            return true;

        isMatched = true;
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).compareValues(table.nodes270.get(i))) {
                isMatched = false;
                break;
            }
        }

        return isMatched;
    }

    @Override
    public String toString() {
        String result = index + " :handled-" + isHandled + " , " + nodes.toString() + "\n";
        // if (isTable) {
        // result += "\n090: " + nodes90.toString();
        // result += "\n180: " + nodes180.toString();
        // result += "\n270: " + nodes270.toString();
        // }
        return result;
    }
}

class Node implements Comparable<Node> {
    int y;
    int x;

    public boolean compareValues(Node obj) {
        return y == obj.y && x == obj.x;
    }

    @Override
    public int compareTo(Node o) {
        if (y == o.y) {
            return x - o.x;
        } else {
            return y - o.y;
        }
    }

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "y:" + y + ",x:" + x;
    }
}