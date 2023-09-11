import java.util.*;
class Solution {
    
    static int ans;
    public int solution(int n, int[][] wires) {
        int answer = 101;
        // n개의 송전탑이 전선을 통해 하나의 트리 형태
        // 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할
        // 두 전력망이 갖게되는 송전탑의 개수를 최대한 비슷하게
        
        // 송전탑의 개수 n개 (2 ~ 100)
        // 전선 정보 wires
        // n개의 노드를 가진 그래프 
        List<Integer> [] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 정보 채우기
        for(int i = 0; i < wires.length; i++) {
            int startNode = wires[i][0];
            int endNode = wires[i][1];
            
            // 무방향 그래프
            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
        
        
        // 전선을 하나씩 끊어보고 그것의 차가 가장 적을 때를 출력하기
        // 트리형태는 적어도 모두 이어져 있다.
        
        for(int i = 0; i < wires.length; i++){
            // 하나씩 끊어본다.
            Integer deleteStart = wires[i][0];
            Integer deleteEnd = wires[i][1];
            
            graph[deleteStart].remove(deleteEnd);
            graph[deleteEnd].remove(deleteStart);
            
            int cnt = bfs(n, graph);
            int diff = Math.abs(cnt - Math.abs(n - cnt)); // n개에서 연결되 있는 cnt를 빼면 두 전력망의 송전탑 개수의 차
            answer = Math.min(answer, diff);
            
            // 다시 연결하기
            graph[deleteStart].add(deleteEnd);
            graph[deleteEnd].add(deleteStart);
            
        }
        
        return answer;
    }
    
    static int bfs(int n, List<Integer> graph []) {
        
        boolean [] visited = new boolean[n + 1];
        int cnt = 1;
        // bfs (1번 노드부터 시작)
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]= true; // 1번 노드는 체크
        while(!q.isEmpty()){
            int node = q.poll();
            // 해당 노드와 연결되 있는 노드
            for(int nextNode : graph[node]){
                // 방문 체크해주고 다음 노드로 넣어준다.
                if(visited[nextNode]) continue;
                q.add(nextNode);
                visited[nextNode] = true;
                cnt++;
            }
        }
        return cnt;
    }
}