boolean solution(String cellA, String cellB) {
    var black = true;
    
    var rA = Integer.valueOf(cellA.charAt(1));
    var cA = Integer.valueOf(cellA.charAt(0) - 'A' + 1);
    
    var rB = Integer.valueOf(cellB.charAt(1));
    var cB = Integer.valueOf(cellB.charAt(0) - 'A' + 1);
    
    return Math.abs(rA - rB) % 2 == Math.abs(cA - cB) % 2;
}