let name = document.getElementById('Name')
let email = document.getElementById('Email')
let phone = document.getElementById('Phone')
let message = document.getElementById('Message')

function sendEmail() {
		
	fetch('/contact/',{
		method:'POST',
		headers: {
        	'Content-Type': 'application/json'
   		},
		body:JSON.stringify({
    		"name": name.value,
    		"email": email.value,
    		"phone": phone.value,
    		"message": message.value
		})
	})
	
	alert ("Email Enviado");
}