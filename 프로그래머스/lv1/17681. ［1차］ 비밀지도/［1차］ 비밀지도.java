class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 지도1과 지도2에서 어느 부분이라도 벽인 부분은 전체지도에서 벽
        // n * n 지도,
        // 각각 정수 배열로 암호화
        // 전체 지도를 뽑기
        Character [][] map = new Character[n][n]; // 지도
        
        // n 번에서 2진수로 바꾸어서 0일 경우 ' ', 아닐 경우 #
        for(int i = 0; i < n; i++){
            String BinaryNum = Integer.toBinaryString(arr1[i]);
            int idx = 0;
            // 앞에 0이 붙는 경우 넣어주기
            if(BinaryNum.length() < n){
                for(int k = 0; k < n - BinaryNum.length(); k++){
                    if(map[i][idx] == null){
                        // 이미 #이 아닌 경우에만
                        map[i][idx] = ' ';
                    }
                    idx++;
                }
            }
            // Binary.charAt으로 넣어주기
            for(int j = 0; j < BinaryNum.length(); j++){
                if(BinaryNum.charAt(j) == '0'){
                    if(map[i][idx] == null){
                        map[i][idx] = ' ';
                    }
                }
                else{
                    map[i][idx] = '#'; 
                }
                idx++;
            }
            
            int idx2 = 0;
            String BinaryNum2 = Integer.toBinaryString(arr2[i]);
            // 앞에 0이 붙는 경우 넣어주기
            if(BinaryNum2.length() < n){
                for(int k = 0; k < n - BinaryNum2.length(); k++){
                    if(map[i][idx2] == ' '){
                        map[i][idx2] = ' ';
                    }
                    idx2++;
                }
            }
            
            for(int j = 0; j < BinaryNum2.length(); j++){
                if(BinaryNum2.charAt(j) == '0'){
                    if(map[i][idx2] == ' '){
                        map[i][idx2] = ' ';
                    }
                }
                else{
                    map[i][idx2] = '#';
                }
                idx2++;
            }
        }
        
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                str += map[i][j];
            }
            answer[i] = str;
        }
        return answer;
    }
}