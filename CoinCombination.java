// Name : Rani Mia
// ID   : 213902058
package LCSprolem;
import java.util.Scanner;
public class CoinCombination {
    public static int countCoinCombination(int targetAmount) {
        int[] coins = {1, 5, 10};
        
        int[] dp = new int[targetAmount + 1];
        dp[0] = 1; 
       
        for (int coin : coins) {
            for (int i = coin; i <= targetAmount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[targetAmount];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the target amount (in taka): ");
        int targetAmount = scanner.nextInt();
        
        scanner.close();
        
        int combinations = countCoinCombination(targetAmount);
        
        System.out.println("Total number of combinations: " + combinations);
    }
}
