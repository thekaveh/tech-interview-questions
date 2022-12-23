class Solution {
    int solution(int n) {
        var rev = new StringBuilder(Integer.toBinaryString(n)).reverse();

        return (int) Math.pow(2, rev.indexOf("0", rev.indexOf("0") + 1));
    }
}