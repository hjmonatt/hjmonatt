import java.util.*;
/*
 * Heather Monatt
 * 11/27/2019
 * IT220 - Java2
 * AssassinManager.java
 *
 * This class manages a game of Assassin.  This program will ask the user for the names of each victim to kill until there is 
 * just one player left alive (at which point the game is over and the last remaining player wins).  AssassinMain calls methods of 
 * this class to carry out the tasks involved in administering the game.
 *
 */

public class AssassinManager 
{
   private AssassinNode frontKill;     // reference to the front node of the kill ring
   private AssassinNode frontGrave;    // reference to the front node of the graveyard (null if empty)

 
   // This constructor should initialize a new assassin manager over the given list of people.  
   public AssassinManager(List<String> names)
   {
      if(names == null || names.size() == 0)          // if list is null or empty, throw an IllegalArgumentException();
      {
         throw new IllegalArgumentException();            
      }
      for(int i = 0; i < names.size(); i++)              // construct new AssassinNodes by looping through the list of 
      {                                                  // names(Strings) and moving the current node
         String name = names.get(i);
         AssassinNode murderer = new AssassinNode(name);
         
         if(frontKill == null)
         {
            frontKill = murderer;
            
         }else
         {
            AssassinNode current = frontKill;
            while(current.next != null)
            {
               current = current.next;
            }
            current.next = murderer;
         }
      }
   
   }    
   
   // This method should print the names of the people in the kill ring, one per line, indented by four spaces, as "X is stalking Y".
   // If the game is over, then instead print X won the game!."
   public void printKillRing()
   {
      AssassinNode current = frontKill;                                
      while(current != null)
      {
         if(isGameOver())
         {
            System.out.println("\t" + current.name + " won the game!");
            
         }else if(current.next == null)
         {
            System.out.println("\t" + current.name + " is stalking " + frontKill.name);
           
         }else 
         {
             System.out.println("\t" + current.name + " is stalking " + current.next.name);
         }
         current = current.next;
      }
    
    
   }
   
  /* This method should print the names of the people in the graveyard, one per line, with each line indented by four spaces, with
   * output of the form "name was killed by name." It should print the names in the opposite of the order in which they were killed
   * (most recently killed first, then next more recently killed, and so on).  It should produce no output if the graveyard is empty.
   */ 
   public void printGraveyard()
   {
      AssassinNode current = frontGrave;                                // temp current
      while(current != null)
      {
         if(current.next == null)
         {
            System.out.println("\t" + current.name + " was killed by " + current.killer);
            
         }else
         {
            System.out.println("\t" + current.name + " was killed by " + current.killer);
         }
         current = current.next;
      }
      System.out.println();
         
   }
   
   // This method should return true if the given name is in the current kill ring and false otherwise.  It should ignore case in
   // comparing names; so, "salLY" should match a node with a name of "Sally".
   public boolean killRingContains(String name)         // LinkedList 1
   {
      AssassinNode current = frontKill;
      return contains(current, name);       // helper method
   }
   
   // This method should return true if the given name is in the current graveyard and false otherwise.  It should ignore case in
   // comparing names; so, "CaRoL" should match a node with a name of "Carol". 
   public boolean graveyardContains(String name)        // LinkedList 2
   {
      AssassinNode current = frontGrave;
      return contains(current, name);        // helper method
   }
   
   // This method should return true if the game is over (the kill ring has one person) and false otherwise. 
   public boolean isGameOver()
   {
      if(frontKill.next == null)
      {
         return true;
         
      }else
         return false;    
   }    
   
   // This method should return the name of the winner of the game, or null if the game is not over. 
   public String winner()
   {
      if(isGameOver())
      {  
         return frontKill.name;
         
      }else
      {
         return null;
      }
      
    }
   
   /* This method should record the assassination of the person with the given name, transferring 
    * the person from the kill ring to the front of the graveyard.  This operation should not change the relative
    * order of the kill ring (i.e. the links of who is killing whom should stay the same other than the person who
    * is being killed).  This method should ignore case in comparing names.  If the game is over, throw an IllegalStateException
    * or throw an IllegalArgumentEception of the given name is not part of the kill ring.  If both of these conditions are true 
    * the IllegalStateException takes precedence.
    */    
    public void kill(String name)
    {
      if(isGameOver())
      {
         throw new IllegalStateException("Game is over!");
      }
      if(!killRingContains(name))
      {
         throw new IllegalArgumentException("The name you entered is not part of the Kill Ring!");
         
      }else
      {
         AssassinNode purgatory = null;                           // temp node to store the victim
         
         if(frontKill.name.equalsIgnoreCase(name))                // remove the victim from the kill ring if at front of kill ring
         {
            String murderer = null;
            AssassinNode current = frontKill;
            while(current != null)
            {
               if(current.next == null)
               {
                  murderer = current.name;
               }
               current = current.next;
            }
            purgatory = frontKill;
            purgatory.killer = murderer;
            frontKill = frontKill.next;
         }else                                              // remove the victim from the kill ring if not at front of the kill ring
         {
            AssassinNode current = frontKill;
            while(current.next != null)
            {
               if(current.next.name.equalsIgnoreCase(name))
               {
                  String murderer = current.name;
                  purgatory = current.next;
                  purgatory.killer = murderer;
                  if(current.next.next != null)                // if there is someone after the victim in the list
                  {
                     current.next = current.next.next;
                     break;
                  }else                                        // if there is not someone after the victim in the list
                  {
                     current.next = null;
                     break;
                  }
               }
               current = current.next;
            }
         }
         if(frontGrave != null)                             // move the victim to the front of the graveyard
         {
            purgatory.next = frontGrave;
            
         }else
         {
            purgatory.next = null;
         }
         frontGrave = purgatory;
    
      }
      
    }
    
    // Helper Method                                                                 // limits code redundancy
    private boolean contains(AssassinNode current, String name)
    {
      while(current != null)
      {
         if(current.name.equalsIgnoreCase(name))
         {
            return true;
         }
         current = current.next;
      }
      return false;

    }  

    /***************** DO NOT MODIFY AssassinNode   **************************/
    /**
     * Each AssassinNode object represents a single node in a linked list
     * for a game of Assassin.
     */
    private static class AssassinNode 
    {
        public final String name;  // this person's name(data)
        public String killer;      // name of who killed this person (null if alive)
        public AssassinNode next;  // next node in the list (null if none)
        
        /**
         * Constructs a new node to store the given name and no next node.
         */
        public AssassinNode(String name) 
        {
            this(name, null);
        }

        /**
         * Constructs a new node to store the given name and a reference
         * to the given next node.
         */
        public AssassinNode(String name, AssassinNode next)
        {
            this.name = name;
            this.killer = null;
            this.next = next;
        }
    }
}
   


  
