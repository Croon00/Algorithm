import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            int count = 0;
            if(i < 10){
                if(i % 3 == 0){
                    sb.append("-").append(" ");
                }
                else{
                    sb.append(i + " ");
                }
            }
            else{
                // 숫자를 스트링으로 받아서 배열 [] 에 넣는다.!!split을 사용하여 받으면 배열당 하나씩
                String a = String.valueOf(i);
                String[] num = a.split("");
                for(int k = 0; k < num.length; k++){
                    if(num[k].contains("3") || num[k].contains("6") || num[k].contains("9")){
                        count++;
                    }
                }
                if(count == 0){
                    sb.append(i + " ");
                }
                else{
                    for(int l = 0; l < count; l++){
                        sb.append("-");
                    }
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}