import java.io.*;
import java.util.StringTokenizer;



public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, max, min, nums[], operator[], order[];

    static void input(){
        FastReader fr = new FastReader();

        N = fr.nextInt();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        nums = new int[N + 1];
        operator = new int[5];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++){
            nums[i] = fr.nextInt();
        }
        for(int i = 1; i <= 4; i++){
            operator[i] = fr.nextInt();
        }
    }


    // 피연산자 2개와 연산자가 주어졌을 때 계산하는 함수
    static int calculator(int operand1, int operator, int operand2){
        if(operator == 1){
            return operand1 + operand2;
        }
        else if(operator == 2){
            return operand1 - operand2;
        }
        else if(operator == 3){
            return operand1 * operand2;
        }
        else{
            return operand1 / operand2;
        }
    }

    static void rec_func(int k, int value){
        if(k == N){
            // int value = calculator();
            max = Math.max(value, max);
            min = Math.min(value, min);

        }
        for(int cand = 1; cand <= 4; cand++){
            if(operator[cand] >= 1){
                operator[cand]--;
                order[k] = cand;
                rec_func(k + 1, calculator(value, cand, nums[k + 1]));
                operator[cand]++;
                order[k] = 0;
            }
        }

    }


    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        sb.append(max).append(" ").append(min);
        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}