import java.io.*;
import java.util.StringTokenizer;



public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, ans, col[];

    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        col = new int[N + 1];
    }

    // 서로 열이 같으면 공격 가능
    // 왼쪽에서 오른쪽으로 내려가는 대각선으로 행 - 열을 하였을 때 값이 같으면 공격 가능
    // 오른쪽에서 왼쪽으로 내려가는 대각선으로 행 + 열을 하였을 때 값이 같으면 공격 가능
    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1 == c2){
            return true;
        }
        if(r1 - c1 == r2 - c2){
            return true;
        }
        if(r1 + c1 == r2 + c2){
            return true;
        }
        return false;
    }


    // 재귀함수를 통해 모든 열에 대해서 말들의 체크 N의 제곱만큼 가짓수 (중복 o, 순서 o)
    // possible을 true로 두어서 만약
    static void rec_func(int row){
        if (row == N + 1){
            ans++;
        }
        else {
            for (int c = 1; c <= N; c++){
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++){
                    // (i, col[i])
                    if(attackable(row, c, i, col[i])){
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }


    }


    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);

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