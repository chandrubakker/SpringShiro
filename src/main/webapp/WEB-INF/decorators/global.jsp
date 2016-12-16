<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="sitemesh-decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><sitemesh-decorator:title default="eSmartLabs" /></title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url  value='/resources/ui/bootstrap/css/bootstrap.min.css' />" />
	<link rel="stylesheet" href="<c:url  value='/resources/ui/bootstrap/font-awesome/css/font-awesome.css' />" />
	<link rel="stylesheet" href="<c:url  value='/resources/ui/assets/css/global.css' />" />
    <!-- Custom CSS -->
    <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }
    </style>
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/" /> ">eSmartLabs</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                    <li>
                        <a href="<c:url value="/login" /> ">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <sitemesh-decorator:body />

    </div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.1 -->
    <script src="<c:url value="/resources/ui/bootstrap/js/jquery.js" /> "></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url  value="/resources/ui/bootstrap/js/bootstrap.min.js" /> "></script>

</body>

</html>