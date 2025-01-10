/*
    바탕화면 상태 나타낸 문자열 배열
    바탕화면 각 칸이 정사각형 격자판
    
    바탕화면 상태 --> wallpaper
    (0,0) 세로 좌표, 가로 좌표
    
    빈칸 -> '.' 파일이 있는 칸 -> '#'
    
    최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우기
    
    격자점 S(lux, luy), 격자점 E(rdx,rdy)로 이동한 뒤 왼쪽 버튼 떼기
    
    S에서 E로 드래그 --> 시작점, 끝점
    거리 --> 양 끝 x - x , y - y 의 절대 값 더한 값
*/


// 가장 짧게 드래그 하는 방법
// 가장 왼쪽의 y, 가장 위의 x, 가장 오른쪽 아래 y, 가장 오른쪽 x 찾아서 드래그

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 55;
        int luy = 55;
        int rdx = -1;
        int rdy = -1;
        
        
        for(int i = 0; i < wallpaper.length; i++){
            String temp = wallpaper[i];
            for(int j = 0; j < temp.length(); j++){
                Character temp1 = temp.charAt(j);
                
                if(temp1 == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        
        // 끝에 좌표임으로 rdx, rdy + 1
        int [] answer = {lux, luy, rdx + 1, rdy + 1};
        
        return answer;
    }
}