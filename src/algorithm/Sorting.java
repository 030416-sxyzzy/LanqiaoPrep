package algorithm;
import java.util.*;
public class Sorting {
//	从大到小排序
//	肖恩的排序
//	求a[i]数组在i位置的数都大于b[i]数组的排序总数
	Arrays.sort(a,Collections.reverseOrder());
	        Arrays.sort(b,Collections.reverseOrder());
	        long ans=1,cnt=0;
	        for(int i=0,j=0;i<n;i++){
	          while(j<n&&a[j]>b[i]){
	            j++;
	            cnt++;
	          }
	          ans*=cnt--;
	          ans%=1e9+7;
	        }
	        System.out.println(ans);

//----------------------------------------------------------------------------------------------------
	        
	        
	/*自定义比较函数（数位排序）
	
	    public static int digitSum(Integer x){
	      Integer sum=0;
	      while(x>0){
	        sum+=x%10;
	        x/=10;
	      }
	      return sum;
	    }
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        int n=scan.nextInt();
	        int m=scan.nextInt();
	        int sum=0;
	        Integer[] a=new Integer[n];
	        for(int i=0;i<n;i++){
	          a[i]=i+1;
	        }
	        Arrays.sort(a,(o1,o2)->digitSum(o1)!=digitSum(o2)?digitSum(o1)-digitSum(o2):o1-o2);
	//Lambda 表达式 (o1, o2) -> ... 指定：
	//如果 o1 和 o2 的各位数字之和不相等（通过 digitSum(o1) != digitSum(o2) 比较），则按照各位数字之和的大小进行排序：digitSum(o1) - digitSum(o2)。
	//如果 o1 和 o2 的各位数字之和相等，则按数字本身的大小进行排序：o1 - o2。
	        System.out.println(a[m-1]);
	        scan.close();
	    }
	}


//---------------------------------------------------------------------------------------------------------------------

	//字符串排序
	//如果你想对对象进行排序时，采用不只是默认排序的规则，比如按某个字段或多个字段来排序，或者通过复杂的逻辑来比较对象，你就可以通过 Comparator 来实现自定义排序规则。
	//自定义排序规则不仅可以用 Lambda 表达式 来为 Arrays.sort 提供一个自定义的比较器 Comparator，还可以通过实现 Comparator 接口来实现 
	    // 定义候选人类
	    static class Candidate {
	        String votes; // 得票数
	        int id; // 编号

	        Candidate(String votes, int id) {
	            this.votes = votes;
	            this.id = id;
	        }
	    }

	    // 自定义比较器，首先比较字符串长度，再按字典顺序
	    static class VoteComparator implements Comparator<Candidate> {
	        @Override
	        public int compare(Candidate a, Candidate b) {
	            if (a.votes.length() == b.votes.length()) {
	                return a.votes.compareTo(b.votes); // 按字典顺序比较
	            }
	            return Integer.compare(a.votes.length(), b.votes.length()); // 按字符串长度比较
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        // 读取候选人数量
	        int n = sc.nextInt();
	        sc.nextLine(); // 读取换行符

	        List<Candidate> candidates = new ArrayList<>();
	        
	        // 读取候选人票数
	        for (int i = 0; i < n; i++) {
	            String votes = sc.nextLine();
	            candidates.add(new Candidate(votes, i + 1)); // 存储票数和编号
	        }

	        // 按照票数排序
	        candidates.sort(new VoteComparator());

	        // 输出得票最多的候选人信息
	        Candidate winner = candidates.get(candidates.size() - 1); // 排序后最后一个就是最多票的人
	        System.out.println(winner.id); // 输出候选人编号
	        System.out.println(winner.votes); // 输出票数
	    }
	}


//------------------------------------------------------------------------------------------------------

	//结构体排序 
	//接水问题
	// 创建一个List来存储时间和对应的原始索引的数组，以便最后输出顺序 例如timeList = [[5, 1], [3, 2], [8, 3]]
	        List<int[]> timeList = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            timeList.add(new int[]{times[i], i + 1});
	        }
	        
	        // 按照接水时间升序排序
	        timeList.sort((a, b) -> Integer.compare(a[0], b[0]));

	        // 计算平均等待时间
	        int totalWaitTime = 0; // 总等待时间
	        int currentWaitTime = 0; // 当前人的等待时间
	        for (int i = 0; i < n; i++) {
	            totalWaitTime += currentWaitTime;
	            currentWaitTime += timeList.get(i)[0];//获取列表每个数组中的第一个元素，即接水时间
	        }

	        // 输出排序后的顺序
	        for (int i = 0; i < n; i++) {
	            System.out.print(timeList.get(i)[1] + " ");//输出列表每个数组中的第二个元素，即索引
	        }
	        System.out.println();

	        // 输出平均等待时间，保留两位小数
	        double averageWaitTime = (double) totalWaitTime / n;
	        System.out.printf("%.2f\n", averageWaitTime);


	/*奖学金
	import java.util.*;
	public class Main {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        int n=scan.nextInt();
	        ArrayList<int[]> record=new ArrayList<>(n);
	        for(int i=1;i<=n;i++){
	          int a=scan.nextInt();
	          int b=scan.nextInt();
	          int c=scan.nextInt();
	          scan.nextLine();
	          record.add(new int[]{i,a+b+c,a});
	        }
	        record.sort((x,y)->x[1]!=y[1]?y[1]-x[1]:x[2]!=y[2]?y[2]-x[2]:x[0]-y[0]);
	        for(int i=0;i<5;i++){
	          int[] t=record.get(i);
	          System.out.println(t[0]+" "+t[1]);
	        }
	        
	        scan.close();
	    }
	}*/


//----------------------------------------------------------------------------------------------------------------------------------
//	复杂排序
//	题目描述
//	现在有n个香蕉，每个香蕉的质量为ai，m只猴子，每只猴子的体重为bi。
//	现在将香蕉分给这些猴子，将猴子按照从大到小的顺序依次拿香蕉。当一轮拿完时，还有多的香蕉就会继续一个个拿，直到被拿完。
//	猴子都是聪明的，每次都会选择一个质量最大的香蕉。
//	现在请求出每个猴子获得的香蕉质量。
//	输入格式
//	第一行输入两个正整数n,m(1<=n,m<=10^5)
//	第二行n个整数ai表示每个香蕉的质量(1<=ai<=10^4)
//	第三行m个整数bi表示每个猴子的体重，保证体重互不相同。(1<=bi<=10^9)
//	输出格式
//	一行，m个用空格分隔的整数，表示每个猴子获得的香蕉质量之和。按照输入顺序输出对应的猴子。
	import java.util.*;

