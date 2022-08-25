import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());
//            st = new StringTokenizer(br.readLine());
            String s = br.readLine();
            int ans = 1;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                // stack에 열린 괄호들을 넣는다.
                if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                    stack.push(s.charAt(i));
                }
                // 닫는 괄호들이 나왔을 때 stack의 top에
                // 해당 괄호와 같은 종류의 여는 괄호가 있다면 pop
                // 아닌 경우 괄호 짝이 안 맞음으로 ans = 0
                else if(s.charAt(i) == ']'){
                    if(stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        ans = 0;
                    }
                }
                else if(s.charAt(i) == '}'){
                    if(stack.peek() == '{'){
                        stack.pop();
                    }
                    else{
                        ans = 0;
                    }
                }
                else if(s.charAt(i) == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        ans = 0;
                    }
                }
            }
            // 다 끝났는데 스택이 비어있지 않으면 열린 괄호들이 안 닫혔음으로 ans = 0
            if (!stack.isEmpty()){
                ans = 0;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}