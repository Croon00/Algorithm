import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [][] meeting = new int [N][2];
        int count = 0;
        int before_end_meeting = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            // 시작 시간
            meeting[i][0] = Integer.parseInt(st.nextToken());
            // 종료 시간
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료시간을 기준으로 오름 차순으로 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        // 전에 회의 종료시간이 현재 보는 회의시간의 시작 시간 보다 작거나 같으면 count++
        for(int i = 0; i < N; i++){
            if(before_end_meeting <= meeting[i][0]){
                before_end_meeting = meeting[i][1];
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}