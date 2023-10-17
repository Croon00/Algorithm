import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        int answer = -1;
        // 5 1개로 만들 수 있는 숫자 --> 5
        // 5 2개로 만들 수 있는 숫자 --> 5 + 5, 5 - 5, 5 * 5, 5 / 5
        // 5 3개로 만들 수 있는 숫자 --> 1개로 만들 수 있는 수 5에서 2 개로 만들 수 있는 연산 붙이기 or 2개로 만들 수 있는 연산 에 1개로 만들 수 있는 숫자 붙이기
        // 5 4개로 만들 수 있는 숫자 --> 3개로 만들 수 있는 수에서 1개로 만들 수 있는 숫자 or 2개 2개 or 1개 3개
        // 5 5개로 만들 수 있는 숫자 --> 4개로 만들 수 있는 수에서 1개로 만들수 있는 숫자 , 
        // 만들 수 있는 개수 최솟값 8개 초과 일경우 - 1 리턴
        
        
        // 각 개수로 만들 수 있는 수가 중복되지 않게 들어가기 위해 Set
        List<HashSet<Integer>> dp = new ArrayList<>();
    
        // 리스트 초기화
        
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<Integer>());
        }
        // 1개인 경우 자기 자신 수 이다.
        dp.get(1).add(N);
        
        // 2개 부터 8개의 숫자 필요한 가지수
        for(int i = 2; i <= 8; i++){
            
            // n개의 가지로 만들 수 있는 자신의 수 --> i개 만큼 N개 붙여서 넣기
            String num = String.valueOf(N);
            for (int j = 1; j < i; j++) {
                num += String.valueOf(N);
            }
            dp.get(i).add(Integer.parseInt(num));
            
            // 1개 필요한 가지수를 시작으로 하여서 i만큼 필요한 가지수
            for(int j = 1; j < i; j++){
                // 끝의 가지수 경우의 수는 현재 필요한 i의 값에서 j 만큼 뺀 가지수
                int k = i - j;
                // 각 가지의 수에서 값을 구해서 4칙 연산 넣기
                for(int num1 : dp.get(j)) {
                    for(int num2 : dp.get(k)){
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0){
                            dp.get(i).add(num1 / num2);
                        }
                        
                    }
                }
            }
            
            if(dp.get(i).contains(number)){
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}