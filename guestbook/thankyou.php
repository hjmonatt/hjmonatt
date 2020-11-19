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

?>

<link rel="stylesheet" href="styles/thankyou.css">

<body>

<div class="container" id="main">

    <!-- Jumbotron header -->
    <div class="jumbotron jumbotron-fluid bg-primary-color">
        <h1 class="text-center display-4">Thank You for Signing Heather's Guestbook!</h1><br>
        <!-- <p class="text-center lead"><strong>Thank You for Signing Heather's Guestbook!</strong></p> -->
    </div>


<?php

$fname = $_POST['fname'];
$lname = $_POST['lname'];
$jobtitle = $_POST['jobtitle'];
$company = $_POST['company'];
$linkedIn = $_POST['linkedIn'];
$email = $_POST['email'];
$meet_how = $_POST['meet'];
$otherDescription = $_POST['other'];
$message = $_POST['message'];
$mailList = $_POST['mailingListCheck'];
$emailFormat = $_POST['mailListMethod'];



//Save entry to database
$sql = "INSERT INTO guestbook(firstName, lastName, jobTitle , company, linkedIn, email, meet_how, otherDescription, message, mailList, emailFormat) 
VALUES ('$fname', '$lname', '$jobtitle', '$company', '$linkedIn', '$email', '$meet_how', '$otherDescription', '$message', '$mailList', '$emailFormat')
         ";
$success = mysqli_query($cnxn, $sql);
if (!$success){
    echo"<p>Sorry...something went wrong.</p>";
    return;
}

?>
    </pre>
</div>
</body>
</html>
