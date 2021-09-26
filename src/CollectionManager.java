import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
	
	public void run() {
		System.out.println("Collection Manager starts running.");
		boolean isRunning=true;
		Collection collection=new Collection();
		collection.initializeCollection();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str,",");
		while(isRunning) {
			try {
			String token=st.nextToken();
			if(token.equals("A")) {
				if(st.countTokens()>4)
					System.out.println("Invalid Command!");
				else {
				String title=st.nextToken();
				String artist=st.nextToken();
				String genre=st.nextToken();
				Genre g;
				if(genre.toUpperCase().equals("CLASSICAL"))
					g =Genre.Classical;
				else if(genre.toUpperCase().equals("COUNTRY"))
					g=Genre.Country;
				else if(genre.toUpperCase().equals("JAZZ"))
					g=Genre.Jazz;
				else if(genre.toUpperCase().equals("POP"))
					g=Genre.Pop;
				else
					g=Genre.Unknown;
				
				String dt=st.nextToken();
				Date date=new Date(dt);
				if(date.isValid()==false) {
					System.out.println("Invalid Date!");
				}
				else {
					Album a=new Album(title,artist,g,date,true);
					if(collection.add(a))
						System.out.println(a.toString()+" >> added.");
					else
						System.out.println(a.toString()+" >> is already in the collection.");
				}
				}
			}
			else if(token.equals("D")) {
				if(st.countTokens()>2)
					System.out.println("Invalid Command!");
				else {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.remove(a))
					System.out.println(a.getTitle()+"::"+a.getArtist()+" >> deleted"); 
				else
					System.out.println(a.getTitle()+"::"+a.getArtist()+" >> is not in the collection."); 
				}
			}
			else if(token.equals("L")) {
				if(st.countTokens()>2)
					System.out.println("Invalid Command!");
				else {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.lendingOut(a))
					System.out.println(a.getTitle()+"::"+a.getArtist()+" >> lending out and set to not available");
				else
					System.out.println(a.getTitle()+"::"+a.getArtist()+" >> is not available");
				}
			}
			else if(token.equals("R")) {
				if(st.countTokens()>2)
					System.out.println("Invalid Command!");
				else {
				Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
				if(collection.returnAlbum(a))
					System.out.println(a.getTitle()+"::"+a.getArtist()+" >> returning and set available");
				else
					System.out.println(a.getTitle()+"::"+a.getArtist()+" >> return cannot be completed");
				}
			}
			else if(str.equals("P")) {
				if(collection.returnNum()==0)
					System.out.println("The collection is empty!");
				else {
					System.out.println("*List of albums in the collection.");
					collection.print();
					System.out.println("*End of List");
				}
			}
			else if(str.equals("PD")) {
				if(collection.returnNum()==0)
					System.out.println("The collection is empty!");
				else {
					System.out.println("*Album collection by the release dates");
					collection.printByReleaseDate();
					System.out.println("*End of List");
				}
			}
			else if(str.equals("PG")) {
				if(collection.returnNum()==0)
					System.out.println("The collection is empty!");
				else {
					System.out.println("*Album collection by genre");
					collection.printByGenre();
					System.out.println("*End of List");
				}
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
