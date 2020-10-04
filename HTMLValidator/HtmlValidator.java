import java.util.*;           // to use Queue and Stack

public class HtmlValidator{

   // fields:
   private Queue<HtmlTag> tagQueue;
   
   // methods:
   // Constructor - initializes validator to store an empty queue of HTML tags
   public HtmlValidator(){
      // create a new empty queue, store its address in tagQueue
      tagQueue = new LinkedList<HtmlTag>();
   
   }
   // Parameterized Constructor - initialize validator with a separate copy of the queue
   // passed in as a parameter.  It copies the contents of the tags using a loop.
   public HtmlValidator(Queue<HtmlTag> tags){
      
      // if the queue passed is null, throw an IllegalArgumentException, however an empty queue
      // (size 0) is allowed.
      if(tags == null){
         throw new IllegalArgumentException("Tags is null.");
      }
      // Step 1: create an empty queue
      tagQueue = new LinkedList<HtmlTag>();
      
      // Step 2: copy all HtmlTags from tags into tagQueue
      //          (copy everything from one queue into the other) 
      for(int i = 0; i < tags.size(); i++){
         HtmlTag temp = tags.remove();
         tagQueue.add(temp);
         tags.add(temp);
      }
   
   }
   // This method adds the given tag to the end of the validator's queue. If the tag passed is
   // null, it throws an IllegalArgumentException.
   public void addTag(HtmlTag tag){
      // if tag is null, throw illegalargumentexception
      // take tag and add it to the back of our queue
      if(tag == null){
         throw new IllegalArgumentException("Tag is null.");
      }else{
         tagQueue.add(tag);
      
      }
   
   
   }
   // This method returns the validator's queue of HTML tags.  The queue should contain tags that were passed
   // to the constructor in order and reflect ant changes that were made with addTag() or removeAll().
   public Queue<HtmlTag> getTags(){
      // return the queue of tags
      return tagQueue;
   
   
   }
   // This method removes any tags that match the given element from the validator's queue.
   public void removeAll(String element){
      // (use the contructor code as a possible example/model) (temp variable)
      // loop through the queue
      // as we peek or remove the front
      //    if it doeesn't match element, add it to the back of the queue
      //    if it does match element, don't add it to back of the queue
         // if the element passed is null, throw an IllegalArgumentException
         if(element == null){
            throw new IllegalArgumentException("Element is null.");
         }
         
         int originalSize = tagQueue.size();
         for(int i = 0; i < originalSize; i++){
            HtmlTag temp = tagQueue.remove();
            if(!temp.getElement().equals(element)){
               tagQueue.add(temp);
            }else{
            
            }
         }
      
   }    
   // this method displays each tag on its own line  Every opening tag
   // that requires a closing tag increases the indenation variable of following tags
   // until closing tag is reached
   // This method prints an indented text representation of the HTML tags in the queue
   public void validate(){
      // Step 1 - print every tag out without indentations
      // Step 2 - variable to keep track of indentations? <, >
      //          - how do you know when to move over and when to move back
      //          - when do you indent to the right and indent to the left
      // Use a stack with a queue to do the work
      
      // indentation count variable to keep track
      int indentation = 0;
      Stack<HtmlTag> tagStack = new Stack<HtmlTag>();
      HtmlTag current = null;
      for(int i = 0; i < tagQueue.size(); i++){
         current = tagQueue.remove();
         tagQueue.add(current);
         if(current.isSelfClosing()){     // if self closing tag
            indentSpaces(indentation);    // indent spaces indenation variable
            System.out.println(current);
         }else if(current.isOpenTag()){   // if open tag
            tagStack.push(current);
            indentSpaces(indentation);    // indent spaces indentation variable
            System.out.println(current);
            indentation++;                // increment indenation variable
         }else{
            if(!tagStack.isEmpty() && current.matches(tagStack.peek())){
               indentation--;                // decrement indenation variable
               indentSpaces(indentation);
               System.out.println(current);
               tagStack.pop();
            }else{
               System.out.println("ERROR unexpected tag: " + current);
            }
         }
      }
      while(!tagStack.isEmpty()){
         System.out.println("ERROR unclosed tag: " + tagStack.pop());
      }
   
    }
    // helper method that indents four spaces when needed
    private void indentSpaces(int numSpaces){
      for(int i = 0; i < numSpaces; i++){
         System.out.print("    ");
      }
    } 
   
}
    


