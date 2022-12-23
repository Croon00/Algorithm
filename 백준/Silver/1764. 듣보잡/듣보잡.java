import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        듣도 못하는 사람 & 보도 못한사람인 듣도보도 못한 사람을 뽑아보여주기
        HashSet을 통해서 contain으로 확인하기( O(1)의 시간복잡도를 가진다)
     */
    static int N, M; // N은 듣도 못한 사람, M은 보도 못한 사람
    static HashSet<String> hear;



    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hear = new HashSet<>();


        for(int i = 0; i < N; i++){
            String str = br.readLine();
            hear.add(str);
        }

        int cnt = 0;

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(hear.contains(str)){
                cnt++;
                ans.add(str);
            }
        }

        // 사전순으로 출력
        Collections.sort(ans);
        System.out.println(cnt);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
