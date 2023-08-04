class Solution {
    public String solution(int[] food) {
        // 1대1 대결
        // 음식들을 일렬로 배취, 한 선수는 왼쪽, 한 선수는 오른쪽
        // 중앙에 물, 물 먼저 먹는 사람이 승리
        
        // 음식은 짝수로 있어야 양쪽에 두는게 가능 --> 7 이면 6개
        String answer = "";
        // 한 번은 앞에서 하고 그 뒤 한 번더 붙이기 (0은 물)
        for(int i = 1; i < food.length; i++){
            // 2로 나눈 값 만큼 더하기
            for(int j = 0; j < food[i] / 2; j++){
                answer += String.valueOf(i);
            }
        }
        answer += "0";
        
        for(int i = food.length - 1; i >= 1; i--){
            for(int j = 0; j < food[i] / 2; j++){
                answer += String.valueOf(i);
            }
        }
        
        return answer;

    }
}