import java.util.*;
/*
    mats에서 돗자리의 한 변의 길이들 담긴 --> 정사각형
    공원의 자리 배치도를 의미하는 2차원 문자열 --> park
    깔 수 있는 가장 큰 돗자리 어떤 것인지 확인
*/

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        // 맵 돌면서 빈자리 찾으면 그곳을 포함하여 mats의 행/열 돌면서 모두 비었는지 확인하기
        int answer = -1;
        
        Arrays.sort(mats);
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                String temp = park[i][j];
                
                // -1인 경우 빈자리
                if(temp.equals("-1")){
                    answer = Math.max(answer, check(park, mats, i, j));
                }
            }
        }
        
        
        return answer;
    }
    
    static int check(String [][] park, int [] mats, int row, int col){
        int answer = -1;
        
        for(int i = mats.length - 1; i >= 0; i--){
            int matsLength = mats[i];
            boolean checkAnswer = true;
            
            
            for(int j = row; j < row + matsLength; j++){
                
                boolean flag = true;
                for(int k = col; k < col + matsLength; k++){
                    
                    // -1이 아닌 곳인경우 돗자리 이미 있음, 범위 넘어감 --> 끝내기
                    if(j >= park.length || k >= park[0].length || !park[j][k].equals("-1")){
                        flag = false;
                        break;
                    }
                }
                // 불가능한 경우 break
                if(!flag){
                    checkAnswer = false;
                    break;
                }
            }
            
            if(checkAnswer) {
                return matsLength;
            }
        }
        return answer;
        
    }
}