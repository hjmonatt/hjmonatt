public class ArraySongList implements SongList{
   
   // constant
   public static final int DEFAULT_CAPACITY = 100;
   
   // fields
   private Song[] elementData;                  
   private int size;
   
   // methods
   // default constructor
   public ArraySongList(){
      this(DEFAULT_CAPACITY);
   
   }
   // parameterized constructor - constructs a new arraylist,
   // but allows the user to tell the capacity.  If user enters a capacity less 
   // than zero, it will throw an IllegalArgumentException
   public ArraySongList(int capacity){
      if(capacity < 0){
         throw new IllegalArgumentException("Illegal Capacity: " + capacity);
      
      }
      elementData = new Song[capacity];
      size = 0;
   
   }
   // add() method that takes in a Song Object and adds the song at the back
   public void add(Song song){
      checkCapacity(size + 1);
      elementData[size] = song;
      size++;                                   // increments the size by 1
   
   }
   // add() method that takes in an index parameter and a Song Object and adds the new song
   // at the given position (index)
   public void add(int index, Song song){
      checkCapacity(size + 1);
      // add value at position index, sliding everything to the
      // right to make room, and shift everything over to the 
      // right to make room
      for(int i = size; i >= index + 1; i--){
         elementData[i] = elementData[i - 1];
      }
      // now that there is room at position index, put song there
      elementData[index] = song;
      size++;                                      // increments the size by 1
   
   
   }
   // remove() method that will take an index parameter and will remove
   // the song at that index and will shift everything over
   public void remove(int index){
      // shift everything over to the left
      for(int i = index; i < size - 1; i++){
         elementData[i] = elementData[i + 1];
      }
      // reduce the size count by 1
      size--;
   
   
   }
   // size() method that returns the number or "spots" that are being used
   public int size(){
      return size;
   
   }
   // get() method that returns the element at the specified index in the arraylist
   public Song get(int index){
      return elementData[index];
   
   }
   // indexOf() method that takes a song parameter and returns the index
   // of where the song is located(first occurrence).Or method will return
   // -1 if the song is not found in the arraylist
   public int indexOf(Song song){
      for(int i = 0; i < size; i++){
         if(elementData[i].equals(song)){
            return i;
         }
      }
      return -1;
   
   }
   // Overriding the toString() method from Song class
   @Override
   public String toString(){
      if(size == 0){
         return "[]";
      }else{
         String result = "[";
      
         // join in the value at position 0 first
         result += elementData[0];
         
         // loop through to print songs with commas between them
         for(int i = 1; i < size; i++){
            result += ", " + elementData[i];
         
         }
      
         result += "]";
         return result;
      }
   
   }
   public int totalDuration(){
      int sum = 0;
      for(int i = 0; i < size; i++){
         sum += elementData[i].getDuration();
      
      }
      return sum;
   
   }
   // helper method - checkCapacity() that checks the capacity of the list
   private void checkCapacity(int capacity){
      if(capacity > elementData.length){
         throw new IllegalStateException("Exceeds list capacity");
      
      }
      
   }
}