package array;
import java.util.*;
/*例题:重新排序（2128）
问题描述
给定一个数组A和一些查询L，R，求数组中第L至第R个元素之和。
小蓝觉得这个问题很无聊，于是他想重新排列一下数组，使得最终每个查询结果的和尽可能地大。
小蓝想知道相比原数组，所有查询结果的总和最多可以增加多少?
输入格式
输入第一行包含一个整数n。
第二行包含n个整数A1，A2，···，An，相邻两个整数之间用一个空格分隔。
第三行包含一个整数m表示查询的数目。
接下来m行，每行包含两个整数L，R相邻两个整数之间用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
例如：5
1 2 3 4 5
2
1 3->1 2 3
2 5->2 3 4 5
原数组=1+2*2+3*2+4+5=20
重新排序1 4 5 2 3 
=1+4*2+5*2+2+3=24
增加24-20=4*/
public class Difference {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        long[] a=new long[n+1];
        long[] cnt=new long[n+1];//统计查询次数
        long[] d=new long[n+2];//差分数组
        for(int i=1;i<=n;i++){
          a[i]=scan.nextInt();
        }
        int m=scan.nextInt();
        while(m-->0){
          int L=scan.nextInt();
          int R=scan.nextInt();
          d[L]++;
          d[R+1]--;
        }
        for(int i=1;i<=n;i++){
          cnt[i]=cnt[i-1]+d[i];
        }
        long ans1=0;
        for(int i=1;i<=n;i++){
          ans1+=a[i]*cnt[i];
        }
        Arrays.sort(a);
        Arrays.sort(cnt);
        long ans2=0;
        for(int i=1;i<=n;i++){
          ans2+=a[i]*cnt[i];
        }
        System.out.println(ans2-ans1);
        scan.close();
    }
}
/*解题思路：
本题的m个查询可以统一处理，读入m个查询后，每个a[i]被查询了多少次就知道了。用cnt[i]记录a[i]被查询的次数，
根据差分的应用场景，每次查询的[L, R]就是对a[L] ~ a[R]中的所有数累加次数加1，
也就是对cnt[L] ~ cnt[R]中的所有cnt[]加1。那么对cnt[]使用差分数组d[]即可。
cnt[i]*a[i]就是a[i]对总和的贡献。先算出原数组上的总和ans1。然后计算新数组上的总和。
显然，把查询次数最多的数分给最大的数，对总和的贡献最大。对a[]和cnt[]排序，
把最大的a[n]与最大的cnt[n]相乘、次大的a[n-1]与次大的cnt[n-1]相乘，算出新数组上的总和ans2。*/