	public class Main {
	    
	    static class Monkey {
	        int w, id, y;//分别表示猴子的体重，编号以及获得的香蕉质量之和
	        
	        Monkey(int w, int id) {
	            this.w = w;
	            this.id = id;
	            this.y = 0; // 初始吃到的香蕉为0
	        }
	    }
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        int n = sc.nextInt(); // 香蕉数量
	        int m = sc.nextInt(); // 猴子数量
	        
	        Integer[] banana = new Integer[n]; // 存储香蕉质量
	        int[] part = new int[m]; // 分成m份存储每份的香蕉数量
	        
	        // 存储猴子
	        Monkey[] monkeys = new Monkey[m];
	        
	        // 输入香蕉的质量
	        for (int i = 0; i < n; i++) {
	            banana[i] = sc.nextInt();
	        }
	        
	        // 输入猴子的体重
	        for (int i = 0; i < m; i++) {
	            monkeys[i] = new Monkey(sc.nextInt(), i + 1); // id 从1开始 例如monkeys = [{w=60, id=1}, {w=70, id=2}, {w=50, id=3}]
	        }
	        
	        // 对香蕉按质量降序排序
	        Arrays.sort(banana,Collections.reverseOrder());
	       
	        
	        // 对猴子按体重降序排序
	        Arrays.sort(monkeys, (a, b) -> Integer.compare(b.w, a.w));
	        
	        // 分配香蕉
	        int bananaIndex = 0;
	        for (int i = 0; i < n; i++) {
	            part[i % m] += banana[i]; // 每份分配一部分香蕉
	        }
	        
	        // 将分配的香蕉赋给猴子
	        for (int i = 0; i < m; i++) {
	            monkeys[i].y = part[i]; // 每个猴子得到的香蕉数量
	        }
	        
	        // 按照原始编号对猴子进行排序
	        Arrays.sort(monkeys, (a, b) -> Integer.compare(a.id, b.id));
	        
	        // 输出每个猴子吃到的香蕉数
	        for (int i = 0; i < m; i++) {
	            System.out.print(monkeys[i].y + " ");
	        }
	    }
	}


//------------------------------------------------------------------------------------------------------------------------------
	/*用哈希表排序
	public class Main {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        int n=scan.nextInt();
	        Map<Long,Integer> map=new HashMap<>();
	        while(n-->0){
	          Long x=scan.nextLong();
	          if(!map.containsKey(x)){
	            map.put(x,1);//检查 map 中是否已经包含了键 x，如果没有，则调用 map.put(x, 1) 将该数字添加到 map 中，且初始化次数为 1。
	          }else{
	            map.put(x,map.get(x)+1);//如果 x 已经存在于 map 中，则通过 map.get(x) 获取该数字的当前计数，并加 1，更新其计数。
	          }
	        }
	        map.entrySet()//map.entrySet() 返回 Map 中所有键值对的集合。每个键值对是 Map.Entry 类型的对象。
	        .stream()//将 entrySet 转换为流（Stream），这允许使用流操作（如排序和遍历）
	        .sorted(Map.Entry.comparingByKey())//使用 Map.Entry.comparingByKey() 按照键（即数字 x）进行升序排序
	        .forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));//遍历排序后的结果,输出每个键（数字）及其对应的值（出现次数）
	        scan.close();
	    }
	}


}
