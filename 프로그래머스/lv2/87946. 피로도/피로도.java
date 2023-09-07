class Solution {
    static int max;
    static boolean [] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        // xx게임에는 피로도 시스템 이 있다.
        // 일정 피로도를 사용해서 던전 돌기
        // 최소 필요 피로도, 소모되는 피로도 2가지 존재
        // 최대한 많은 던전을 탐험하기
        // k는 1 ~ 5000
        // dungeons의 개수는 1 ~ 8이하
        
        // 던전의 개수가 1 ~ 8 이하임으로 충분히 완탐가능
        max = 0;
        
        visited = new boolean[dungeons.length];
        answer = 0;
        dfs(0, dungeons, k, 0);
        
        return answer;
    }
    
    // 던전을 도는 순서에 따라 달라짐으로 순서 있음(순열)
    static void dfs(int cnt, int [][] dungeons, int fatigue, int ans) {
        // 던전 다 돌아본 후
        if(cnt == dungeons.length){
            answer = Math.max(answer, ans);
        }
        
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            // 현재 남은 피로도가 최소 필요 피로도 이상이면서
            // fatigue의 값이 해당 던전을 돌을 수 있는 경우 빼주고, ans++
            if(fatigue >= dungeons[i][0] && fatigue - dungeons[i][1] >= 0){
                dfs(cnt + 1, dungeons, fatigue - dungeons[i][1], ans + 1);
            }
            // 아닌 경우 카운트 횟수는 늘리되 피로도는 그대로, ans도 그대로
            else{
                dfs(cnt + 1, dungeons, fatigue, ans);
            }
            visited[i] = false;
        }
    }
}