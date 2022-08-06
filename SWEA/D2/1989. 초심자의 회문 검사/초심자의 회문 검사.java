import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = sc.nextInt();
        String a;
        String flag;
        char arr [] = new char [11];

        for (int i = 1; i <= N; i++){
            a = sc.nextLine();
            arr = a.toCharArray();
            flag = "1";

            for(int j = 0; j < a.length()/2; j++){
                if(arr[j] != arr[a.length()-j-1]){
                    flag = "0";
                }
            }
            System.out.println("#"+ i +" " + flag);
        }


    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            if(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
