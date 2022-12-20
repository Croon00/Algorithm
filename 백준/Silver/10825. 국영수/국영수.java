import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        국어/ 점수 / 영어 로 과목을 받아서
        1. 국어 (감소)
        2. 국어 같을 경우 영어 (증가)
        3. 위 2 개 같을 경우 수학 (감소)
        순서대로 정렬하자.
     */

    // 비교를 위한 Comparable
    static class Subject implements Comparable<Subject>{
        String name;
        int korean;
        int math;
        int english;

        @Override
        public int compareTo(Subject o) {
            if(this.korean == o.korean){
                if(this.english == o.english){
                    if(this.math == o.math){
                        // 점수가 모두 같으면 이름 사전순으로
                        return name.compareTo(o.name);
                    }
                    // 수학은 내림 차순으로
                    return o.math - this.math;
                }
                // 영어는 오름 차순으로
                return this.english - o.english;
            }
            // 국어는 내림 차순으로
            return o.korean - this.korean;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // N명의 점수
        Subject [] student = new Subject[N];

        // 받기
        for(int i = 0;  i < N; i++){
            st = new StringTokenizer(br.readLine());
            student[i] = new Subject();
            student[i].name = st.nextToken();
            student[i].korean = Integer.parseInt(st.nextToken());
            student[i].english = Integer.parseInt(st.nextToken());
            student[i].math = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(student);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(student[i].name);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
