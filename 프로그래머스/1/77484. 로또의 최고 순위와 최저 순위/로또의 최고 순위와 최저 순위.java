import java.util.*;

// 로또 -> 1 ~ 45 까지의 숫자 중 6개 찍어서 맞히기
// 일부 번호 낙서로 인해 알아보지 못함
// 구매했던 로또로 가능했던 최고 순위 최저 순위

// lottos --> 길이 6, 0 ~ 45 숫자, 0은 알아볼 수 없는 숫자, 0을 제외하면 해당 숫자는 2개 이상 담기지 않음
// win_nums --> 길이 6, 1 ~ 45, 2개 이상 x, 정렬 x
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zeroCnt = 0;
        int sum = 0;
        
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(lottos[i] == 0){
                    zeroCnt++;
                    break;
                }
                if(lottos[i] == win_nums[j]) sum++;
            }
        }
        
        int maxSum = zeroCnt + sum;
        int minSum = sum;
        int maxRank = check(maxSum);
        int minRank = check(minSum);
        
        int [] answer = {maxRank, minRank};
        
        
        return answer;
    }
    
    static int check(int num){
        
        if(num == 2){
            return 5;
        }
        else if(num == 3) {
            return 4;
        }
        else if(num == 4){
            return 3;
        }
        else if(num == 5){
            return 2;
        }
        else if(num == 6){
            return 1;
        }
        return 6;
    }
}