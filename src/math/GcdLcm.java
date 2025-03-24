package math;
import java.util.*;
/*最大公约数：
 * 辗转相除法：public static long gcd(long x,long y){
 * return y==0?x:gcd(y,x % y);}
 最小公倍数：
 public static long lcm(long x, long y){
 return x/gcd(x,y)*y;
 */
public class GcdLcm {
//	public static void main(String [] args) {
//		Scanner scanner=new Scanner(System.in);
//		int x=scanner.nextInt();
//		int y=scanner.nextInt();
//		int z=scanner.nextInt();
//		int n=gcd(x, y);
//		System.out.println(gcd(n, z));
//	}
//	public static int gcd(int x,int y){
//		 return y==0?x:gcd(y,x % y);
//	}
//-------------------------------------------------------------------------
//等差数列
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		Arrays.sort(a);
		int d=a[1]-a[0];
		for(int i=2;i<n;i++) {
			d=gcd(d, a[i]-a[i-1]);
		}
		if(d==0) {
			System.out.println(n);
		}else {
			long res=1;
			for(int i=1;i<n;i++) {
				res+=(a[i]-a[i-1])/d;
			}
			System.out.println(res);
		}
	}
	public static int gcd(int x,int y ) {
		return y==0?x:gcd(x, x%y);
	}
}
