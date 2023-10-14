class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 회원을 대상으로 매일 한 가지 제품을 할인
        // 할인하는 제품은 하루에 하나씩만 구매할 수 있따
        // 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
        // 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수 
        
        // 원하는 음식의 index 수를 세어서 갯수가 맞으면 answer ++ 하기
        
        
        // discount가 최대 10만 이니까 want 의 길이 최대 10인 것과 곱해도 충분히 안전한 최소시간
        
        int answer = 0;
        
        int sum = 0;
        // 전체 필요한 제품이 몇 개인지 
        for(int i = 0; i < number.length; i++){
            sum += number[i];
        }
        
        // 전체 할인하는 품목을 돌면서(열흘은 되어야 한다)
        for(int i = 0; i < discount.length - 9; i++){
            
            // 해당 제품군을 며칠 ~ 며칠까지 정했을 때
            int[] discountNum = new int[number.length];
            
            // i 번째 품목 부터 시작해서 갯수만큼
            for(int j = i; j < i + 10; j++){
                
                String item = discount[j];
                for(int k = 0; k < want.length; k++){
                    // want에 있는 품목과 같으면 ++
                    if(item.equals(want[k])){
                        discountNum[k]++;
                        break;
                    }
                }
            }
            boolean flag = true;
            // number에 있는 개수만큼을 비교해서 다른 경우 원하는 제품을 못 채웠음으로 false 하고 끝내기
            for(int j = 0; j < number.length; j++){
                if(number[j] != discountNum[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        
        return answer;
    }
}