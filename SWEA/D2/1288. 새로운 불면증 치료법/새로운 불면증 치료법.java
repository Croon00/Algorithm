import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++){
            boolean [] arr = new boolean[10];

            int a = 1;
            int cnt = 0;
            String SN = sc.next();
            int N = Integer.parseInt(SN);
            while(true){
                for(int j = 0; j < SN.length(); j++){
                    int tmp = Integer.parseInt(SN.substring(j, j+1));
                    if(arr[tmp] == false){
                        cnt++;
                        arr[tmp] = true;
                    }
                }
                if(cnt == 10){
                    break;
                }
                else {
                    a++;
                    SN = Integer.toString(N * a);
                }

            }
            System.out.println("#" + i + " " + SN);

        }
    }
}
