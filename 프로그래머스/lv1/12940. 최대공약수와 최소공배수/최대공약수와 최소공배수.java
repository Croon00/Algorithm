class Solution {
    public int[] solution(int n, int m) {
        int num = 0;
        
        if(n >= m){
            num = gcd(n, m);
        }
        else{
            num = gcd(m, n);
        }
        
        int minNum = (n * m)/num;
        int [] answer = {num, minNum};
        
        return answer;
    }
    // 유클리드 호제법
    static int gcd(int a, int b){
        int r = 0;
        
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}