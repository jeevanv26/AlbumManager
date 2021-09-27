package manager;
/**
 * Creates a collection object to keep track of all albums that a user contains
 * and help users manipulate their album  collection such as finding, adding, deleting , lending, and printing albums
 * @author Jeevan Vasanthan, Noah Young
 */

public class Collection {

	private static final int NOT_FOUND = -1;
	private Album[] albums; //collection 
	private int numAlbums; // number of albums currently in the collection
	
	/**
	 * finds the location of a particular album in a collection
	 * @param album album that is being found
	 * @return the index of a album in the albums array and -1 if it doesn't exist
	 */
	private int find(Album album) { 
		for(int x = 0; x < numAlbums; x++) {
			if(albums[x].equals(album))
			return x;
		}
		return NOT_FOUND;
	}
	
	/**
	 * increases the size of album collection  by four indexes
	 */
	private void grow() {
		Album [] temp = albums;
		albums = new Album[albums.length+4];
		for(int x = 0; x < temp.length; x++) {
			albums[x] = temp[x];
		}
	
	}
	
	/**
	 * adds a new album  to the collection of albums if it doesn't already exist, otherwise does nothing
	 * @param album album that is being added
	 * @return true if the album doesn't already exist in the collection and is added, false if the album already exists
	 */
	public boolean add(Album album) {
		if(find(album) != NOT_FOUND)
			return false;
		if(albums.length == numAlbums)
			grow();
		albums[numAlbums]=album;
		numAlbums++;
		return true;
	}
	
	/**
	 * removes an album from the collection of albums if it exists in the array, otherwise does nothing
	 * @param album album that is being removed
	 * @return true if the album was removed and false if it wasn't removed
	 */
	public boolean remove(Album album) {
		int index = find(album);
		if(index == NOT_FOUND)
			return false;
		for(int x = index; x < albums.length-1; x++) {
			albums[x] = albums[x+1];
		}
		albums[albums.length-1] = null;
		numAlbums--;
		return true;
	}
	
	/**
	 * lends an album to a friend from the collection, does nothing if the album doesn't exist or isn't available
	 * @param album album that is being lended
	 * @return true if the album was lended out and false if it wasn't
	 */
	public boolean lendingOut(Album album) { // set to not available
		if(find(album) == NOT_FOUND || albums[find(album)].getAvailability() == false)
			return false;
		albums[find(album)].changeAvailability();
		return true;
	}
	
	/**
	 * returns an album back  if the album was lended in the first place, does nothing if the album doesn't exist or wasn't lended
	 * @param album album that is being returned
	 * @return true if the book was returned and false if it wasn't
	 */
	public boolean returnAlbum(Album album) { // set to available
		if(find(album) == NOT_FOUND || albums[find(album)].getAvailability() == true)
			return false;
		albums[find(album)].changeAvailability();
		return true;
	}
	
	/**
	 * prints a list of albums in the album collection in no order.
	 */
	public void print() { // display the list without specifying the order
		for (int x = 0; x < numAlbums; x++) {
			System.out.println(albums[x].toString());
		}
	}
	
	/**
	 * prints a list of albums in the album collection in order of release dates
	 */
	public void printByReleaseDate() {
		sortByReleaseDate();
		print();
	
	}
	
	/**
	 * prints a list of albums in the album collection in order of genres
	 */
	public void printByGenre() {
		sortByGenre();
		print();
	}
	
	/**
	 * sorts the album collection in order of release dates
	 */
	public void sortByReleaseDate() {
		for(int x = 0; x < numAlbums; x++){
			int min = x;
			for(int y = x; y<numAlbums; y++) {
					if(albums[min].getReleaseDate().compareTo(albums[y].getReleaseDate()) == 1) 
						min = y;	
			}
			Album temp = albums[x];
			albums[x] = albums[min];
			albums[min] = temp;
		}
	}
	
	/**
	 * sorts the genre collection in order of genres
	 */
	public void sortByGenre() {
		for(int x = 0; x < numAlbums; x++){
			int min = x;
			for(int y = x; y < numAlbums; y++) {
					if(albums[min].getGenre().compareTo(albums[y].getGenre()) == 1) 
						min = y;	
			}
			Album temp = albums[x];
			albums[x] = albums[min];
			albums[min] = temp;
		
		}
	
	}
	
	/**
	 * initializes an album array
	 */
	public void initializeCollection() {
		albums = new Album[1];
	}
	
	/**
	 * getter method for number of albums in the collection
	 * @return number of albums in the collection
	 */
	public int returnNum() {
		return numAlbums;
	}
}
