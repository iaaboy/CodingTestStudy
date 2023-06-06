package prog43164airport;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[][][] tickets = {
                // {{"ii", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                { { "ii", "aa" }, { "ii", "bb" }, { "aa", "bb" }, { "bb", "ii" }, { "bb", "aa" } }
        };

        Solution mSol = new Solution();
        for (String[][] ticket : tickets) {
            System.out.println(Arrays.toString(mSol.solution(ticket)));
        }
    }
}

class Solution {
    int ticketSize = 0;
    Map<String, AirPort> airportMap = new HashMap<String, AirPort>();
    HashMap<String, Boolean> ticketUsed;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        TreeSet<String> airports = new TreeSet<>();

        ticketUsed = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            AirPort ap;
            if (airportMap.containsKey(tickets[i][0])) {
                ap = airportMap.get(tickets[i][0]);
            } else {
                ap = new AirPort(tickets[i][0]);
            }
            ap.nexts.add(tickets[i][1]);
            airportMap.put(tickets[i][0], ap);
            ticketUsed.put(tickets[i][0] + tickets[i][1], false);
            airports.add(tickets[i][0]);
        }

        System.out.println(airportMap);
        System.out.println(ticketUsed);

        for (String aiport : airports) {
            journey(aiport);

            for (String a : ticketUsed.keySet()) {
                ticketUsed.put(a, false);
            }
        }

        return answer;
    }

    Stack<Integer> routine = new Stack<Integer>();

    private boolean journey(String ap) {

        while (true) {
            System.out.println(ap);
            AirPort curAp = airportMap.get(ap);
            boolean hasNext = false;
            for (String next : curAp.nexts) {
                if (ticketUsed.get(ap + next)) {
                } else {
                    hasNext = true;
                    ticketUsed.put(ap + next, true);
                    ap = next;
                    break;
                }
            }
            if (!hasNext) {
                break;
            }
        }

        System.out.println(ticketUsed);
        return false;
    }

}

class AirPort {
    String name;

    public AirPort(String name) {
        this.name = name;
    }

    TreeSet<String> nexts = new TreeSet<>();;

    @Override
    public String toString() {
        return nexts.toString();
    }
}