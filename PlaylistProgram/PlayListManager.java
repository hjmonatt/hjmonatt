public class PlayListManager{

   public static void main(String[] args){
      
      // PARTYLIST
      System.out.println("PARTYLIST");
      // Create playlist #1 using ArrayList
      SongList partyList = new ArraySongList();
      // Adding songs
      partyList.add(new Song("Beat It", "Michael Jackson", 1111));
      partyList.add(new Song("The Glamorous Life", "Sheila E.", 1050));
      partyList.add(new Song("Cool Off", "Missy Elliott", 2222));
      partyList.add(new Song("1999", "Prince", 1999));
      // Adding songs at specified indices
      partyList.add(4, new Song("Love Shack", "B-52s", 711));
      partyList.add(0, new Song("Jump Around", "House of Pain", 431));
      partyList.add(3, new Song("Hey Ya!", "OutKast", 603));
      
      // Duration BEFORE song removal
      System.out.println("Total duration of partyList in seconds BEFORE removing songs is: " + partyList.totalDuration() + " seconds.");
      int partyListLength = partyList.totalDuration();
      System.out.println("PartyList " + formatTime(partyListLength));
      // Size
      System.out.println("PartyList size BEFORE song removal is: " + partyList.size());
      System.out.println();
      
      // indexOf
      System.out.println("The index where Beat It by Michael Jackson is in partyList: " + partyList.indexOf(new Song("Beat It", "Michael Jackson", 1111)));
      System.out.println("The index where Tusk by Fleetwood Mac is in partyList: " + partyList.indexOf(new Song("Tusk", "Fleetwood Mac", 444)));
      
      //toString
      System.out.println(partyList.toString());
      System.out.println();
            
      // Get
      System.out.println("The song at index 2 of partyList BEFORE song removal is " + partyList.get(2));
      
      // Removing songs
      partyList.remove(0);
      partyList.remove(5);
      partyList.remove(2);      
      
      // Get
      System.out.println("The song at index 2 of partyList AFTER song removal is " + partyList.get(2));
      System.out.println();
      
      // Duration AFTER song removal            
      System.out.println("Total duration of partyList in seconds AFTER removing songs is: " + partyList.totalDuration() + " seconds.");
      partyListLength = partyList.totalDuration();
      System.out.println("PartyList " + formatTime(partyListLength));
      // Size
      System.out.println("PartyList size AFTER song removal is: " + partyList.size());
      System.out.println();
      
      // indexOf
      System.out.println("The index where Beat It by Michael Jackson is in partyList: " + partyList.indexOf(new Song("Beat It", "Michael Jackson", 1111)));
      
      //toString
      System.out.println(partyList.toString());
      System.out.println();
      
      // CODINGLIST
      System.out.println("CODINGLIST");
      // Create playlist #2 using LinkedList
      SongList codingList = new LinkedSongList();
      // Adding songs
      codingList.add(new Song("Tusk", "Fleetwood Mac", 444));
      codingList.add(new Song("Maneater", "Hall & Oates", 555));
      codingList.add(new Song("Hotel California", "Eagles", 222));
      codingList.add(new Song("Opposites Attract", "Paula Abdul", 888));
      codingList.add(new Song("December", "Collective Soul", 2150));
      // Adding songs at specified nodes
      codingList.add(3, new Song("Purple Rain", "Prince", 233));
      codingList.add(0, new Song("No Ordinary Love", "Sade", 255));
      codingList.add(7, new Song("Angel", "Jon Secada", 234));
      
      // Duration of playlist #2 BEFORE song removal
      System.out.println("Total duration of codingList in seconds BEFORE removing songs is: " + codingList.totalDuration() + " seconds.");
      int codingListLength = codingList.totalDuration();
      System.out.println("CodingList " + formatTime(codingListLength));
      // Size of playlist #2 BEFORE song removal
      System.out.println("CodingList size BEFORE song removal is: " + codingList.size());
      System.out.println();
      
      // indexOf
      System.out.println("The index where Purple Rain by Prince is in codingList: " + codingList.indexOf(new Song("Purple Rain", "Prince", 233)));
      System.out.println("The index where Beat It by Michael Jackson is in codingList: " + codingList.indexOf(new Song("Beat It", "Michael Jackson", 1111)));

      //toString
      System.out.println(codingList.toString());
      System.out.println();
      
      // Get
      System.out.println("The song at index 3 of codingList BEFORE song removal is " + codingList.get(3));
      
      // Remove songs
      codingList.remove(7);
      codingList.remove(3);
      codingList.remove(0);
      
      // Get
      System.out.println("The song at index 3 of codingList AFTER song removal is " + codingList.get(3));
      System.out.println();
      
      // Duration of playlist #2 AFTER song removal
      System.out.println("Total duration of codingList in seconds AFTER removing songs is: " + codingList.totalDuration() + " seconds.");
      codingListLength = codingList.totalDuration();
      System.out.println("CodingList " + formatTime(codingListLength));
      // Size of playlist #2 AFTER song removal
      System.out.println("CodingList size AFTER song removal is: " + codingList.size());
      System.out.println();
      
      // indexOf
      System.out.println("The index where Purple Rain by Prince is in codingList: " + codingList.indexOf(new Song("Purple Rain", "Prince", 233)));
      
      // toString 
      System.out.println(codingList.toString());
      System.out.println();
      
      // CHILLAXLIST
      System.out.println("CHILLAXLIST");
      // Create playlist #3 using ArrayList
      SongList chillaxList = new ArraySongList();
      // Adding songs
      chillaxList.add(new Song("Vision Of Love", "Mariah Carey", 253));
      chillaxList.add(new Song("La Isla Bonita", "Madonna", 999));
      chillaxList.add(new Song("I Want To Know What Love Is", "Foreigner", 2422));
      chillaxList.add(new Song("Just Another Day", "Jon Secada", 158));
      chillaxList.add(new Song("Broken Wings", "Mr. Mister", 2455));
      chillaxList.add(new Song("Be With You", "Enrique Iglesias", 1344));
      // Adding songs at specified indices
      chillaxList.add(6, new Song("If You Go", "Jon Secada", 154));
      chillaxList.add(0, new Song("Live To Tell", "Madonna", 241));
      chillaxList.add(3, new Song("Rush Rush", "Paula Abdul", 250));
      
      // Duration BEFORE song removal
      System.out.println("Total duration of chillaxList in seconds BEFORE removing songs is: " + chillaxList.totalDuration() + " seconds.");
      int chillaxListLength = chillaxList.totalDuration();
      System.out.println("ChillaxList " + formatTime(chillaxListLength));
      // Size of playlist #3 BEFORE song removal
      System.out.println("ChillaxList size BEFORE song removal is: " + chillaxList.size());
      System.out.println();
      
      // indexOf
      System.out.println("The index where Just Another Day by Jon Secada is in chillaxList: " + chillaxList.indexOf(new Song("Just Another Day", "Jon Secada", 158)));
      System.out.println("The index where Just Another Day by John Secada is in chillaxList: " + chillaxList.indexOf(new Song("Just Another Day", "John Secada", 158)));
      
       //toString
      System.out.println(chillaxList.toString());
      System.out.println();
      
      // Get
      System.out.println("The song at index 4 of chillaxList BEFORE song removal is " + chillaxList.get(4));
      
      // Removing songs
      chillaxList.remove(4);
      chillaxList.remove(7);
      chillaxList.remove(0);
      
      // Get
      System.out.println("The song at index 4 of chillaxList AFTER song removal is " + chillaxList.get(4));
      System.out.println();
      
      // Duration AFTER song removal
      System.out.println("Total duration of chillaxList in seconds AFTER removing songs is: " + chillaxList.totalDuration() + " seconds.");
      chillaxListLength = chillaxList.totalDuration();
      System.out.println("ChillaxList " + formatTime(chillaxListLength));
      // Size of playlist #3 AFTER song removal
      System.out.println("ChillaxList size AFTER song removal is: " + chillaxList.size());
      System.out.println();
      
      // indexOf
      System.out.println("The index where Just Another Day by Jon Secada is in chillaxList: " + chillaxList.indexOf(new Song("Just Another Day", "Jon Secada", 158)));
      
      //toString
      System.out.println(chillaxList.toString());
      System.out.println();
      
      // EMPTYLIST
      System.out.println("EMPTYLIST");
      // Create an empty list to test total duration      
      SongList emptyList = new LinkedSongList();
      System.out.println("Total duration of emptyList in seconds is: " + emptyList.totalDuration() + " seconds.");
      // Size of playlist #4
      System.out.println("EmptyList size is: " + emptyList.size());
      // toString
      System.out.println(emptyList.toString());
                  
      }
      // helper method to format the total seconds into hours, minutes and seconds
      public static String formatTime(int totalSeconds){
       
         int hours = totalSeconds/3600;
         int minutes = (totalSeconds % 3600) / 60;
         int seconds = totalSeconds % 60;
         
         return "formated total duration is: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds."; 
         
      }
      
   }



