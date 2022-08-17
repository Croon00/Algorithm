import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            sb.append("#" + tc + " ");
            Stack<Integer> stack = new Stack<>();
            int K = Integer.parseInt(br.readLine());
            for(int i = 0; i < K; i++){
                int num = Integer.parseInt(br.readLine());
                if(num == 0){
                    stack.pop();
                }
                else{
                    stack.push(num);
                }
            }

            for(int i = 0; i < stack.size(); i++){
                sum += stack.get(i);
            }
            sb.append(sum);
            System.out.println(sb);
        }
    }
}