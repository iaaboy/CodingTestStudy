package prog0326_2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/172928

public class MyMain {
    public static void main(String[] args) {
            String [][] park = {{"XXX","XSX","XXX"}};
            String [][] route = {{"W 1"}};

            Solution mSol = new Solution();
            for(int i = 0; i < park.length; i++) {
                System.out.println(Arrays.toString(mSol.solution(park[i], route[i])));
            }
    }
}

/*
[2, 1]
[0, 1]
[3, 1]
 */

class Solution {
    Coord curCoord, parLimit;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        curCoord = new Coord(0,0);
        parLimit = new Coord(park.length-1, park[0].length()-1);
        HashMap <Character, Coord> dirMap = new HashMap<Character, Coord>();
        dirMap.put('E', new Coord(0, 1));
        dirMap.put('W', new Coord(0, -1));
        dirMap.put('N', new Coord(-1, 0));
        dirMap.put('S', new Coord(1, 0));

        curCoord = findStart(park);

        for(String route : routes) {
            int dist = route.charAt(2) - '0';
            move(park, new Coord(dirMap.get(route.charAt(0)).y, dirMap.get(route.charAt(0)).x), dist);
        }

        answer[1] = curCoord.x;
        answer[0] = curCoord.y;

        return answer;
    }

    private Coord findStart(String[] park) {
        for(int y = 0 ; y < park.length ; y++) {
            for(int i = 0; i < park[y].length(); i++) {
                if(park[y].charAt(i) == 'S') {
                    return new Coord(y, i);
                }
            }
        }
        return null;
    }

    private void move(String[] park, Coord mv, int distance){
        int destX = curCoord.x + mv.x * distance;
        int destY = curCoord.y + mv.y * distance;

        if(destY < 0 || destY > parLimit.y) {
            return ;
        }

        if(destX < 0 || destX > parLimit.x) {
            return ;
        }
        
        //xy를 증가 시면서 장애물이 있는지 확인

        for(int i = 0; i < distance + 1; i++){
            if(park[curCoord.y + mv.y * i].charAt(curCoord.x + mv.x * i) == 'X') {
                return;
            }
        }

        curCoord.x = destX;
        curCoord.y = destY;
        return ;
    }

    class Coord {
        int y;
        int x;
        Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
