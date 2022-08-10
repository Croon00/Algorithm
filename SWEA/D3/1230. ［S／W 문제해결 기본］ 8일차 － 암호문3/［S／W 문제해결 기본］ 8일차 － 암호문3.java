import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc++){
            // 명령어 갯수
            int comandNum;
            // 암호 갯수
            int passwordNum = Integer.parseInt(br.readLine());
            // 암호 갯수만큼 가진 암호 배열
            List<Integer> passwordArr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            // 암호 받기
            for(int i = 0; i < passwordNum; i++){
                passwordArr.add(Integer.parseInt(st.nextToken()));
            }

            comandNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < comandNum; i++){
                String s = st.nextToken();
                // 명령어 받기기
               if(s.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < y; j++){
                        // x 위치에서 넣어야 하기 때문에 
                        // 그냥 x에 넣으면 뒤에 넣을 수록 앞에 들어간다.
                        // 따라서 x + j에 넣어주어야 한다.
                        passwordArr.add(x + j, Integer.parseInt(st.nextToken()));
                    }
                }
                else if(s.equals("D")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < y; j++){
                        passwordArr.remove(x);
                    }

                }
                else if(s.equals("A")){
                    int y = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < y; j++){
                        passwordArr.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }

            System.out.print("#" + tc + " ");
            for(int i = 0; i < 10; i++){
                System.out.print(passwordArr.get(i)+ " ");
            }
            System.out.println();
        }
    }
}