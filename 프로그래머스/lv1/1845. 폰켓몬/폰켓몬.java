class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리 중에 N/2 마리 가져가도 좋다 함
        // 폰켓몬은 종류에 따라 번호를 붙여 구분함
        // 4마리의 폰켓몬 3번, 1번, 2번, 3번
        // 최대한 다양한 종류의 폰켓몬을 가지길 원함
        // 최대한 많은 종류의 폰켓몬을 포함해서 N/2 마리 선택
        
        // nums 는 항상 짝수
        int take = nums.length / 2; // 가져갈 수 있는 폰켓몬은 2분의 1
        int type = 0;
        
        boolean [] idx = new boolean[200001];
        for(int num : nums){
            idx[num] = true;
        }
        
        for(int i = 0; i < idx.length; i++){
            if(idx[i]) type++;
        }
        
        // 가져갈 수 있는 수가 종류보다 많으면
        if(take >= type){
            answer= type;
        }
        // 가져갈 수 있는 수 보다 종류가 적으면
        else{
            answer = take;
        }
        return answer;
    }
}