import java.util.*;
class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            // 비지 않았을 때
            if(!stack.isEmpty()){
                // 같은 경우 pop한다
                if(s.charAt(i) == stack.peek()){
                    stack.pop();
                }
                // 다른 경우 추가
                else{
                    stack.push(s.charAt(i));
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        int answer = 0;

        if(stack.isEmpty()) answer = 1;
        else{
            answer = 0;
        }

        return answer;
    }
}