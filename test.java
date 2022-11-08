import java.util.*;

public class test {
    public static boolean solution(int n) {
        var digits = new ArrayList<Integer>();
        
        while(n >= 0) {
            digits.add(0, n % 10);
            
            n /= 10;
        }
        
        var N = digits.size();
        
        if((N % 2) != 0) { return false; }
        
        int firstHalf = 0;
        for(var i = 0; i < N / 2; i++) { firstHalf += digits.get(i); }
        
        int secondHalf = 0;
        for(var i = N / 2; i < N; i++) { secondHalf += digits.get(i); }
        
        return firstHalf == secondHalf;
    }
    public static void main(String[] args) {
        solution(1230);
    }
}