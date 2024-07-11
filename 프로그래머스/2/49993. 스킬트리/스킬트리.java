import java.util.*;   


class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 선행 스킬 순서가 있다
        // skill과 유저들이 만든 스킬트리 skill_trees 매개변수
        // 가능한 스킬 트리 개수
        // skill 1 ~ 26
        // skil_trees 1 ~ 20 이하 배열
        int answer = 0;
        
        int skillIndex = 1;
        
        int [] skillFlag = new int [26];
        
        
        // 해당 스킬 알파벳에 1 부터 순서 넣기
        for(int i = 0; i < skill.length(); i++){
            int flagIndex = skill.charAt(i) - 'A';
            skillFlag[flagIndex] = skillIndex;
            skillIndex++;
        }
        
        // 스킬트리들
        for(int i = 0; i < skill_trees.length; i++){
            
            int skill_treeIndex = 1;
            String skillTree = skill_trees[i];
            boolean ableFlag = true;
            
            // 하나의 스킬트리
            for(int j = 0; j < skillTree.length(); j++){
                Character skillOne = skillTree.charAt(j);
                int skillOneIndex = skillOne - 'A';
                int ableSkill = skillFlag[skillOneIndex];
                
                //0 인 경우 선행 필요 x
                if(ableSkill == 0) continue;
                
                // 현재 skill_treeIndex랑 같으면 현재 배울 수 있는 스킬
                if(ableSkill == skill_treeIndex) skill_treeIndex++;
                
                //skill_treeIndex보다 높으면 아직 배우지 못하는 스킬
                if(ableSkill > skill_treeIndex){
                    ableFlag = false;
                    break;
                }
            }
            
            if(ableFlag) answer++;
        }
        
        
        
        return answer;
    }
}