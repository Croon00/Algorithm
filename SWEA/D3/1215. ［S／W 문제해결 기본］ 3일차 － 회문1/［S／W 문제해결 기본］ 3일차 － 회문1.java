import java.util.Scanner;

public class Solution {
    static Character word_char[][] = new Character[8][8];
    static StringBuilder sb;
    static int count;
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            String Char;
            count = 0;
            length = sc.nextInt();
            for (int i = 0; i < 8; i++) {
                Char = sc.next();
                for (int j = 0; j < 8; j++) {
                    word_char[i][j] = Char.charAt(j);
                }
            }
            palindrome();
            System.out.println("#" + tc + " " + count);
        }
    }

    static void palindrome() {
        // 가로 확인
        for (int i = 0; i < 8; i++) {
            String word = "";
            for (int j = 0; j < 8 - length + 1; j++) {
                for (int k = j; k < j + length; k++) {
                    word += word_char[i][k];

                }
                sb = new StringBuilder(word);
                if (sb.reverse().toString().equals(word)) {
                    count++;
                }
                word = "";
            }
        }


        for (int i = 0; i < 8; i++) {
            String word = "";
            for (int j = 0; j < 8 - length + 1; j++) {
                for (int k = j; k < j + length; k++) {
                    word += word_char[k][i];
                }
                sb = new StringBuilder(word);
                if (sb.reverse().toString().equals(word)) {
                    count++;
                }
                word = "";
            }
        }
    }
}
