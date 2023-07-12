import java.util.*;
import java.io.*;


    /*
        김지민은 N명이 참가하는 스타 토너먼트에 진출
        N 명의 참가자는 번호 1번 ~ N번 까지 배정
        인접한 번호끼리 스타를 한다.
        홀수라면 마지막 번호를 가진 사람은 다음 라운드로 자동 진출
        다음 라운드에서 다시 참가자의 번호를 1번부터 매김
        처음 번호의 순서를 유지하면서 1번부터 매김

       김지민과 임한수는 서로 대결하기 전까지 항상이긴다 가정 할 때 몇 라운드에서 대결하는지 출력하기
     */

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(kim != lim) {
			kim = kim/2 + kim%2;
			lim = lim/2 + lim%2;
			cnt++;
		}
		System.out.println(cnt);
	}
}