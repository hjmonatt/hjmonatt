public class SongListNode{
   // fields
   public Song data;
   public SongListNode next;
   
   // methods
   // constructors
   public SongListNode(Song data, SongListNode next){
      this.data = data;
      this.next = next;
      
   }
   public SongListNode(Song data){
      this(data, null);
      
   }
   public SongListNode(){
      this(null, null);
      
   }



}