package datastructure;

public class Collections {
	/*Set集合：
	例题：去重
	给定 n 个数，要求把其中重复的去掉，只保留第一次出现的数。*/
		public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			for(int i=0;i<n;i++) {
				int m=scanner.nextInt();
				Set<Integer>set=new HashSet<Integer>();
				for(int j=0;j<m;j++) {
					int x=scanner.nextInt();
					if(set.contains(x)) {
						continue;
					}
					System.out.print(x+" ");
					set.add(x);
				}
				System.out.println();
			}
		}
	

	/*List动态数组：
	ArrsyList方法：
	add(); size();get(int index);返回列表中指定索引的值，从0开始*/

	/*Map散列表:
	常用方法：
	put(key,value);
	get(key) 返回key对应的value
	getOrdefault(key,value) 若找不到Key,则返回设置的默认值value
	例题：给出一串正整数数列以及一个正整数 C，要求计算出所有满足 A−B=C 的数对的个数（不同位置的数字一样的数对算不同的数对）。*/
		
		public static void main(String[] args) {
			Map<Integer, Integer>map=new HashMap<Integer, Integer>();
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int[] a=new int[n];
			int c=scanner.nextInt();
			for(int i=0;i<n;i++) {
				a[i]=scanner.nextInt();
				map.put(a[i],map.getOrDefault(a[i], 0)+1);//记录数组中每个数出现的次数
			}
			long res=0;
			for(int i=0;i<n;i++) {
				int b=a[i]-c;
				res+=map.getOrDefault(b, 0);
			}
			System.out.println(res);
		}
	}

