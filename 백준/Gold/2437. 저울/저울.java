import java.util.*;
import java.io.*;

public class Main {

    // 저울
    // 하나의 양팔 저울을 이용하여 물건의 무게를 측정
    // 양 팔 끝에는 물건이나 추를 올려놓는 접시가 달려있음
    // 양팔의 길이가 같음
    // 저울의 한쪽에는 저울추들만 놓을 수 있고 다른쪽에 무게 측정하는 물건 올려놓음
    // 무게가 양의 정수인 N개의 저울추가 주어질 때 측정할 수 없는 양의 정수 무게 중 최솟값을 구하기


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 1 ~ 1000
        st = new StringTokenizer(br.readLine());

        int [] weight = new int[N];

        for(int i = 0; i < N; i++){
            weight[i] = Integer.parseInt(st.nextToken()); // 1 ~ 100만
        }

        // 현재 올리려는 무게 추가 전에 누적합으로 올라간 무게추 + 1보다 큰 경우 해당 값을 무게추로 잴 수 없는 최소 값
        Arrays.sort(weight);

        int sum = 0;

        for(int i = 0; i < N; i++){
            if(sum + 1 < weight[i]){
                break;
            }
            sum += weight[i];
        }

        System.out.println(sum + 1);
    }

}



