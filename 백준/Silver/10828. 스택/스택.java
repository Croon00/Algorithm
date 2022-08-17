import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int top;
    static int [] Stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack = new int[N];
        top = -1;
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
                if(isEmpty() == true){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(command.equals("top")){
                top();
            }
        }
    }

    static void push(int X){
        if(isFull()){

        }
        else{
            Stack[++top] = X;
        }
    }

    static boolean isFull(){
        if(top == Stack.length - 1){
            return true;
        }else{
            return false;
        }
    }

    static boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    static void pop(){
        if(isEmpty()){
            System.out.println(-1);
        }
        else{
            System.out.println(Stack[top--]);
        }
    }

    static void size(){
        if(isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(top + 1);
        }
    }
    static void top(){
        if(isEmpty()){
            System.out.println(-1);
        }
        else{
            System.out.println(Stack[top]);
        }
    }
}
