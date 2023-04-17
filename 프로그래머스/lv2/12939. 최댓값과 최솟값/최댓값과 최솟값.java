class Solution {
    public String solution(String s) {
        String [] numbers = s.split(" ");
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        
        for(int i = 0; i < numbers.length; i++){
            minNum = Math.min(minNum, Integer.parseInt(numbers[i]));
            maxNum = Math.max(maxNum, Integer.parseInt(numbers[i]));
        }
        
        String answer = "";
        answer = minNum + " " + maxNum;
        return answer;
    }
}