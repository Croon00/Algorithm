import java.util.*;
import java.io.*;

public class Main {

    /*
        석환이가 자연수 n 장을 갖고 있다.
        i번 카드에 ai가 쓰여있다.
        카드 합체 놀이는 이 카드들을 합체하며 노는 놀이
        x번 카드와 y번 카드를 골라 그 두장에 쓰여진 수를 더한 값을 계산한다.
        계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어쓴다.

        카드 합체를 총 m번 하면 놀이 끝(m번의 합체를 모두 끝낸 뒤
        n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다. 이 점수를 가장 작게 만드는 것이 놀이의 목표

        만들 수 있는 가장 작은 점수를 계산하기

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 카드의 개수 2 ~ 1000
        m = Integer.parseInt(st.nextToken()); // 합체하는 수 0 ~ 15 X n

        long [] card = new long[n]; // 최대 15000 번 1,000,000을 더할 수 있으니 long으로
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            card[i] = Long.parseLong(st.nextToken());
        }

        // 할때마다 오름차순으로 정렬한 후 더해주기
        for(int i = 0; i < m; i++){
            // 오름 차순으로 정렬한다.
            Arrays.sort(card);
            long temp1 = card[0];
            long temp2 = card[1];
            card[0] = temp1 + temp2;
            card[1] = temp1 + temp2;
        }

        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += card[i];
        }

        System.out.println(ans);
    }
}
