package dp;
import java.util.Scanner;
public class Bagjichu {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();//物品种数
	        int bagweight = scanner.nextInt();//背包容量

	        int[] weight = new int[n];//物品重量
	        int[] value = new int[n];//物品价值

	        for (int i = 0; i < n; ++i) {
	            weight[i] = scanner.nextInt();
	        }
	        for (int j = 0; j < n; ++j) {
	            value[j] = scanner.nextInt();
	        }
	        //定义dp数组：表示从[0,i]中取任意物品放进容量为j的背包中所产生的最大价值为dp[i][j]
	        int[][] dp = new int[n][bagweight + 1];
	        //初始化：物品0从weight[0]开始都初始化为value[0]，其余都初始化为0
	        for (int j = weight[0]; j <= bagweight; j++) {
	            dp[0][j] = value[0];
	        }

	        for (int i = 1; i < n; i++) {//从物品1开始遍历
	            for (int j = 0; j <= bagweight; j++) {
	                if (j < weight[i]) {//背包容量比物品容量小
	                    dp[i][j] = dp[i - 1][j];//不放物品
	                } else {
	                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
	                }
	            }
	        }

	        System.out.println(dp[n - 1][bagweight]);
	    }
	}

