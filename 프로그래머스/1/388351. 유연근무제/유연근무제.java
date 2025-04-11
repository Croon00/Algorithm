/**
    일주일동안 자신이 설정한 출근 희망 시각 + 10분까지 어플로 출근
    (토일 제회), n명이 설정한 출근 희망 시각 schedules, 직원들이 일주일 동안 출근한 시각 timglogs,
    시작한 요일 --> startday
    이벤트 받을 직원 몇 명인지
    
*/
import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length; // 총 사람 수
        
        // 사람 크기
        for(int i = 0; i < timelogs.length; i++){
            boolean flag = true; // 해당 사람의 이벤트 가능 여부
            int startD = startday;
            // 일주일 출근시간
            for(int j = 0; j < timelogs[0].length; j++){
                // 토 일은 건너띄기
                if(startD == 6 || startD == 7){
                    startD++;
                    if(startD == 8) startD = 1;
                    continue; 
                } 
                
                int time = timelogs[i][j];
                // 정해진 출근 시간 + 10 보다 크면 지각해서 이벤트 실패
                int timeTowork = schedules[i] + 10;
                
                // 10분 이상 더해서 60분 이상인 경우
                if(timeTowork % 100 >= 60){
                    int min = schedules[i] % 10;
                    // 1시간(100) 더하고, 50분빼기(50)
                    timeTowork = schedules[i] + 100 - 50;
                }
                
                if(timeTowork < time){
                    flag = false;
                    break;
                }
                startD++;
            }
            
            if(!flag) answer--;
        }
        return answer;
    }
}