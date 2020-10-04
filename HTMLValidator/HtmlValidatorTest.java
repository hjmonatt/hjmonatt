// This testing program stub creates a queue of HTML tags 
// in a valid sequence.
// You may use this as a starting point for being a client of your
// HtmlValidator object
import java.util.*;

public class HtmlValidatorTest {
	public static void main(String[] args) {
		// <b>Hi</b><br/>
		// A Queue of tags you may modify and pass to your HtmlValidator object
		Queue<HtmlTag> tags = new LinkedList<HtmlTag>();
		tags.add(new HtmlTag("b", true)); // <b>
		tags.add(new HtmlTag("b", false)); // </b>
		tags.add(new HtmlTag("br")); // <br/>

		// Your code here
      HtmlTag t1 = new HtmlTag("h1", true);  // <h1>
      HtmlTag t2 = new HtmlTag("h1", false); // </h1>

      System.out.println(t1.getElement());
      System.out.println(t2.getElement());
      
      // Test1
      HtmlValidator test1 = new HtmlValidator();
      test1.addTag(new HtmlTag("h1", true));
      test1.addTag(new HtmlTag("h1", false));
      test1.addTag(new HtmlTag("p", true));
      test1.addTag(new HtmlTag("p", false));
      test1.addTag(new HtmlTag("br"));
      test1.addTag(new HtmlTag("p", true));
      test1.addTag(new HtmlTag("p", false));

      System.out.println(test1.getTags());
      
      test1.validate();
            
      test1.removeAll("p");
      
      System.out.println(test1.getTags());
      
      // Test2
      HtmlValidator test2 = new HtmlValidator();
      test2.addTag(new HtmlTag("html", true));
      test2.addTag(new HtmlTag("h1", true));
      test2.addTag(new HtmlTag("p", true));
      test2.addTag(new HtmlTag("p", false));
      test2.addTag(new HtmlTag("h1", false));
      test2.addTag(new HtmlTag("br"));
      test2.addTag(new HtmlTag("link"));
      test2.addTag(new HtmlTag("p", true));
      test2.addTag(new HtmlTag("img"));
      test2.addTag(new HtmlTag("p", false));
      test2.addTag(new HtmlTag("html", false));

      System.out.println(test2.getTags());
      
      test2.validate();
            
      test2.removeAll("html");
      test2.removeAll("br");
      test2.removeAll("link");
      
      System.out.println(test2.getTags());
      
      // Test3
      HtmlValidator test3 = new HtmlValidator();
      test3.addTag(new HtmlTag("!doctype"));
      test3.addTag(new HtmlTag("!-- --"));
      test3.addTag(new HtmlTag("html"));
      test3.addTag(new HtmlTag("head", true));
      test3.addTag(new HtmlTag("title", true));
      test3.addTag(new HtmlTag("meta"));
      test3.addTag(new HtmlTag("link"));
      test3.addTag(new HtmlTag("head", false));
      test3.addTag(new HtmlTag("head", false));
      test3.addTag(new HtmlTag("body", true));
      test3.addTag(new HtmlTag("p", true));
      test3.addTag(new HtmlTag("a", true));
      test3.addTag(new HtmlTag("a", false));
      test3.addTag(new HtmlTag("p", false));
      test3.addTag(new HtmlTag("p", true));
      test3.addTag(new HtmlTag("img"));
      test3.addTag(new HtmlTag("p", false));

      System.out.println(test3.getTags());
      
      test3.validate();
            
      test3.removeAll("p");
      test3.removeAll("head");
      test3.removeAll("img");
      
      System.out.println(test3.getTags());
      


   
	}
}