import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {   
        // 대회 n명이 참가, 토너먼트 형식
        // n명의 참가자 1 ~ N번
        // a와 b는 항상 이기어서 서로 붙게 되는 라운드 구하기
        int answer = 0;
        while(true){
            // 홀 수 일때는 2로 나눈 후 +1
            // 짝 수 일때는 2로 나눈 값
            if(a % 2 != 0){
                a = a / 2 + 1;
            }
            else{
                a = a / 2;
            }
            if(b % 2 != 0){
                b = b / 2 + 1;
            }
            else {
                b = b / 2;
            }
            answer++;

            if(a == b){
                break;
            }
        }
        return answer;
    }
}