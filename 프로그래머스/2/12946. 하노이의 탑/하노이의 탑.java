import java.util.*;

class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        
        
        list = new ArrayList<>();
        
        // n 은 15이하의 자연수
        // 점화식을 세우자
        // 2개 옮길때 --> 1번에서 2번으로 옮기기, 1번에서 3번으로 옮기기, 2번에서 3번으로 옮기기
        // n - 1개의 원판을 2번으로 옮긴다. 맨 밑에 원판을 3번으로 옮긴다, n - 1개의 원판을 3번으로 옮긴다.
        // 총 hanoi(n - 1) * 2 에다가 마지막 원판 옮길거 + 1이다.
        
        // 3개 옮길때 제일 위에거 3번으로 옮기기, 2번으로 가운데거 옮기기 제일 위에거 2번으로 옮기기, 제일 밑에거 3번으로 옮기기
        // 시작하는 기둥, 끝나는 기둥, 거치는 기둥, 몇개째인지, 총 몇 개를 해야 하는지
        // 처음에는 1번 기둥에서 시작해서 3번 기둥으로 보내야 하는데 2번 기둥을 거쳐야 한다.
        hanoi(1, 3, 2, n);
        
        int[][] answer = list.stream().toArray(int[][]::new);
        return answer;
    }
    
    static void hanoi(int start, int end, int temp, int n){
        
        // 더 이상 옮길 필요 없으면 끝
        if(n == 0){
            return;
        }
        
        // 3번 기둥을 거쳐서 2번으로 n -1 개가 옮겨야 한다.
        hanoi(start, temp, end, n - 1);
        
        list.add(new int []{start, end});
        // 현재 2번에서 1번 기둥을 거쳐 3번으로 옮겨야 한다.
        hanoi(temp, end, start, n - 1);
    }

}