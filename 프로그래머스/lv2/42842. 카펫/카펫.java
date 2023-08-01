class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        // 갈색 + 노란색의 약수 이면서, 가로의 길이가 더 클 때만 가능
        // 가로,세로의 길이가 3이상이여야 가운데 노란색 놓을 수 있음
        int [] answer = new int [2];
        for(int i = 1; i <= sum; i++){
            int row = i; // 가로 길이
            int col = sum / row; // 세로 길이
            
            // 가로 길이가 세로 길이 보다 커야 함
            if(row > col) continue;

            // 노란색 타일이 가로 길이 - 2, 세로 길이 - 2 같아야 한다.
            if((row - 2) * (col - 2) == yellow){
                answer[0] = col;
                answer[1] = row;
                break;
            }
            
        }
        return answer;
    }
}