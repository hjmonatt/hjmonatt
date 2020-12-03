<?php
// Validate name
function validName($name)
{
    return !empty($name); //&& ctype_alpha($name);
}

// Validate email
function validEmail($email)
{
    if(empty($email)){
        return false;
    }
    else{
        return true;
    }

}

//function validOther($otherDescription)
//{
    //if(empty($otherDescription)){
       // return false;
    //}
    //else{
        //return true;
    //}

//}

function validOther($otherDescription)
{
    if(isset($meet_how) == 'Other: ' AND (!empty($otherDescription))){
        return true;
    }
    else{
        return false;
    }

}


// Validate mailing list
function validList($mailList)
{
    if(isset($mailList) == 'yes'){
       return true;
    }
}

// Validate linkedIn
function validLinkedIn($linkedIn)
{
    if(empty($linkedIn)){
        return false;
    }
    else{
        return true;
    }

}

// Validate how we met
function validMeeting($meet_how){
    if($meet_how == 'Meetup' OR $meet_how == 'Job Fair' OR $meet_how == 'School' OR $meet_how == 'Work'
    OR $meet_how == 'Not Yet' OR $meet_how == 'Other:')
    {
        return true;
    }else{
        return false;
    }
}

// Validate email method
function validMailMethod($emailFormat)
{
    if(isset($emailFormat) == 'html' OR isset($emailFormat) == 'text'){
        return true;
    }
}



// Validate how we met
//function validMeeting($meet_how)
//{

//}


