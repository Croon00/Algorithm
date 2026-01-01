class Solution {
    public int solution(String s) {
        int answer = 0;

        int startIdx = 0;
        int nextIdx = 1;
        int startAlphaCnt = 1;
        int nextAlphaCnt = 0;

        while (true) {
            // 시작점이 마지막 문자면 그 한 글자도 한 조각
            if (startIdx == s.length() - 1) {
                answer++;
                break;
            }

            // ✅ 더 읽을 글자가 없으면, 남은 건 마지막 조각으로 분리하고 종료
            if (nextIdx >= s.length()) {
                answer++;
                break;
            }

            char startAlphabet = s.charAt(startIdx);
            char nextAlphabet = s.charAt(nextIdx);

            if (startAlphabet == nextAlphabet) startAlphaCnt++;
            else nextAlphaCnt++;

            if (startAlphaCnt == nextAlphaCnt) {
                answer++;
                startIdx = nextIdx + 1;
                nextIdx = startIdx + 1;

                // 다음 조각이 아예 없으면 종료(딱 끝에서 맞아떨어진 경우)
                if (startIdx >= s.length()) break;

                startAlphaCnt = 1;
                nextAlphaCnt = 0;
            } else {
                nextIdx++;
            }
        }

        return answer;
    }
}
