import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 원형 큐로 만들기
    static int [] dequeue;
    // 원형 큐이기 때문에 모두 0으로 초기화.
    static int front = 0, rear = 0, size = 0;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 어차피 명령 수 보다 높게 크기는 만들어 질 수 없기 때문에 최대 명령수 N 크기
        dequeue = new int[N];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_back")){
                int X = Integer.parseInt(st.nextToken());
                push_back(X);
            }
            else if(s.equals("push_front")){
                int X = Integer.parseInt(st.nextToken());
                push_front(X);
            }
            else if(s.equals("pop_front")){
                pop_front();
            }
            else if(s.equals("pop_back")){
                pop_back();
            }
            else if(s.equals("size")){
                size();
            }
            else if(s.equals("empty")){
                empty();
            }
            else if(s.equals("front")){
                front();
            }
            else if(s.equals("back")){
                back();
            }
        }
        System.out.println(sb);
    }

    // front는 현재 가리키는 자리에 넣고 다음에 빈칸(-1한 위치)을 가리킨다.
    static void push_front(int x){
        dequeue[front--] = x;
        // 만약 front의 값이 음수라면 맨뒤에 가서 deque의 끝에 부터 넣기
        if(front < 0){
            front = dequeue.length - 1;
        }

        size++;
    }
    // rear를 한 칸 늘리고 거기다가 넣기 / 원형 큐이기 때문에 deque의 길이 만큼 나눈 나머지 값으로 넣기
    static void push_back(int x){
        rear = (rear + 1) % dequeue.length;
        dequeue[rear] = x;
        size++;

    }
    // 현재는 빈칸을 가리키고 있고 +1 한 앞칸에 값이 들어있다.
    static void pop_front(){
        if(size == 0){
            sb.append(-1).append("\n");
        }
        else{
            // +1한 값에서 만약 크기가 deque의 크기를 넘을 수 있음으로 deque의 나머지 값으로 넣기
            int temp = dequeue[(front + 1) % dequeue.length];
            // 그 후 front가 가리키는 값은 앞으로 한 칸 땡기기
            front = (front + 1) % dequeue.length;
            size--;
            sb.append(temp).append("\n");
        }
    }
    // 현재 rear가 가리키는 값에 값이 들어있음으로 rear에 위치한 값을 받고 --
    static void pop_back(){
        if(size == 0){
            sb.append(-1).append("\n");
        }
        else{
            int temp = dequeue[rear--];
            // 만약 rear의 값이 음수면 deque의 마지막 부분을 가리키기
            if(rear < 0){
                rear = dequeue.length - 1;
            }
            size--;
            sb.append(temp).append("\n");
        }
    }
    static void size(){
        sb.append(size).append("\n");
    }
    static void empty(){
        if(size == 0){
            sb.append(1).append("\n");
        }
        else{
            sb.append(0).append("\n");
        }
    }
    // front가 가리키는 바로 앞에 값이 front 값 (사이즈를 넘어가지 못하게 나머지 값)
    static void front(){
        if(size == 0){
            sb.append(-1).append("\n");
        }
        else{
            sb.append(dequeue[(front + 1) % dequeue.length]).append("\n");
        }
    }
    // rear가 가리키고 있는 값이 back 값
    static void back(){
        if(size == 0){
            sb.append(-1).append("\n");
        }
        else{
            sb.append(dequeue[rear]).append("\n");
        }
    }
}
