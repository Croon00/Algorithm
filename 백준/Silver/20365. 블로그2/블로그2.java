

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 더 많은 색의 색깔로 전부 색칠한 뒤, 더 적은 색의 색깔로 부분 부분을 칠하기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<String> red = new ArrayList<>();
        List<String> blue = new ArrayList<>();

        int ans = 0;

        String str = br.readLine();

        StringTokenizer R = new StringTokenizer(str, "R");
        while (R.hasMoreTokens()){
            blue.add(R.nextToken());
        }

        StringTokenizer B =  new StringTokenizer(str, "B");
        while (B.hasMoreTokens()){
            red.add(B.nextToken());
        }


        if(red.size() >= blue.size()){
            ans = blue.size() + 1;
        }
        else{
            ans = red.size() + 1;
        }
        System.out.println(ans);
    }
}