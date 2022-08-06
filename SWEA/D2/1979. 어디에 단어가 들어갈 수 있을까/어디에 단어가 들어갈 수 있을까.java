import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int [][] puzzle = new int[N][N];
            int ans = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    puzzle[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < N; i++){
                // 가로부터 알아보기
                int columCheck = 0;
                for(int j = 0; j < N; j++){
                    // 0이면 검은색으로 그 전까지 K와 같다면 정답
                    if(puzzle[i][j] == 0){

                        if(columCheck == K){
                            ans++;
                        }
                        // 검은색으로 가면 그동안 샜던걸 다시 초기화
                        columCheck = 0;
                        // 흰색일 경우에는 +1씩 쓸 수 있음
                    }else{
                        columCheck += 1;
                    }
                }
                if(columCheck == K){
                    ans++;
                }
            }
            // 세로 체크
            for(int j = 0; j < N; j++){
                int rowCheck = 0;
                for(int i = 0; i < N; i++){
                    if(puzzle[i][j] == 0){
                        if(rowCheck == K){
                            ans++;
                        }
                        rowCheck = 0;
                    }else{
                        rowCheck += 1;
                    }
                }
                if(rowCheck == K){
                    ans++;
                }
            }

            System.out.println("#" + tc + " "+ans);
        }
    }
}