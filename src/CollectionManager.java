import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
	
	public void run() {
		System.out.println("Collection Manager starts running.");
		boolean isRunning=true;
		Collection collection=new Collection();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str,",");
		while(isRunning) {
			if(st.nextToken()=="A") {
				Album a=new Album(st.nextToken(),st.nextToken(),(Genre)st.nextElement(),(Date)st.nextElement(),true);
				if(collection.add(a))
					System.out.println(a.toString());//not complete
				else
					System.out.println(a.toString());//not complete
			}
			else if(st.nextToken()=="D") {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.remove(a))
					System.out.println(a.toString()); //not complete
				else
					System.out.println(a.toString()); //not complete
			}
			else if(st.nextToken()=="L") {
				
			}
			else if(st.nextToken()=="R") {
				
			}
			else if(st.nextToken()=="Q") {
				System.out.println("Collection Manager terminated.");
				sc.close();
				isRunning=false;
			}
			else {
				System.out.println("Collection Manager terminated.");
			}
			if(isRunning) {
				str = sc.nextLine();				//reads next line of input
				st = new StringTokenizer(str,",");	//resets string tokenizer
			}
		}
	}
}
