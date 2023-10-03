class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 사진속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 된다.
        // 그리워 하는 사람의 이름을 담은 문자열 name
        // 각 사람의 그리움 점수를 담은 정수 yearning
        // 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo
        int [] answer = new int [photo.length];
        for(int i = 0; i < photo.length; i++){
            for(int j = 0; j < photo[i].length; j++){
                for(int k = 0; k < name.length; k++){
                    if(photo[i][j].equals(name[k])){
                        answer[i] += yearning[k];
                    }
                }
            }
        }
        return answer;
    }
}