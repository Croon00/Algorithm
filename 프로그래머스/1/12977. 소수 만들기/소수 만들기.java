import java.util.*;
class Solution {
    static int cnt;
    public int solution(int[] nums) {
        int answer = -1;
        cnt = 0;
        // 주어진 숫자 중 3개의 수를 더했을때 소수가 되는 경우의 수
        
        // nums의 배열에서 숫자 3개 고르기 (3 ~ 50개 이하, 순서 상관 x이니 조합으로 구하면 되겠다)
        // 먼저 소수들 부터
        
        
        // 중복된 숫자가 들어가지 않으면서 더 했을 때 최대 수 (해당 수가 소수인지 아닌지 구별)
        boolean [] sumNum = new boolean[2998];
        
        // 0, 1은 소수가 아님
        sumNum[0] = true;
        sumNum[1] = true;
        
        // 3부터 2997 까지 소수 구하기
        // 에라스토네세스의 체로 미리 소수 구해놓기
        for(int i = 2; i <= Math.sqrt(2997); i++){
            if(sumNum[i] == true) continue;
            
            for(int j = i * i; j <= 2997; j += i){
                sumNum[j] = true;
            }
        }
        // 조합 dfs 돌리기
        dfs(nums, 0, 0, 0, sumNum);

        // answer는 cnt
        answer = cnt;
        return answer;
    }
    
    static void dfs(int [] nums,int depth, int start, int sum, boolean[] sumNum){
        // 3개 고르면
        if(depth == 3){
            // 아직 체크 안한 수면서
            // 소수인 경우만 cnt에 추가
            if(!sumNum[sum]){
                cnt++;
            }
            return;
        }
        
        // 조합으로 돌기
        for(int i = start; i < nums.length; i++){
            dfs(nums, depth + 1, i + 1, sum + nums[i], sumNum);
        }
    }
}