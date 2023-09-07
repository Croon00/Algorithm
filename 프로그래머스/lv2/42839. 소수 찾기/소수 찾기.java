import java.util.*;
class Solution {
    static boolean [] visited;
    static int cnt;
    static boolean [] visited2;
    public int solution(String numbers) {
        boolean [] prime = new boolean[10000000];
        // 체크를 위한 
        visited = new boolean[numbers.length()];
        // 0과 1은 소수 가 아니다
        prime[0] = true;
        prime[1] = true;
        visited2 = new boolean[10000000];
        
        for(int i = 2; i <= Math.sqrt(prime.length - 1); i++){
            // 소수라면 해당 수의 배수들은 소수가 아니다.
            if(!prime[i]){
                // i의 값은 소수 임으로 i * i 값 부터(i의 아래 배수는 이미 채움), i 만큼 더하면 i만큼 배수
                for(int j = i * i; j <= prime.length - 1; j += i){
                    prime[j] = true;
                }
            }
        }
        cnt = 0;
        dfs(numbers, "", prime);
        int answer = cnt;
        
        return answer;
        
    }
    
    // 수를 조합으로 구성하기(순서를 고려해야 한다.)
    static void dfs(String numbers, String str, boolean [] prime){
        
        // 문자가 하나라도 들어오면
        if(str != ""){
            // 맨 앞수가 0이 아니면서 소수인 경우
            if(str.charAt(0) != '0' && !prime[Integer.parseInt(str)]){
                // 중복 수가 아닌 경우
                if(!visited2[Integer.parseInt(str)]){
                    // 중복체크 해주면서 카운트하기
                    visited2[Integer.parseInt(str)] = true;
                    cnt++;
                }
            }
        }
        
        
        for(int i = 0; i <numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numbers, str + numbers.charAt(i), prime);
            visited[i] = false;
        }
    }
}