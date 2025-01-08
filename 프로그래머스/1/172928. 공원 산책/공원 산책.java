/*
    지나다닌느 길 O, 장애물 X
    직사각형 격자 모양의 공원
    로봇 강아지 E 5는 동쪽으로 5칸 이동
    주어진 방향 --> 공원 벗어났는지 or 장애물 만나는지 확인
    --> 가로 길이가 W, 세로 길이가 H 공원의 좌측 상단 좌표 0,0 우측 하단 -1 ,-1
*/

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int [] answer = new int[2];
        
        int size = park[0].length();
        Character [][] map = new Character[park.length][size];
        
        // 맵 채우기
        for(int i = 0; i < park.length; i++){
            String temp = park[i];
            for(int j = 0; j < size; j++){
                Character characterTemp = temp.charAt(j);
                map[i][j] = characterTemp;
                
                // 시작 지점
                if(characterTemp == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                    System.out.println(i + "시작"+ j);
                }
            }
        }
        
        
        for(int i = 0; i < routes.length; i++){
            String [] temp = routes[i].split(" ");
            String direct = temp[0]; // 방향
            String dis = temp[1]; // 거리
            
            int ansRow = answer[0];
            int ansCol = answer[1];
            
            int dist = Integer.parseInt(dis);
            
            int [][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            
            int k = 0;
            
            // 동쪽
            if(direct.equals("E")){
                k = 3;
            }
            // 남쪽
            else if(direct.equals("S")){
                k = 1;
            }
            // 서쪽
            else if(direct.equals("W")){
                k = 2;
            }
            // 북쪽
            else if(direct.equals("N")){
                k = 0;
            }
            
            // 거리만큼 이동
            for(int j = 0; j < dist; j++){
                int row = answer[0];
                int col = answer[1];
                System.out.println(k);
                System.out.println(row + "," + col);
                
                int nr = row + dir[k][0];
                int nc = col + dir[k][1];
                
                // 거리를 넘거나 장애물이 있는 경우 이번 명령어 무시 하고 건너띄기
                if(nr < 0 || nc < 0 || nr >= park.length || nc >= size || map[nr][nc] == 'X'){
                    answer[0] = ansRow;
                    answer[1] = ansCol;
                    break;
                } 

                answer[0] = nr;
                answer[1] = nc;
            }
        }
        
        return answer;
    }
}