class Solution {
    public long solution(int[] arr) {
        // 두 수의 최소 공배수 --> 배수 중 공통이되는 가장 작은 수
        // n개의 수의 최소공배수는 n개의 수들의 배수 중 공통이 되는 가장 작은 숫자
        // 
        long num = 1;
        for(int i = 0; i < arr.length; i++){
            num *= arr[i];
        }
        
        long answer = 0;
        for(long i = 1; i <= num; i++){
            boolean flag = true;
            for(int j = 0; j < arr.length; j++){
                if(i % arr[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer = i;
                break;
            }
        }
        return answer;
    }
}