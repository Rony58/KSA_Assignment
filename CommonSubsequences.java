// Name : Rani Mia
// ID   : 213902058
package LCSprolem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class CommonSubsequences {
    
    public static List<String> findCommonSubsequences(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        List<String> subsequences = new ArrayList<>();
        findAllSubsequences(s1, s2, dp, m, n, "", subsequences);
        
        Collections.sort(subsequences, (a, b) -> b.length() - a.length());
        
        return subsequences;
    }
    
    public static void findAllSubsequences(String s1, String s2, int[][] dp, int i, int j, String subsequence, List<String> subsequences) {
        if (i == 0 || j == 0) {
            subsequences.add(subsequence);
            return;
        }
        
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            findAllSubsequences(s1, s2, dp, i-1, j-1, s1.charAt(i-1) + subsequence, subsequences);
        } else {
            if (dp[i][j-1] >= dp[i-1][j]) {
                findAllSubsequences(s1, s2, dp, i, j-1, subsequence, subsequences);
            }
            
            if (dp[i-1][j] >= dp[i][j-1]) {
                findAllSubsequences(s1, s2, dp, i-1, j, subsequence, subsequences);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first sequence: ");
        String s1 = scanner.nextLine();
        
        System.out.print("Enter the second sequence: ");
        String s2 = scanner.nextLine();
        
        scanner.close();
        
        List<String> commonSubsequences = findCommonSubsequences(s1, s2);
        
        System.out.println("Common Subsequences:");
        for (String subsequence : commonSubsequences) {
            System.out.println(subsequence);
        }
    }
}
