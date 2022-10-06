import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String sentence;
	static String[][] book;
	static int[] selected;
	static int min;
	
	static boolean check(int cnt) {
        // 26개의 대문자 알파벳
		int[] letter = new int[26];
        // 뽑은 책 만큼(cnt)
		for (int i=0; i<cnt; i++) {
            // 고른 책 == selected[i] 의 제목 book[selected[i]][1]
			String name = book[selected[i]][1];
            // 해당 제목을 보면서 Integer로 변경하여서 해당 제목 부분 ++ 하기
			for (int j=0; j<name.length(); j++) {
				letter[name.charAt(j) - 'A']++;
			}
		}
        // 내가 고른 단어 만큼 돌면서
		for (int i=0; i<sentence.length(); i++) {
            // 단어가 없을 경우에는 바로 return
			if (letter[sentence.charAt(i) - 'A'] == 0) return false;
            // 있으면 해당 부분 --
			letter[sentence.charAt(i) - 'A']--;
		}
        // 내가 고른 단어가 다 나왔따.
		return true;
	}
	
    // 시작지점, cnt, 가격
	static void dfs(int start, int cnt, int sum) {
        // 최소 가격으로 해야함으로 백트래킹
        if (sum >= min) return;
        
        // 하나 이상의 책을 골랐으면서, 
		if (cnt > 0 && check(cnt)) {
			if (sum < min) min = sum;
		}
		
        // start부터 N - 1개의 책을
		for (int i=start; i<N; i++) {
            // 골랐을 경우에는 i에 넣고
			selected[cnt] = i;
            // i번째의 책 가격을 더해서 넣고, cnt + 1, i + 1;
			dfs(i + 1, cnt + 1, sum + Integer.parseInt(book[i][0]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자 받기
		sentence = br.readLine();
        // N개의 책
		N = Integer.parseInt(br.readLine());
		
        // [0] --> 가격, [1] --> 책 제목
		book = new String[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			book[i][0] = st.nextToken();
			book[i][1] = st.nextToken();
		}
		
		Arrays.sort(book, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		min = Integer.MAX_VALUE;
        // 선택된 얘들
		selected = new int[N];
		dfs(0, 0, 0);
		
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		br.close();
	}

}
