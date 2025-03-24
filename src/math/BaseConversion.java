package math;
import java.util.*;
/*进制转换方法
 * 1.调用API
 * String str=Integer.toString(x,y);//x是十进制数，y是你要转换的进制，返回值是字符串。
 * 2.自己写方法
 * public static String jinzhizhuanhuan(int x,int y) {
		StringBuilder str=new StringBuilder();
		while(x>0) {
			str.append(x%y);
			x/=y;
		}
		return str.reverse().toString();
	}
 */
public class BaseConversion {
/*	题目描述
	给一个小整数 x 和一个 x 进制的数 S。将 S 转为 10 进制数。对于超过十进制的数码，用 A，B，… 表示。
	输入格式
	第一行一个整数 x;
	第二行一个字符串 S。
	输出格式
	输出仅包含一个整数，表示答案。
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		char []c=scanner.next().toCharArray();
		int sum=0,k=1;
		for(int i=c.length-1;i>=0;i--) {
			int res=0;
			if(c[i]>='A'&&c[i]<='Z') {
				res=c[i]-'A'+10;
			}else {
				res=c[i]-'0';
			}
			sum+=res*k;
			k*=x;
		}
		System.out.println(sum);
	}*/
//---------------------------------------------------------------------------------------------------
/*题目描述
给定一个十进制整数 n 和一个小整数 x。将整数 n 转为 x 进制。对于超过十进制的数码，用 A，B ... 表示。
输入格式
第一行一个整数 n；
第二行一个整数 x。
输出格式
输出仅包含一个整数，表示答案。*/
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int x=scanner.nextInt();
		String string=Integer.toString(n, x);
		char[] c=string.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(c[i]>='a'&&c[i]<='z') {
				c[i]^=32;
			}
		}
		string=new String(c);
		System.out.println(string);
	}
}
