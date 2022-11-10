import java.util.*;

class Program {
  public String runLengthEncoding(String txt) {
    int N = txt.length();
    var cipher = new StringBuilder();
    
    int runCount = 1;	
    for(var i = 0; i < N; i++) {
        char runChar = txt.charAt(i);
        
        if((i < N - 1 && runChar != txt.charAt(i + 1)) || runCount == 9 || i == N - 1) {
            cipher.append(runCount);
            cipher.append(runChar);
            
            runCount = 1;
        }
        else {
            runCount++;
        }
    }
    
    return cipher.toString();
  }
}