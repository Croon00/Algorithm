import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] rope = new int[N];
        // 가장 많이 들 수 있는 중량
        int maxWeight = 0;

        // 로프들 받기
        for(int i = 0; i < N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        // 중량 오름차순으로 정렬
        Arrays.sort(rope);

        // 뒤에서부터 차례대로 최대로 들을 수 있는 중량 받기
        for(int i = 0; i < rope.length; i++){
            int weight = rope[rope.length - (i + 1)] * (i+1);
            maxWeight = Math.max(maxWeight, weight);
        }
        sb.append(maxWeight);
        System.out.println(sb);
    }
}