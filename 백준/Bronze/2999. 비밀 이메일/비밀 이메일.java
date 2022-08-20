import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String password = br.readLine();
        // 넣을 행
        int row = 1;
        // 넣을 열
        int col = password.length();

        // row 값이 col 값 보다 작으면서
        // 암호 길이에서row 값을 나눈 값이 col값에 들어가기 때문에 이 값이 row보다 클때만
        while(row <= col && password.length() / row >= row){
            // 만약 길이의 값이 row로 나누었을 때 나머지 값이 0이면 col을 바꾸어준다.
            if(password.length() % row == 0){
                col = password.length() / row;
            }
            row++;
        }
        row = password.length() / col;
        // 암호화 한 2차 배열
        Character [][] encoding = new Character[row][col];
        // 현재 암호값의 인덱스를 가리켜주는 cnt
        int cnt = 0;
        // 이중 for문 돌면서 col과 row를 바꾸어 행부터 넣어준다.
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                encoding[j][i] = password.charAt(cnt);
                cnt++;
            }
        }
        // 정상적으로 읽기
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sb.append(encoding[i][j]);
            }
        }
        System.out.println(sb);
    }
}