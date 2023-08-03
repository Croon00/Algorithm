import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        // 만들 수 있는 모든 수 --> 브루트포스
        // 이미 있는 수면 겹치지 않게
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                int num = numbers[i] + numbers[j];
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}