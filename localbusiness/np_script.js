"use strict";

/*

   Filename: np_script.js

   Purpose: The purpose of this program is to simply report on a
            successful completition of a valid Web form.

            When the form is submitted, the onsubmit event handler
            verifies that the form data is complete and valid.
            An alert box is displayed notifying the user.

            The event function returns a value of false so that the
            student does not have to continually retype test values
            in the survey form.


*/

window.onload = setForm;

function setForm() {
   document.forms[0].onsubmit = function() {
      if (this.checkValidity()) alert("No invalid data detected. Will retain data for further testing.");
      return false;
   }
}

// JavaScript for daily specials

//var thisDate = new Date('October 12, 2018');

// Step 13 - test your code by changing the date in the thisDate variable from 10/13/2018 up to 10/19/2018. Verify that adifferent set of events is listed for each date when you refresh the page in your browser.
//var thisDate = new Date('October 13, 2018');
//var thisDate = new Date('October 14, 2018');
//var thisDate = new Date('October 15, 2018');
//var thisDate = new Date('October 16, 2018');
//var thisDate = new Date('October 17, 2018');
//var thisDate = new Date('October 18, 2018');


var thisDate = new Date();

// Step 6 - Declare the dateString variable containing the text of the thisDate variable using local conventions.
var dateString = thisDate.toLocaleDateString();

// Step 7 - Declare the dateHTML variable containing the following text string <h2>date</h2>
var dateHTML = "<h2>" + dateString + "<h2>";

// Step 8 - Create the thisDay variable containing the day of the week number from the thisDate variable
var thisDay = thisDate.getDay();

// Step 9 - Using the thisDay variable as a parameter value, call the getEvent() function to get the HTML code of that day's events and store that value in a variable named eventHTML
var eventHTML = getEvent(thisDay);

// Step 10 - A[[lying the insertAdjacentHTML() method to the page element with the ID unionToday, insert the value of the dateHTML plus the entHTML variables before the end of the element contents.
document.getElementById('spaToday').insertAdjacentHTML('beforeend', dateHTML + eventHTML);

function getEvent(day) {
   var eventHTML;
   switch (day) {
      case 0: // Sunday Events
      eventHTML = "<dl> \
         <dt>Sunday Funday in the Mud</dt> \
         <dd><p>Enjoy a mud bath spa treatment and see (and feel) the difference in your skin.</p> \
             <p><strong>Time:</strong> 90 minutes</p> \
             <p><strong>Cost:</strong> $120</p> \
         </dd> \
      </dl>";
      break;
      case 1: // Monday Events
      eventHTML = "<dl> \
         <dt>Monday Mud Mask</dt> \
         <dd><p>Missed our Mud Special on Sunday? Well here's your second chance!</p> \
             <p><strong>Time:</strong> 90 minutes</p> \
             <p><strong>Cost:</strong> $120</p> \
      </dl>";
      break;
      case 2: // Tuesday Events
      eventHTML = "<dl> \
         <dt>It's Tanning Tuesday!</dt> \
         <dd><p>No plans for Spring Break? No problem! Treat yourself to a spray tan and make it\ look like you just got back from the beach!</p> \
             <p><strong>1st Session:</strong> $50</p> \
             <p><strong>2nd Session:</strong> $50</p> \
         </dd> \
      </dl>";
      break;      
         case 3: // Wednesday Events
      eventHTML = "<dl> \
         <dt>Wrap Wednesday</dt> \
         <dd><p>Add any spa wrap to your treatment and receive a 20% discount off of your next\ treatment!</p> \
             <p><strong>Cost:</strong> $100</p> \
         </dd> \
      </dl>";
      break;
      case 4: // Thursday Events
      eventHTML = "<dl> \
         <dt>10% Thursdays!</dt> \
         <dd><p>It's almost the weekend, here's that extra break before payday!</p> \
             <p><strong>Cost:</strong> follow us and check-in on social media to receive your 10% discount.</p> \
         </dd> \
      </dl>";
      break;         
         case 5: // Friday Events
      eventHTML = "<dl> \
         <dt>Fresh'N Up Friday</dt> \
         <dd><p>Prepare for the weekend by pampering yourself on Friday, and enjoy a complimentary\
		 3oz bottle of one of our homemade vegan lotions.</p> \
             <p><strong>Cost:</strong> free after purchase of treatment</p> \
         </dd> \
      </dl>";
      break;
      case 6: // Saturday Events
      eventHTML = "<dl> \
         <dt>Spouse Saturdays</dt> \
         <dd><p>Enjoy an incredible spa treatment with your spouse.\
		 Couples who spa together, stay together!  We are now doing couples massages!</p>\
             <p><strong>Time:</strong> Only available for 60 minutes</p> \
             <p><strong>Cost:</strong> $200</p> \
         </dd> \
      </dl>";
      break;      
   }
   
   return eventHTML
}
