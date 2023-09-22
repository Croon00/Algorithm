import java.util.*;
class Solution {
    static boolean[] visited;
    static List<List<String>> airportList;
    static List<String> answer; // 정답 경로
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        airportList = new ArrayList<>();
        answer = new ArrayList<>();
        
        // tickets을 돌면서 ICN일 때 출발한다.
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                List<String> list = new ArrayList<>();
                list.add("ICN");
                dfs(tickets, tickets[i][1], 1, list);
                visited[i] = false;
            }
        }
        
        // 알파벳 순서로 정렬
        Collections.sort(airportList, (s1, s2) -> {
            for (int i = 0; i < s1.size(); i++) {
                int cmp = s1.get(i).compareTo(s2.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        
        // 정렬된 경로 중 첫 번째 경로를 정답으로 선택
        answer = airportList.get(0);
        
        String[] result = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
    
    static void dfs(String[][] tickets, String airport, int depth, List<String> list) {
        // 모든 티켓을 사용한 경우
        if (depth == tickets.length) {
            list.add(airport);
            airportList.add(new ArrayList<>(list));
            list.remove(list.size() - 1); // 마지막 항목 제거
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) continue;
            
            if (airport.equals(tickets[i][0])) {
                visited[i] = true;
                list.add(airport);
                dfs(tickets, tickets[i][1], depth + 1, list);
                visited[i] = false;
                list.remove(list.size() - 1); // 마지막 항목 제거
            }
        }
    }
}
