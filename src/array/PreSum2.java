package array;
//例题2：
//给定一个长度为 N 的数列​，如果其中一段连续的子序列 A  (i≤j) 之和是 K 的倍数，我们就称这个区间 [i,j] 是 K 倍区间。
//你能求出数列中总共有多少个 K 倍区间吗？
public class PreSum2 {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] f=new int[k];//存储余数出现的次数
		f[0]=1;//余数为0，则表示一个k倍区间
		long sum=0,ans=0;
		for(int i=0;i<n;i++) {
			sum+=scanner.nextLong();
			ans+=f[(int)(sum%k)];
			f[(int)(sum%k)]++;
		}
		System.out.println(ans);
	}
}
/*算法思路：如果两个前缀和对K取余的结果相同，那么这两个前缀和之间的子数组的和一定能被K整除
即同余定理：
前缀和Sn=a1+a2+a3+a4+...+an;
S4%k=1;
S8%k=1;
那就表明S8-S4可以被k整除，是一个k倍区间
举例说明：
输入：
n=4 k=3
数组：[1,2,3,1]

执行过程：
1. 初始状态：
   f[0]=1, f[1]=0, f[2]=0
   sum=0, ans=0

2. i=0：
   sum=1
   sum%k=1
   ans+=f[1]=0
   f[1]++
   状态：f[0]=1, f[1]=1, f[2]=0, ans=0

3. i=1：
   sum=3
   sum%k=0
   ans+=f[0]=1
   f[0]++
   状态：f[0]=2, f[1]=1, f[2]=0, ans=1

4. i=2：
   sum=6
   sum%k=0
   ans+=f[0]=2
   f[0]++
   状态：f[0]=3, f[1]=1, f[2]=0, ans=3

5. i=3：
   sum=7
   sum%k=1
   ans+=f[1]=1
   f[1]++
   状态：f[0]=3, f[1]=2, f[2]=0, ans=4*/
	
	
