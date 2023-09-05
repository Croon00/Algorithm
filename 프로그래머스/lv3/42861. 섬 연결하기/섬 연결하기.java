import java.util.*;
class Solution {
    static int [] parent;
    public int solution(int n, int[][] costs) {
        // n개의 섬에서 다리 건설하는 비용(costs)
        // 모든 섬이 서로 통행 가능하도록 최소 비용
    
        // 섬의 개수 n 1 ~ 100이하
        // costs의 길이는 
        // 모든 섬 사이의 다리 건설 비용이 주어지진 않는다. 
        // 모든 섬은 연결 가능하게 되어 있다.
        
        // 무방향 그래프이면서 가중치 있는 그래프
        // 크루스칼 알고리즘 사용
        
        // 가중치가 낮은 노드끼리 먼저 연결해야 함으로 오름차순으로 정렬
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2]-c2[2]);
        
        parent = new int[n];
        // 부모 노드 초기화
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int total = 0;
        
        // 간선의 수
        for(int [] edge : costs){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            
            int fromParent = find(from);
            int toParent = find(to);
            
            // 부모노드가 같으면 같은 그래프에 속한다.
            // 가중치를 더할 필요가 없어짐
            if(fromParent == toParent) continue;
            
            total += weight;
            parent[toParent] = fromParent; // 아직 연결되지 않은 그래프임으로 간선을 연결해준다.
        }
        
        
        int answer = total;
        return answer;
    }
    
    static int find(int num){
        if(parent[num] == num) return num; // 부모와 내가 같으면 num
        return parent[num] = find(parent[num]);
    }
}