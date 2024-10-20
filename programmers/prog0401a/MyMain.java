package prog0401a;

import java.util.*;

//과제 진행하기 176962
public class MyMain {
 
    public static void main(String[] args) {
        String [][][] plans = {
            {{"music", "12:20", "11"}, 
            {"computer", "12:30", "11"},
            {"science", "12:40", "21"}, 
            {"history", "13:00", "30"}
            },
        };

        for(int i = 0; i < plans.length ; i++) {
            System.out.println(Arrays.toString(new Solution().solution(plans[i])));
        }
    }
}

class Solution {
    PriorityQueue<Cl> startQ;
    Stack<Cl> workingQ;
    int passedTime, currentTime;
    int answerIdx = 0;
    String[] answer;
    public String[] solution(String[][] plans) {
        answer = new String[plans.length];
        startQ = new PriorityQueue<>();
        workingQ = new Stack<>();

        //System.out.println(plans.length);
        for(String[] plan: plans) {
            int startMin = Integer.parseInt(plan[1].substring(0, 2)) * 60 + Integer.parseInt(plan[1].substring(3, 5));
            startQ.add(new Cl(startMin, plan[0], Integer.valueOf(plan[2])));
        }

        passedTime = 0;
        while(startQ.size() > 0){
            System.out.println("HandleStart : " + startQ.peek());
            Cl currentWork = startQ.peek();
            startQ.remove();
            handleIng(currentWork.start - currentTime);

            currentTime = currentWork.start;
            workingQ.add(currentWork);
        }

        handleIng(10000);

        return answer;
    }

    void handleIng(int passedTime) {
        while(workingQ.size() > 0){
            System.out.println(workingQ.peek());
            Cl currentWork = workingQ.peek();
            
            if(currentWork.duration > passedTime) {
                currentWork.duration -= passedTime;
                break;
            } else {
                passedTime -= currentWork.duration;
                System.out.println("Current work done: " + currentWork.Subject);       
                answer[answerIdx++] = currentWork.Subject;
                workingQ.pop();
            }
        }
    }
}

class Cl implements Comparable<Cl>{
    int start;
    String Subject;
    int duration;
    Cl(int start, String Subject, int duration) {
        this.start = start;
        this.Subject = Subject;
        this.duration = duration;
    }

    @Override
    public String toString() {
        String str = "";
        str += Subject + "," + start + "," + duration;
        return str;
    }

    @Override
    public int compareTo(Cl o) {
        if(this.start > o.start) {
            return 1;
        } else 
            return -1;
    }
}