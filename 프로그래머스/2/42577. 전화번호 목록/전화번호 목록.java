import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        
        // 어떤 번호가 다른 번호의 접두어인 경우가 잇으면 false 아니면 true return
        
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i + 1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }
}