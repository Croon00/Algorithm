import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int a = 1;
            int b = 1;
            String tree = br.readLine();
            // 받은 한줄의 LR값들을 toCharArrray를 통해서 배열로 받기
            char [] tree_arr = tree.toCharArray();
            // 받은 문자열이 L인지 R인지
            for(int i = 0; i < tree_arr.length; i++){
                if(tree_arr[i] == 'L'){
                    b = a + b;
                }
                else if(tree_arr[i] == 'R'){
                    a = a + b;
                }
            }
            System.out.println("#" + tc + " " + a + " " + b);
        }
    }
}