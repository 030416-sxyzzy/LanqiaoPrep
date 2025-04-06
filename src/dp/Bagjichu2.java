package dp;
import java.util.Scanner;
public class Bagjichu2 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // 读取 M 和 N
	        int M = scanner.nextInt();  // 物品数量
	        int N = scanner.nextInt();  // 背包容量

	        int[] weight = new int[M];   // 每种物品的重量
	        int[] values = new int[M];  // 每种物品的价值

	        // 输入每种物品的重量
	        for (int i = 0; i < M; i++) {
	            weight[i] = scanner.nextInt();
	        }

	        // 输入每种物品的价值
	        for (int j = 0; j < M; j++) {
	            values[j] = scanner.nextInt();
	        }

	        // 创建一个动态规划数组 dp，初始值为 0
	        int[] dp = new int[N + 1];

	        // 外层循环遍历每个类型的物品
	        for (int i = 0; i < M; i++) {
	            // 内层循环从 N 空间逐渐减少到当前物品所占容量
	            for (int j = N; j >= weight[i]; j--) {
	                // 考虑当前物品选择和不选择的情况，选择最大值
	                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
	            }
	        }

	        // 输出 dp[N]，即在给定 N 容量空间可以放进的物品的最大价值
	        System.out.println(dp[N]);

	        scanner.close();
	    }
	}
