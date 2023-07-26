import java.util.*;
class Solution {
    public int[] solution(String s) {
        String str = "";
        
        int cnt = 0;
        int zeroCnt = 0;
        while(true){
            if(s.equals("1")) break;
            str = "";
            for(int i = 0; i < s.length(); i++){
                if(s.substring(i, i + 1).equals("1")){
                    str += "1";
                }
                else{
                    zeroCnt++;
                }
            }
            int strLength = str.length();
            s = Integer.toBinaryString(strLength);
           
            cnt++;
        }
        int [] answer = {cnt, zeroCnt};
        return answer;
    }
}