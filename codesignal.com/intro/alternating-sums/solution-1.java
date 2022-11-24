int[] solution(int[] A) {
    var N = A.length;

    var one = 0;
    var two = 0;
    
    for(var i = 0; i < N; i++) {
        if(i % 2 == 0)  { one += A[i]; }
        else            { two += A[i]; }
    }
    
    return new int[] { one, two };
}