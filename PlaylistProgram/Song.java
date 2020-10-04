// defining a new type called Song
public class Song{

   // fields
   private String name;
   private String artist;
   private int duration;
   
   // methods
   // constructor method
   public Song(String name, String artist, int duration){
      this.name = name;
      this.artist = artist;
      this.duration = duration;
   
   }
   // getName() method that returns the name of the song
   public String getName(){
      return name;
   
   }
   // getArtist() method that returns the artist of the song
   public String getArtist(){
      return artist;
   
   }
   // getDuration() method that returns the duration of the song in seconds
   public int getDuration(){
      return duration;
      
   }
   // toString() method to print out the song in this format: (name, artist, duration)
   @Override
   public String toString(){
      return "(" + name + ", " + artist + ", " + duration + ")";
   
   }
   // equals() method to determine if two songs are the same, will return true if they
   // and false if they are not
   @Override 
   public boolean equals(Object o){
      if(o instanceof Song){
         Song other = (Song) o;
         return other.name.equals(name) && other.artist.equals(artist) && other.duration == duration; 
      }else{
            return false;
      }
   }
}

