import java.util.NoSuchElementException;
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
			String token=st.nextToken();
			try {
			if(token.equals("A")) {
				Album a=new Album(st.nextToken(),st.nextToken(),(Genre)st.nextElement(),(Date)st.nextElement(),true);
				if(collection.add(a))
					System.out.println(a.toString()+" >> added.");//not complete
				else
					System.out.println(a.toString()+" >> is already in the collection.");//not complete
			}
			else if(token.equals("D")) {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.remove(a))
					System.out.println(a.toString()+" >> deleted"); //not complete
				else
					System.out.println(a.toString()+" >> is not in the collection."); //not complete
			}
			else if(token.equals("L")) {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.lendingOut(a))
					System.out.println(a.getTitle()+"::"+a.getTitle()+" >> lending out and set to not available");
				else
					System.out.println(a.getTitle()+"::"+a.getTitle()+" >> is not available");
			}
			else if(token.equals("R")) {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.returnAlbum(a))
					System.out.println(a.getTitle()+"::"+a.getTitle()+" >> returning and set available");
				else
					System.out.println(a.getTitle()+"::"+a.getTitle()+" >> return cannot be completed");
				
			}
			else if(token.equals("Q")) {
				System.out.println("Collection Manager terminated.");
				sc.close();
				isRunning=false;
			}
			else {
				System.out.println("Invalid Command!");
			}
			}
			catch(NoSuchElementException e) {
				System.out.println("Invalid Command!");
			}
			if(isRunning) {
				str = sc.nextLine();				//reads next line of input
				st = new StringTokenizer(str,",");	//resets string tokenizer
			}
		}
	}
}
