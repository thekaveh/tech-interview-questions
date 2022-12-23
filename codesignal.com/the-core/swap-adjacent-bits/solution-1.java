class Solution {
    int solution(int n) {
        return (n << 1 & 0b10101010101010101010101010101010) + (n >> 1 & 0b01010101010101010101010101010101);
    } 
}