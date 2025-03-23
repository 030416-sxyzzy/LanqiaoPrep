package dp;
import java.util.Scanner;
/*最优子结构
最优子结构的意思是：首先，大问题的最优解包含小问题的最优解；其次，可以通过小问题的最优解推导出大问题的最优解。
主要思路：推出状态转移方程 dp[i]=dp[i-1]+dp[i-3]
例题1：程序员爬楼梯
楼梯有n级，每次你只能爬1级或者3级，那么你有多少种方法爬到楼梯的顶部
当前在0级
状态转移方程：dp[i]=dp[i-1]+dp[i-3];*/
public class solve1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		if(n<3) {
			System.out.println(1);
		}else {
			int[] dp=new int[n+1];
			dp[1]=1;
			dp[2]=1;
			dp[3]=2;
			for(int i=4;i<=n;i++) {
				dp[i]=dp[i-1]+dp[i-3];
			}
			System.out.println(dp[n]);
		}	
	}

}
