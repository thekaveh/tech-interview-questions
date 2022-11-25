boolean solution(char symbol) {
    var offset = symbol - '0';
    
    return 0 <= offset && offset <= 9;
}