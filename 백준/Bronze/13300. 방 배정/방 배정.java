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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 6학년 까지 성별
        int [][] student = new int[6][2];
        // 방 수
        int room = 0;
        // 학생 수만큼
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            // 해당하는 학생 학년과 성별의 값을 받아서 ++
            student[--grade][gender]++;
        }
        
        // 1학년 부터 6학년 까지 성별에 따라서 
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 2; j++){
                // 1명 이상 있는 경우메만
                if(student[i][j] > 0){
                    // 배수일 경우에는 딱 떨어지게 방을 더해주면 된다.
                    if(student[i][j] % K == 0){
                        room += student[i][j] / K;
                    }
                    // 배수가 아닐 경우 +1 씩 방을 더해준다.
                    else{
                        room += student[i][j] / K + 1;
                    }
                }
            }
        }
        System.out.println(room);
    }
}