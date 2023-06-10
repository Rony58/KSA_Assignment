// Name : Rani Mia
// ID   : 213902058
package LCSprolem;
import java.util.Arrays;
import java.util.Scanner;
public class LongestIncreasingSubsequence {
  
    public static int findLongestIncreasingSubsequence(String sequence) {
        int n = sequence.length();
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1); 
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.charAt(i) > sequence.charAt(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the sequence: ");
        String sequence = scanner.nextLine();
        scanner.close();
        
        int lisLength = findLongestIncreasingSubsequence(sequence);
        
        System.out.println("Length of the Longest Increasing Subsequence: " + lisLength);
    }
}
