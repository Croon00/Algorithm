class Solution {
    static int [] oper;
    static int cnt;
    public int solution(int[] numbers, int target) {
        // n 개의 음이 아닌 정수들이 있다.
        // 이 정수들을 순서를 바꾸지 않고 더하거나 빼서 타겟넘버를 만드려한다.
        // 주어진 개수가 2 ~ 20개로 적음
        
        // 각 연산을 + 는 true, -는 false
        oper = new int[numbers.length];
        cnt = 0;
        dfs(0, numbers, target, 0);
        int answer = 0;
        answer = cnt;
        return answer;
    }
    
    static void dfs(int depth, int [] numbers, int target, int sum){
        
        // oper 길이만큼 dfs 했을 때
        if(depth == oper.length){
            
            
            if(target == sum){
                cnt++;
            }
            return;
        }
        
        // 더하고 dfs 하거나 빼고 dfs
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
        
    }
}