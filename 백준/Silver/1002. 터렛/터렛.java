import java.util.*;
import java.io.*;

public class Main {

    // 조규현 좌표 x1 y1, 백승환 지표 x2 y2
    // 조규현이 계산한 류재명과의 거리 r1 백승환이 계산한 류재명과의 거리 r2
    // 류재명이 있을 수 있는 좌표의 수를 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int x1, y1, x2, y2, r1, r2;
        int T = 0;

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){

            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());


            // 두 점사이의 거리가 각 원의 반지름의 합보다 클 때는 추측할 수 있는 좌표는 2개이다
            int dist = (int)(Math.pow(x2 - x1,2) + Math.pow(y2 - y1, 2));
            int minusRadius = (int)(Math.pow(r2 - r1, 2));
            int sumRadius = (int)(Math.pow(r2 + r1, 2));

            // 각각 원을 그릴 수 있다
            // 두 좌표가 같으면 각 원에서의 거리도 같음으로 무한대이다.
            if(x1 == x2 && y1 == y2 && r1 == r2){
                sb.append(-1).append("\n");
            }
            // 두 점 사이의 거리가 각 원의 반지름의 합 보다 클때
            else if(dist > sumRadius){
                sb.append(0).append("\n");
            }

            // 한 원안에 있으면 (반지름의 차가 두 원간의 중점 거리보다 크면)
            else if(dist < minusRadius){
                sb.append(0).append("\n");
            }
            // 내접 할 때(반지름의 차가 좌표 차랑 같음)
            else if(dist == minusRadius){
                sb.append(1).append("\n");
            }
            // 외접 할 때(반지름 더한 것이 좌표 더한 것과 같다)
            else if(dist == sumRadius){
                sb.append(1).append("\n");
            }
            // 각 원이 중첩될 때 2개의 점
            else{
                sb.append(2).append("\n");
            }

        }
        System.out.println(sb);

    }
}



