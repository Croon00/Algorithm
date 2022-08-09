import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            String memory = sc.next();
            char [] char_arr = new char[memory.length()];
            int count = 0;
            for(int i = 0; i < memory.length(); i++){
                char_arr[i] = memory.charAt(i);
            }

            for(int i = 0; i < memory.length(); i++){
                if(char_arr[i] == '1'){
                    for(int j = i; j < memory.length(); j++){
                        if(char_arr[j] == '0') {
                            char_arr[j] = '1';
                        }
                        else{
                            char_arr[j] = '0';
                        }
                    }
                    count++;
                }
            }
            System.out.println("#" + tc + " "+ count);
        }
    }
}
