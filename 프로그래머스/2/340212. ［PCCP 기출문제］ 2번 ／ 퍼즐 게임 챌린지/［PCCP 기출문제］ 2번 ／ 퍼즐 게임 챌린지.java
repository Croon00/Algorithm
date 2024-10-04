// n개의 퍼즐 시간 내의 풀기
// 난이도, 소요 시간
// 숙련도에 따라 틀리는 횟수
// 현재 난이도 --> diff, 퍼즐의 소요 시간 --> time_cur, 이전 퍼즐 소요시간 time_prev
// 숙련도 level, diff - level 만큼 틀리고 time_cur 만큼 시간 사용
// 추가로 time_prev 만큼 더 사용
// 전체 제한 시간 limit
// 난이도, 소요 시간 모두 양의 정수
// 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟 값을 정수로 return



import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        // 난이도 diff와 times가 각각 다른 배열에 있음으로 정렬은 x 순서가 존재함
        // 구하려는 난이도를 이분탐색으로 찾으면 될듯
        
        int maxDiff = maxDiff(diffs);
        
        int answer = search(diffs, times, limit, maxDiff);
        
        
        return answer;
    }
    
    
    // 최고 난이도
    static int maxDiff(int [] diffs){
        int max = 0;
        
        for(int diff : diffs){
            if(max < diff) max = diff;
        }
        
        return max;
    }
    
    static int search(int [] diffs, int [] times, long limit, int maxDiff){
        
        int L = 1;
        int R = maxDiff;
        int minLevel = maxDiff;
        
        
        while(L <= R){
            int mid = (L + R) / 2;
            
            // 가능하다면 숙련도를 낮춰보기
            if(solveFlag(diffs, times, limit, maxDiff, mid)){
                minLevel = Math.min(minLevel, mid);
                R = mid - 1;
            }
            
            // 불가능하다면 숙련도를 좀 더 높이기
            else if(!solveFlag(diffs, times, limit, maxDiff, mid)){
                L = mid + 1;
            }
        }
        return minLevel;
        
    }
    // 걸리는 시간 구하기
    static boolean solveFlag(int [] diffs, int [] times, long limit, int maxDiff, int level){

        // 첫번째 문제는 level1 짜리로 무조건 풀기
        long totalTime = times[0];
        
        for(int i = 1; i < diffs.length; i++){
            
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = times[i - 1];
            
            // 난이도 - 현재 레벨 만큼 다시 풀어야 한다.
            // 풀때마다 이전 퍼즐 다시 풀어야함
            int k = diff - level;
            long levelTime = 0;
            if(k >= 1){
               levelTime = k * (time_cur + time_prev);
            }
            
            
            // 그 후 현재 퍼즐을 푼다.
            levelTime += time_cur;
            
            totalTime += levelTime;
            
            // limit를 넘으면 false
            if(totalTime > limit) return false;
        }
        
        return true;
    }
}