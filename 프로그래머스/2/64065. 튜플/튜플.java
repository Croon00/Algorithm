import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        // 셀수 있는 수량의 순서있는 열거 또는 순서를 따르는 요소들의 묶음 --> 튜플
        
        // 중복된 원소 o, 순서가 있으며 순서가 다르면 서로 다른 튜플
        // 원소 개수는 유한
        // 중복되는 원소가 없는 튜플이 주어질 때
       
        
        //s 에서 각각의 집합에서 크기가 작은 값 부터 받은 후 그 다음 추가된 값을 이어 붙인다.
        
        // 중복 되는 원소 없게 받기 위한 boolean
        boolean [] visit = new boolean[100001];
        
        // 맨앞 "와 { 를 빼고 맨 뒤 }와 "를 뺀 값 받은 후 },{를 -로 대체
        String str = s.substring(2, s.length() - 2);
        str = str.replace("},{", "-");
        
        // -를 기준으로 배열 스플릿
        String [] arr = str.split("-");
        
        // 문자열 길이에 따라 정렬하기
        Arrays.sort(arr, (o1, o2) -> (o1.length() - o2.length()));
        
        // 각각의 집합 돌면서
        for(int i = 0; i < arr.length; i++){
            // 해당 부분 문자열 numArr
            String numArr = arr[i];
            String num = "";
            // 집합 부분 String 에서
            for(int j = 0; j < numArr.length(); j++){
                
                // 반점 부분 일때
                if(numArr.charAt(j) == ','){
                    // 아직 중복되지 않은 숫자일 때 추가 후 방문 체크
                    if(!visit[Integer.parseInt(num)]){
                        answer.add(Integer.parseInt(num));
                        visit[Integer.parseInt(num)] = true;
                    }
                    // 다시 num String을 초기화 한다.
                    num = "";
                }
                // 맨 마지막 부분일 때
                else if(j == numArr.length() - 1){
                    // 뒤에 해당 숫자String 추가 한뒤 체크해서 넣는다.
                    num += numArr.charAt(j);
                    if(!visit[Integer.parseInt(num)]){
                        answer.add(Integer.parseInt(num));
                        visit[Integer.parseInt(num)] = true;
                    }
                }
                // 반점 부분, 마지막 부분이 아닐 때는 String에 문자열 이어 붙이기
                else{
                    num += numArr.charAt(j);
                }
            }
        }
    
        return answer;
    }
}