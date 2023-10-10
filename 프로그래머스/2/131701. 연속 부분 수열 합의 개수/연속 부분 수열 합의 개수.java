class Solution {
    static boolean [] index;

    public int solution(int[] elements) {
        int answer = 0;
        // 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지
        // 부분 수열 선택해서 더한 값을 index에 true 해서 true한 개수 구하기
        index = new boolean[500501];
        
        // 0번째 인덱스 값부터
        for(int i = 0; i < elements.length; i++){
            int sum = 0;
            int index2 = i;
            // elements 길이 만큼 하는데
            for(int j = 0; j < elements.length; j++){
                // 더하는 값은 index 위치 값, 넘어가지 않게 나머지 정리
                sum += elements[index2];
                index2 = (index2 + 1) % elements.length;
                
                // 이 값이 아직 세지 않은 값이면 answer++ 하고 해당 값을 센다.
                if(!index[sum]){
                    answer++;
                    index[sum] = true;
                }
            }
        }
        
        return answer;
    }
}