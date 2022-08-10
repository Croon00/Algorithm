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
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> skill = new ArrayList<>();
            int boredom = 0;
            int K = Integer.parseInt(br.readLine());
            int num = 1;
            // 인원 수는 2의 k승
            for(int i = 0; i < K; i++){
                num *= 2;
            }
            
            st = new StringTokenizer(br.readLine());
            // 인원 수 만큼 실력 받기
            for(int i = 0; i < num; i++){
                skill.add(Integer.parseInt(st.nextToken()));
            }
            
            // 최종 한 명이 남을 때 까지 지루함 받기
            while(num > 1){
                num /= 2;
                for(int i = 0; i < num; i++){
                    if(skill.get(i) >= skill.get(i + 1)){
                        boredom += skill.get(i) - skill.get(i + 1);
                        skill.remove(i + 1);
                    }
                    else{
                        boredom += skill.get(i + 1) - skill.get(i);
                        skill.remove(i);
                    }
                }
            }
            
            sb.append("#" + tc + " " + boredom);
            System.out.println(sb);
        }
    }
}