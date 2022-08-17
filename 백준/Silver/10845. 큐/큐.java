import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int [] queue;
    static int rear = 0, front = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                pop();

            }
            else if(command.equals("size")){
                size();
            }
            else if(command.equals("empty")){
                empty();
            }
            else if(command.equals("front")){
                front();
            }
            else if(command.equals("back")){
                back();
            }
        }
        System.out.println(sb);
    }

    static void push(int x){
        queue[++rear % queue.length] = x;
    }

    static void pop(){
        if(rear == front){
            sb.append(-1).append("\n");
        }
        else{
            // 앞에서 ++해서 그 값을 뺀다.
            sb.append(queue[++front % queue.length]).append("\n");
        }
    }

    static void size(){
        // 사이즈 값은 0부터 넣었기 때문에 +1씩 해서 뒤에 idx에서 앞에 idx를 빼준다.
        sb.append ((rear + 1) - (front + 1)).append("\n");
    }

    static void empty(){
        if(rear == front){
            sb.append(1).append("\n");
        }
        else{
            sb.append(0).append("\n");
        }
    }

    static void front(){
        if(rear == front){
            sb.append(-1).append("\n");
        }
        else{
            sb.append(queue[front + 1 % queue.length]).append("\n");
        }
    }

    static void back(){
       if(rear == front){
           sb.append(-1).append("\n");
       }
       else{
           sb.append(queue[rear]).append("\n");
       }
    }
}

