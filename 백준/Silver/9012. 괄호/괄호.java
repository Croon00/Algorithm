import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String Parenthesis = br.readLine();

            if(Stack_bracket(Parenthesis) == true){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }


    }
    static boolean Stack_bracket (String s){
        Stack<Character> stack = new Stack<>();
        // 스택에 ( 넣기
        for(int i = 0; i < s.length(); i++){
            // String 에서 ( 만났을 때
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty()){
                return false;
            }
            else{
                stack.pop();
            }
        }
        // 다 끝나고 스택이 비어있다면 true;
        if(stack.isEmpty()){
            return true;
        }
        // 다 끝나고 스택이 비어있지 않다면 false;
        else{
            return false;
        }
    }
}

