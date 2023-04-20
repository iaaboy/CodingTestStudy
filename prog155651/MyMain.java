package prog155651;

public class MyMain {
    public static void main(String[] args) {
        //["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]
        String[][] bTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        Solution mSol = new Solution();
        mSol.solution(bTime);
    }
}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        for(String[] bt : book_time){
            convertTime(bt[0]);
            convertTime(bt[1]);
        }

        return answer;
    }
    private int convertTime(String time){
        String[] numString = time.split(":");
        

        int hour = Integer.parseInt(numString[0]);
        System.out.println(hour);
        int min = Integer.parseInt(numString[1]);
        System.out.println(min);
        int result = hour*60+min;
        System.out.println(result);
        return result;
    }
}

class TimeLog{
    int time; //시작 시간
    int startEnd; //start인지 end인지. 1 / -1
    public TimeLog(int time, int startEnd) {
        this.time = time;
        this.startEnd = startEnd;
    }
}