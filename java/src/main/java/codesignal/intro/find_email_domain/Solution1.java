package codesignal.intro.find_email_domain;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static String solution(String address) {
        var atIdx = address.lastIndexOf('@');
        
        return address.substring(atIdx + 1);
    }
}
