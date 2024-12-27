import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약 정보를 시작 시간 기준으로 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        // PriorityQueue를 사용하여 종료 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String[] time : book_time) {
            // 시작 시간과 종료 시간 계산
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1]) + 10; // 청소 시간 10분 추가

            // PriorityQueue에서 가장 빨리 비는 객실의 종료 시간을 확인
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); // 기존 객실을 재사용
            }

            // 새로운 종료 시간 추가
            pq.offer(end);
        }

        // PriorityQueue의 크기가 필요한 최소 객실 수
        return pq.size();
    }

    // "HH:mm" 형식의 시간을 분 단위로 변환하는 메서드
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
