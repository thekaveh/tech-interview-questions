class Solution {
    boolean solution(int n) {
        return (n + "").matches(".*0[^0]+0*");
    }
}