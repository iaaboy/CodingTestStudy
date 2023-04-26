package prog43164airport;

import java.util.*;

/*
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class MyMain {
    public static void main(String[] args) {
        String[][][] tickets = {
                {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                //{ { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } }
        };

        Solution mSol = new Solution();
        for (String[][] ticket : tickets) {
            System.out.println(Arrays.toString(mSol.solution(ticket)));
        }
    }
}

class Solution {
    int ticketSize = 0;
    Map<Integer, AirPort> airportMap = new HashMap<Integer, AirPort>();
    Map<String, Integer> airportIndex = new HashMap<String, Integer>();

    public String[] solution(String[][] tickets) {
        String[] answer;

        ticketSize = tickets.length;
        System.out.println("ticket length: " + tickets.length);
        // 1 공항을 이름순으로 정렬
        TreeSet<String> sortedAiports = new TreeSet<String>();
        for (String[] ticket : tickets) {
            sortedAiports.add(ticket[0]);
            sortedAiports.add(ticket[1]);
        }

        // index를 key로 공항 map생성
        int index = 0;
        for (String ap : sortedAiports) {
            AirPort aa = new AirPort(ap, index);
            airportIndex.put(ap, index);
            airportMap.put(index++, aa);
        }

        //각 공항에 노드 저장
        for (String[] ticket : tickets) {
            airportMap.get(
                    airportIndex.get(ticket[0])).next.add(
                            new Node(airportIndex.get(ticket[0]), airportIndex.get(ticket[1])));
        }

        //System.out.println("airportMap" + airportMap);

        journey(airportMap.get(airportIndex.get(tickets[0][0])).next.first());

        // make answer
        System.out.println(airportIndex.get(tickets[0][0]) + ", " + routine);

        //결과 처리
        int[] resultArr = new int[routine.size() + 1];
        resultArr[0] = airportIndex.get(tickets[0][0]);
        int idx = routine.size();
        while (routine.size() - 1 > 0) {
            resultArr[idx--] = routine.peek();
            routine.pop();
        }

        answer = new String[resultArr.length];
        idx = 0;
        for(int apIdx : resultArr) {
            answer[idx++] = airportMap.get(apIdx).name;
        }

        return answer;
    }

    Stack<Integer> routine = new Stack<Integer>();

    private boolean journey(Node currentNode) {
        currentNode.visited = true;
        System.out.println(currentNode + " " + airportMap.get(currentNode.st).name);
        System.out.println(airportMap);
        // 루틴에 add
        routine.push(currentNode.ed);

        // 종점인지 체크
        if (routine.size() == ticketSize) {
            //System.out.println("종점");
            return true;
        } else {
            // 다음 지점으로 가라.
            Iterator<Node> aa = airportMap.get(currentNode.ed).next.iterator();
            while (aa.hasNext()) {
                Node nextNode = aa.next();
                if (!nextNode.visited) {
                    if (journey(nextNode)) {
                        // 종점 찾아서 리턴
                        return true;
                    } else {
                        // try next
                    }
                }
            }
        }
        //

        return false;
    }

}

class Node implements Comparable<Node> {
    int st;
    int ed;
    boolean visited;

    public Node(int st, int ed) {
        this.st = st;
        this.ed = ed;
        visited = false;
    }

    @Override
    public int compareTo(Node o) {
        if (ed > o.ed) {
            return 1;
        } else if (ed == o.ed) {
            if (st > o.st) {
                return 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return st + "," + ed + "," + visited;
    }
}

class AirPort {
    String name;
    int id;

    public AirPort(String name, int id) {
        this.name = name;
        this.id = id;
        next = new TreeSet<>();
    }

    @Override
    public String toString() {
        return id + ":" + name + "-" + next;
    }

    TreeSet<Node> next;
}