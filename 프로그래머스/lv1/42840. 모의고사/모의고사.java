import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 수포자 --> 1번 수포자 :  1,2,3,4
        // 2번 수포자 : 2,1,2,3,2,4
        // 3번 수포자 : 3,3,1,1,2,2,4,4
        
        int [] supoja1 = new int[answers.length];
        int [] supoja2 = new int[answers.length];
        int [] supoja3 = new int[answers.length];
        
        
        int supo1 = 1;
        int supo2 = 1;
        int supo3 = 3;
        int supo3Cnt = 1;
        for(int i = 0; i < answers.length; i++){
            supoja1[i] = supo1;
            supoja3[i] = supo3;
            
            supo1++;
            if(supo1 == 6){
                supo1 = 1;
            }
            // 짝수번 인덱스에선 2 주기
            if(i % 2 == 0){
                supoja2[i] = 2;
            }
            else{
                supoja2[i] = supo2;
                // 늘려주고
                supo2++;
                // 2라면 3으로 바꾸어야 함
                if(supo2 == 2) supo2++;
                // 6라면 1로 다시 바꿔주기
                if(supo2 == 6) supo2 = 1;
            }
            
            // 수포자 3은 3을 먼저 넣었다가
            supoja3[i] = supo3;
            
            // 다음 cnt++
            supo3Cnt++;
            // 3이면 다음 숫자로 넘어가야 한다.
            if(supo3Cnt == 3){
                // 3이 였으면 1로 바꾸기
                if(supo3 == 3){
                    supo3 = 1;
                    supo3Cnt = 1;
                }
               // 2였으면 4로 넘어가기
                else if(supo3 == 2){
                    supo3 = 4;
                    supo3Cnt = 1;
                }
                // 5였으면 다시 3으로 넘어가기
                else if(supo3 == 5){
                    supo3 = 3;
                    supo3Cnt = 1;
                }
                // 나머지 1이나 4였을 때는 그냥 ++
                else{
                    supo3++;
                    supo3Cnt = 1;
                }
            }
        }
        
    
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(supoja1[i] == answers[i]) answer1++;
            if(supoja2[i] == answers[i]) answer2++;
            if(supoja3[i] == answers[i]) answer3++;
            System.out.println(supoja3[i]);
        }
        int [] ans = new int[3];
        
        ans[0] = answer1;
        ans[1] = answer2;
        ans[2] = answer3;
        // 가장 큰 값 구하기
        int max = Math.max(answer1, Math.max(answer2, answer3));
        
        // list에다가 max 인덱스 추가하기
        List<Integer> maxValue = new ArrayList<Integer>();
        
        // max와 같은 경우 추가
        for(int i = 0; i < 3; i++){
            if(ans[i] == max) maxValue.add(i + 1);
        }
        
        // 정답 배열
        int [] answer = new int[maxValue.size()];
        
        for(int i = 0; i < maxValue.size(); i++){
            answer[i] = maxValue.get(i);
        }
        return answer;
    }
}