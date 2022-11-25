String solution(String address) {
    var atIdx = address.lastIndexOf('@');
    
    return address.substring(atIdx + 1);
}