class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        // n미터인 벽
        // 벽 전체 페인트 새로 x 1미터 길이의 구역 n 개로 나누기
        // 1번부터 n번까지 번호를 붙이기
        // 롤러가 벽에서 벗어나면 안됨, 구역의 일부분만 포함되도록 칠하면 안됨
        // 길이가 m미터인 롤러
        
        boolean [] wall = new boolean[n + 1];
        
        for(int i = 0; i < section.length; i++){
            wall[section[i]] = true;
        }
        
        // n미터의 벽에서
        for(int i = 1; i <= n; i++){
            // 칠하지 않은 벽을 만나면 칠하기
            if(wall[i]){
                answer++;
                for(int j = i; j < i + m; j++){
                    // 벽에서 벗어나면 break;
                    if(j > n) break;
                    wall[j] = false;
                }
            }
        }
        
        return answer;
    }
}