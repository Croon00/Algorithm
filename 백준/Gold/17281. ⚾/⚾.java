
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] player;
    static int [] selected;

    static boolean [] visited;
    static int ans;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 1번 ~ 9번의 9명의 선수의 각 이닝 마다 치는 것
        player = new int[N + 1][10];
        // 각 선수의 순서를 정할 방문배열
        visited = new boolean[10];

        // 4번 타자는 1번으로 고정
        visited[4] = true;
        // 결정된 라인업
        selected = new int[10];
        selected[4] = 1;

        ans = 0;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++){
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(2);
        System.out.println(ans);


    }

    // 1번 --> 4번타자 후 나머지는 순열
    static void dfs(int cnt){
        // 9명의 타자를 모두 선정했을 경우
        if(cnt == 10){
            ans = Math.max(baseball(), ans);
            return;
        }
        for(int i = 1; i <= 9; i++){
            // 이미 결정된 타자는 건너띄고
            if(visited[i]) continue;

            visited[i] = true;
            selected[i] = cnt;
            dfs(cnt + 1);
            visited[i] = false;
        }
    }

    // 플레이
    static int baseball(){
        int score = 0;
        int batter = 1;

        // i번째 이닝 까지
        for(int i = 1; i <= N; i++){

            // 각 베이스
            boolean [] base = new boolean[4];
            int out = 0;
            // 3아웃 되기 전까지
            while (out < 3){
                // 타자는 계속 1 ~ 9 번 타자 이닝 이어서
                batter = batter % 10;
                if(batter == 0) batter = 1;
                // 해당 이닝에서 정해진 배터가 휘둘렀을 때 얻는 것
                int swing = player[i][selected[batter]];

                // 아웃일때
                if(swing == 0){
                    // 아웃 카운트 하나늘리기
                    out++;

                }
                // 1루타
                else if(swing == 1){
                    // 이미 베이스에 있는 사람들 앞으로 한 칸씩
                    for(int j = 3; j >= 1; j--){
                        if(base[j]){
                            // 3루에 있었으면
                            if(j == 3){
                                // 들어오고, 스코어
                                base[j] = false;
                                score++;
                                continue;
                            }
                            // 현재 있었던 베이스 비우고, 다음 베이스 채우기
                            base[j] = false;
                            base[j + 1] = true;
                        }
                    }
                    // 1루 채우기
                    base[1] = true;
                }

                // 2루타
                else if(swing == 2){
                    for(int j  = 3; j >= 1; j--){
                        if(base[j]){
                            // 2루타 일대는 2베이스 까지
                            if(j == 3 || j == 2){
                                base[j] = false;
                                score++;
                                continue;
                            }

                            base[j] = false;
                            base[j + 2] = true;
                        }
                    }
                    // 2루 채우기
                    base[2] = true;
                }

                // 3루타
                else if(swing == 3){
                    // 베이스에 있는 선수들 모두 들어오기
                    for(int j = 3; j >= 1; j--){
                        if(base[j]){
                            score++;
                            base[j] = false;
                        }
                    }

                    base[3] = true;
                }

                // 홈런
                else if(swing == 4){
                    // 베이스에 있는 선수들 모두 들어오기
                    for(int j = 3; j >= 1; j--){
                        if(base[j]){
                            score++;
                            base[j] = false;
                        }
                    }
                    // 자신도 득점
                    score++;
                }
                // 다음 타자로
                batter++;
            }

        }
        return score;
    }

}