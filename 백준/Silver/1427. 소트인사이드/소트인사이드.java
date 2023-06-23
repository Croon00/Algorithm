import java.util.*;
import java.io.*;

public class Main {



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String num = br.readLine();

        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i < num.length(); i++){
            nums.add(num.charAt(i) - '0');
        }

        Collections.sort(nums);

        String ans = "";
        for(int i = nums.size() - 1; i >= 0; i--){
            ans += String.valueOf(nums.get(i));
        }

        System.out.println(ans);
    }
}
