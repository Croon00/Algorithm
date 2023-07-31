import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // sizes 크기 1 ~ 10,000
        // w는 명함의 가로 길이
        // h는 명함의 세로 길이
        // w, h 1 ~ 1000
        
        int maxW = 0;
        int maxH = 0;
        
        // 각 사각형의 긴 부분을 가로 길이로 바꾸어서 길이 비교
        for(int i = 0; i < sizes.length; i++){
            int W = Math.max(sizes[i][0], sizes[i][1]);
            int H = Math.min(sizes[i][0], sizes[i][1]);
            
            maxW = Math.max(maxW, W);
            maxH = Math.max(maxH, H);
        }

        answer = maxW * maxH;
        return answer;
    }
}