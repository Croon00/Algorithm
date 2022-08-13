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
        // 유제품 갯수
        int N = Integer.parseInt(br.readLine());
        // 각 상품 가격
        int [] dairy_product = new int[N];
        for(int i = 0; i < N; i++){
            dairy_product[i] = Integer.parseInt(br.readLine());
        }
        // 오름차순으로 정렬
        Arrays.sort(dairy_product);
        // 할인 하는 상품 인덱스
        int sale_idx = 0;
        // 최소비용
        int min_cost = 0;
        // 끝에서부터 할인 상품 인덱스를 더하면서 상품 가격 더하기
        for(int i = N - 1; i >= 0; i--){
            sale_idx++;
            if(sale_idx % 3 != 0){
                min_cost += dairy_product[i];
            }
        }
        sb.append(min_cost);
        System.out.println(sb);
    }
}
