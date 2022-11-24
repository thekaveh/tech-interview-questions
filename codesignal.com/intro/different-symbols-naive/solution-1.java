int solution(String txt) {
    var M = new HashSet<Character>();

    for(var c : txt.toCharArray()) { M.add(c); }

    return M.size();
}