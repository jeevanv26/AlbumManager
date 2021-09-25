
enum Genre{
	Classical, Country, Jazz, Pop, Unknown
}

public class Album {
	private String title;
	private String artist;
	private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
	private Date releaseDate;
	private boolean isAvailable;
	
	public Album(String title,  String artist, Genre genre, Date releaseDate,boolean isAvailable) {
		this.title=title;
		this.artist=artist;
		this.genre=genre;
		this.releaseDate=releaseDate;
		this.isAvailable=isAvailable;
	}
	
	@Override
	public boolean equals(Object obj) {
		Album album=(Album)obj;
		if(this.title.equals(album.title)&& artist.equals(album.artist))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		if(isAvailable==true)
			return title+"::"+artist+"::"+genre+"::"+releaseDate+":: is available";
		else
			return title+"::"+artist+"::"+genre+"::"+releaseDate+":: is not available";
	}
	
	public void changeAvailability() {
		if(isAvailable==true)
			isAvailable=false;
		else
			isAvailable=true;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	public boolean getAvailability() {
		return isAvailable;
	}
	
}

