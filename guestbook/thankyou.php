<?php
// Turn on error reporting
ini_set('display_errors', 1);
error_reporting(E_ALL);

//Redirect if form has not been submitted
if (empty($_POST)){
    header("location: guestbook.html");
}

// Include files
include('includes/head.html');
require('../../../dbcreds.php');
require('includes/guestbookFunctions.php');


?>

<link rel="stylesheet" href="styles/thankyou.css">

<body>

<div class="container" id="main">

    <!-- Jumbotron header -->
    <div class="jumbotron jumbotron-fluid bg-primary-color">
        <h1 class="text-center display-4">Thank You for Signing Heather's Guestbook!</h1><br>
        <!-- <p class="text-center lead"><strong>Thank You for Signing Heather's Guestbook!</strong></p> -->
    </div>

    <h2>Guestbook Entry Summary</h2>


<?php

//Data validation
$isValid = true;

// Check first name
if(validName($_POST['fname'])){
    $fname = $_POST['fname'];
}else {
    echo"<p>Please provide first name</p>";
    $isValid = false;
}

// Check last name
if(validName($_POST['lname'])){
    $lname = $_POST['lname'];
}else {
    echo"<p>Please provide last name</p>";
    $isValid = false;
}

// Check email
if(empty($email)){
    $email = $_POST['email'];
}elseif (!empty($email) && validEmail(preg_match('/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/', $_POST['email']))){
    $email = $_POST['email'];
}else{
    echo "<p>Invalid email format</p>";
    $isValid = false;
}

// Check other description
if(empty($otherDescription)){
    $otherDescription = $_POST['other'];
}elseif(isset($_POST['meet']))

// Check mail list
$email = "";
$mailList = "";
if(isset($_POST['mailingListCheck']) && validList($_POST['mailingListCheck'])) {
    $mailList = $_POST['mailingListCheck'];
    if (!empty($_POST['email'])) {
        $email = $_POST['email'];
    }
    if (empty($email) && isset($_POST['mailingListCheck']) && validList($_POST['mailingListCheck'])) {
        echo "<p>Please provide an email to be on the mailing list</p>";
        $isValid = false;
    }
}

// Check linkedIn
if(empty($linkedIn)){
    $linkedIn = $_POST['linkedIn'];
}elseif (!empty($linkedIn) && validLinkedIn(preg_match('/^(?:(?:https?|ftp):\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,}))\.?)(?::\d{2,5})?(?:[/?#]\S*)?$/i', $_POST['linkedIn']))){
    $linkedIn = $_POST['linkedIn'];
}else{
    echo "<p>Invalid URL format</p>";
    $isValid = false;
}

// Check how we met
if(validMeeting($_POST['meet'])){
    $meet_how = $_POST['meet'];
}else {
    echo"<p>Please select how we met</p>";
    $isValid = false;
}

// Check email method
$emailFormat = "";
if (isset($_POST['mailingListCheck']) AND validList($_POST['mailingListCheck']) AND validEmail($_POST['email']) AND validMailMethod($_POST['mailListMethod'])) {
    $emailFormat = $_POST['mailListMethod'];
    if(!validMailMethod($emailFormat)) {
        echo "<p>Please select HTML or Text</p>";
        $isValid = false;
    }
}

$fname = $_POST['fname'];
$lname = $_POST['lname'];
$jobtitle = $_POST['jobtitle'];
$company = $_POST['company'];
$linkedIn = $_POST['linkedIn'];
$email = $_POST['email'];
$meet_how = $_POST['meet'];
$otherDescription = $_POST['other'];
$message = $_POST['message'];
//$mailList = $_POST['mailingListCheck'];
//$emailFormat = $_POST['mailListMethod'];


//Prevent sql injection
$fname = mysqli_real_escape_string($cnxn, $fname);
$lname = mysqli_real_escape_string($cnxn, $lname);
$email = mysqli_real_escape_string($cnxn, $email);
$mailList = mysqli_real_escape_string($cnxn, $mailList);
$linkedIn = mysqli_real_escape_string($cnxn, $linkedIn);
$meet_how = mysqli_real_escape_string($cnxn, $meet_how);
$otherDescription = mysqli_real_escape_string($cnxn, $otherDescription);
//$emailFormat = mysqli_real_escape_string($cnxn, $emailFormat);


//Save entry to database
$sql = "INSERT INTO guestbook(firstName, lastName, jobTitle , company, linkedIn, email, meet_how, otherDescription, message, mailList, emailFormat) 
VALUES ('$fname', '$lname', '$jobtitle', '$company', '$linkedIn', '$email', '$meet_how', '$otherDescription', '$message', '$mailList', '$emailFormat')
         ";
$success = mysqli_query($cnxn, $sql);
echo $sql;
if (!$success){
    echo"<p>Sorry...something went wrong.</p>";
    return;
}

// PRINT DATA SUMMARY
echo "<p>Name: $fname $lname</p>";
echo "<p>Job Title: $jobtitle</p>";
echo "<p>Company: $company</p>";
echo "<p>LinkedIn URL: $linkedIn</p>";
echo "<p>Email: $email</p>";
echo "<p>How Did We Meet?: $meet_how</p>";
echo "<p>Other Description: $otherDescription</p>";
echo "<p>Message: $message</p>";
echo "<p>Mailing List: $mailList</p>";
echo "<p>Email Format: $emailFormat</p>";


//var_dump($_POST);

// shortcut
echo $success ? "<p>Your entry has been submitted.</p>" :
    "<p>Sorry...there was a problem.</p>"
?>


    </pre>
</div>
</body>
</html>
