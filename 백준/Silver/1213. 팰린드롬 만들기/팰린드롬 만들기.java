import java.util.*;
import java.io.*;

public class Main {

    // 펠린드롬 만들기
    // 적절히 바꾸어서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();


        // 알파벳을 전부 받은 후 순서대로 짝수 개수인 경우 앞뒤로 더하고
        // 홀수인 경우 사이에 넣기
        int [] alphabet = new int['Z' - 'A' + 1];

        // 받은 문자열의 문자 수 ++
        for(int i = 0; i < str.length(); i++){
            alphabet[str.charAt(i) - 'A']++;

        }

        System.out.println(pelindrom(str, alphabet));

    }


    // 조건 분기를 해보자
    static String pelindrom (String str, int[] alphabet){

        // 문자열 사이즈가 짝수
        if(str.length() % 2 == 0){
            String start = "";
            String end = "";
            for(int i = 0; i <= 'Z' - 'A'; i++){
                // 홀수개 문자가 있는 경우 펠린드롬 불가능
                if(alphabet[i] % 2 != 0){
                    return "I'm Sorry Hansoo";
                }
                // 펠린드롬 만들 때 모두 짝수인 문자인 경우 양 끝에 붙익디디
               while (alphabet[i] != 0){
                    start += (char) (i + 'A');
                    end = (char) (i + 'A') + end;
                    alphabet[i] -= 2;
                }
            }
            return start + end;
        }

        // 문자열 사이즈가 홀수
        else{
            String start = "";
            String mid = "";
            String end = "";
            for(int i = 0; i <= 'Z' - 'A'; i++){
                if(alphabet[i] > 0){
                    // 문자 붙이기
                    while (alphabet[i] != 0){
                        // 남은 갯수가 홀 수 인경우
                        if(alphabet[i] % 2 != 0){
                            if(mid.length() != 0){
                                return "I'm Sorry Hansoo";
                            }
                            mid += (char) (i + 'A');
                            alphabet[i]--;
                        }
                        // 짝수 인 경우
                        else{
                            start += (char) (i + 'A');
                            end = (char) (i + 'A') + end;
                            alphabet[i] -= 2;
                        }
                    }
                }
            }
            return start + mid + end;
        }
    }
}



