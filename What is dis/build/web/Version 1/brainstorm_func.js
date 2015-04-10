function logincheck(){

 var email = document.getElementById('emaillogin').value;
 var password = document.getElementById('passwordlogin').value;
 
 console.log("Email: " + email);
 console.log("Password: " + password);
 
 if(email=="" || email.indexOf('@')!=email.lastIndexOf('@') || email.indexOf('@')==-1){
  alert("Please enter your account's email.");
 }
 else if(password==""){
  alert("Please enter your account's password.");
 }
 else if( (email!="" || email.indexOf('@')==email.lastIndexOf('@')) && password!="" ){
  alert("Welcome to BrainStorm!");
  window.location.href="Main Page.html";
 }
 
 /*
 Cannot click Log In button (loginpage.html), pls help - M
 */
}

function signupcheck(){
   var email = document.getElementById('emailsignup').value;
   var firstname= document.getElementById('firstname').value;
   var lastname = document.getElementById('lastname').value;
   var password1 = document.getElementById('passwordsignup').value;
   var password2 = document.getElementById('anotherpass').value;
   
   if(email=="" || email.indexOf('@')!=email.lastIndexOf('@') || email.indexOf('@')==-1){
   alert("Enter correct email.");
   }
   else if(password1!=password2){
   alert("Enter correct password twice.");
   }
   else if(password1=="" || password2==""){
   alert("Please enter password.")
   }
   else if(firstname==""){
   alert("Please enter your first name.");
   }
   else if(lastname==""){
   alert("Please enter your last name.");
   }
 else if( (email!="" || email.indexOf('@')==email.lastIndexOf('@') || email.indexOf('@')==-1) && (password1!="" || password1==password2 || password2!="") && firstname!="" && lastname!=""){
   alert("You are signed up for BrainStorm! Enjoy!");
   window.location.href="Main Page.html";
   }
}

function ideacheck(){
    var topictitle = document.getElementById('selected').value;
    var ideadesc = document.getElementById('ideadesc').value;
    
    if(topictitle=="new"){
        topictitle=document.getElementById('topictitle').value;
    }else if(ideadesc==""){
        alert("Please enter a suitable description.");
    }else if (topictitle!="" && ideadesc!=""){
        alert("New idea submitted! Good luck with it!");
        window.location.href.href="Main Page.html";
    }
}