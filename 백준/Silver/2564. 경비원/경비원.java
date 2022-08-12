import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int block_x = Integer.parseInt(st.nextToken());
        int block_y = Integer.parseInt(st.nextToken());

        // 최단 거리 합
        int distance = 0;

        st = new StringTokenizer(br.readLine());
        int shop_amount = Integer.parseInt(st.nextToken());

        // 상점 동서남북 / 위치 / 원점으로부터 거리
        int [] shop_point = new int[shop_amount];
        int [] shop_place = new int[shop_amount];
        int [] shop_distance = new int[shop_amount];

        for(int i = 0;  i < shop_amount; i++){
            st = new StringTokenizer(br.readLine());
            shop_point[i] = Integer.parseInt(st.nextToken());
            shop_place[i] = Integer.parseInt(st.nextToken());
        }

        // 동근이 동서남북 / 위치 / 원점으로부터 거리
        st = new StringTokenizer(br.readLine());
        int Donggeun_point = Integer.parseInt(st.nextToken());
        int Donggeun_place = Integer.parseInt(st.nextToken());
        int Donggeun_distance = 0;

        // 시계 방향
        int clockwise = 0;

        // 반 시계 방향
        int counter_clockwise = 0;

        // 둘레 길이
        int round = block_x * 2 + block_y * 2;


        // 동근이의 위치에 따른 원점으로부터의 거리
        if(Donggeun_point == 1){
            Donggeun_distance = Donggeun_place;
        }
        // 남
        else if(Donggeun_point == 2){
            Donggeun_distance = block_x + block_y + (block_x - Donggeun_place);
        }
        // 서
        else if(Donggeun_point == 3){
            Donggeun_distance = round - Donggeun_place;
        }
        // 동
        else if(Donggeun_point == 4){
            Donggeun_distance =block_x + Donggeun_place;
        }

        // 상점의 위치에 따른 원점으로부터의 거리
        for(int i = 0; i < shop_amount; i++){
            // 북
            if(shop_point[i] == 1){
                shop_distance[i] = shop_place[i];
            }
            // 남
            else if(shop_point[i] == 2){
                shop_distance[i] = block_x + block_y + (block_x - shop_place[i]);
            }
            // 서
            else if(shop_point[i] == 3){
                shop_distance[i] = round - shop_place[i];
            }
            // 동
            else if(shop_point[i] == 4) {
                shop_distance[i] = block_x + shop_place[i];
            }
            // 나의 거리로 부터 상점의 거리를 뺀 절대 값은 시계방향 거리
            clockwise = Math.abs(Donggeun_distance - shop_distance[i]);
            // 둘레에서 이 시계방향 거리를 빼면 반시계 방향 거리
            counter_clockwise = round - clockwise;
            // 최단거리의 합 구하기
            distance += Math.min(clockwise, counter_clockwise);
           
        }
        sb.append(distance);
        System.out.println(sb);
    }
}
