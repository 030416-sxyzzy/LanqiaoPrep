package array;
import java.util.*;
//例题1：
//问题描述：给定n个整数a1,a2,…,an，求他们两两相乘再相加的和，
//即：S = a1•a2+ a1•a3+ ... + a1•an+ a2•a3+ ... + an-2•an-1+ an-2•an+ an-1•an
//解：把计算式子变换为：S= (a1+a2 +...+an-1)×an+(a1+a2+...+an-2)×an-1+(a1+a2+...+an-3)×an-2+...   +(a1+a2)×a3+ a1×a2
public class PreSum1 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n=scan.nextInt();
        long[] a=new long[200010];
        long[] sum=new long[200010];
        for(int i=1;i<=n;i++){
          a[i]=scan.nextInt();
          sum[i]=sum[i-1]+a[i];//预求前缀和
        }
        long x=0;
        for(int i=1;i<=n;i++){
          x+=a[i]*(sum[n]-sum[i]);
        }
        System.out.println(x);
        scan.close();
    }

}
