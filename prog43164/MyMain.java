package prog43164;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[][][] tickets = {
                // { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "SFO", "ICN" } },
                { { "ICN", "JFK" }, { "JFK", "ICN" }, { "ICN", "HND" } }
        };

        Solution mSol = new Solution();
        for (String[][] ticket : tickets) {
            System.out.println(Arrays.toString(mSol.solution(ticket)));
        }
    }
}

class Solution {
    int ticketCount = 0;
    Map<String, AirPort> airportMap = new HashMap<String, AirPort>();
    HashMap<String, Integer> ticketRemained;

    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;
        ticketRemained = new HashMap<>();
        String[] answer = new String[ticketCount + 1];

        for (int i = 0; i < ticketCount; i++) {
            AirPort ap;
            if (airportMap.containsKey(tickets[i][0])) {
                ap = airportMap.get(tickets[i][0]);
            } else {
                ap = new AirPort(tickets[i][0]);
            }
            ap.nexts.add(tickets[i][1]);
            airportMap.put(tickets[i][0], ap);

            if (airportMap.containsKey(tickets[i][1])) {
            } else {
                ap = new AirPort(tickets[i][1]);
                airportMap.put(tickets[i][1], ap);
            }
        }

        // System.out.println(airportMap);

        for (int i = 0; i < ticketCount; i++) {
            String key = tickets[i][0] + tickets[i][1];
            if (ticketRemained.containsKey(key)) {
                ticketRemained.put(key, ticketRemained.get(key) + 1);
            } else {
                ticketRemained.put(key, 1);
            }
        }

        // System.out.println(ticketRemained);

        boolean j = journey("ICN", ticketCount);
        if (j) {
            System.out.println("has answer: " + routine);
        } else {
            // System.out.println("Something wrong");
        }

        for (int k = ticketCount; k >= 0; k--) {
            answer[ticketCount - k] = routine.pop();
        }

        return answer;
    }

    Stack<String> routine = new Stack<String>();

    private boolean journey(String ap, int ticketRemainedCount) {
        boolean result = false;
        AirPort curAp = airportMap.get(ap);

        // System.out.println(ap + ",cnt:" + ticketRemainedCount);
        if (ticketRemainedCount == 0) {
            result = true;
            System.out.println(ticketRemained);
            routine.add(ap);
            return result;
        }
        for (String next : curAp.nexts) {
            String key = ap + next;
            if (ticketRemained.get(key) <= 0) {
            } else {
                ticketRemained.put(key, ticketRemained.get(key) - 1);
                result = journey(next, ticketRemainedCount - 1);
                if (result) {
                    routine.add(curAp.name);
                    break;
                } else {
                    ticketRemained.put(key, ticketRemained.get(key) + 1);
                }
            }
        }
        return result;
    }
}

class Tks {
    String st;
    String ed;
    int used;

    public Tks(String st, String ed, int used) {
        this.st = st;
        this.ed = ed;
        this.used = used;
    }

    @Override
    public String toString() {
        return st + "," + ed + ": " + used + " ";
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
        return "nexts: " + nexts.toString();
    }
}