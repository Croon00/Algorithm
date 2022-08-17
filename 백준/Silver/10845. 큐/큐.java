import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int [] queue;
    static int rear = 0, front = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                System.out.println(pop());
            }
            else if(command.equals("size")){
                System.out.println(size());
            }
            else if(command.equals("empty")){
                if(empty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(command.equals("front")){
                System.out.println(front());
            }
            else if(command.equals("back")){
                System.out.println(back());
            }
        }


    }

    static void push(int x){
        queue[++rear % queue.length] = x;

    }

    static int pop(){
        if(empty()){
            return -1;
        }
        else{
            // 앞에서 ++해서 그 값을 뺀다.
            return queue[++front % queue.length];
        }
    }

    static int size(){
        // 사이즈 값은 0부터 넣었기 때문에 +1씩 해서 뒤에 idx에서 앞에 idx를 빼준다.
        return (rear + 1) - (front + 1);
    }

    static boolean empty(){
        if(rear == front){
            return true;
        }
        else{
            return false;
        }
    }
    
    static int front(){
        if(empty()){
            return -1;
        }
        else{
            return queue[front + 1 % queue.length];
        }
    }

    static int back(){
       if(empty()){
           return -1;
       }
       else{
           return queue[rear];
       }
    }
}

