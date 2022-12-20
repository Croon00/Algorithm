import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
       알파벳 소문자로 이루어진 N개의 단어가 들어오면 정렬
       1. 길이가 짧은 것부터 정렬
       2. 길이가 같으면 사전순으로 정렬
       중복되는 단어인 경우 한 번만 출력
     */
    static int N;

    static class Word implements Comparable<Word>{
        int l;
        String word;

        @Override
        public int compareTo(Word o) {
            if(this.l == o.l){
                // 길이가 같을 경우에는 사전순으로 정렬
                return word.compareTo(o.word);
            }
            // 길이 순으로 정렬
            return this.l - o.l;
        }
    }
    static List<Word> word;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        word = new ArrayList<>();

        // 단어와 단어 길이 받기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            Word w = new Word();
            w.word = str;
            w.l = str.length();
            word.add(w);
        }
        // 정렬
        Collections.sort(word);

        

        StringBuilder sb = new StringBuilder();
        String check = "";
        for(int i = 0; i < N; i++){
            // 0번째 인덱스를 제외한 중복 체크
            if(i > 0){
                check = word.get(i - 1).word;
            }
            if(!check.equals(word.get(i).word)){
                sb.append(word.get(i).word).append("\n");
            }
        }

        System.out.println(sb);

    }
}
