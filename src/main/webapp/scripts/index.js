function sendLogin() {
	console.log("sendLogin started.");
	let loginForm = document.loginForm;
	let username = loginForm.username.value;
	let password = loginForm.password.value;
	let loginTemplate = {
			username: username,
			password: password,
	};
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			sessionStorage.setItem('currentUser', this.responseText);
			console.log("Got Green liight")
			window.location = "http://localhost:8080/project-1/home.main";
		}
		if(this.readyState === 4 && this.status === 204) {
			alert("Failed to login! Username or password is incorrect.");
		}
	};
	console.log("Running post method")
	xhr.open("POST", "http://localhost:8080/project-1/home.main"); 
	xhr.send(JSON.stringify(loginTemplate));
}
