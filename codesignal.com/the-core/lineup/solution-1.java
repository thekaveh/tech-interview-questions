class Solution {
    int solution(String commands) {
        var ret = 0;
        var state = true;

        for(var command : commands.toCharArray()) {
            if(command == 'L' || command == 'R') { state = !state; }

            if(state) { ret++; }
        }

        return ret;
    }
}