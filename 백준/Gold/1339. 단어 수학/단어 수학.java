import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 각 알파벳 마다 가치를 주기 위해
        // 1100 = A, 100 = B 등
        int [] alphabet = new int[26];

        String [] alphabets = new String[N];

        for(int i = 0; i < N; i++){
            alphabets[i] = br.readLine();

            int unit = 1;
            for(int j = alphabets[i].length() - 1; j >= 0; j--){
                // 해당 위치의 알파벳에 unit의 가치만큼 더해주고 다음 단위는 *10 해서 주기
                alphabet[alphabets[i].charAt(j) - 'A'] += unit;
                unit *= 10;
            }
        }

        // 가장 큰 단위의 값 부터 * 9 해서 더해주면 된다.
        Arrays.sort(alphabet);

        int ans = 0;
        int num = 9;
        for(int i = alphabet.length - 1; i >= 0; i--){
            if(alphabet[i] == 0) break;

            ans += alphabet[i] * num;
            num--;
        }

        System.out.println(ans);


    }
}
