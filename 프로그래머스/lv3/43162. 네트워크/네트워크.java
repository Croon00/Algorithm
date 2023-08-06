class Solution {
    public int solution(int n, int[][] computers) {
        boolean [] check = new boolean[n];
        int answer = 0;
        
        // n개 까지 돌면서 아직 방문 못한 노드일 경우 갯수 늘리기
        for(int i = 0; i < n; i++){
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int [][] computers, int i, boolean[] check){
        for(int j = 0; j < computers[i].length; j++){
            // [i][j] 에서 연결된 부분을 찾으면 그 부분에 대해서 체크 하고 dfs 다시 들어가기
            if(computers[i][j] == 1 && !check[j]){
                check[j] = true;
                dfs(computers, j, check);
            }
        }
    }
}