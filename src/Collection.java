
public class Collection {

	private static final int NOT_FOUND = -1;
	private Album[] albums;
	private int numAlbums; // number of albums currently in the collection
	
	private int find(Album album) { // find the album index, or return NOT_FOUND
		for(int x = 0; x < numAlbums; x++) {
			if(albums[x].equals(album))
			return x;
		}
		return NOT_FOUND;
	}
	
	private void grow() {// increase the capacity of the array list by 4
		Album [] temp = albums;
		albums = new Album[albums.length+4];
		for(int x = 0; x < temp.length; x++) {
			albums[x] = temp[x];
		}
	
	}
	
	public boolean add(Album album) {
		if(find(album) != NOT_FOUND)
			return false;
		if(albums.length == numAlbums)
			grow();
		albums[numAlbums]=album;
		numAlbums++;
		return true;
	}
	
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
	
	public boolean lendingOut(Album album) { // set to not available
		if(find(album) == NOT_FOUND || albums[find(album)].getAvailability() == false)
			return false;
		albums[find(album)].changeAvailability();
		return true;
	}
	
	public boolean returnAlbum(Album album) { // set to available
		if(find(album) == NOT_FOUND || albums[find(album)].getAvailability() == true)
			return false;
		albums[find(album)].changeAvailability();
		return true;
	}
	
	public void print() { // display the list without specifying the order
		for (int x = 0; x < numAlbums; x++) {
			System.out.println(albums[x].toString());
		}
	}
	
	public void printByReleaseDate() {
		sortByReleaseDate();
		print();
	
	}
	
	public void printByGenre() {
		sortByGenre();
		print();
	}
	
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
	
	public void initializeCollection() {
		albums = new Album[1];
	}
	
	public int returnNum() {
		return numAlbums;
	}
}
