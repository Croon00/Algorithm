import java.util.*;
import java.io.*;

public class Main {

    /*
        스택은 기본적인 자료구조
        LIFO
        1 부터 n 까지의 수를 스택에 넣었다가 뽑아 늘어놓는 걸로 수열 만들 수 있음
        push하는 순서는 오름차순 지킴
        임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지
        있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지 알아낼 수 있는지 계산하는 프로그램

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 1 ~ 100,000
        int [] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine()); // 1 이상 n 이하의 정수
        }

        Stack<Integer> stack = new Stack<>();

        // 0번째 index부터 체크
        // 1번 부터 넣음으로 cnt는 1 부터
        int index = 0;
        int cnt = 1;
        stack.push(cnt);
        List<String> cal = new ArrayList<>();
        // 1 추가 함으로 + 추가
        cal.add("+");
        while (true){
            // cnt 값이 n + 1 인 경우 n을 초과 함으로 종료
            if(cnt == n + 1) break;
            // 스택이 비어있지 않을 경우
            if(!stack.isEmpty()){
                // 스택의 peek가 현재 수열에서 index 부분과 같을 경우 pop을 하고 -추가 한 후 index 증가
                if(stack.peek() == num[index]){
                    stack.pop();
                    cal.add("-");
                    index++;
                }
                // peek 값이 수열에서 index 부분과 같지 않을 경우 cnt증가 한 후 push 한 후 + 추가
                else {
                    cnt++;
                    stack.push(cnt);
                    cal.add("+");
                }
            }
            // 스택이 비어있는 경우 cnt 증가한 후 추가한다.
            else{
                // cnt 값이 n을 초과하는 경우 이것은 수열 만들기 불가능 함으로 break
                if(cnt + 1 == n + 1) break;
                cnt++;
                stack.push(cnt);
                cal.add("+");
            }
        }

        // index 의 값이 num 수열의 길이와 같은 경우 가능한 경우 임으로 출력 그 외에는 NO
        if(index == num.length){
            for(int i = 0; i < cal.size(); i++){
                System.out.println(cal.get(i));
            }
        }
        else{
            System.out.println("NO");
        }

    }
}
