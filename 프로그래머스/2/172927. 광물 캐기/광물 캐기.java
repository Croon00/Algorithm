import java.util.*;

class Solution {
    static class Mineral {
        int dia;
        int iron;
        int stone;
        int cnt;

        public Mineral(int dia, int iron, int stone, int cnt) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
            this.cnt = cnt;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 곡괭이 수 x 5 갯수 만큼 광물 캘 수 있다
        int diaPickel = picks[0];
        int ironPickel = picks[1];
        int stonePickel = picks[2];
        int totalPick = diaPickel + ironPickel + stonePickel;

        // 캘 수 있는 최대 광물 개수
        int maxMinerals = Math.min(totalPick * 5, minerals.length);

        List<Mineral> list = new ArrayList<>();

        // 곡괭이 갯수만큼, 5개씩
        for (int i = 0; i < maxMinerals; i += 5) {
            int cnt = 0;
            int diaCnt = 0;
            int ironCnt = 0;
            int stoneCnt = 0;

            // 5개씩 묶어서
            for (int j = i; j < i + 5 && j < maxMinerals; j++) {
                String temp = minerals[j];

                // 다이아일 경우
                if (temp.equals("diamond")) {
                    diaCnt++;
                    cnt += 25;
                }

                // 철일 경우
                else if (temp.equals("iron")) {
                    ironCnt++;
                    cnt += 5;
                }

                // 돌일 경우
                else {
                    stoneCnt++;
                    cnt++;
                }
            }

            Mineral mineral = new Mineral(diaCnt, ironCnt, stoneCnt, cnt);
            list.add(mineral);
        }

        // list Cnt 기준으로 내림차순으로 정렬
        Collections.sort(list, (o1, o2) -> (o2.cnt - o1.cnt));

        // 곡괭이로 캐기
        for (Mineral m : list) {
            int dia = m.dia;
            int iron = m.iron;
            int stone = m.stone;

            // 다이아 곡괭이가 1개 이상인 경우
            if (diaPickel > 0) {
                diaPickel--;
                answer += dia;
                answer += iron;
                answer += stone;
            }

            // 철 곡괭이가 1개 이상인 경우
            else if (ironPickel > 0) {
                ironPickel--;
                answer += dia * 5;
                answer += iron;
                answer += stone;
            }

            // 돌 곡괭이인 경우
            else if (stonePickel > 0) {
                stonePickel--;
                answer += dia * 25;
                answer += iron * 5;
                answer += stone;
            }
        }

        return answer;
    }
}
