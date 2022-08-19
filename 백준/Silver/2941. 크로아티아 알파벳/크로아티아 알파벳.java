import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // 크로아티아 알파벳 받기
        String [] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String croatia = br.readLine();
        for(int i = 0; i < croatiaAlphabet.length; i++){
            // 크로아티아 알파벳이 있는 부분들을 길이 하나짜리인 a로 넣어준다.
            croatia = croatia.replaceAll(croatiaAlphabet[i], "a");
        }
        // 길이는 그냥 세면댐
        System.out.println(croatia.length());
    }
}