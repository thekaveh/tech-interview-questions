boolean solution(String name) {
    var N = name.length();
    
    for(var i = 0; i < N; i++) {
        var c = name.charAt(i);
        
        if(i == 0 && !Character.isAlphabetic(c) && c != '_') { return false; }
        
        if(i > 0 && !Character.isAlphabetic(c) && !Character.isDigit(c) && c != '_') { return false; }
    }
    
    return true;
}