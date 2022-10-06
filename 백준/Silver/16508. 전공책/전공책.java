import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String sentence;
	static String[][] book;
	static int[] selected;
	static int min;
	
	static boolean check(int cnt) {
		int[] letter = new int[26];
		for (int i=0; i<cnt; i++) {
			String name = book[selected[i]][1];
			for (int j=0; j<name.length(); j++) {
				letter[name.charAt(j) - 'A']++;
			}
		}
		for (int i=0; i<sentence.length(); i++) {
			if (letter[sentence.charAt(i) - 'A'] == 0) return false;
			letter[sentence.charAt(i) - 'A']--;
		}
		return true;
	}
	
	static void dfs(int start, int cnt, int sum) {
		if (sum >= min) return;
		if (cnt > 0 && check(cnt)) {
			if (sum < min) min = sum;
		}
		
		for (int i=start; i<N; i++) {
			selected[cnt] = i;
			dfs(i + 1, cnt + 1, sum + Integer.parseInt(book[i][0]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sentence = br.readLine();
		N = Integer.parseInt(br.readLine());
		
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
		selected = new int[N];
		dfs(0, 0, 0);
		
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		br.close();
	}

}
