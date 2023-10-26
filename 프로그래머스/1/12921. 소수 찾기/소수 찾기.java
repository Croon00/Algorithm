import java.util.*;
class Solution {
    public int solution(int n) {
        
        // 1부터 입력 받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수
        
        // 에라스토 테네스의 체로 구하기
        
        int answer = 0;
        
        boolean [] isPrime = new boolean[n + 1];
        
        isPrime[0] = true;
        isPrime[1] = true;
        
        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true){
                continue;
            }
            else{
                answer++;
                if(i <= Math.sqrt(n)){
                    for(int j = i * i; j <= n; j += i){
                        isPrime[j] = true;
                    }   
                }
            }
        }
  

        return answer;
    }
}