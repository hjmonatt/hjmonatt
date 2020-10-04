public class LinkedSongList implements SongList{
   
   // fields
   private SongListNode front;
   
   // methods
   // default constructor
   public LinkedSongList(){
      front = null;
      
   }
   // add() method that adds a new element to the back of the list
   public void add(Song song){
      if(front == null){
         front = new SongListNode(song, null);         // if list is empty(no nodes)
      
      }else{
         SongListNode current = front;            
         while(current.next != null){                  // traverse from the front to the back of the list
            current = current.next;                
                                                   
         }
         current.next = new SongListNode(song, null);  // and then put in a new node at the end of the list
      }
   }
   // add() method that adds a new node with data (song) before the specified position (index)
   public void add(int index, Song song){
      if(index == 0){                              // if the user is adding at the front of the list
         front = new SongListNode(song, front);    // change the front field
      
      }else{
         SongListNode current = front;
         for(int i = 0; i < index - 1; i++){
            current = current.next;
         
         }
         current.next = new SongListNode(song, current.next);
      }
   }
   // remove() method that removes the songListNode from the list
   public void remove(int index){
      if(index == 0){                           // if user is removing the node at the front
         front = front.next;
      
      }else{                              
         SongListNode current = front;          // if the user is removing a node somewhere in the middle
         for(int i = 0; i < index - 1; i++){
            current = current.next;
         
         }
         current.next = current.next.next;      // current is one node before the index
      }
   }
   // size() method - have to manually count up the nodes by traversing from the front to back
   // returns the number that has been counted
   public int size(){
      int count = 0;
      SongListNode current = front;
      while(current != null){                // traversing
         count++;                            // incrementing the count
         current = current.next;
      }
      return count;           
   
   }
   // get() method that takes in an index parameter and will return the song at that position (index)
   public Song get(int index){
      SongListNode current = front;
      for(int i = 0; i < index; i++){
         current = current.next;
      
      }
      return current.data;
   }
   // indexOf() method that takes a song parameter and returns the index
   // of where the song is located(first occurrence). Or method will return
   // -1 if the song is not found in the linkedlist
   public int indexOf(Song song){
      int index = 0;
      SongListNode current = front;
      while(current != null){
         if(current.data.equals(song)){
            return index;
         
         }
         index++;
         current = current.next;
        
      }
      return -1;
   }
   // Overriding the toString() method from class Object
   @Override
   public String toString(){
      if(front == null){
         return "[]";
      
      }else{
         String result = "[";
         
         result += front.data;
         
         SongListNode current = front.next;
         
         while(current != null){
            result += ", " + current.data;
            current = current.next;
         
         }
         result += "]";
         return result;
      }
   
   }
   public int totalDuration(){
      int sum = 0;
      SongListNode current = front;
      while(current != null){
         sum += current.data.getDuration();
         current = current.next;
      }
      return sum;
   
   }   
   
}