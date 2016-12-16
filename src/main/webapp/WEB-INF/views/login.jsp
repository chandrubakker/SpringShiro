<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>eSmartLabs - Login</title>
	</head>
	<body>
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Sign in to continue to
					eSmartLabs</h1>
				<div class="account-wall">
					<img class="profile-img"
						src="<c:url value="/resources/ui/assets/img/login.png" />"
						alt="login-pic">
					<form action="" method="post" name="loginform" class="form-signin">
						<input type="text" name="username" class="form-control" placeholder="Email"
							required autofocus> <input type="password" name="password"
							class="form-control" placeholder="Password" required>
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Sign in</button>
						<label class="checkbox pull-left"> <input type="checkbox" name="rememberMe"
							value="remember-me"> Remember me
						</label> <a href="#" class="pull-right need-help">Need help? </a><span
							class="clearfix"></span>
					</form>
				</div>
				<a href="#" class="text-center new-account">Create an account </a>
			</div>
		</div>
	</body>
</html>