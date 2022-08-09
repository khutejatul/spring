<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	var check = function() {
		if (document.getElementById('passwordnew').value == document
				.getElementById('passwordnewconfirm').value) {
			document.getElementById('message').style.color = 'white';
			document.getElementById('message').innerHTML = 'matching';
			return true;
		} else {
			document.getElementById('message').style.color = 'red';
			document.getElementById('message').innerHTML = 'Password does not match';
			return false;
		}
	}
</script>
</head>
<body>
	<div class="container">
		<header>
			<div id="header" class="col-sm-12">
				<h2>Login</h2>
			</div>
			<br>
			<br>
		</header>

		<form action="Login" method="post">
			<div class="form-group">
				<label for="username">User name:</label> <input type="text"
					class="form-control" id="username" name="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" name="password">
			</div>
			<button style="float: right" type="button"
				class="btn btn-info a-btn-slide-text center" data-toggle="modal"
				data-target="#editModal">Forgotten your Password?</button>

			<button type="submit" class="btn btn-default right">Login</button>
		</form>
	</div>
	<%=request.getAttribute("error") %>
	
	 <% if (session.getAttribute("authorized") != null && session.getAttribute("authorized").equals("false"))
            { %>
            <p style="color: crimson; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif;">Invalid credentials </p>
            <% session.setAttribute("authorized", null);
            } %>

	<div class="modal fade" id="editModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Reset password</h4>
				</div>

				<div class="modal-body centre">
					<form action="ResetPassword" method="post"
						onsubmit="return check()">
						<input type="text" name="username" placeholder="Confirm Username"
							required> <br /> <input type="text" name="fullname"
							placeholder="Confirm Full Name" required> <br /> <input
							type="password" name="passwordnew" id="passwordnew"
							placeholder="New Password" onkeyup='check();' required> <br />
						<input type="password" name="passwordnewconfirm"
							id="passwordnewconfirm" placeholder="Confirm new password"
							onkeyup='check();' required> <br /> <input type="submit"
							value="Change Password">
						<hr />
						<span id='message'><%=session.getAttribute("message")%></span>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	 <% if(session.getAttribute("passwordmessage") != null)
            {%>
            <p style="color: blue; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif;">
            <%= session.getAttribute("passwordmessage") %></p>
            <% session.setAttribute("passwordmessage", null);
            }
        %>
</body>
</html>
