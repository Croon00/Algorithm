import java.util.*;
class Solution {
    public int solution(int n) {
        String binaryNum = Integer.toBinaryString(n);
        int oneCnt = 0;
        // 해당 n 숫자의 1 갯수 구하기
        for(int i = 0; i < binaryNum.length(); i++){
            if(binaryNum.charAt(i) == '1') oneCnt++;
        }
        int answer = 0;
        // 해당 숫자 이후 부터 1,000,000 숫자 하면서 1 카운트 해서 같으면 break
        for(int i = n + 1; i < 1000001; i++){
            int tempNum = i;
            String tempBinaryNum = Integer.toBinaryString(tempNum);
            
            int cntTempNum = 0;
            for(int j = 0; j < tempBinaryNum.length(); j++){
                if(tempBinaryNum.charAt(j) == '1') cntTempNum++;
            }
            
            if(oneCnt == cntTempNum){
                answer = tempNum;
                break;
            }
        }
        return answer;
    }
}