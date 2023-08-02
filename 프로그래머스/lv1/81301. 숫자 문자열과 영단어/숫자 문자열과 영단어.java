class Solution {
    public int solution(String s) {
        
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // nums만큼에서 s가 알파벳 가진 경우
        for(int i = 0; i < 10; i++){
            if(s.contains(nums[i])){
                // 해당 문자를 숫자로 바꾸기
                s = s.replace(nums[i], Integer.toString(i));
            }
        }
        int answer = Integer.parseInt(s);
        
        
        return answer;
    }
}