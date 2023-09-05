import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 한칸씩 커서 이동한 횟수
        
        for(int i = 0; i < name.length(); i++){
            // 알파벳을 A 쪽에서 다음 알파벳으로 혹은 이전 알파벳으로 할지
            answer += Math.min(name.charAt(i) - 'A', 'Z'- name.charAt(i) + 1);
            
            // 이미 A가 있는 곳은 바꿀 필요 없음으로 커서 이동할때 더 가깝게 이동해야 한다.
            // 범위가 맨 끝에 있는 A가 아니면서 다음 알파벳이 A인 경우
            if(i < name.length() - 1 && name.charAt(i + 1) == 'A'){
                int index = i + 1;
                // name 범위를 넘어가지 않으면서 A인 경우 index++해서 건너띄게 한다.
                while(index < name.length() && name.charAt(index) == 'A'){
                    index++;
                }
                // 그냥 쭈욱 오른쪽으로 이동 vs 왔던 만큼 왼쪽으로 돌아가서 채우기
                // 왔던 만큼 다시 뒤로 이동함으로 * 2하기, 남은 채워야 하는 알파벳 수는 name.length에서 index 빼기
                move = Math.min(move, i * 2 + (name.length() - index));
                // 바로 왼쪽으로 이동해서 채우기 vs 위에서 했던 방법
                // 바로 왼쪽으로 가서 하면 이것을 다시 앞으로 와야 함으로 * 2, 그 후 i번 만큼 알파벳 채워야함
                move = Math.min(move, i + (name.length() - index) * 2);
            }
            
        }
        return answer + move;
    }
}