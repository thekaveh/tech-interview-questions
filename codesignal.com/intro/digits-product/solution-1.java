int solution(int product) {
    for(var num = 1; num < 65522; num++) {
        if(digitsProductEquals(num, product)) { return num; }
    }

    return -1;
}

boolean digitsProductEquals(int num, int prod) {
    var p = 1;

    while(num > 0) {
        p *= num % 10;

        num /= 10;
    }

    return p == prod;
}