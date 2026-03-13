/**
    m명이 늘어날때마다 서버 1대 추가 필요
    n x m <= 어느 시간대 이용자 < (n + 1) x m --> 최소 n대의 증설된 서버 운영
    
    k 시간 동안 운영 후 반납
    
    모든 이용자 게임 하기 위한 최소 몇 번 증설 필요한가?
    x대 증설 --> x 회
    
    현재 
*/
import java.util.*;

// players 만큼 돌면서 현재 게임 이용자 수 체크하여서 m 보다 큰 경우 서버 증설
// 서버 증설하면 현재 시각 + k 번까지만 증설한 서버 수 
class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        int presentServer = 0;
        int [] server = new int [24]; // 시간대 마다 서버 수
        int [] serverCnt = new int [24]; // 시간마다 증설 횟수
        
        int index = 0;
        
        // 시간대마다
        for(int player : players){
            // 현 시각 이용자 수 가 m명 이상인 경우
            if(player >= m){
                
                
                // 현재 증설된 서버가 없는 경우
                if(server[index] == 0){
                    // 그만큼 서버가 증설되야함 (k번 후까지)
                    for(int i = index; i < index + k; i++){
                        // 범위 넘어가면 끝내기
                        if(i > 23) break;
                        server[i]++;
                        
                    }
                    answer++;
                }
                
                // 이용자 수 / m이 server[index]의 증설된 서버 보다 큰 경우
                if(player / m > server[index]){

                    // 현재 시간대에 서버가 이용자수를 전부 수용 할 수 있을 때 까지
                    while(player / m > server[index]){
                    
                         // 그만큼 서버가 증설되야함 (k번 후까지)
                        for(int i = index; i < index + k; i++){
                            // 범위 넘어가면 끝내기
                            if(i > 23) break;
                            server[i]++;
                        }
                        answer++;
                    }

                }
            }
            index++;
        }
        return answer;
    }
}

