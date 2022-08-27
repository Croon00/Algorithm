import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int money = Integer.parseInt(br.readLine());
        // 준현이와 성민이의 돈과 주식 갯수
        int Jmoney = money;
        int J_stokc = 0;
        int Smoney = money;
        int S_stock = 0;
        st = new StringTokenizer(br.readLine());
        // 성민이의 3번 연속 오름 , 내림을 알려줄 cnt
        int downCnt = 0;
        int upCnt = 0;
        // 1일부터 14일 까지 이다.
        int[] stock = new int[14];
        for(int i = 0; i < 14; i++){
            stock[i] = Integer.parseInt(st.nextToken());
            // 준현이는 해당 날에 살 수 있으면 가능한 만큼 산다.
            while (Jmoney >= stock[i]){
                Jmoney -= stock[i];
                J_stokc++;
            }
            // 2번째 날부터 전날을 비교해 가면서 
            // 가격이 전날 보다 낮아졌으면 downCnt++, 올랐으면 upCnt++
            // 하면서 조건에 안 맞으면 0으로 초기화도 시켜준다.
            if(i >= 1){
                if(stock[i - 1] > stock[i]){
                    downCnt++;
                    upCnt = 0;
                }
                else if(stock[i - 1] < stock[i]){
                    upCnt++;
                    downCnt = 0;
                }
                else{
                    upCnt = 0;
                    downCnt = 0;
                }
            }
            // 3일 이상 연속으로 내려간 경우 전량 매수
            if(downCnt >= 3){
                while (Smoney >= stock[i]){
                    Smoney -= stock[i];
                    S_stock++;
                }
            }
            // 3일 연속 올라간 경우 전량 매도
            if(upCnt == 3){
                Smoney += S_stock * stock[i];
                S_stock = 0;
            }
        }
        // 남은 주식을 마지막 날 가격으로 환산하여 현금에 더한 가격
        Jmoney += stock[13] * J_stokc;
        Smoney += stock[13] * S_stock;
        if(Jmoney > Smoney){
            System.out.println("BNP");
        }
        else if(Jmoney < Smoney){
            System.out.println("TIMING");
        }
        else{
            System.out.println("SAMESAME");
        }
    }
}
