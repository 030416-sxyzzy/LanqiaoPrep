package datetime;

public class Date {
	/*（1）高斯日记
	import java.util.Scanner;
	import java.time.*;
	import java.time.format.DateTimeFormatter;//引入了用于格式化日期时间的 DateTimeFormatter 类。
	public class Main {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        LocalDate start = LocalDate.of(1777,4,30);
	        LocalDate end = start.plusDays(8112);//使用 start 对象的 plusDays() 方法，计算从1777年4月30日开始，往后推8112天后的日期。这个新日期保存在 end 变量中。
	        System.out.print(end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));//将 end 这个日期格式化为 yyyy-MM-dd 的字符串形式
	        scan.close();
	    }
	}


	（2）时间显示1452
	将毫秒转换为时分秒的格式
	import java.sql.Date;//导入date类
	import java.text.SimpleDateFormat;//用于格式化和解析日期对象，将 Date 类型转化为特定格式的字符串。
	import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	         //在此输入您的代码...
	         long mills = scan.nextLong();
	         Date date = new Date(mills);//创建Date对象
	         SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
	         System.out.println(ft.format(date));//将 Date 对象date按照 SimpleDateFormat 中指定的格式转换成一个字符串。
	         scan.close();
	    }
	}


	(3)跑步锻炼
	小蓝每天都锻炼身体。
	正常情况下，小蓝每天跑 1 千米。如果某天是周一或者月初(1 日)，为了激励自己，小蓝要跑 2千米。如果同时是周一或月初，小蓝也是跑 2千米。
	小蓝跑步已经坚持了很长时间，从2000年1月1日周六(含)到2020年10月1日周四(含)。请问这段时间小蓝总共跑步多少千米?
	import java.util.Scanner;
	import java.time.LocalDate;
	public class Main {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        LocalDate start=LocalDate.of(2000,1,1);
	        LocalDate end=LocalDate.of(2020,10,2);//不包括10月2号
	        int sum=0;
	        while(start.compareTo(end)!=0){//循环条件是 start 日期不等于 end
	          if(start.getDayOfWeek().getValue()==1 || start.getDayOfMonth()==1){
	            sum+=2;
	          }else{
	            sum+=1;
	          }
	          start=start.plusDays(1);//将 start 日期向前推一天，进入下一天
	        }
	        System.out.println(sum);
	        scan.close();
	    }
	}


	（4）小明正在整理一批历史文献。这些历史文献中出现了很多日期。小明知道这些日期都在 1960年1月1日至 2059年 12 月 31 日。令小明头疼的是，这些日期采用的格式非常不统一，有采用年1月/的，有采用月/日/年的，还有采用日/月/年的。更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。比如 02/03/04，可能是2002年03月04日、2004 年02月 03 日或2004年03 月 02 日。给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗?
	import java.util.Scanner;
	import java.text.SimpleDateFormat;
	import java.util.Scanner;
	import java.util.TreeSet;

	public class Main {
	    public static void main(String[] args) {
	        Scanner scanner=new Scanner(System.in);
	        String  temp=scanner.next();
	        String  date[]=temp.split("/");//将输入字符串转换为数组
	        String y=date[0],m=date[1],d=date[2],//获取数组数值 用加号连接字符串
	                yMd=(Integer.parseInt(y)<60?"20"+y:"19"+y)+"-"+m+"-"+d,
	                mDy=(Integer.parseInt(d)<60?"20"+d:"19"+d)+"-"+y+"-"+m,
	                dMy=(Integer.parseInt(d)<60?"20"+d:"19"+d)+"-"+m+"-"+y;

	        TreeSet<String> set = new TreeSet<String>();//创建一个 TreeSet 用于存储所有有效的日期（这个集合会自动按照字典顺序排序）
	        if(f(yMd)) set.add(yMd);//依次检查三种日期格式是否有效，使用 f() 方法验证日期的有效性。
	        if(f(mDy)) set.add(mDy);
	        if(f(dMy)) set.add(dMy);
	        //02/03/04
	        for (Object object : set) {
	            System.out.println(object);
	        }
	    }
	    static boolean  f(String date){
	//f() 方法使用 SimpleDateFormat 来解析给定的日期字符串。
	format.setLenient(false) 设置宽松模式为 false，即严格检查日期的有效性。例如，02/30/2025 这样的日期将被认为是无效的。
	使用 format.parse(date) 尝试解析日期字符串，如果成功解析，说明该日期有效，返回 true；否则捕获 Exception，返回 false。

	        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	        format.setLenient(false);
	        try {
	            format.parse(date);
	        }catch (Exception e){
	            return  false;
	        }
	        return  true;
	    }
	}


	(5)特殊日期3495
	问题描述：记一个日期为y年m月d日，统计从2000年1 月1 日（含）到2000000年1月1日（含），有多少个日期满足年份y是月份m的倍数，同时也是d的倍数。
	public class Main {
	    static int[] d={31,28,31,30,31,30,31,31,30,31,30,31};
	    static int leap(int i){
	    if((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
	      return 1;
	    } else {
	      return 0;
	    }
	    }
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        long ans=0;
	        for(int i=2000;i<=1999999;i++){
	          if(leap(i)==1) d[1]=29;
	          else d[1]=28; 
	          for(int j=1;j<=12;j++){
	            for(int k=1;k<=d[j-1];k++){
	              if(i%j==0&&i%k==0){
	                ans++;
	              }
	            }
	          }
	        }
	        ans++;
	        System.out.println(ans);
	        scan.close();
	    }
	}
*/
}
