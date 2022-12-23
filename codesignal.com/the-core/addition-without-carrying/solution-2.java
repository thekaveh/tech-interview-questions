class Solution {
    int solution(int param1, int param2) {
        if(param1 == 0 || param2 == 0) { return param1 + param2; }

        return solution(param1 / 10, param2 / 10) * 10 + (param1 + param2) % 10;
    }
}