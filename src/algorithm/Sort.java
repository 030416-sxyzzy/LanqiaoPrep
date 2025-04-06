package algorithm;
import java.util.*;
public class Sort {
//二维数组排序
//	public static void main(String [] args) {
//		Scanner scanner=new Scanner(System.in);
//		Integer[][] a={{2,7,4},{8,4,6}};
//		Arrays.sort(a,(o1,o2)->o1[2]-o2[2]);//按照数组中的第三个数字的大小进行排序
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				System.out.print(a[i][j]+" ");	
//			}
//			System.out.println();
//		}
//	}
//集合排序
//	public static void main(String [] args) {
//		List<Integer>list=new ArrayList<Integer>();
//		list.add(4);
//		list.add(2);
//		list.add(7);
//		Collections.sort(list,(o1,o2)->o2-o1);
//		for(int i=0;i<list.size();i++) {
//			System.out.print(list.get(i)+" ");
//		}
//	}
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int[] a=new int[3];
		for(int i=0;i<3;i++) {
			a[i]=scanner.nextInt();
		}
		Arrays.sort(a);
		char[]c=scanner.next().toCharArray();
		for(int i=0;i<3;i++) {
			System.out.print(a[c[i]-'A']+" ");
		}
	}
}
