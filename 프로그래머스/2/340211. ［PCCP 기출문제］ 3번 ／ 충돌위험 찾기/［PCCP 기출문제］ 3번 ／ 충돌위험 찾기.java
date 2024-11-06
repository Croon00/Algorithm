import java.util.*;

class Solution {
    static int answer;

    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        
        // 모든 로봇의 경로를 계산하여 충돌 확인
        function(points, routes);
        
        return answer;
    }
    
    // 모든 로봇의 이동 경로를 계산하며 충돌을 체크하는 메서드
    public static void function(int[][] points, int[][] routes) {
        int numRobots = routes.length;
        int routeLength = routes[0].length;

        // 매 초마다의 좌표와 로봇 수를 기록
        List<Map<String, Integer>> positionPerTime = new ArrayList<>();

        for (int i = 0; i < numRobots; i++) {
            int[] startPoint = points[routes[i][0] - 1];
            int x = startPoint[0];
            int y = startPoint[1];

            // 첫 좌표를 추가
            addPosition(positionPerTime, x, y, 0);

            int time = 1;  // 이동 시작 시간
            for (int j = 1; j < routeLength; j++) {
                int[] endPoint = points[routes[i][j] - 1];
                int targetX = endPoint[0];
                int targetY = endPoint[1];

                // x좌표부터 이동
                while (x != targetX) {
                    x += (targetX > x) ? 1 : -1;
                    addPosition(positionPerTime, x, y, time++);
                }

                // y좌표 이동
                while (y != targetY) {
                    y += (targetY > y) ? 1 : -1;
                    addPosition(positionPerTime, x, y, time++);
                }
            }
        }

        // positionPerTime을 바탕으로 충돌 계산
        calculateCollisions(positionPerTime);
    }

    // 특정 시간의 좌표에 로봇이 위치한 횟수 기록
    private static void addPosition(List<Map<String, Integer>> positionPerTime, int x, int y, int time) {
        // 필요한 시간까지 Map을 생성
        while (positionPerTime.size() <= time) {
            positionPerTime.add(new HashMap<>());
        }

        String key = x + "," + y;
        Map<String, Integer> currentMap = positionPerTime.get(time);
        currentMap.put(key, currentMap.getOrDefault(key, 0) + 1);
    }

    // 각 시간별 좌표에서 충돌 횟수를 계산
    private static void calculateCollisions(List<Map<String, Integer>> positionPerTime) {
        for (Map<String, Integer> timeMap : positionPerTime) {
            for (int count : timeMap.values()) {
                if (count > 1) {
                    answer += 1; // 해당 초에서 한 번의 충돌로 계산
                }
            }
        }
    }
}
