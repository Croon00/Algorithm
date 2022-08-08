import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] vowels = {"a", "i", "o", "e", "u"};

        int T = sc.nextInt();
        sc.nextLine();
        for(int tc = 1; tc <= T; tc++) {

            String word = sc.nextLine();

            // replaceAll을 이용하면 String 안에서 찾은 값들을 replacement 값으로 바꾸어준다.
            for(int i = 0; i < vowels.length; i++){
                word = word.replaceAll(vowels[i], "");
            }

            System.out.println("#" + tc + " " + word);
        }
    }
}