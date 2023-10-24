import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // 과일 장수가 사과 상자를 포장하고 있음
        // 사과 상태에 따라 1점 부터 k점 까지의 점수 분류
        // k점이 최상품, 1점이 최하품
        // 한 상자에 사과를 m개씩 담아 포장
        // 상자에 담긴 사과 중 가장 낮은 점수가 p점인 경우, 사과 한 상자의 가격은 p * m 임
        // 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산 (상자 단위로만 판매, 남는 사과 버림)
        // 최상품 점수 k점 --> 3 ~ 9
        // 사과 한 박스의 최대 개수 --> 3 ~ 9
        // score의 길이 7 ~ 100만
        
        // 최대한 비싼 사과들 끼리 한 박스에 묶어야 많이 점수를 얻을 거고, 남는 사과는 점수가 낮아야 함
        
        // 만들어 져야 할 사과박스의 개수는 사과 갯수 나누기 m
        int boxCnt = score.length / m;
        
        // 사과 점수로 정렬
        Arrays.sort(score);
        
        // boxScore의 인덱스와 그 안에 m개의 사과 index를 가르킴
        int boxScoreIdx = 0;
        int scoreIdx = 0;
        
        // 스코어를 돌면서
        for(int i = score.length - 1; i >= 0; i--){
            
            // 스코어 인덱스 값이 m개에 만족 했을 경우 해당 값을 answer에 * m개해서 넣고 0번째로 초기화
            // 다음 박스스코어 인덱스로 ++
            if(scoreIdx == m - 1){
                answer += score[i] * m;
                scoreIdx = 0;
                boxScoreIdx++;
            }
            // m개에 만족하지 않은 경우에는 다음 인덱스로 증가
            else{
                scoreIdx++; 
            }
            //박스 스코어 idx의 값이 boxCnt의 값과 같아지면 더 이상 사과를 채울 필요가 없음으로 끝냄
            if(boxScoreIdx == boxCnt) break;
            
        }
        
        return answer;
    }
}