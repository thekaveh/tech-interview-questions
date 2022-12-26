class Solution {
    int solution(int current, int remainingDigits) {
        while(numOfDigits(current) <= remainingDigits) {
            remainingDigits -= numOfDigits(current);
            current++;
        }
        
        return current - 1;
    }
    
    int numOfDigits(int num) {
        return Integer.toString(num).length();
    }
}