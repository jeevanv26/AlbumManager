package manager;
/**
 * Creates Album object that contains a title, artist, genre, release date, and availability status
 * @author Jeevan Vasanthan, Noah Young
 */


public class Album {
	private String title;
	private String artist;
	private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
	private Date releaseDate;
	private boolean isAvailable;
	
	/**
	 * constructor  that takes in several parameters in order to create an Album instance
	 * @param title title of the album
	 * @param artist artist of the album
	 * @param genre genre of the album
	 * @param releaseDate release date of the album
	 * @param isAvailable availability of the album
	 */
	public Album(String title,  String artist, Genre genre, Date releaseDate,boolean isAvailable) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.isAvailable = isAvailable;
	}
	
	/**
	 * checks if two albums are equal by overriding the Object superclass equals
	 * @param obj album that will be compared with
	 * @return true if the albums are equal and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		Album album = (Album)obj;
		if(this.title.equals(album.title) && this.artist.equals(album.artist))
			return true;
		else
			return false;
	}
	
	/**
	 * a string representation of an Album to be used in print statements
	 * @return a string
	 */
	@Override
	public String toString() {
		if(isAvailable == true)
			return title+"::"+artist+"::"+genre+"::"+releaseDate.toString()+"::is available";
		else
			return title+"::"+artist+"::"+genre+"::"+releaseDate.toString()+"::is not available";
	}
	
	/**
	 * changes the availability of a particular album in a collection
	 */
	public void changeAvailability() {
		if(isAvailable == true)
			isAvailable = false;
		else
			isAvailable = true;
	}
	
	/**
	 * getter method for album release date
	 * @return release date (Date) of an album
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}
	/**
	 * getter method for album title
	 * @return title (String) of an album
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * getter method for album artist
	 * @return artist (String) of an album
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * getter method for availability
	 * @return true if the album is available and false otherwise
	 */
	public boolean getAvailability() {
		return isAvailable;
	}
	/**
	 * getter method for genre
	 * @return returns the genre (Genre) of an album
	 */
	public Genre getGenre() {
		return genre;
	}
}

