import java.io.*;
import java.util.*;

/*
    사람의 마음을 읽는 기계
    N명의 후보, 기계를 이용하여 M명의 마음을 모두 읽음
    다솜의 기호 1번 --> 다른 모든 사람의 득표 수보다 많은 득표수를 가질 때 국회의원 당선

    매수해야하는 사람의 최소값 찾기

 */

public class Main {

    // 내림차순으로 정렬하게 만들기
    static class Candidate implements Comparable<Candidate>{
        int no;
        int voted;

        public Candidate (int no, int voted){
            this.no = no;
            this.voted = voted;
        }

        @Override
        public int compareTo(Candidate o){
            return o.voted - this.voted;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫째 줄 N명
        int N = Integer.parseInt(br.readLine());

        // 1명 밖에 없으면 후보자가 다솜 혼자
        if(N == 1) {
            System.out.println(0);
            return;
        }


        Candidate [] candidates = new Candidate[N + 1];

        PriorityQueue<Candidate> pq = new PriorityQueue<>();

        for(int i = 1; i <= N; i++){
            int votedCnt = Integer.parseInt(br.readLine());
            candidates[i] = new Candidate(i, votedCnt);

            // 1번인 다솜 이외에 pq에 넣기
            if(i == 1) continue;
            pq.offer(candidates[i]);
        }

        int answer = 0;

        while (true) {
            Candidate candidate = pq.poll();

            // 다솜의 투표 수가 다솜 이외의 가장 높은 투표 수 보다 높으면 끝
            if (candidates[1].voted > candidate.voted) break;

                // 다솜 이외의 사람에게서 투표 빼서 다솜의 투표 수 늘리기
            else {
                candidates[1].voted++;
                candidate.voted--;
                pq.offer(candidate);
                answer++;

            }

        }
        System.out.println(answer);
    }
}
