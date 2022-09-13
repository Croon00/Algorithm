import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // N 과 K 값
    static int N, K;
    // 주어진 card 숫자
    static String [] card;
    // 중복된 값은 빼기 위한 HashSet
    static HashSet<String> list = new HashSet<>();
    // 방문을 체크하는 visited
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        // N개의 카드 갯수 만큼 초기화
        card = new String[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            card[i] = br.readLine();
        }
        // K 값 까지 ""에 붙이기
        selectCard(K, "");
        System.out.println(list.size());
    }
    // 완전탐색인데 K번째가 입력 마다 다르게 주어지니 이 K 값을 인자인 rest로 받아서 재귀탐색을 돌린다.
    static void selectCard(int rest, String k){
        // 기회가 0이 되었을 때 해당 문자(숫자를 붙인)를 hashSet에 추가 (중복은 거름)
        if(rest == 0){
            list.add(k);
            return;
        }
        
        // N개의 카드만큼 visited를 통해서 사용한 카드인지 아닌지 확인 한다.
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                selectCard(rest - 1, k + card[i]);
                visited[i] = false;
            }
        }
    }
}
