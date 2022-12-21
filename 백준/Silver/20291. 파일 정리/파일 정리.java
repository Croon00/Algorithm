import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    /*
        파일을 확장자 별로 정리해서 몇 개 있는지 확인
        보기 편하게 확장자들을 사전 순으로 정렬
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<String> ExtensionList = new ArrayList<>();

        // 파일 확장자 넣기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < str.length(); j++){
                // . 부분이 왔을 경우
                if(str.charAt(j) == '.'){
                    // ex에 . 뒤에 있는 확장자 이름을 추가한다.
                    String ex = "";

                    ex = str.substring(j + 1);
                    ExtensionList.add(ex);
                    break;
                }
            }
        }
        // 정렬
        Collections.sort(ExtensionList);

        StringBuilder sb = new StringBuilder();

        // 브루트포스를 통해서 같은 확장자인 경우 cnt만 ++
        for(int i = 0; i < ExtensionList.size(); i++){
            int cnt = 1;
            int j = i + 1;
            for(; j < ExtensionList.size(); j++){
                // 같은 확장자인 경우 cnt + 1
                if(ExtensionList.get(i).equals(ExtensionList.get(j))) cnt++;

                // 아닌 경우 다음 확장자 세기
                else break;
            }
            sb.append(ExtensionList.get(i)).append(" ").append(cnt).append("\n");
            i = j - 1;
        }

        System.out.println(sb);

    }
}
