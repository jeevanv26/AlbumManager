
public class Collection {

	private static final int NOT_FOUND = -1;
	private Album[] albums;
	private Album[] albumsR;
	private Album[] albumsG;
	private int numAlbums; // number of albums currently in the collection
	
	private int find(Album album) { // find the album index, or return NOT_FOUND
		for(int x=0; x<albums.length-1; x++) {
			if(albums[x].equals(album))
			return x;
		}
		return NOT_FOUND;
	}
	
	private void grow() {// increase the capacity of the array list by 4
		Album [] temp=albums;
		albums=new Album[albums.length+4];
		for(int x=0; x<temp.length-1; x++) {
			albums[x]=temp[x];
		}
	
	}
	
	public boolean add(Album album) {
		if(find(album)!=NOT_FOUND)
			return false;
		if(albums.length==numAlbums)
			grow();
		for(int x=0; x<albums.length; x++) {
			if(albums[x]==null)
				albums[x]=album;
		}
		numAlbums++;
		return true;
	}
	
	public boolean remove(Album album) {
		int index=find(album);
		if(index==NOT_FOUND)
			return false;
		for(int x=index; x<albums.length-2; x++) {
			albums[x]=albums[x+1];
		}
		albums[albums.length-1]=null;
		numAlbums--;
		return true;
	}
	
	public boolean lendingOut(Album album) { // set to not available
		album.changeAvailability();
		return true;
	}
	
	public boolean returnAlbum(Album album) { // set to available
		album.changeAvailability();
		return true;
	}
	
	public void print() { // display the list without specifying the order
		for (Album album:albums) {
			System.out.print(album.toString());
		}
	}
	
	public void printByReleaseDate() {
		
	
	}
	
	public void printByGenre() {
		
	}
	
	public void sortByReleaseDate() {
		
	}
	
	public void sortByGenre() {
		
	}
	
	public Album[] getCollection() {
		return albums;
	}
	
	public int getNumAlbums() {
		return numAlbums;
	}
	
}
