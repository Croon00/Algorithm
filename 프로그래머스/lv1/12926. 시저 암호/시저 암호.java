class Solution {
    public String solution(String s, int n) {
        String answer = "";
        Character [] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character [] alphabets2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        Character [] alphabet = new Character[s.length()];
        
        // 각각 26의 나머지로 계산해서 넣기
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 26; j++){
                if(s.charAt(i) == alphabets[j]) {
                    alphabet[i] = alphabets[(j + n) % 26];
                }
                else if(s.charAt(i) == alphabets2[j]){
                    alphabet[i] = alphabets2[(j + n) % 26];
                }
                // 빈칸은 빈칸 넣기
                else if(s.charAt(i) == ' '){
                    alphabet[i] = s.charAt(i);
                }
            }
        }
        for(int i = 0; i < alphabet.length; i++){
            answer += String.valueOf(alphabet[i]);
        }
        return answer;
    }
}