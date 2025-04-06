package zhati;
import java.util.*;
//test
public class HaoShu {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int ans=0;
		for(int i=1;i<=n;i++) {
			if(fun(i)==1){
				ans++;
			}
		}
		System.out.println(ans);
		
	}
	public static int fun(int n) {
		int x=1;
		while(n!=0) {
			int t=n%10;
			if(x%2==1) {
				if(t%2==0)
					return 0;
			}else { 
				if(t%2==1)
					return 0;
				
			}
			x++;
			n/=10;
		}
			return 1;
		}
	}

