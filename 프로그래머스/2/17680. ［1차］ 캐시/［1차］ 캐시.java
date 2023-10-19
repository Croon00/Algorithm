import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 지도개발팀 캐시 교체 알고리즘 LRU를 이용하여 실행시간 구하기
        
        // 큐를 통해서 가장 최근에 찾은 도시 이름을 캐시에 다시 집어넣기
        // cache hit는 캐시에 있으면 걸리는 실행시간
        // cache miss는 캐시에 없으면 걸리는 실행 시간
        int answer = 0;

        List<String> cache = new ArrayList<>();
        
        // 캐시 사이즈가 0인 경우 그냥 길이 * 5;
        if(cacheSize == 0){
            return cities.length * 5;
        }
        // 도시 전체 돌면서
        for(String city : cities){
            // 캐시에 이미 있는 도시인 경우
            // 이미 있는 캐시를 위치에서 삭제하고
            // 캐시에 제일 뒷부분에 붙인다.
            // 도시 이름은 대소문자 관계없이
            String upperCity = city.toUpperCase();
            if(cache.contains(upperCity)){
                cache.remove(upperCity);
                answer += 1;
                cache.add(upperCity);
            }
            // 캐시에 없는 도시인 경우
            else{
                // 캐시가 꽉 찾을 때랑 아닐때 구분해서
                // 캐시가 캐시 사이즈 보다 작을 때
                if(cache.size() < cacheSize){
                    answer += 5;
                    cache.add(upperCity);
                }
                // 캐시 사이즈가 꽉 찼으면 가장불리지 않은 도시(0번째 위치) 제거 하고 city 붙이기
                else{
                    cache.remove(0);
                    cache.add(upperCity);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}