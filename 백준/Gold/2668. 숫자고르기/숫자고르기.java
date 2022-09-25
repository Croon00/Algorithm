import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        각 idx마다 dfs를 통해서 자기 자신으로 돌아오는지 확인하여
        돌아오게 된다면 ArrayList에 추가하기
     */
    static int [] num2;
    static boolean [] visited;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int N, NUM;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num2 = new int[N + 1];
        visited = new boolean[N + 1];


        for(int i = 1; i <= N; i++){
            num2[i] = Integer.parseInt(br.readLine());
        }
        // 1부터 N까지 방문체크 하여 해당 숫자를 NUM에 넣는다.
        for(int i = 1; i <= N; i++){
            visited[i] = true;
            NUM = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }

    }
    // 0행칸에 있는 숫자가 되돌아와야 하기 때문에 해당 idx부터 시작하여 dfs하기
    static void dfs (int idx){
        if(num2[idx] == NUM){
            ans.add(NUM);
            return;
        }

        // 방문체크를 통해 들어간 곳이 없는 경우만 들리기
        if(!visited[num2[idx]]){
            visited[num2[idx]] = true;
            dfs(num2[idx]);
            visited[num2[idx]] = false;
        }
    }
}