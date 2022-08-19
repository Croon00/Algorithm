import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int Score = 0;
        int [] mushroomScore = new int[10];
        for(int i = 0; i < 10; i++) {
            mushroomScore[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < 10; i++){
            // 점수를 버섯점수를 누적해서 더함
            Score += mushroomScore[i];
            // 점수가 100이상일때
            if(Score >= 100){
                // 이전 점수와 지금 점수가 100점으로 부터 차를 구한다.
                int preScore = Math.abs(100 - (Score - mushroomScore[i]));
                int afterScore = Math.abs(100 - Score);
                // 이전 점수의 100점으로부터 차가 더 작을 경우 이전 점수를 넣어준다.
                if(preScore < afterScore){
                    sb.append(Score-mushroomScore[i]);
                }
                // 이후 점수가 100점으로 부터 차가 더 클 경우 이후 점수를 넣는다 (같을 때 포함);
                else{
                    sb.append(Score);
                }
                break;
            }
        }
        // 다 더해서 100점도 안되면 다 더한 값
        if(Score < 100){
            sb.append(Score);
        }
        System.out.println(sb);
    }
}