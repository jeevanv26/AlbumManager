package manager;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Creates user interface for managing an album
 * by taking in various user commands which perform certain functions
 * @author Jeevan Vasanthan, Noah Young 
 */

public class CollectionManager {
	
	String str;
	StringTokenizer st;
	Collection collection;
	boolean isRunning;
	Scanner sc;
	
	/**
	 * runs the collection manager by taking input from the console
	 */
	public void run() {
		start();
		while(isRunning) {
			try {
				String token = st.nextToken();
				if(token.equals("A")) 
					add();
				else if(token.equals("D")) 
					delete();
				else if(token.equals("L")) 
					lend();
				else if(token.equals("R")) 
					rtn();
				else if(str.equals("P")) 
					printInNoOrder();
				else if(str.equals("PD")) 
					printOrderReleaseDates();
				else if(str.equals("PG")) 
					printOrderGenre();
				else if(token.equals("Q")) 
					quit();
				else 
					System.out.println("Invalid command!");
			}
			catch(NoSuchElementException e) {
				System.out.println("Invalid command!");
			}
			if(isRunning) {
				str = sc.nextLine();				
				st = new StringTokenizer(str,",");	
			}
		}
	}
	
	/**
	 * starts the collection manager
	 */
	public void start() {
		System.out.println("Collection Manager starts running.");
		 isRunning = true;
		 collection = new Collection();
		collection.initializeCollection();
		 sc = new Scanner(System.in);
		str = sc.nextLine();
		 st = new StringTokenizer(str,",");
	}
	
	/**
	 * add command in the collection manager
	 */
	public void add() {
		if(st.countTokens() > 4)
			System.out.println("Invalid command!");
		else {
		String title = st.nextToken();
		String artist = st.nextToken();
		String genre = st.nextToken();
		Genre g;
		if(genre.toUpperCase().equals("CLASSICAL"))
			g = Genre.Classical;
		else if(genre.toUpperCase().equals("COUNTRY"))
			g = Genre.Country;
		else if(genre.toUpperCase().equals("JAZZ"))
			g = Genre.Jazz;
		else if(genre.toUpperCase().equals("POP"))
			g = Genre.Pop;
		else
			g = Genre.Unknown;
		
		String dt = st.nextToken();
		Date date = new Date(dt);
		if(date.isValid() == false) {
			System.out.println("Invalid Date!");
		}
		else {
			Album a = new Album(title,artist,g,date,true);
			if(collection.add(a))
				System.out.println(a.toString()+" >> added.");
			else
				System.out.println(a.toString()+" >> is already in the collection.");
		}
		}
	}
	
	/**
	 * delete command in the collection manager
	 */
	public void delete() {
		if(st.countTokens() > 2)
			System.out.println("Invalid command!");
		else {
			Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
			if(collection.remove(a))
				System.out.println(a.getTitle()+"::"+a.getArtist()+" >> deleted."); 
			else
				System.out.println(a.getTitle()+"::"+a.getArtist()+" >> is not in the collection."); 
		}
	}
	
	/**
	 * lend command in the collection manager
	 */
	public void lend() {
		if(st.countTokens() > 2)
			System.out.println("Invalid command!");
		else {
			Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
			if(collection.lendingOut(a))
				System.out.println(a.getTitle()+"::"+a.getArtist()+" >> lending out and set to not available.");
			else
				System.out.println(a.getTitle()+"::"+a.getArtist()+" >> is not available.");
		}
	}
	/**
	 * return command in the collection manager
	 */
	public void rtn() {
		if(st.countTokens() > 2)
			System.out.println("Invalid command!");
		else {
			Album a=new Album(st.nextToken(), st.nextToken(), null, null,true);
			if(collection.returnAlbum(a))
				System.out.println(a.getTitle()+"::"+a.getArtist()+" >> returning and set to available.");
			else
				System.out.println(a.getTitle()+"::"+a.getArtist()+" >> return cannot be completed.");
		}
	}
	
	/**
	 * print in no order command in the collection manager
	 */
	public void printInNoOrder() {
		if(collection.returnNum() == 0)
			System.out.println("The collection is empty!");
		else {
			System.out.println("*List of albums in the collection.");
			collection.print();
			System.out.println("*End of list");
		}
	}
	/**
	 * print in order of release dates command in the collection manager
	 */
	public void printOrderReleaseDates() {
		if(collection.returnNum() == 0)
			System.out.println("The collection is empty!");
		else {
			System.out.println("*Album collection by the release dates.");
			collection.printByReleaseDate();
			System.out.println("*End of list");
		}
	}
	
	/**
	 * print in order of genres command in the collection manager
	 */
	public void printOrderGenre() {
		if(collection.returnNum() == 0)
			System.out.println("The collection is empty!");
		else {
			System.out.println("*Album collection by genre.");
			collection.printByGenre();
			System.out.println("*End of list");
		}
	}
	
	/**
	 * exit command in the collection manager
	 */
	public void quit() {
		System.out.println("Collection Manager terminated.");
		sc.close();
		isRunning=false;
	}
	
}
