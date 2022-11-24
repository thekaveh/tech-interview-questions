int[] solution(int[] A, int k) {
    var M = A.length;
    var N = M - M / k;
    
    var B = new int[N];

    var j = 0;
    for(var i = 0; i < M; i++) {
        if((i + 1) % k == 0) { continue; }
        
        B[j++] = A[i];        
    }
    
    return B;
}