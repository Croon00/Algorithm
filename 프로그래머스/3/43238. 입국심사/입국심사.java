// n명이 입국심사를 위해 줄을서서 기다린다.
// 모든 심사대는 비어있다, 동시에 한 명만 심사를 할 수 있다.
// 가장 앞에 있는 사람이 비어있는 심사대 가서 받기, 더 빨리 끝나는 곳이 있으면 가서 받음
// 시간을 최소로 하고싶다.
// 사람수 n, 걸리는 시간이 담긴 times, 

import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        
        long answer = 0;
        
        // 1명 ~ 10억명
        // 1분 ~ 10억 분 이하 걸림
        // 심사관 1 ~ 10만명 이하
        
        
        // 이분탐색을 위해 times를 정렬
        Arrays.sort(times);
        
        
        // left와 right 구하기 --> 가장 오래 걸리는 시간은 가장 시간 걸리는 심사 x 사람
        // 적은 시간 부터 큰 시간 까지 이분 탐색을 하여 심사 가능한지 체크 이분탐색으로
        long left = 0;
        long right = times[times.length - 1] * (long) n;
        
        
        while(left <= right){
            long cnt = 0;
            long mid = (left + right) / 2;
            System.out.println(mid);
            for(int i = 0; i < times.length; i++){
                cnt += mid / times[i];
            }
            
            // 가능한 시간이면 시간을 더 줄여보기
            if(cnt >= n){
                right = mid - 1;
                answer = mid;
            }
            
            // 불가능한 시간이면 시간을 더 늘리기
            else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}