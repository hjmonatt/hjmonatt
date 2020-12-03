<?php
/**
 *  305/guestbook/login-guest.php
 *  Heather Monatt
 *  11/28/2020
 *  Login form for personal portfolio project
 */

//Turn on error reporting -- this is critical!
ini_set('display_errors', 1);
error_reporting(E_ALL);

//Start session
session_start();

//var_dump($_POST);

//Initialize variables
$err = false;
$username = "";

//If the form has been submitted
if($_SERVER['REQUEST_METHOD'] == 'POST') {
    //echo "Form has been submitted";

    //Get the username and password
    $username = strtolower(trim($_POST['username']));
    $password = trim($_POST['password']);

    //If they are correct
    //Actual username and password are stored in a separate file
    //Should be moved to home directory ABOVE public_html
    require ('login-guest-creds.php');

    if ($username == $adminUser && $password == $adminPassword) {

        $_SESSION['loggedin'] = true;

        //Redirect to page the user was on
        header("location: admin.php");

    }

    //Set an error flag
    $err = true;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/guestbook.css">
    <style>
        .err {
            color: darkred;
        }
    </style>
</head>
<body>
<div class="container">

    <br>
    <h1>Guestbook Login Page</h1>
    <br>
    <form action="#" method="post">
        <div class="form-group">
            <label for="username"><strong>Username</strong></label>
            <input type="text" class="form-control" id="username" name="username"
                <?php echo "value='$username' " ?>
            >
        </div>
        <div class="form-group">
            <label for="password"><strong>Password</strong></label>
            <input type="password" class="form-control" id="password" name="password" >
        </div>

        <?php
        if ($err) {
            echo '<span class="err"><strong>Incorrect login</strong></span><br>';
        }
        ?>

        <br>
        <button type="submit" class="btn btn-dark btn-lg"><strong><h4>Login</h4></strong></button>
        <!--<button type="submit" class="links"><p><strong>Login</strong></p></button>-->
        <!--<a href="http://hmonatt.greenriverdev.com/305/guestbook/admin.php" role="button" type="submit" class="links"><p><strong>Login</strong></p></a>-->
   </form>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>