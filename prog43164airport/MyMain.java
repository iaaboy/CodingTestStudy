package prog43164airport;

import java.util.*;
/*
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class MyMain {
    public static void main(String[] args) {
        String [][][] tickets = {
           // {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
            {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
        };

        Solution mSol = new Solution();
        for (String[][] ticket : tickets) {
            System.out.println(Arrays.toString(mSol.solution(ticket)));
        }
    }
}

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};

        //1 공항을 이름순으로 정렬
        TreeSet <String> sortedAiports = new TreeSet<String>();
        for(String[] ticket: tickets){
            sortedAiports.add(ticket[0]);
            sortedAiports.add(ticket[1]);
        }

        //index를 key로 공항 map생성
        Map <Integer, AirPort> airportMap = new HashMap<Integer, AirPort>();
        int index = 0;
        for(String ap : sortedAiports) {
            airportMap.put(index++, new AirPort(ap, index));
        }

        System.out.print(sortedAiports);
        System.out.print(airportMap);

        return answer;
    }
}

class AirPort{
    String name;
    int id;
    public AirPort(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ":" + name;
    }
}