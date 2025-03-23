package dp;
import java.util.*;
//例题2：求最长递增子序列
//状态转移方程:i>j a[i]>a[j]
//dp[i]=Math.max(dp[i], dp[j]+1);

public class solve2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] a=new int[n];
		int[] dp=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		int max=1;
		dp[0]=1;
		for(int i=1;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(a[i]>a[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
		
	}


}
