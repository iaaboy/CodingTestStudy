package acmicpc17244;

import java.io.*;
import java.util.*;

/* 아맞다우산
 * https://www.acmicpc.net/problem/17244
 */

public class Main {
    static int[] sequence; // X 위치를 방문하는 순서를 저장하는 배열
    static boolean[] visited; // 순열 생성 시 방문 여부를 체크하는 배열
    static int xCount; // X의 개수
    static char map[][]; // 지도를 저장하는 2차원 배열
    static int minStep = Integer.MAX_VALUE; // 최소 이동 횟수
    static Coord start, end; // 시작점(S)과 끝점(E)
    static ArrayList<Coord> targets = new ArrayList<>(); // X 위치들을 저장하는 리스트
    static int N, M; // 지도 가로(N)와 세로(M) 크기

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도 가로 크기
        M = Integer.parseInt(st.nextToken()); // 지도 세로 크기
        map = new char[M][];

        xCount = 0; // X의 개수를 초기화

        // 지도를 읽어오고, S, E, X 위치를 저장
        for (int i = 0; i < M; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') { // X 위치를 찾으면
                    xCount++;
                    targets.add(new Coord(i, j)); // X의 좌표를 리스트에 추가
                } else if (map[i][j] == 'S') { // S 위치를 찾으면
                    start = new Coord(i, j); // 시작점 설정
                } else if (map[i][j] == 'E') { // E 위치를 찾으면
                    end = new Coord(i, j); // 끝점 설정
                    map[i][j] = '#'; // 끝점은 이동할 수 없는 '#'으로 표시
                }
            }
        }

        sequence = new int[xCount]; // X 방문 순서를 저장할 배열
        visited = new boolean[xCount]; // 순열 생성 시 방문 체크 배열 초기화
        permu(0); // 순열 생성 및 최소 이동 계산
        System.out.println(minStep); // 최소 이동 횟수 출력
    }

    // 순열을 생성하는 메서드
    private static void permu(int depth) {
        if (depth == xCount) { // 순열이 완성되면
            int stepCount = getMinStep(); // 순열에 따른 최소 이동 거리 계산
            minStep = Math.min(minStep, stepCount); // 최소값 업데이트
        }

        for (int i = 0; i < sequence.length; i++) { // 순열 생성 로직
            if (!visited[i]) {
                visited[i] = true; // 방문 체크
                sequence[i] = depth; // 현재 depth 저장
                permu(depth + 1); // 재귀 호출
                visited[i] = false; // 방문 해제
            }
        }
    }

    // 현재 순열에 따른 이동 거리 계산
    private static int getMinStep() {
        if (targets.size() == 0) { // X가 없는 경우, S에서 E까지 이동 거리 계산
            return getStep(start, end);
        }

        // S에서 첫 번째 X까지 거리 계산
        int step = getStep(start, targets.get(sequence[0]));
        int result = step;

        // 순열에 따른 X 간 이동 거리 계산
        for (int i = 0; i < targets.size() - 1; i++) {
            step = getStep(targets.get(sequence[i]), targets.get(sequence[i + 1]));
            result += step;
        }

        // 마지막 X에서 E까지 거리 계산
        step = getStep(targets.get(sequence[sequence.length - 1]), end);
        result += step;
        return result; // 총 이동 거리 반환
    }

    // BFS를 사용하여 두 좌표 간 최단 거리를 계산
    private static int getStep(Coord st, Coord ed) {
        Queue<Coord> q = new ArrayDeque<>(); // BFS를 위한 큐
        boolean[][] visited = new boolean[M][N]; // 방문 체크 배열
        q.add(new Coord(st.y, st.x, 0)); // 시작 좌표를 큐에 추가
        visited[st.y][st.x] = true; // 시작점 방문 체크

        while (!q.isEmpty()) {
            Coord c = q.poll(); // 큐에서 좌표를 꺼냄
            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nextY = c.y + offsetY[i];
                int nextX = c.x + offsetX[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) { // 지도 범위 밖 확인
                    continue;
                }
                if (!visited[nextY][nextX]) { // 방문하지 않은 위치 확인
                    if (nextY == ed.y && nextX == ed.x) { // 목적지에 도달하면 거리 반환
                        return c.count + 1;
                    }
                    if (map[nextY][nextX] != '#') { // 이동 가능하면 큐에 추가
                        visited[nextY][nextX] = true;
                        q.add(new Coord(nextY, nextX, c.count + 1));
                    }
                }
            }
        }
        return -1000000; // 도달 불가능한 경우 큰 음수 반환
    }

    static int[] offsetY = { 0, -1, 0, 1 }; // 상하좌우 이동을 위한 y 변화량
    static int[] offsetX = { -1, 0, 1, 0 }; // 상하좌우 이동을 위한 x 변화량

    // 좌표와 이동 거리를 저장하는 클래스
    static class Coord {
        int y, x;
        int count = 0;

        public Coord(int y, int x) { // 좌표만 설정하는 생성자
            this.y = y;
            this.x = x;
        }

        public Coord(int y, int x, int count) { // 좌표와 이동 거리 설정하는 생성자
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public String toString() { // 좌표를 문자열로 표현
            return y + "," + x + "(" + count + ")";
        }
    }
}
