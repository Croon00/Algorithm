import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static Character [][] word = new Character[100][100];
    static StringBuilder sb;
    static int max_count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트케이스 10개
        for(int tc = 1; tc <= 10; tc++){
            String Char;
            // 가장 긴 count 구하기
            max_count = 0;
            int T = Integer.parseInt(br.readLine());
            // 100행 100열 만큼 문자 받기
            for(int i = 0; i < 100; i++){
                Char = br.readLine();
                for(int j = 0; j < 100; j++){
                    word[i][j] = Char.charAt(j);
                }
            }
            // 회문 검사하고 print
            palindrome();
            System.out.println("#" + tc + " " + max_count);
        }
    }
    
    static void palindrome() {
        // 가로 확인
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j ++){
                // 열 하나하나의 회문을 검사해야 함으로 초기화 시키면서
                String rowWord = "";
                // j 부터 100까지
                for(int k = j; k < 100; k++){
                    rowWord += word[i][k];
                    sb = new StringBuilder(rowWord);
                    // 회문일 경우 길의를 비교해서 더 큰 길이로 교체
                    if(sb.toString().equals(sb.reverse().toString())){
                        max_count = Math.max(max_count, sb.length());
                    }
                }
            }
        }

        // 세로 확인
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j ++){
                String rowWord = "";
                for(int k = j; k < 100; k++){
                    rowWord += word[k][i];
                    sb = new StringBuilder(rowWord);
                    if(sb.toString().equals(sb.reverse().toString())){
                        max_count = Math.max(max_count, sb.length());
                    }
                }
            }
        }
    }
}