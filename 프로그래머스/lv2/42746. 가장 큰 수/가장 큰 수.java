import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String [] nums = new String[numbers.length];
        // 0 또는 양의 정수
        // 정수를 이어 붙여 만들 수 있는 가장 큰 수
        // 9에 가까운 수가 앞으로 갈 수록 크겠지?
        // numbers는 1 ~ 100,000 사이즈
        // 0 ~ 1000 이하의 값
        // 문자열로 전환하기
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String a, String b){
                // 내림차순으로 정렬하기
                return(b+a).compareTo(a+b);
            }
        });
        // 중복값 빼주기
        if(nums[0].equals("0")) return "0";
        
        
        String answer = "";
        
        for(String str : nums) answer += str;
        
        return answer;
    }
}