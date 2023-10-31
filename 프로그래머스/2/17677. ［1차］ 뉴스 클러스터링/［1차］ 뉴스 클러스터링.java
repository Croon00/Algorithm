import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        
        // 비슷한 뉴스 기사
        // 집합간 유사도 검사
        // 교집합, 합집합 - > 교집합 / 합집합
        
        // 모두 공집합 --> 1로
        // 마찬 가지로 문자열 --> 두 글자씩 끊어서 다중집합
        
        // 영문자로 딘 글자만 쌍으로 유효, 기타 공백이나 숫자나 특수문자 --> 글자쌍을 버린다.
        
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        
        
        for(int i = 0; i < str1.length() - 1; i++){
            // 2자리씩 끊어서 받기
            String temp = str1.substring(i, i + 2);
            temp = temp.toUpperCase();
            boolean check = true;
            
            // A보다 작은 아스키값 혹은 z 보다 큰 아스키 값의 경우는 넣지 않는다
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j) < 'A' || temp.charAt(j) > 'Z'){
                    check =false;
                    break;
                }
            }
            // 대문자로만 받는다.
            if(check){
                arr1.add(temp.toUpperCase());
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String temp = str2.substring(i, i + 2);
            temp = temp.toUpperCase();
            boolean check = true;
            
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j) < 'A' || temp.charAt(j) > 'Z'){
                    check =false;
                    break;
                }
            }
            if(check){
                arr2.add(temp.toUpperCase());
            }
        }
        
        // 모두 공집합인 경우 1로 정의한다.
        if(arr1.size() == 0 && arr2.size() == 0){
            return 65536;
        }
        
        
        // 체크
        boolean [] visited = new boolean[arr2.size()];
    
        double same = 0;
        for(int i = 0; i < arr1.size(); i++){
            
            for(int j = 0; j < arr2.size(); j++){
                // 이미 교집합 한 단어면 건너띄기
                if(visited[j]) continue;
                // 같은지 확인해서 중복 체크 후 교집합 수 ++
                if(arr1.get(i).equals(arr2.get(j))){
                    visited[j] = true;
                    same++;
                    break;
                }
            }
        }
        // 합집합은 둘이 더한 값에서 교집합 수 빼기
        double sum = arr1.size() + arr2.size() - same;
        double ans = same / sum * 65536;
        

        int answer = (int) ans;
        return answer;
    }
}