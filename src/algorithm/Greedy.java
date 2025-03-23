package algorithm;
import java.util.*;
/*例题：填充 （3519）
	问题描述：有一个长度为n的01串s，其中有一些位置标记为 ? ，这些位置上可以任意填充0或者1。请问如何填充这些位置使得这个01串中出现互不重叠的00和11子串最多，输出子串个数。输入：输入一行包含一个字符串。输出：输出一行包含一个整数表示答案。

	题解：题目要求 00、11尽可能的多，所以目的是尽可能多配对。配对只在相邻s[i]和s[i+1]之间发生。从s[0]、s[1]开始，每次观察相邻的两个字符s[i]、s[i+1]，
	讨论以下情况：
	（1）s[i] = s[i+1]，这两个字符可能是“00”、“11”、“??”，都是配对。下一次观察s[i+2]、s[i+3]。
	（2）s[i]或s[i+1]有一个是‘?’，那么可以匹配。例如“1?”、“?1”、“0?”、“?0”，都是匹配的。下一次观察s[i+2]、s[i+3]。
	（3）s[i] =‘0’，s[i+1] =‘1’，不配对。下一次观察s[i+1]、s[i+2]。
	（4）s[i] =‘1’，s[i+1] =‘0’，不配对。下一次观察s[i+1]、s[i+2]。
	只需计算（1）、（2）即可。*/
public class Greedy {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        char[] arr=scan.next().toCharArray();
	        int sum=0;
	        for(int i=0;i<arr.length-1;){
	          if(arr[i]==arr[i+1]||arr[i]=='?'||arr[i+1]=='?'){
	            sum++;
	            i+=2;
	          }else{
	            i++;
	          }
	        }
	        System.out.println(sum);
	        scan.close();
	    }
	}

