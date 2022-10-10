
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 앞에 [] --> 톱니바퀴 갯수, 뒤에 [] --> 톱니 수(8개)
    static int [][] sawtooth;
    static int K, ans;
    static int num;
    static int direction;


    /*
    서로의 톱니바퀴의 [2] 번째의 값과, [6]번째의 값을 유심히 살피며 돌린다.
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ans = 0;
        sawtooth = new int[5][8];

        // 4개의 톱니바퀴 상태 받기
        for(int i = 1; i <= 4; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                sawtooth[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());


        // K번의 회전
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            // 회전 시킬 톱니바퀴 번호와 회전시킬 방향 받기
            num = Integer.parseInt(st.nextToken());
            direction = Integer.parseInt(st.nextToken());
            rotated(num, direction);

        }

        ans += sawtooth[1][0];
        ans += sawtooth[2][0] * 2;
        ans += sawtooth[3][0] * 4;
        ans += sawtooth[4][0] * 8;

        System.out.println(ans);


    }

    // 1은 시계방향, -1 반시계 방향
    static void rotated(int n, int d) {
        int [] rotateDirection = new int[5];
        rotateDirection[n] = d;

        // 회전 하는 톱나바퀴가 첫 번째거 일떄
        if(n == 1){
            // 1, 2 번째 톱니 바퀴 서로 극이 다를 때 반대 방향으로
            if(sawtooth[1][2] != sawtooth[2][6]){
                if(rotateDirection[1] == 1){
                    rotateDirection[2] = -1;
                }
                else{
                    rotateDirection[2] = 1;
                }
                // 2, 3번째 톱니바퀴 서로 극이 다를 때
                if(sawtooth[2][2] != sawtooth[3][6]){
                    if(rotateDirection[2] == 1){
                        rotateDirection[3] = -1;
                    }
                    else{
                        rotateDirection[3] = 1;
                    }

                    // 3, 4번째 톱니바퀴 서로 극이 다를 때
                    if(sawtooth[3][2] != sawtooth[4][6]){
                        if(rotateDirection[3] == 1){
                            rotateDirection[4] = -1;
                        }
                        else{
                            rotateDirection[4] = 1;
                        }
                    }
                }

            }
        }

        else if(n == 2){
            // 1, 2 번째 서로 극이 다를 때 반대 방향으로
            if(sawtooth[2][6] != sawtooth[1][2]){
                if(rotateDirection[2] == 1){
                    rotateDirection[1] = -1;
                }
                else{
                    rotateDirection[1] = 1;
                }
            }
            // 2, 3번째 서로 극이 다를 때
            if(sawtooth[2][2] != sawtooth[3][6]){
                if(rotateDirection[2] == 1){
                    rotateDirection[3] = -1;
                }
                else{
                    rotateDirection[3] = 1;
                }
                // 3, 4번째 서로 극이 다를 때
                if(sawtooth[3][2] != sawtooth[4][6]){
                    if(rotateDirection[3] == 1){
                        rotateDirection[4] = -1;
                    }
                    else{
                        rotateDirection[4] = 1;
                    }
                }
            }
        }

        else if(n == 3){
            // 2, 3 번째 서로 극이 다를 때 반대 방향으로
            if(sawtooth[3][6] != sawtooth[2][2]){
                if(rotateDirection[3] == 1){
                    rotateDirection[2] = -1;
                }
                else{
                    rotateDirection[2] = 1;
                }
                // 1, 2번 째 서로 극이 다를 때
                if(sawtooth[1][2] != sawtooth[2][6]){
                    if(rotateDirection[2] == 1){
                        rotateDirection[1] = -1;
                    }
                    else{
                        rotateDirection[1] = 1;
                    }
                }
            }
            // 3, 4번째 서로 극이 다를 때
            if(sawtooth[3][2] != sawtooth[4][6]){
                if(rotateDirection[3] == 1){
                    rotateDirection[4] = -1;
                }
                else{
                    rotateDirection[4] = 1;
                }
            }
        }

        // 4번째 일때
        else{
            // 4, 3번째 서로 극이 다를 때
            if(sawtooth[4][6] != sawtooth[3][2]){
                if(rotateDirection[4] == 1){
                    rotateDirection[3] = -1;
                }
                else{
                    rotateDirection[3] = 1;
                }
                // 3, 2 번째 서로 극이 다를 때
                if(sawtooth[3][6] != sawtooth[2][2]){
                    if(rotateDirection[3] == 1){
                        rotateDirection[2] = - 1;
                    }
                    else{
                        rotateDirection[2] = 1;
                    }
                    // 2, 1번째 서로 극이 다를 때
                    if(sawtooth[1][2] != sawtooth[2][6]){
                        if(rotateDirection[2] == 1){
                            rotateDirection[1] = -1;
                        }
                        else{
                            rotateDirection[1] = 1;
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= 4; i++){
            // 해당 톱니바퀴를 정해진 방향으로 돌린다.
            if(rotateDirection[i] == 1){
                rightRotation(i);
            }
            else if(rotateDirection[i] == -1){
                leftRotation(i);
            }
        }
    }

    // 오른쪽으로 회전
    static void rightRotation(int n){
        int [] tempArr = new int[8];
        for(int i = 0; i < 8; i++){
            if(i == 0){
                tempArr[0] = sawtooth[n][7];
            }
            else{
                tempArr[i] = sawtooth[n][i - 1];
            }
        }

        for(int i = 0; i < 8; i++){
            sawtooth[n][i] = tempArr[i];
        }
    }

    // 왼쪽으로 회전
    static void leftRotation(int n){
        int [] tempArr = new int[8];
        for(int i = 0; i < 8; i++){
            if(i == 7){
                tempArr[7] = sawtooth[n][0];
            }
            else{
                tempArr[i] = sawtooth[n][i + 1];
            }
        }

        for(int i = 0; i < 8; i++){
            sawtooth[n][i] = tempArr[i];
        }
    }
}