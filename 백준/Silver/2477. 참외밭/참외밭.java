import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        // 최종 멜론 갯수
        int Kmelon = 0;
        // 넓이
        int area = 0;
        //가장 긴 가로 / 세로 길이
        int max_width = 0;
        int max_height = 0;
        // 가장 긴 가로 세로 길이가 들은 배열 위치
        int maxWidth_idx = 0;
        int maxHeight_idx = 0;
        // 삭제해야할 가로 / 세로
        int delete_height = 0;
        int delete_width = 0;
        // 방향과 길이
        int [] direction = new int[6];
        int [] length = new int[6];

        // 방향과 길이를 받아주면서 가장 긴 가로와 세로를 받아주고 그 idx도 받아준다.
        for(int i = 0; i < 6; i++){
            st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            if(direction[i] == 1 || direction[i] == 2){
                if(max_width < length[i]){
                    max_width = length[i];
                    maxWidth_idx = i;
                }
            }
            if(direction[i] == 3 || direction[i] == 4) {
                if (max_height < length[i]) {
                    max_height = length[i];
                    maxHeight_idx = i;
                }
            }
        }

        // 가장 긴 가로 길이의 인덱스의 전 인덱스와 후 인덱스를 받아준다.
        // 두 인덱스에 들어있는 길이의 차가 삭제해야 할 세로 길이
        int temp = (maxWidth_idx + 1) %6;
        int temp2 = (maxWidth_idx - 1 + 6) % 6;
        delete_height = Math.abs(length[temp] - length[temp2]);

        // 마찬 가지로 가장 긴 세로 길이의 전 인덱스와 후 인덱스를 받고 그 차를 받는다.
        temp = (maxHeight_idx + 1) % 6;
        temp2 = (maxHeight_idx - 1 + 6) % 6;
        delete_width = Math.abs(length[temp] - length[temp2]);

        // 넓이는  큰 사각형 안에 작은 사각형 을 빼면 구할 수 있다.
        area = max_width * max_height - delete_height * delete_width;
        // 넓이 1제곱미터 당 받은 멜론 갯수 곱하기
        Kmelon = area * K;
        sb.append(Kmelon);
        System.out.println(sb);
    }
}
