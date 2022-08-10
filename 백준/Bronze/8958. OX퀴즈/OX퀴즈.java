import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            String s = sc.next();

            int sum = 0;
            int n = 1;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'O'){
                    sum = sum + n;
                    n++;
                }
                else{
                    n = 1;
                }
            }
            System.out.println(sum);

        }
    }
}