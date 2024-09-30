import java.util.*;
// 동영상 재생기
// 10초 전으로 이동, 10초 후로 이동, 오프닝 건너띄기
// prev -> 10초 전 / 10초 미만인 경우 영상 처음으로 이동
// next -> 10초 후로 이동 // 10초 미만인 경우영상 마지막 위치로 이동
// 오프닝 건너띄기 --> 현재 재생 위치가 오프닝 구간인 경우 자동으로 오프닝 끝나는 위치로 이동
// video_len --> 동영상의 길이, pos --> 재생위치, op_start --> 시작 시각, op_end --> 오프닝 끝나는 시각,
// commands --> 사용자의 입력 "mm:ss" 형식

// 분도 0 ~ 59, 초도 0 ~ 59 초가 60 넘으면 1분 늘리고 초는 00으로
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
   
        // 시간, 초 를 int로 바꾸기
                int video_m = Integer.parseInt(video_len.substring(0, 2));
                int video_s = Integer.parseInt(video_len.substring(3, 5));
                
                int pos_m = Integer.parseInt(pos.substring(0, 2));
                int pos_s = Integer.parseInt(pos.substring(3, 5));
        
                int ops_m = Integer.parseInt(op_start.substring(0, 2));
                int ops_s = Integer.parseInt(op_start.substring(3, 5));
                
                int ope_m = Integer.parseInt(op_end.substring(0, 2));
                int ope_s = Integer.parseInt(op_end.substring(3, 5));
        
        
                // 오프닝 분보다 같으면서 크거나, 엔딩 분보다 작으면서 같거나
                if(pos_m >= ops_m && pos_m <= ope_m){
                    boolean flag = true;
                    // 오프닝분과 같은 분이지만 초가 오프닝 보다 낮으면 건너띄기
                    if(pos_m == ops_m){
                        if(pos_s < ops_s) flag = false;
                    }
                    
                    // 엔딩 분과 같은 분이지만 초가 엔딩보다 크면 건너띄기
                    if(pos_m == ope_m){
                        if(pos_s > ope_s) flag = false;
                    }
                    
                    // 엔딩으로 이동
                    if(flag){
                        pos_m = ope_m;
                        pos_s = ope_s;
                    }
                }
        
        
        // 총 커맨드
        for(int i = 0; i < commands.length; i++){
            
            // 10초 뒤
            if(commands[i].equals("next")){
                pos_s += 10;
                
                if(pos_s >= 60){
                    pos_s %= 60;
                    pos_m++;
                }
                
                // 영상 끝 보다 큰경우
                if(pos_m >= video_m){
                    if(pos_m == video_m && pos_s <= video_s){
                        
                    }
                    else{
                        pos_m = video_m;
                        pos_s = video_s;
                    }
                }
                
            }
            else if(commands[i].equals("prev")){
                pos_s -= 10;
                
                if(pos_s < 0){
                    pos_s = 60 + pos_s;
                    pos_m--;
                }
                
                // 영상 시작보다 작은 경우
                if(pos_m <= 00){
                    if(pos_m == 00 && pos_s >= 00){
                        
                    }
                    else{
                        pos_m = 00;
                        pos_s = 00;
                    }
                }
            }
            
            // 오프닝 분보다 같으면서 크거나, 엔딩 분보다 작으면서 같거나
                if(pos_m >= ops_m && pos_m <= ope_m){
                    boolean flag = true;
                    // 오프닝분과 같은 분이지만 초가 오프닝 보다 낮으면 건너띄기
                    if(pos_m == ops_m){
                        if(pos_s < ops_s) flag = false;
                    }
                    
                    // 엔딩 분과 같은 분이지만 초가 엔딩보다 크면 건너띄기
                    if(pos_m == ope_m){
                        if(pos_s > ope_s) flag = false;
                    }
                    
                    // 엔딩으로 이동
                    if(flag){
                        pos_m = ope_m;
                        pos_s = ope_s;
                    }
                }
        }
    
        String answer_m;
        String answer_s;
        
        if(pos_m < 10){
            answer_m = "0" + String.valueOf(pos_m);
        }
        else{
            answer_m =  String.valueOf(pos_m);
        }
        
        if(pos_s < 10){
            answer_s = "0" + String.valueOf(pos_s);
        }
        else{
            answer_s = String.valueOf(pos_s);
        }
        
        
        
        String answer = answer_m + ":" + answer_s;
        return answer;
    }
}