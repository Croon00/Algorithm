import java.util.*;
import java.io.*;

public class Main {
    /*
        뱀과 새의 모습을 닮은 귀여운 생물체 스네이크버드

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 과일의 개수
        int L = Integer.parseInt(st.nextToken()); // 초기 스네이크 버드 길이
        int [] fruits = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fruits);
        // 스네이크의 최대 길이
        for(int i = 0; i < N; i++){
            if(fruits[i] <= L){
                L++;
            }
            else{
                break;
            }
        }
        System.out.println(L);
    }
}



