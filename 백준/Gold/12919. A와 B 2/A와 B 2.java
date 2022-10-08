

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static String str2;
    static int length;
    static boolean flag;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        str = br.readLine();
        str2 = br.readLine();
        length = str.length();

        dfs(str2.length(), str2);

        if(flag){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }


    }

    static void dfs(int cnt, String str2){
        // 두 문자열 길이가 같을 때
        if(cnt == length){
            // 같다면 flag는 true
            if(str2.equals(str)){
                flag = true;
                return;
            }
            return;
        }

        String reverse = "";

        // 맨앞에 B가 왔다면 맨앞 B를 빼고 뒤집고 dfs
        if(str2.charAt(0) == 'B'){
            for(int i = str2.length() - 1; i >= 1; i--){
                reverse += str2.charAt(i);
            }
            dfs(cnt - 1, reverse);
        }

        // 맨 뒤가 A라면 맨뒤에 A 빼서 dfs
        if(str2.charAt(str2.length() - 1) == 'A'){
            dfs(cnt - 1, str2.substring(0, str2.length() - 1));
        }
    }

}