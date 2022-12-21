import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N, M, tree[];

    // 문제를 역으로 뒤집었을 때 매개변수가 될 수 있는 나무를 자를 높이(H)
    static boolean determination (int H){

        // H 높이로 나무를 잘랐을 때, 얻을 수 있는 길이(M)
        // 나무의 길이로 얻을 수 있는 값이 10억(길이) x 백만(나무 갯수) 임으로 총 얻을 수 있는 길이인 sum은 long으로
        long sum = 0;

        for (int i = 1; i <= N; i++){
            if (tree[i] > H){
                sum += tree[i] - H;
            }
        }
        return sum >= M;
    }
    static void process(){
        long L = 0, R = 2000000000, ans = 0;

        // [L .. R] 범위 안에 정답이 존재
        // 이분 탐색과 determination 문제를 이용해서 찾으려하는 값을 빠르게 구할 수 있다.
        while (L <= R){
            int mid = (int) ((L + R) / 2);
            if (determination(mid)){
                ans = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        System.out.println(ans);

    }
    static void Input(){
        N = sc.nextInt();
        M = sc.nextInt();
        tree = new int[N + 1];
        for (int i = 1; i <= N; i++){
            tree[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Input();
        process();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            if(st == null || !st.hasMoreElements()) {
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
