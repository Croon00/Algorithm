import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 올바른 괄호 문자열을 만들 수 있는 왼쪽으로 x 칸 만큼 회전 시켰을 때 올바른 괄호 문자열이면 가능
        // 올바르게 만들 수 있는 x번의 횟수를 구하기
        
        // 하나씩 빼서 넣으니 Stack
        
        
        // 총 문자열 길이 만큼 만들 수 있다.
        for(int i = 0; i < s.length(); i++){
            // 시작부분 부터 끝까지
            String str = s.substring(i, s.length());
            // i가 진행됨에 따라 뒤에 i번 만큼을 앞에서 더 붙여준다.
            str += s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            
            boolean check = true;
            // 여는 것을 스택에 넣고 닫는 것을 보았을 때 스택에서 꺼낸다.
            // 열지도 않고 닫아버리면 이미 안됌 // 스택에 남는 것이 있으면 안됌
            for(int j = 0; j < s.length(); j++){
                if(str.charAt(j) == '[' || str.charAt(j) == '(' || str.charAt(j) == '{'){
                    stack.push(str.charAt(j));
                }
                
                else{
                    if(str.charAt(j) == ']'){
                        if(stack.isEmpty()){
                            check = false;
                            break;
                        }
                        if(stack.peek() == '['){
                            stack.pop();
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
                    else if(str.charAt(j) == ')'){
                        if(stack.isEmpty()){
                            check = false;
                            break;
                        }
                        if(stack.peek() =='('){
                            stack.pop();
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
                    else if(str.charAt(j) == '}'){
                        if(stack.isEmpty()){
                            check = false;
                            break;
                        }
                        if(stack.peek() == '{'){
                            stack.pop();
                        }
                        else{
                            check = false;
                            break;
                        }
                    }
                }
            }
            if(!stack.isEmpty()) check = false;
            if(check) answer++;
            
        }
        
        return answer;
    }
}