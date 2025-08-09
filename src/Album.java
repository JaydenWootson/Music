import java.util.List;

public class Album {
    private int id;
    private List<String> artists;
    private String title;
    private int numSongs;

    public Album(int id, List<String> artists, String title, int numSongs) {
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    public int getNumSongs() {
        return numSongs;
    }

    @Override
    public String toString() {
        return id + ": " + numSongs + " -- " + artists;
    }

    public int compareTo(Album other){
        return Integer.compare(this.numSongs, other.numSongs);
    }
}
