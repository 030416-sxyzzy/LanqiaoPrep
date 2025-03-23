package datastructure;
/*问题描述：有一个n(n≤106)个节点的二叉树。给出每个节点的两个子节点编号（均不超过n），
建立一棵二叉树（根节点的编号为1），如果是叶子节点，则输入0 0。建好树这棵二叉树之后，依次求出它的前序、中序、后序列遍历。
输入 
7
2 7
4 0
0 0
0 3
0 0
0 5
6 0
输出 
1 2 4 3 7 6 5
4 3 2 1 6 5 7
3 4 2 5 6 7 1 
*/
public class BinaryTree {
	static class Node{
        int v,ls,rs;//节点值,左节点，右节点
        Node(int v,int ls,int rs){
            this.v=v;this.ls=ls;this.rs=rs;
        }//初始化
        
    }
    static final int N=100005;
    static Node[] t=new Node[N];//t存储所有节点的数组
    //前序遍历
    static void preorder(int p,StringJoiner joiner)//接收一个节点编号（p）和一个 StringJoiner 对象，用于构建遍历结果的字符串
    {
        if(p!=0){
            joiner.add(t[p].v+"");
            preorder(t[p].ls,joiner);
            preorder(t[p].rs,joiner);
        }
    }
    //中序遍历
    static void midorder(int p,StringJoiner joiner){
        if(p!=0){
            midorder(t[p].ls,joiner);
            joiner.add(t[p].v+"");          
            midorder(t[p].rs,joiner);
        }
    }
    //后序遍历
    static void postorder(int p,StringJoiner joiner){
        if(p!=0){
            postorder(t[p].ls,joiner);
            postorder(t[p].rs,joiner);
            joiner.add(t[p].v+"");  
        }
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            int a=scan.nextInt(),b=scan.nextInt();
            t[i]=new Node(i,a,b);
        }
        StringJoiner joiner=new StringJoiner(" ");
        preorder(1,joiner); 
        System.out.println(joiner);
        joiner=new StringJoiner(" ");
        midorder(1,joiner); 
        System.out.println(joiner);
        joiner=new StringJoiner(" ");
        postorder(1,joiner); 
        System.out.println(joiner);
    }
}
