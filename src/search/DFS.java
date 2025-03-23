package search;
import java.util.*;
public class DFS {
	//例题1：全排列
		static List<List<Integer>> list =new ArrayList<>();
		public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int[] v=new int[n+1];
			List<Integer>t =new ArrayList<Integer>();
			dfs(n, v, t);
			for(int i=0;i<list.size();i++) {
				for(int j=0;j<list.get(i).size();j++) {
					System.out.print("    "+list.get(i).get(j));
				}
				System.out.println();
			}
		}
		public static void dfs(int n,int[] v,List<Integer>t) {
			if(t.size()==n) {
				list.add(new ArrayList<>(t));
				return;		
			}
			for (int i = 1; i <= n; i++) { // 尝试每一个数字
	        	if (v[i] == 1) continue; // 如果数字 i 已经被选过，跳过
	        	v[i] = 1; // 标记数字 i 已经被选中
	        	t.add(i); // 将数字 i 加入当前组合
	        	dfs(n, v, t); // 递归调用 dfs，继续构建下一个数字
	        	v[i] = 0; // 回溯，恢复数字 i 的状态为未选中
	        	t.remove(t.size() - 1); // 移除当前组合中的最后一个数字，准备进行下一个选择
		}

	}

	//例题2：图的搜索
		static boolean falg=false;
		static List<Integer>[] list;
		public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int m=scanner.nextInt();
			list=new List[n+1];
			for(int i=0;i<=n;i++) {
				list[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<m;i++) {
				int x=scanner.nextInt();
				int y=scanner.nextInt();
				list[x].add(y);
				list[y].add(x);
			}
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			falg=false;
			Set<Integer>set=new HashSet<Integer>();
			dfs(x, y, x, 0, set);
			if(!falg) {
				System.out.println(-1);
			}
			else {
				int ans=0;
				for(int i=1;i<=n;i++) {
					if(i==x||i==y||list[i].size()==0) continue;
					set=new HashSet<Integer>();
					set.add(x);
					falg=false;
					dfs(x, y, x, i, set);
					if(!falg) {
						ans++;
					}
					
				}
				System.out.println(ans);
			}
		}
		public static void dfs(int s,int t,int u,int i,Set<Integer>set) {
			if(u==t) {
				falg=true;
				return;
			}
			for(int x:list[u]) {
				if(set.contains(x)||x==i) {
					continue;
				}
				set.add(x);
				dfs(s, t, x, i, set);
			}
		}
	

	//例3：剪枝
		static int n,k,ans=0;
		public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			n=scanner.nextInt();
			k=scanner.nextInt();
			dfs(1, 0, 0);//从1开始遍历，避免重复
			System.out.println(ans);
			
		}
		public static void dfs(int last,int sum,int cnt) {
			if(cnt==k) {
				if(sum==n) {
					ans++;
				}
				return ;
			}
			for(int i=last;sum+i*(k-cnt)<=n//剪枝操作;i++) {
				dfs(i, sum+i, cnt+1);
			}
		}
	

