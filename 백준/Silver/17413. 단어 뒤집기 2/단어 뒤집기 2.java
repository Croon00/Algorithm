import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        boolean word = false;

        for(int i = 0; i < s.length(); i++){
            // 기호 <를 만났을 경우 단어 그대로 오기 때문에 true
            if(s.charAt(i) == '<'){
                word = true;
                // 그때가지 들어왔던 단어들으 모두 pop해서 보여준다.
                while(!stack.empty()){
                    System.out.print(stack.pop());
                }
                // 그 후 <
                System.out.print(s.charAt(i));
            }

            // > 로 끝났을 경우 word 부분이 끝났음으로 false 후 >
            else if(s.charAt(i) == '>'){
                word = false;
                System.out.print(s.charAt(i));
            }
            // word 부분일 경우에는 그대로 보여주기
            else if(word == true){
                System.out.print(s.charAt(i));
            }
            // word 부분이 아닌 경우 공백 부분을 만나면 모두 뽑기
            else if(word == false){
                if(s.charAt(i) == ' ' ){
                    while (!stack.empty()){
                        System.out.print(stack.pop());
                    }
                    // 다 꺼냈으면 공백추가
                    System.out.print(" ");
                }
                // 공백이 아닌 경우 push해서 넣는다.
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        // 마지막에 공백 없는 부분을 출력
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
