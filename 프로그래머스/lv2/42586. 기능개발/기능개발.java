import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 프로그래머스팀에서 기능 개선 작업을 수행중
        // 각 기능 개발 속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있다.
        // 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열(progresses), 개발 속도가 적힌 정수 배열(speeds)
        // 각 배포마다 몇 개의 기능이 배포되는지를 return
        
        // 각 남은 날짜에 완수되는 작업을 누적시켜서 보여주면 될 듯
        int [] day = new int[101]; // 100개 이하
        boolean [] flag =  new boolean [101];
        List<Integer> answerDay = new ArrayList<Integer>();

        for(int i = 0; i < progresses.length - 1; i++){
            if(flag[i]) continue; // 이미 끝낸 일이면 건너띄기
            int cnt = 1;
            
            int restProgresses = 100 - progresses[i]; // 남은 진도 %
            
            int jobDay = 0; // 걸리는 날짜
            if(restProgresses / speeds[i] >= 1){
                // 1보다 크게 걸릴 경우
                if(restProgresses % speeds[i] > 0){
                    jobDay = (restProgresses / speeds[i]) + 1;
                }
                else{
                    jobDay = restProgresses / speeds[i];
                }
            }
            else{
                // 남은 일 보다 작업속도가 더 빠를 경우 1일 째에 끝난다. (나누는 speeds[i] 값이 더 큰 경우)
                jobDay = 1;
            }
            // 현재 했던 작업보다 걸리는 시간이 낮으면 가능
            for(int j = i + 1; j < progresses.length; j++){
                int restProgresses2 = 100 - progresses[j];
                int jobDay2 = 0;
                if(restProgresses2 / speeds[j] >= 1){
                // 1보다 크게 걸릴 경우
                    if(restProgresses2 % speeds[j] > 0){
                        jobDay2 = (restProgresses2 / speeds[j]) + 1;
                    }
                    else {
                        jobDay2 = restProgresses2 / speeds[j];
                    }
                }
                else{
                    // 남은 일 보다 작업속도가 더 빠를 경우 1일 째에 끝난다. (나누는 speeds[i] 값이 더 큰 경우)
                    jobDay2 = 1;
                }
                // 이전 기능보다 더 빠르게 끝난다면 ++
                if(jobDay >= jobDay2){
                    // 이 일은 끝낸 것으로 체크
                    flag[j] = true;
                    cnt++;
                }
                // 아니면 break;
                else{
                    break;
                }
            }
        
            answerDay.add(cnt);
        }
        
        // 마지막 작업 끝내지 못했으면 추가하기
        if(!flag[progresses.length - 1]){
            answerDay.add(1);
        }
        
        
        int[] answer = new int[answerDay.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerDay.get(i);
        }
        return answer;
    }
}