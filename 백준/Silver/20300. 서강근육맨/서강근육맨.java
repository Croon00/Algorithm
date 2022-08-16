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
        // 운동 기구마다의 근손실양
        long [] health = new long[N];
        // 2개의 근손실양을 더해줄 뒤에서 부터 읽는 운동기구 idx
        int number = N - 1;
        // 근손실
        long lostOfMuscle = 0;
        st = new StringTokenizer(br.readLine());
        // 운동기구 근손실양 받기
        for(int i = 0; i < N; i++){
            health[i] = Long.parseLong(st.nextToken());
        }
        // 오름차순으로 정렬
        Arrays.sort(health);

        // 만약 주어진 운동 기구가 홀수 일때
        if(N % 2 != 0){
            // 제일 뒤에거는 제외하기 위해 number--
            number--;
            // 맨 앞과 맨 뒤의 근손실 양을 더하면시 비교해야 제일 적은 근손실 계산가능
            for(int i = 0; i < N / 2; i++){
                // 비교해가면서 더 큰 근손실 양을 구함
                lostOfMuscle = Math.max(lostOfMuscle, health[i] + health[number]);
                // 뒤에서 -- 해가면서 idx 줄이기
                number--;
            }
            lostOfMuscle = Math.max(lostOfMuscle, health[N - 1]);
        }
        // 짝수일때는 맨 마지막날 또한 2개로 구한다.
        else{
            for(int i = 0; i < N / 2; i++){
                lostOfMuscle = Math.max(lostOfMuscle, health[i] + health[number]);
                number--;
            }
        }
        System.out.println(lostOfMuscle);
    }
}
