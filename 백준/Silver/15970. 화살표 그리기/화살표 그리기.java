import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        N개의 위치에 하나씩 점들이 주어진다.
        주어진 점들의 위치는 모두 다름 / 두 점 사이의 거리 차이는 수들의 차이
        각 점은 N개의 색깔 중 하나를 가진다.

        각 점 p에 대해서 직선 화살표를 이용해 다른 점 q에 연결해야 함 (q는 p와 같은 색깔의 점들 중 거리가 가장 가까운 점)
     */

    static class Point implements Comparable<Point>{
        int color;
        int point;


        @Override
        public int compareTo(Point o) {
            return this.point - o.point;
        }
    }
    static int N;
    static Point [] p;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        p = new Point[N];

        int ans = 0;

        // 각 점들의 좌표와 색깔 받기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = new Point();
            p[i].point = Integer.parseInt(st.nextToken());
            p[i].color = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        // 브루트포스로 두 점 사이 거리 누적해서 더하기
        for(int i = 0; i < N; i++){
            Point p1 = p[i];
            int min = 100001;

            for(int j = 0; j < N; j++){
                // 자기 자신의 점은 건너띄고
                if(p1.point == p[j].point) continue;

                    // 같은 색깔일 때
                    if(p[j].color == p1.color){
                        // 가장 최소 사이 거리 값만 가져가기
                        min = Math.min(min,Math.abs(p1.point - p[j].point));
                    }
            }
            // 최소거리가 존재하는 경우에만 ans에 누적해서 더하기
            if(min != 100001){
                ans += min;
            }
        }
        System.out.println(ans);

    }
}
