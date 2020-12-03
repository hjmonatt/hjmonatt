<?php


//Connect to database
$database = "hmonattg_grc";
$username = "hmonattg_grcuser";
$password = "FeatherBear1!";
$hostname = "localhost";

$cnxn = @mysqli_connect($hostname, $username, $password, $database)
or die("There was a problem.");
//var_dump($cnxn);
