package datastructure;
import java.util.*;
/*（1）约瑟夫环问题（1893）
问题描述：约瑟夫环问题，即出列游戏：n个人围成一圈，从第一个人开始报数，数到m的人出列，再由下一个人重新从1开始报数，数到m的人再出列，依次类推，直到所有的人都出列，请依次输出出列的人的编号。输入描述：输入两个整数 n,m（1≤m,n≤100）。输出描述：输出一行n个整数，按顺序输出每个出列的人的编号。
输入样例：10 3
输出样例：3 6 9 2 7 1 8 5 10 4*/
public class queue {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
          queue.offer(i);
        }
        while(!queue.isEmpty()){
          for(int i=1;i<m;i++){
            queue.offer(queue.peek());//读取对头元素，并将其添加到队尾
            queue.poll();//移除对头元素
          }
          System.out.print(queue.peek()+" ");//打印当前对头元素，即第m个人
          queue.poll();//移除第m个人
        }
        
        scan.close();
    }

/*（2）机器翻译（511）
内存大小 M = 3
待翻译的文章有 6 个单词，例如：["apple", "banana", "apple", "grape", "banana", "pear"]
初始化：内存为空。
翻译过程：
"apple"：不在内存中，去外存查找，并放入内存 → 内存：["apple"]，查找次数：1
"banana"：不在内存中，去外存查找，并放入内存 → 内存：["apple", "banana"]，查找次数：2
"apple"：已在内存中，不需要查找 → 内存：["apple", "banana"]，查找次数：2
"grape"：不在内存中，去外存查找，并放入内存 → 内存：["banana", "apple", "grape"]，查找次数：3
"banana"：已在内存中，不需要查找 → 内存：["banana", "apple", "grape"]，查找次数：3
"pear"：不在内存中，去外存查找，并放入内存。由于内存已满，删除最早的单词 "apple"，将 "pear" 放入内存 → 内存：["pear", "banana", "grape"]，查找次数：4
最终，翻译过程中去外存查找词典的次数为 4。求查询次数*/
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int m=scan.nextInt();
	    int n=scan.nextInt();
	    int x,ans=0;
	    Queue<Integer> q=new LinkedList();
	    for(int i=0;i<n;i++){
	      x=scan.nextInt();
	      if(!q.contains(x)){
	        ans++;
	        if(q.size()>=m){
	          q.poll();
	        }
	        q.offer(x);
	      }
	    }
	    System.out.println(ans);
	    scan.close();
	}
}