import java.util.*;
import java.io.*;

public class Main {

    /*
    안테나로부터 모든 집까지의 거리의 총합이 최소인 경우 구하기
    그냥 풀면 20만 곱하기 10만 하여서 시간 초과
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 집의 개수 1 ~ 200,000
        List<Integer> house = new ArrayList<>();
        st = new StringTokenizer(br.readLine()); // 위치는 1 ~ 100,000

        for(int i = 0; i < N; i++){
            house.add(Integer.parseInt(st.nextToken()));
        }


        Collections.sort(house);

        // 집마다 설치 할 수 있음으로 집의 중간 값이 가장 낮은 숫자의 집의 안테나
        System.out.println(house.get((N - 1)/ 2));

    }
}
