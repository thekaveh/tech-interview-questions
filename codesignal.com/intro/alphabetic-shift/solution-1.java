String solution(String txt) {
    var R = new StringBuilder();
    
    for(var from : txt.toCharArray()) {
        var to = (char)((from - 'a' + 1) % ('z' - 'a' + 1) + 'a');
        
        R.append(to);
    }
    
    return R.toString();
}