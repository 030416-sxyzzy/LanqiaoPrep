package string;
import java.util.*;
public class String {
	//（1）公司名称3329
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String A="Lanqiao";
	        char[] Array=A.toCharArray();
	        Arrays.sort(Array);
	        String AArray=new String(Array);
	        int t=scan.nextInt();
	        for(int i=0;i<t;i++){
	          int n=scan.nextInt();
	          scan.nextLine();
	          String s=scan.nextLine();
	          char[] sArray=s.toCharArray();
	          Arrays.sort(sArray);
	          String SArray=new String(sArray);
	          if(AArray.equals(SArray))
	            System.out.println("YES");            
	          else         
	            System.out.println("NO"); 
	          
	        }
	        scan.close();
	    }

//	（2）标题统计
//	replace()用法
//	String s = sc.nextLine().replace(" ", "");
//	        System.out.println(s.length());

	//（3）字符串连接次数
	Set<String> set=new HashSet<>();
	        for(int i=0;i<n;i++){
	          for(int j=0;j<n;j++){
	            if(i!=j){
	              set.add(arr[i]+arr[j]);
	            }
	          }
	        }
	        System.out.println(set.size());


	//(4)句子反转
		public static void main(String [] args) {
			Scanner scanner=new Scanner(System.in);
			String string=scanner.nextLine();
			StringBuilder s =new StringBuilder();
			StringBuilder a =new StringBuilder();
			char[] ch=string.toCharArray();
			for(int i=ch.length-1;i>=0;i--) {
				if(ch[i]==' ') {
					if(a.length()!=0) {
						int k=a.charAt(0)-'0';
						if(k>=0&&k<=9) {
							a.reverse();
						}
					}
					s.append(a.toString()+" ");
					a=new StringBuilder();
				}
				else {
					char x=ch[i];
					if((x>='a'&&x<='z')||(x>='A'&&x<='Z')) {
						x^=32;//异或运算
					}
					a.insert(0, x);//每次在索引为0的位置插入字符
				}
				
			}
			if(a.length()!=0) {//处理最后一个字符串
					int k=a.charAt(0)-'0';
					if(k>=0&&k<=9) {
						a.reverse();
					}
			}
			s.append(a);
			System.out.println(s);
			
		}
	}
}
