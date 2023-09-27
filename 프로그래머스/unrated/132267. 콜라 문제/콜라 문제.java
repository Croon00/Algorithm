class Solution {
    public int solution(int a, int b, int n) {
        // 정답은 아무에게도 말하지 않는다.
        // 콜라 빈 병 2개를 가져다주면 콜라 1병을 가져다 주는 마트   
        // 단 보유 중인 빈 병이 2개 미만이면 콜라 못 받음
        
        // 보유 중인 빈 병 a개를 가져다 주면 콜라 b 병을 준다
        // 빈 병 n 개를 가져다 주면 몇 병을 받을 수 있는지
        int answer = 0;

        while(n >= a){
            // 남은 빈 병과 콜라 갯수
            int colar = (n / a) * b;
            n %= a;
            // 정답에 콜라 누적 시키기
            answer += colar;
            // 콜라 다 마시고 다시 빈병 됨으로 콜라추가
            n += colar;
        }
        return answer;
    }
}