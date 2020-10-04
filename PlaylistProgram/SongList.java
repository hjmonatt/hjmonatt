// Interface for a list of songs
public interface SongList{
   public void add(Song song);
   public void add(int index, Song song);
   public void remove(int index);
   public int size();
   public Song get(int index);
   public int indexOf(Song song);
   public String toString();
   public int totalDuration();

}