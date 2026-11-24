import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 세계에서 가장 유명한 사람
        // 2-친구 : 두 사람이 친구 or 둘이 공통인 친구를 가지고 있으면
        // 가장 유명한 사람의 2-친구 수 구하기
        // NYNNN A : B
        // YNYNN B : A, C
        // NYNYN C : B, D
        // NNYNY D : C, E
        // NNNYN E : D
        // A의 친구 : (B, C) : 2 , B의 친구 (A, C, D) : 3,  C의 친구 : (B, D, E, A) : 4, D의 친구 : (C, E, B) 3, E의 친구 : (D, C) 2


        int N = Integer.parseInt(br.readLine());
        String [] friends  = new String[N];

        for (int i = 0; i < N; i++){
            friends[i] = br.readLine();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            boolean[] check = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (friends[i].charAt(j) == 'Y') {
                    check[j] = true; // 직접 친구

                    for (int k = 0; k < N; k++) {
                        if (friends[j].charAt(k) == 'Y') {
                            check[k] = true; // 친구의 친구
                        }
                    }
                }
            }

            check[i] = false; // 자기 자신 제외

            int count = 0;
            for (boolean isFriend : check) {
                if (isFriend) count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}