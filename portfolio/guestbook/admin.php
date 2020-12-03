<?php
/*
 * Heather Monatt
 * requests.php
 * Display requests for help
 */
ob_start();
// Turn on error reporting
ini_set('display_errors', 1);
error_reporting(E_ALL);

session_start();

// Includes
include('includes/head.html');
require('../../../dbcreds.php');


if (!isset($_SESSION['loggedin'])) {

//Store the page that I'm currently on in the session
//$_SESSION['admin'] = $_SERVER['SCRIPT_URI'];


//Redirect to login
    header("location: login-guest.php");
    ob_flush();

}


?>

<link rel="stylesheet" href="styles/admin.css">
    <br><br>
    <h1><strong>Heather's Guestbook Log</strong></h1><br>

</div>


<body>

<div class="container" id="main" style="overflow-x:auto;">
    <br>
    <h2><strong>Visitors</strong></h2>
    <br>
    <table id="guestbook-table" class="display">
        <thead>
        <tr>
            <td>VisitorID</td>
            <td>Name</td>
            <td>Job Title</td>
            <td>Company</td>
            <td>LinkedIn URL</td>
            <td>Email</td>
            <td>How We Met</td>
            <td>Message</td>
            <td>Mail List</td>
            <td>Email Format</td>
            <td>Visitation Date</td>
        </tr>
        </thead>
        <tbody>

        <?php
        $sql = "SELECT * FROM guestbook";
        $result = mysqli_query($cnxn, $sql);
        //var_dump($result);

        foreach($result as $row){
            //var_dump($row);
            $guest_id = $row['guest_id'];
            $fullname = $row['firstName'] . " " . $row['lastName'];
            $jobTitle = $row['jobTitle'];
            $company = $row['company'];
            $linkedIn = $row['linkedIn'];
            $email = $row['email'];
            $meet_how = $row['meet_how'] . " " . $row['otherDescription'];
            $message = $row['message'];
            $mailList = $row['mailList'];
            $emailFormat = $row['emailFormat'];
            $visitation_date = date("M d, Y g:i a", strtotime($row['datestamp']."- 3 hours"));

            echo"<tr>";
            echo"<td>$guest_id</td>";
            echo"<td>$fullname</td>";
            echo"<td>$jobTitle</td>";
            echo"<td>$company</td>";
            echo"<td>$linkedIn</td>";
            echo"<td>$email</td>";
            echo"<td>$meet_how</td>";
            echo"<td>$message</td>";
            echo"<td>$mailList</td>";
            echo"<td>$emailFormat</td>";
            echo"<td>$visitation_date</td>";
            echo"</tr>";

        }
        ?>
        </tbody>
    </table>
    <br>
</div>
<br><br>
<div class="container">
    <a href="http://hmonatt.greenriverdev.com/305/guestbook/guestbook.html" class="links"><p><strong>Guestbook Form</strong></p></a>
</div>
<br><br>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="scripts/guestbook.js"></script>
<script src="//cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script>
    $('#guestbook-table').DataTable({
        "order": [[ 0, "desc" ]]
    });
</script>

</body>
</html>

