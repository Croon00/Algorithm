
class Solution {
    
    // 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1
    // 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어짐
    // 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        // 분모는 최소 공배수
        int denom = lcm(denom1, denom2);
        
        int multiple1 = denom / denom1;
        int multiple2 = denom / denom2;
        // 분자는 최소 공배수 되기위해 곱해야 하는 값들 곱해서 더하기
        int numer = (numer1 * multiple1) + (numer2 * multiple2);
        
        // 분자와 분모 사이의 최대 공약수가 1보다 크면 해당 공약수로 나누기
        while(1 < gcd(numer, denom)){
            int gcd1 = gcd(numer, denom);
            numer = numer / gcd1;
            denom = denom / gcd1;
        }
        
        
        
        int[] answer = {numer, denom};
        
        
        return answer;
    }
    
    // 최대 공약수
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    // 최소 공배수
    static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}