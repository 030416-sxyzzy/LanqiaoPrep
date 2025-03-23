package search;

public class BinarySearch {
	//例题1:问题描述：满足N!的末尾恰好有K个0的最小的N是多少？如果这样的N不存在，输出-1。 
	    static long check(long x){
	    //计算n!末尾有多少0，由于10=2*5，所以只需要计算n!中2和5的因子的数量。又因为n!中2的因子数量远大于5的因子数量，所以只需要计算5的因子数量
	      long cnt=0;
	      while(x>0){
	        cnt+=(x/=5);
	      }
	      return cnt;
	    }
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        long k=scan.nextLong();
	        long l=1l;
	        long r=Long.MAX_VALUE - 1;
	        while(l<r){
	          long mid = (l+r) /2;
	        if(check(mid)>=k){
	          r=mid;
	        }else{
	          l=mid+1;
	        }}
	        if(check(r)==k){
	          System.out.println(r);
	        }else{
	          System.out.println(-1);
	        }
	        scan.close();
	    }
	
//-------------------------------------------------------------------------------

	/*例题2：二分查找+前缀和
	题目描述
	给定三个整数数组 A,B,C
	请你统计有多少个三元组 (i,j,k) 满足：
	1≤i,j,k≤N
	 Ai<Bj<Ck
	输入格式
	第一行包含一个整数 N。第二行包含 N 个整数 A 第三行包含 N 个整数 B 第四行包含 N 个整数 C 
	输出格式
	一个整数表示答案*/

		public static void main(String [] args) {
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int[] a=new int[n];
			int[] b=new int[n];
			int[] c=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=scanner.nextInt();
			}
			for(int i=0;i<n;i++) {
				b[i]=scanner.nextInt();
			}
			for(int i=0;i<n;i++) {
				c[i]=scanner.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b);
			Arrays.sort(c);
			int[] B=new int[n];
			for(int i=0;i<n;i++) {
				int left=0,right=n-1;
				while(left<right) {
					int mid=(left+right)/2;
					if(c[mid]>b[i]) {
						right=mid;
					}else {
						left=mid+1;
					}
				}
				if(c[left]>b[i])
					B[i]=n-left;
			}
			long []sum=new long[n+1];
			for(int i=1;i<=n;i++)
				sum[i]=sum[i-1]+B[i-1];
			long ans=0;
			for(int i=0;i<n;i++) {
				int left=0,right=n-1;
				while(left<right) {
					int mid=(left+right)/2;
					if(b[mid]>a[i]) {
						right=mid;
					}else {
						left=mid+1;
					}
				}
				if(b[left]>a[i])
					ans+=sum[n]-sum[left];
			}
			System.out.println(ans);
		}

	/*解释：
	输入：
	n = 3
	a = [1, 2, 3]
	b = [2, 3, 4]
	c = [3, 4, 5]

	处理过程：
	1. 首先计算每个b[i]有多少个c[k]大于它：
	   对于b[0]=2：c中有3个数大于它，B[0]=3
	   对于b[1]=3：c中有2个数大于它，B[1]=2
	   对于b[2]=4：c中有1个数大于它，B[2]=1
	   
	2. 计算B的前缀和：
	   sum[0]=0
	   sum[1]=3
	   sum[2]=5
	   sum[3]=6

	3. 对于每个a[i]：
	   a[0]=1：b中有3个数大于它，贡献是sum[3]-sum[0]=6
	   a[1]=2：b中有2个数大于它，贡献是sum[3]-sum[1]=3
	   a[2]=3：b中有1个数大于它，贡献是sum[3]-sum[2]=1

	4. 最终答案：6+3+1=10
*/
//----------------------------------------------------------------------------------------------------
	/*浮点二分
	例题3：切绳子
	题目描述
	有 N 条绳子，它们的长度分别为 Li。如果从它们中切割出 K 条长度相同的绳子，这 K 条绳子每条最长能有多长？答案保留到小数点后 2 位(直接舍掉 2 位后的小数)。

	输入格式
	第一行两个整数 N 和 K，接下来 N 行，描述了每条绳子的长度 Li。

	输出格式
	切割后每条绳子的最大长度。答案与标准答案误差不超过 0.01 或者相对误差不超过 1% 即可通过。*/
		public static void main(String [] args) {
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			double[] a=new double[n];
			for(int i=0;i<n;i++) 
				a[i]=scanner.nextDouble();
			double left=0,right=1e9;
			while(right-left>1e-2) {
				double mid=(left+right)/2;
				if(check(a,mid,k)) {
					right=mid;
				}else {
					left=mid;
				}
			}
			System.out.println(left);
		}
		public static boolean check(double[] a,double mid,int k) {
			int res=0;
			for(double x:a) {
				res+=(int)(x/mid);
			}
			return res<k;
		}
	}

