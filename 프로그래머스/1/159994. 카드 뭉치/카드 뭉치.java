class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용
        // 한 번 사용한 카드는 다시 사용 x
        // 기존에 주어진 카드 뭉치의 단어 순서 바꾸기 x
        // 카드를 사용 무조건 해야함
        
        // 첫 번째와 두 번째 카드 뭉치의 인덱스
        int index1 = 0;
        int index2 = 0;
        String answer = "";
        // 만드려는 단어 배열에서
        
        boolean check = true;
        for(int i = 0; i < goal.length; i++){
            // 가능한지 여부
            boolean flag = false;
            String goalWord = goal[i];
            
            
            // 첫 번째 카드 뭉치에서 찾기
            if(index1 < cards1.length && cards1[index1].equals(goalWord)){
                // 있는 경우 인덱스 증가 및 true
                index1++;
                flag = true;
            }
            // 첫 번째 카드 뭉치에 없는 경우 두 번째 카드 뭉치에서 찾기
            else{
                // 있는 경우 인덱스 증가 및 true 

                if(index2 < cards2.length && cards2[index2].equals(goalWord)){
                    index2++;
                    flag = true;
                }
            }
            // 있지 않다면 반복문 나가기
            if(!flag){
                check = false;
                break;
            } 
        }
        if(check){
            answer = "Yes";
        }
        else{
            answer = "No";
        }
        
        return answer;
    }
}