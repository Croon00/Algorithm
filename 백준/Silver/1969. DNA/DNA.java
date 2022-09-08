import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String [] nucleotide = new String[N];
        String [] DNA = new String[M];
        int ans = 0;

        for(int i = 0 ; i < N; i++){
            nucleotide[i] = br.readLine();
        }
        // M의 뉴클레오 티드 길이를 돌면서 N 번째 뉴클레오 티드를
        for(int i = 0; i < M; i++){
            int Tcnt = 0;
            int Acnt = 0;
            int Gcnt = 0;
            int Ccnt = 0;
            // 카운트로 각 뉴클레오티드 수를 구한다.
            for(int j = 0; j < N; j++){
                if(nucleotide[j].charAt(i) == 'T'){
                    Tcnt++;
                }
                else if(nucleotide[j].charAt(i) == 'G'){
                    Gcnt++;
                }
                else if(nucleotide[j].charAt(i) == 'A'){
                    Acnt++;
                }
                else if(nucleotide[j].charAt(i) == 'C') {
                    Ccnt++;
                }
            }
            // 사전순으로 많은 것을 넣는다.
            if(Acnt >= Tcnt && Acnt >= Gcnt && Acnt >= Ccnt){
                DNA[i] = "A";
            }
            else if(Ccnt > Acnt && Ccnt >= Gcnt && Ccnt >= Tcnt){
                DNA[i] = "C";
            }
            else if(Gcnt > Acnt && Gcnt > Ccnt && Gcnt >= Tcnt){
                DNA[i] = "G";
            }
            else{
                DNA[i] = "T";
            }
        }
        // 위와 마찬가지로 FOR문을 돌면서 DNA 보여주면서, 비교하면서 다를 경우 ans++
        for(int i = 0; i < M; i++){
            System.out.print(DNA[i]);
            for(int j = 0; j < N; j++){
                String temp = String.valueOf(nucleotide[j].charAt(i));
                if(!DNA[i].equals(temp)){
                    ans++;
                }
            }
        }
        System.out.println();
        System.out.println(ans);
    }
}