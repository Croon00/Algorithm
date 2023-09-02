import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        // 점심시간 도둑 --> 학생들의 번호는 체격 순으로 매겨져 있다.
        // 바로 앞 번호나 뒷 번호의 학생에게만 체육복 빌려줄 수 있음
        // 최대한 많은 학생이 체육 수업을 들어야 함
        // n 명의 학생 수 도난 당한 학생들의 번호가 담긴 lost, 여벌의 체육복을 가져온 학생들의 번호 reserve 배열
        // n 2 ~ 30명
        // 여벌의 체육복을 가져온 사람이 도난 당한 경우 하나만 도난 당하고 다른 사람 빌려주기 가능 x
        
        // 전체인원에서 lost한 사람 세고 받을 수 있는 경우를 세서 빼기

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean [] visited = new boolean[reserve.length];
        boolean [] visited1 = new boolean[lost.length];
        // 예벌이 있지만 도난 당했으면 
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                // 도난 당하면 못 빌려주기 때문에 true 만들기
                // 도난 당했지만 여벌이 있음으로 자신은 입을 수 있다.
                if(lost[i] == reserve[j]){
                    visited[j] = true;
                    // 도난이지만 여벌이 있는 사람
                    visited1[i] = true;
                    break;
                }
            }
        }
        int lostNums = lost.length;
        int canNum = 0;
        
        // lost가 있는 사람일 경우
        for(int i = 0; i < lost.length; i++){
            int lostNum = lost[i];
            // 잃은 사람이지만 여벌 있는 사람
            // 잃어버린 사람 수에서 -- 하고 다음 사람으로
            if(visited1[i]){
                lostNums--;
                continue;
            }
            
            // 받을 경우 오름 차순임으로 자기 아래 있는 사람한테 먼저 빌리기
            for(int j = 0; j < reserve.length; j++){
                //이미 빌려준 사람은 못 빌려줌
                if(visited[j]) continue;
                
                // 잃어버린 사람에 + 1이면 앞 사람한테 받을 수 있다.
                if(lostNum == reserve[j] + 1){
                    visited[j] = true;
                    canNum++;
                    break;
                }
                
                // 잃어버린 사람에 - 1이면 뒷 사람한테 받을 수 있다.
                if(lostNum == reserve[j] - 1){
                    visited[j] = true;
                    canNum++;
                    break;
                }
            }
        }
        
        // 진짜 잃어버린 사람은 lost의 사이즈에서 받을 수 있는 사람 뺀 수
        lostNums -= canNum;
        // 전체 인원에서 못 받은 사람 빼기
        answer -= lostNums;
        // 도난 당했지만 여벌이 있었던 사람은 입을 수 있다.
        return answer;
    }
} 