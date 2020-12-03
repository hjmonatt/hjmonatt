//let form = document.getElementById("guestbookform");
//form.onsubmit = validate;

/* Make all error messages invisible */
function clearErrors(){
    let errors = document.getElementsByClassName("text-danger");
    for(let i = 0; i<errors.length; i++){
        errors[i].classList.add("d-none");

    }

}

/* Validate the guest book form */
function validate() {

    clearErrors();

    //Create an error flag
    let isValid = true;

    //Validate first name
    let first = document.getElementById("fname").value;
    if (first == "") {
        let errFname = document.getElementById("err-fname");
        errFname.classList.remove("d-none");
        isValid = false; //Stay on the page
    }

    //Validate last name
    let last = document.getElementById("lname").value;
    if (last == "") {
        let errLname = document.getElementById("err-lname");
        errLname.classList.remove("d-none");
        isValid = false; //Stay on the page
    }

    //Validate email
    //Stack Overflow https://stackoverflow.com/questions/46841752/javascript-regular-expressions-email-address
    let email = document.forms["guestbookform"]["email"].value;
    let emailValidator = '/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/';

    if (email != "" && !email.match(emailValidator))
    {
        let errEmail = document.getElementById("err-email");
        errEmail.classList.remove("d-none");
        isValid = false;
    }

    //Validate how we met
    let meeting = document.getElementById("meet").value;
    if(meeting == "None"){
        let errMeet = document.getElementById("err-meet");
        errMeet.classList.remove("d-none");
        isValid = false;

    }

    //Validate checkbox
    let mailCheckbox = document.getElementById("mailingListCheck");
    if (mailCheckbox.checked && email == "") {
        let errMailList = document.getElementById("err-mailList");
        errMailList.classList.remove("d-none");
        isValid = false;
    }

    //Validate linkedIn
    //StackOverflow https://stackoverflow.com/questions/161738/what-is-the-best-regular-expression-to-check-if-a-string-is-a-valid-url
    let url = document.getElementById("linkedIn").value;
    let regExp2 = '/^(?:(?:https?|ftp):\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,}))\.?)(?::\d{2,5})?(?:[/?#]\S*)?$/i';
    if (url != "" && !regExp2.test(url)) {
        //alert("Url is valid");
        let errLinkedIn = document.getElementById("err-linkedIn");
        errLinkedIn.classList.remove("d-none");
        isValid = false;
    }

    return isValid;

}

