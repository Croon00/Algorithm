import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] switch_status = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            switch_status[i] = Integer.parseInt(st.nextToken());
        }
        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
                // 남학생일때
                if (gender == 1) {
                    for (int j = 0; j < N; j++) {
                        // 해당 스위치가 그 학생의 번호의 배수일 경우
                        if ((j + 1) % num == 0) {
                            if (switch_status[j] == 1) {
                                switch_status[j] = 0;
                            } else {
                                switch_status[j] = 1;
                            }
                        }
                    }
                }
                // 여학생일때
                else if (gender == 2) {
                    int temp = 1;
                    // 자기 자신의 값을 바꾸기
                    if(switch_status[num - 1] == 0){
                        switch_status[num - 1] = 1;
                    }
                    else{
                        switch_status[num - 1] = 0;
                    }
                    
                    while (true) {
                        // +1, -1 한 위치의 값을 바꾸기
                        if ((num - 1) - temp >= 0 && (num - 1) + temp < N) {
                            int switch1 = switch_status[(num - 1) - temp];
                            int switch2 = switch_status[(num - 1) + temp];
                            if (switch1 == switch2){
                                if(switch1 == 0){
                                    switch_status[(num - 1) - temp] = 1;
                                    switch_status[(num - 1) + temp] = 1;
                                }
                                else{
                                    switch_status[(num - 1) - temp] = 0;
                                    switch_status[(num - 1) + temp] = 0;
                                }
                                temp++;
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }
                }

        }

        for(int i = 0; i < N; i++){
            System.out.print(switch_status[i] + " ");
            if((i + 1) % 20 == 0){
                System.out.println();
            }
        }
    }
}
