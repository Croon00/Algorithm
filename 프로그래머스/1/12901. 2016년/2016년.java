class Solution {
    public String solution(int a, int b) {
        // 윤년
        
        
        int [] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String [] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        // 현재 달과 일, 요일을
        int monthCnt = 1;
        int dayCnt = 1;
        int weekCnt = 5;
        
        String answer = "";
        
        while(true){
            // 해당 날짜일 경우
            if(a == monthCnt && b == dayCnt){
                answer += week[weekCnt];
                break;
            }
            // 해당 날짜가 아닐 경우
            // 날짜 ++, 요일 ++
            dayCnt++;
            weekCnt = (weekCnt + 1) % 7;
            
            // 만약 해당 달의 마지막 날짜 이후인 경우 1일로 변경하고 달++
            if(dayCnt == month[monthCnt - 1] + 1){
                dayCnt = 1;
                monthCnt++;
            }
            
        }
        
        return answer;
    }
}