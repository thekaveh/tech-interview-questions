boolean solution(String cellA, String cellB) {
    var black = true;
    
    var rA = Integer.valueOf(cellA.charAt(1));
    var cA = Integer.valueOf(cellA.charAt(0) - 'A' + 1);
    
    var rB = Integer.valueOf(cellB.charAt(1));
    var cB = Integer.valueOf(cellB.charAt(0) - 'A' + 1);
    
    var colorA = black;
    for(var rT = 1; rT < rA; rT++) { colorA = !colorA; }
    for(var cT = 1; cT < cA; cT++) { colorA = !colorA; }
    
    var colorB = black;
    for(var rT = 1; rT < rB; rT++) { colorB = !colorB; }
    for(var cT = 1; cT < cB; cT++) { colorB = !colorB; }
    
    return colorA == colorB;
}