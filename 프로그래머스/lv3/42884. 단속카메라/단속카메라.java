import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 오름차순으로 정렬한 후 내 나간 시점이 다음 진입 지점과 나간 지점 범위 안에 들었는지 확인하기
        
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 0;
        int min = Integer.MIN_VALUE;
        
        // route를 routes에서 전 차량의 나간 지점인 min 값 보다 다음 차량의 진입한 지점인 route[0]의 값이 더 큰 경우
        // 카메라가 새로 필요, min 값은 route의 나간 지점으로 바꾸어야한다.
        for(int [] route : routes){
            if(route[0] > min){
                cnt++;
                min = route[1];
            }
        }
        answer = cnt;
        return answer;
    }
}