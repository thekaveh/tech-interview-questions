String solution(String code) {
    return new String(new BigInteger(code, 2).toByteArray());
}