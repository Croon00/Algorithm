import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int H  = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Character [][] map = new Character[H][W];
            int tankRow = 0;
            int tankCol = 0;
            // 높이 h, 너비 w
            for(int i = 0; i < H; i++){
                String s = br.readLine();
                for(int j = 0; j < W; j++){
                    map[i][j] = s.charAt(j);
                    // 탱크 위치 받기
                    if(s.charAt(j) == '^' || s.charAt(j) == 'v' || s.charAt(j) == '<' || s.charAt(j) == '>'){
                        tankRow = i;
                        tankCol = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();

            // command를 n번 받기
            for(int i = 0; i < N; i++){
                Character Command = str.charAt(i);
                // u인 경우 ^로 탱크 있는 위치 ^로 바꾸어주고 map범위를 넘지 않으면서
                // 해당 방향으로 갔을 때 평지라면 서로 바꾸어주고 탱크 있는 위치 바꾸기
                if(Command == 'U'){
                    map[tankRow][tankCol] = '^';
                    if(tankRow - 1 >= 0 && map[tankRow - 1][tankCol] == '.'){
                        map[tankRow-1][tankCol] = '^';
                        map[tankRow][tankCol] = '.';
                        tankRow = tankRow - 1;
                    }
                }
                else if(Command == 'D'){
                    map[tankRow][tankCol] = 'v';
                    if(tankRow + 1 < H && map[tankRow + 1][tankCol] == '.'){
                        map[tankRow + 1][tankCol] = 'v';
                        map[tankRow][tankCol] = '.';
                        tankRow = tankRow + 1;
                    }

                }
                else if(Command == 'L'){
                    map[tankRow][tankCol] = '<';
                    if(tankCol - 1 >= 0 && map[tankRow][tankCol - 1] == '.'){
                        map[tankRow][tankCol - 1] = '<';
                        map[tankRow][tankCol] = '.';
                        tankCol = tankCol - 1;
                    }
                }
                else if(Command == 'R'){
                    map[tankRow][tankCol] = '>';
                    if(tankCol + 1 < W && map[tankRow][tankCol + 1] == '.'){
                        map[tankRow][tankCol + 1] = '>';
                        map[tankRow][tankCol] = '.';
                        tankCol = tankCol + 1;
                    }
                }
                // 쐈을 때 해당 위치로 cnt로 계속 간다.
                // map 범위를 넘거나 강철벽은 만난 경우 break 한다.
                // 만난 곳이 벽돌 벽이라면 평지로 바꾸어주고 break;
                else if(Command == 'S'){
                    if(map[tankRow][tankCol] == '^'){
                        int cnt = 1;
                        while (true){
                            int temp = tankRow - cnt;
                            if(temp < 0 || map[temp][tankCol] == '#'){
                                break;
                            }
                            else if(map[temp][tankCol] == '*'){
                                map[temp][tankCol] = '.';
                                break;
                            }
                            cnt++;
                        }
                    }
                    if(map[tankRow][tankCol] == 'v'){
                        int cnt = 1;
                        while (true){
                            int temp = tankRow + cnt;
                            if(temp >= H || map[temp][tankCol] == '#'){
                                break;
                            }
                            else if(map[temp][tankCol] == '*'){
                                map[temp][tankCol] = '.';
                                break;
                            }
                            cnt++;
                        }
                    }
                    if(map[tankRow][tankCol] == '<'){
                        int cnt = 1;
                        while (true){
                            int temp = tankCol - cnt;
                            if(temp < 0 || map[tankRow][temp] == '#'){
                                break;
                            }
                            else if(map[tankRow][temp] == '*'){
                                map[tankRow][temp] = '.';
                                break;
                            }
                            cnt++;
                        }
                    }
                    if(map[tankRow][tankCol] == '>'){
                        int cnt = 1;
                        while (true){
                            int temp = tankCol + cnt;
                            if(temp >= W || map[tankRow][temp] == '#'){
                                break;
                            }
                            else if(map[tankRow][temp] == '*'){
                                map[tankRow][temp] = '.';
                                break;
                            }
                            cnt++;
                        }
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
