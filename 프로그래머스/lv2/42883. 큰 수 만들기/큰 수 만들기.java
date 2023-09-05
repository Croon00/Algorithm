import java.util.*;
class Solution {
    
    public String solution(String number, int k) {
        int length = number.length() - k; // 전체 숫자 길이
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int index = 0;
        
        // 만들어져야 하는 숫자 길이
        for(int i = 0; i < length; i++){
            int max = 0;
            // 뒤에서부터 보면서 k만큼의 길이가 만들어 질 수 있게 가장 큰 수를 뽑는다.
            // index의 값은 0부터 시작하고 해당 숫자가 골라지면 그 앞으로는 못 고르기 때문에 필요
            for(int j = index; j <= i + k; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    // 가장 큰 값을 가진 부분 이후로 다시 시작해야 한다.
                    index = j + 1;
                }
            }
            
            sb.append(max);
        }
        

        return sb.toString();
    }
    
}