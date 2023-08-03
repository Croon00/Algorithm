import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        //  정렬해야 하는 인덱스의 단어를 맨 앞에 넣어서 정렬한다.
        List<String> tempList = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            String str = "";
            str += strings[i].charAt(n);
            str += strings[i];
            tempList.add(str);
        }
        Collections.sort(tempList);
        
        String [] answer = new String[tempList.size()];
        // 맨 앞글자 뺀 후 받기
        for(int i = 0; i < tempList.size(); i++){
            answer[i] = tempList.get(i).substring(1, tempList.get(i).length());
        }
        
        return answer;
    }
}