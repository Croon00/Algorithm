import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> personalityPoint = new HashMap<>();

        personalityPoint.put("R", 0);
        personalityPoint.put("T", 0);
        personalityPoint.put("C", 0);
        personalityPoint.put("F", 0);
        personalityPoint.put("J", 0);
        personalityPoint.put("M", 0);
        personalityPoint.put("A", 0);
        personalityPoint.put("N", 0);

        int index = 0;
        for (String surv : survey) {
            int point = choices[index];

            // 동의: 두 번째 문자에 점수
            if (point > 4) {
                String str = surv.substring(1, 2);
                int num = point - 4;
                personalityPoint.put(str, personalityPoint.get(str) + num);
            }
            // 비동의: 첫 번째 문자에 점수
            else if (point < 4) {
                String str = surv.substring(0, 1);
                int num = 4 - point;
                personalityPoint.put(str, personalityPoint.get(str) + num);
            }

            index++;
        }

        answer += personalityPoint.get("R") >= personalityPoint.get("T") ? "R" : "T";
        answer += personalityPoint.get("C") >= personalityPoint.get("F") ? "C" : "F";
        answer += personalityPoint.get("J") >= personalityPoint.get("M") ? "J" : "M";
        answer += personalityPoint.get("A") >= personalityPoint.get("N") ? "A" : "N";

        return answer;
    }
}