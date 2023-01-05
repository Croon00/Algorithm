import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> guest = new ArrayList<>();
        List<Integer> owner = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            guest.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(guest);

        st = new StringTokenizer(br.readLine());

        int cnt = 0;

        for(int i = 0; i < N; i++){
            owner.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(owner);



        for(int i = 0; i < N; i++){
            int guestCard = guest.get(i);
            int ansMid = 0;

            int L = 0;
            int R = owner.size() - 1;

            // 오래 걸리니까 이분탐색으로 찾기
            while (L <= R){
                int mid = (L + R) / 2;
                if(guestCard < owner.get(mid)){
                    ansMid = mid;
                    R = mid - 1;
                }
                else{
                    L = mid + 1;
                }
            }

            if(ansMid != 0){
                cnt++;
                owner.remove(ansMid);
            }
        }

        if((N + 1) / 2 <= cnt){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }



    }
}
