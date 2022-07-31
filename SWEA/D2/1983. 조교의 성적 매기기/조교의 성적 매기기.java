import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static String [] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            double score = 0.0;
            Double [] result = new Double[N];

            for(int i = 0; i < N; i++) {
                int mid_exam = sc.nextInt();
                int final_exam = sc.nextInt();
                int homework = sc.nextInt();
                double sum = 0.35 * mid_exam + 0.45 * final_exam + 0.20 * homework;
                result[i] = sum;
                if (i + 1 == K) {
                    score = sum;
                }
            }

                Arrays.sort(result, Collections.reverseOrder());

                int index = 0;
                for(int i = 0; i < result.length; i++){
                    if(result[i] == score){
                        index = i;
                    }
                }
                index /= (N/10);

                System.out.println("#" + tc + " " + grades[index]);
            }
        }
    }