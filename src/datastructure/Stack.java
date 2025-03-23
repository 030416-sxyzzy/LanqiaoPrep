package datastructure;
import java.util.*;
/*例题1
问题描述：假设一个表达式有英文字母（小写）、运算符（+、-、*、/）和左右小（圆）括号构成，以 @ 作为表达式的结束符。请编写一个程序检查表达式中的左右圆括号是否匹配，若匹配，则输出 YES；否则输出 NO。表达式长度小于255，左圆括号少于20个。
输入：一行，表达式。
输出：一行，YES或NO。
输入样例：2*(x+y)/(1-x)@
输出样例：YES*/

/*题解：合法的括号串例如“(())”、“()()()”。像“)(()”这样是非法的。合法括号组合的特点是：左括号先出现，右括号后出现；左括号和右括号一样多。括号组合的合法检查是栈的经典应用。用一个栈存储所有的左括号。遍历字符串的每一个字符，
处理流程是：
（1）若字符是 '('，进栈。
（2）若字符是')'，有两种情况：如果栈不空，说明有一个匹配的左括号，弹出这个左括号，然后继续读下一个字符；如果栈空了，说明没有与右括号匹配的左括号，字符串非法，输出NO，程序退出。
（3）读完所有字符后，如果栈为空，说明每个左括号有匹配的右括号，输出YES，否则输出NO。*/

public class Stack {
	public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Stack<Character> stack=new Stack<Character>();
        String s=scan.next();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='@')
                break;
            if(x=='(')
                stack.push(x);
            if(x==')'){
                if(stack.empty()){
                    System.out.println("NO");
                    return;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.empty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

}
/*例题2：日志分析
输入格式
包含 N+1 行：
第一行为一个正整数 N，对应于日志内所含操作的总数。
接下来的 N 行，分别属于以下三种格式之一：
格式 1：0 X，表示一次集装箱入库操作，正整数 X 表示该次入库的集装箱的重量。
格式 2：1，表示一次集装箱出库操作，（就当时而言）最后入库的集装箱出库。
格式 3：2，表示一次查询操作，要求分析程序输出当前仓库内最大集装箱的重量。
当仓库为空时你应该忽略出库操作，当仓库为空查询时你应该输出 0。
输出格式
输出行数等于日志中查询操作的次数。每行为一个整数，表示查询结果。*/
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int n=scanner.nextInt();
	Stack<Integer> stack = new Stack<>();
   		Stack<Integer> maxStack = new Stack<>();// 用于存储当前最大值的栈       
         for (int i = 0; i < n; i++) {
        int op = scanner.nextInt();
        
        if (op == 0) { // 入库操作
            int weight = scanner.nextInt();
            stack.push(weight);
            
            // 如果最大栈中为空或者压入栈的数比栈顶大，则压入栈，否则仍然将当前最大值（即 maxStack.peek()）压入 maxStack
            if (maxStack.isEmpty() || weight >= maxStack.peek()) {
                maxStack.push(weight);
            } else {
                maxStack.push(maxStack.peek());
            }
        } else if (op == 1) { // 出库操作
            if (!stack.isEmpty()) {
                stack.pop();
                maxStack.pop();
            }
        } else if (op == 2) { // 查询操作
            if (stack.isEmpty()) {
                System.out.println(0); // 如果仓库为空，输出 0
            } else {
                System.out.println(maxStack.peek()); // 输出当前最大值
            }
        }
    }


