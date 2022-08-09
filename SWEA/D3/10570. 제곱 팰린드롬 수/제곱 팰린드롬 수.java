import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            ArrayList<String> numArr = new ArrayList<>();
            int count = 0;

            for(int i = A; i <= B; i++){
                numArr.add(Integer.toString(i));
            }

            for(int i = 0; i < numArr.size(); i++){
                StringBuilder sb = new StringBuilder(numArr.get(i));
                String num_reverse = String.valueOf(sb.reverse());

                if(numArr.get(i).equals(num_reverse)){
                    String sqrt_str = (numArr.get(i));

                    Double sqrt = Math.sqrt(Integer.parseInt(sqrt_str));
                    int temp = (int) (sqrt * 10);
                    if(temp % 10 == 0){
                        int temp2 = temp / 10;
                        StringBuilder sb1 = new StringBuilder(Integer.toString(temp2));
                        String sqrt_reverse = String.valueOf(sb1.reverse());

                        if(temp2 == Integer.parseInt(sqrt_reverse)){
                            count++;
                        }
                    }

                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}