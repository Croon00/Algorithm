import java.util.Scanner;
 
public class Solution {
    static int [] box;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for(int tc = 1; tc <= 10; tc++){
            int dump_count = sc.nextInt();
            box = new int[100];
            int max = 0;
            int min = 101;
 
            for(int i = 0; i < 100; i++){
                box[i] = sc.nextInt();
            }
 
            for(int i = 0; i < dump_count; i++){
                max_min_box();
            }
            for(int i = 0; i < 100; i++){
                max = Math.max(max, box[i]);
                min = Math.min(min, box[i]);
            }
            System.out.println("#" + tc + " "+ (max - min));
        }
    }
 
    static void max_min_box(){
        int max_idx = 0;
        int max_box = 0;
        int min_box = 101;
        int min_idx = 0;
 
        for(int i = 0; i < 100; i++){
            if(max_box < box[i]){
                max_box = box[i];
                max_idx = i;
            }
        }
 
        for(int i = 0; i < 100; i++){
            if(min_box > box[i]){
                min_box = box[i];
                min_idx = i;
            }
        }
        box[max_idx]--;
        box[min_idx]++;
    }
}