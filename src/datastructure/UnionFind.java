package datastructure;
import java.util.*;
/*（1）题目背景
若某个家族人员过于庞大，要判断两个是否是亲戚，确实还很不容易，现在给出某个亲戚关系图，求任意给出的两个人是否具有亲戚关系。
题目描述
规定：x 和 y 是亲戚，y 和 z 是亲戚，那么 x 和 z 也是亲戚。如果 x，y 是亲戚，那么 x 的亲戚都是 y 的亲戚，y 的亲戚也都是 x 的亲戚。
输入格式
第一行：三个整数 n,m,p，（n,m,p≤5000），分别表示有 n 个人，m 个亲戚关系，询问 p 对亲戚关系。
输入输出样例
输入 
6 5 3
1 2
1 5
3 4
5 2
1 3
1 4
2 3
5 6
输出 
Yes
Yes
No
*/
public class UnionFind {
	static int[] s;  //表示每个元素的父节点
    static int N=5010;
    public static void init_set(){  //初始化并查集，表示每个元素的父节点都初始化为它自身
        s=new int[N+1];
        for(int i=1;i<=N;i++){
            s[i]=i;
        }  
    }
    public static int find_set(int x){  //查找操作 如果 x 是根节点（即 s[x] == x），返回 x。
    	//如果 x 不是根节点，则递归地查找 s[x] 的父节点，并将其父节点直接指向根节点，从而加快查询速度
        return x==s[x]?x:find_set(s[x]);
    } 
    public static void merge_set(int x,int y){  //合并操作 如果x和y有关系，首先，通过 find_set(x) 和 find_set(y) 找到元素 x 和 y 的根节点。
//如果它们的根节点不同，说明 x 和 y 不在同一集合中，就需要将它们合并。合并时，任意选择一个根作为另一个根的父节点。在这里，选择将 y 作为 x 的父节点，即 s[x] = s[y];
        x=find_set(x);
        y=find_set(y);
        if(x!=y){
            s[x]=s[y];
        } 
    }
    public static void main(String[] args){  
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();
        init_set();
        while(m-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            merge_set(x,y);//合并
        }
        while(p-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(find_set(x)==find_set(y)){//查找
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
/*2）小猪存钱罐
题目解析：第 i 个存钱罐的钥匙在第 x 个存钱罐中，这一点的意思是，如果你想打开第 i 个存钱罐，
你需要找到并打开第 x 个存钱罐 ，那么就表示存钱罐 i 和存钱罐 x 是互相关联的，属于同一个集合。所以代码中需要将i和x合并。
写代码过程：创建数组->查找，合并方法->主函数（初始化独立集合->合并修改集合->查找统计集合数量)
*/
    static int[] s;
    public static int find(int x){
      if(s[x]!=x){
        s[x]=find(s[x]);
      }
      return s[x];
    }
    public static void union(int x,int y){
      x=find(x);
      y=find(y);
      if(x!=y){
        s[x]=s[y];
      }
    }
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int N=scan.nextInt();
        s=new int[N+1];
        for(int i=1;i<=N;i++){
          s[i]=i;
        }
        for(int i=1;i<=N;i++){
          int x=scan.nextInt();
          union(i,x);   
        }
        int ans=0;
        for(int i=1;i<=N;i++){
          if(find(i)==i){
            ans++;
          }
        }
        System.out.println(ans);
        scan.close();
    }


}
