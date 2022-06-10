



function cancelBooking() {
  history.go(-1);
}

document.getElementById("cancelButton").onclick = function() {
  var cancel = this;
  cancel.onclick = cancelBooking();
}

function showPsd()
{
	let x = document.getElementById("pswd");
    if (x.type === "password") {
    x.type = "text";
     }
	 else {
    x.type = "password";
  }
} 


function validate_password() {
 
            let pass = document.getElementById("psw").value;
            let confirm_pass = document.getElementById("psw-repeat").value;
            if (pass != confirm_pass || pass==="" || confirm_pass==="") {
                document.getElementById('wrong_pass_alert').style.color = 'red';
                document.getElementById('wrong_pass_alert').innerHTML
                  = "Enter valid password please";
                document.getElementById('create').disabled = true;
                document.getElementById('create').style.opacity = (0.4);
            } else {
                document.getElementById('wrong_pass_alert').style.color = 'green';
                document.getElementById('wrong_pass_alert').innerHTML =
                    "Password Matched";
                document.getElementById('create').disabled = false;
                document.getElementById('create').style.opacity = (1);
            }
        }
		
function passwordStrength() {
        
        let strongRegex = new RegExp("^(?=.{14,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
        let mediumRegex = new RegExp("^(?=.{10,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
        let enoughRegex = new RegExp("(?=.{8,}).*", "g");
        let pwd = document.getElementById("psw");
		
        if(pwd.value.length == 0) {
            document.getElementById("strength").innerHTML = "Type Password";
        } else if (false == enoughRegex.test(pwd.value)) {
            document.getElementById("strength").innerHTML = "Password too short!";
			document.getElementById("strength").style.color = '	#FFA50';
			
        } else if (strongRegex.test(pwd.value)) {
            document.getElementById("strength").innerHTML = "Strong!";
			document.getElementById("strength").style.color = "green";
        } else if (mediumRegex.test(pwd.value)) {
            document.getElementById("strength").innerHTML = "Medium!";
			document.getElementById("strength").style.color = "orange";
        } else {
            document.getElementById("strength").innerHTML = "Weak!";
			document.getElementById("strength").style.color = 'red';
        }
    }
	
	
function checkPassword() {
		passwordStrength();
        validate_password()

	}
		
		
function validEmail() {
	let email = document.getElementById("email");
	let emailRegex=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if(email.value.match(emailRegex)) {
		document.getElementById("email_format").innerHTML="Valid email"
		document.getElementById("email_format").style.color = "green";
		document.getElementById('create').disabled = flase;
		document.getElementById('create').style.opacity = (1);
	} else {
		document.getElementById("email_format").innerHTML="Invalid email";
		document.getElementById("email_format").style.color = "red";
		document.getElementById('create').disabled = true;
		document.getElementById('create').style.opacity = (0.4);
	}	
}
//Phone format
function phoneFormat() {
	let phoneNo= document.getElementById("phone").value;
	let phoneRegex = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	if(phoneRegex.test(phoneNo)) {
		document.getElementById("phone").style.color = "green";
		document.getElementById('create').disabled = false;
		document.getElementById('create').style.opacity = (1);
		
	} else {
		document.getElementById("phone").style.color = "red";
		document.getElementById('create').disabled = true;
		document.getElementById('create').style.opacity = (0.4);
		
	}
}

function cvvFormat() {
	let cvv = document.getElementById("cvv");
	let cvvLength = cvv.innerHTML.length;
	let format = /^[0-9]{0,3}$/;
	if((!cvv.value.match(format)) || (!cvvLength ===3 )) {
		document.getElementById("wrong_cvv").style.color = "red";
		document.getElementById("wrong_cvv").innerHTML="Invalid CVV";
		document.getElementById('check_out').disabled = true;
		document.getElementById('check_out').style.opacity = (0.4);
	}else {
		document.getElementById("wrong_cvv").innerHTML="";
		document.getElementById('check_out').disabled = false;
		document.getElementById('check_out').style.opacity = (1);
	}
}

function creditNum() {
	let masterRegex= /^5[1-5][0-9]{14}$|^2(?:2(?:2[1-9]|[3-9][0-9])|[3-6][0-9][0-9]|7(?:[01][0-9]|20))[0-9]{12}$/;
	let expressRegex = /^3[47][0-9]{13}$/;
	let visaRegex = /^4[0-9]{12}(?:[0-9]{3})?$/;
	let discoverRegex = /^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$/;
	let credit = document.getElementById("ccnum").value;
	
	if ((credit.match(masterRegex)) || (credit.match(expressRegex)) || (credit.match(visaRegex)) || (credit.match(discoverRegex))) {
		document.getElementById("invalid_card").innerHTML="";
		document.getElementById("ccnum").style.color="green";
		document.getElementById('check_out').disabled = false;
		document.getElementById('check_out').style.opacity = (1);
		
	}else{
		document.getElementById("invalid_card").innerHTML="Please enter a valid credit card number";
	    document.getElementById("invalid_card").style.color="red";
		document.getElementById('check_out').disabled = true;
		document.getElementById('check_out').style.opacity = (0.4);
	}
	
}

function pay(){
	
	      
           alert("Payment Complete! You will be redirected to Home Page");
           window.location.href = "home.jsp";
}
$(window).on("load resize ", function() {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({'padding-right':scrollWidth});
}).resize()
		
