package string;
import java.util.*;
public class S1 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Character,Integer> map=new HashMap<>();
        String string=scan.next();
        for(char c:string.toCharArray()) {
        	map.put(c,map.getOrDefault(c, 0)+1);
        }
        char charmax=' ';
        int max=0;
        for(Map.Entry<Character, Integer> entry:map.entrySet()) {
        	char ch=entry.getKey();
        	int n=entry.getValue();
        	if((n>max)||(max==n&&ch<charmax)) {
        		max=n;
        		charmax=ch;
        	}
        }
        System.out.println(charmax);
        System.out.println(max);
        scan.close();
    }

}
