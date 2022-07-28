import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int num[][] = new int[9][9];
            boolean ans = true;
            
            
           for(int i = 0; i < 9; i++){
               for(int j = 0; j < 9; j++){
                   num[i][j] = sc.nextInt();
               }
           }

           // 행 확인
            for(int i = 0; i < 9; i++){
                boolean [] sign = new boolean[10];
                for(int j = 0; j < 9; j++){
                    if(sign[num[i][j]] == false){
                        sign[num[i][j]] = true;
                    }
                    else{
                        ans = false;
                        break;
                    }

                }
            }
            // 열 확인
            for(int i = 0; i < 9; i++){
                boolean [] sign = new boolean[10];
                for(int j = 0; j < 9; j++){
                    if(sign[num[j][i]] == false){
                        sign[num[j][i]] = true;
                    }
                    else{
                        ans = false;
                        break;
                    }

                }
            }
            // 격자 확인
            for(int i = 0; i <= 6; i+=3){
                for(int j = 0; j <=6; j+=3){
                    boolean [] sign = new boolean[10];
                    for(int k = i; k < i+3; k++){
                        for(int l = j; l < j+3; l++){
                            if(sign[num[k][l]] == false){
                                sign[num[k][l]] = true;
                            }
                            else{
                                ans = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(ans == true){
                System.out.println("#" + tc + " " + 1);
            }
            else{
                System.out.println("#" + tc + " " + 0);
            }

        }
    }
}