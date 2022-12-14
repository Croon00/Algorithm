import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /*
    가능 한 문자로 사전순으로 모두 출력한다.
    중복되는 문자는 입력 x
     --> 부분 집합(L개 만큼)

     최소 1개 이상의 모음 (a, e, i, o, u)와 최소 두 개의 자음으로 구성성
    */
    static int L, C; // 서로다른 L개의 조합, C개의 문자
    static char[] pw; // 패스워드 문자
    static ArrayList<String> ans; // 정답 arrayList

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pw = new char[C]; // C의 문자만큼 배열 초기화

        // 정답 초기화
        ans = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            pw[i] = st.nextToken().charAt(0);
        }

        // pw를 사전순으로 정렬
        Arrays.sort(pw);

        dfs(0,"", 0);

        // 정답을 ArrayList를 사전순으로 정렬
        Collections.sort(ans);

        // 출력
        for(int i = 0; i < ans.size(); i++){

            // 모음, 자음 갯수를 세어서 1개 이상의 모음과 2개 이상의 자음인 경우만 출력
            if(check(ans.get(i))) System.out.println(ans.get(i));

        }
    }

    // 문자의 위치를 알려주는 idx, 가져갈 비밀번호 passWord, 만들어진 비밀번호 갯수 cnt
    static void dfs(int idx, String passWord, int cnt){
        // L개 만큼 길이로 만들어졌으면 정답 String 배열에 추가
        if(cnt == L){
            ans.add(passWord);
            return;
        }

        // idx의 위치가 C 크기만큼 가면 return;
        if(idx == C){
            return;
        }

        // 해당 문자를 안 더하고 가기
        dfs(idx + 1, passWord, cnt);

        // 더하고 가기
        passWord += pw[idx];
        dfs(idx + 1, passWord, cnt + 1);
    }


    // 모음과 자음 갯수 체크
    static boolean check(String s){
        int cnt1 = 0; // 모음 갯수
        int cnt2 = 0; // 자음 갯수
        // 받은 문자열의 알파벳, 모음, 자음 갯수 세기
        for(int i = 0; i < L; i++){
            char tempChar = s.charAt(i);
            // 모음일 경우
            if(tempChar == 'a' || tempChar == 'e' || tempChar == 'i' || tempChar == 'o' || tempChar == 'u'){
                cnt1++;
            }
            // 자음일 경우
            else{
                cnt2++;
            }
        }
        // 모음 갯수가 1개 이상, 자음 갯수가 2개 이상일 경우 true
        if(cnt1 >= 1 && cnt2 >= 2){
            return true;
        }
        // 이외 false
        else{
            return false;
        }
    }
}
