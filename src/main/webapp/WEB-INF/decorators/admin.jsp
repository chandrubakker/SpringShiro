<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="sitemesh-decorator"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>	
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
	
    <!-- Custom CSS -->
    <%-- <link rel="stylesheet" href="<c:url  value='/resources/ui/assets/css/global.css' />" /> --%>
    
    <!-- IonIcons -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/ui/admin/dist/css/ionicons.min.css"/>">

	<!-- Theme style -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/ui/admin/dist/css/AdminLTE.min.css"/>">

	<!-- Skin style -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/ui/admin/dist/css/skins/skin-blue.min.css"/>">

	<!-- DataTables -->
	<link rel="stylesheet" href="<c:url value="/resources/ui/plugins/datatables/dataTables.bootstrap.css" />">

	<!-- Custom Styles -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/ui/admin/css/style.css"/>">
    <!-- <style>
	    body {
	        padding-top: 70px;
	        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
	    }
    </style> -->
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Main Header -->
		<header class="main-header">
		
			<!-- Logo -->
			<a href="<c:url value="/" />" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>E</b>SL</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Admin</b>ESL</span>
			</a>
		
			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
								class="label label-success">4</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 4 messages</li>
								<li>
									<!-- inner menu: contains the messages -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<!-- User Image -->
													<img
														src="<c:url value="/resources/ui/admin/dist/img/avatar5.png" />"
														class="img-circle" alt="User Image">
												</div> <!-- Message title and timestamp -->
												<h4>
													Support Team <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4> <!-- The message -->
												<p>Why not buy a new awesome theme?</p>
										</a>
										</li>
										<!-- end message -->
									</ul> <!-- /.menu -->
								</li>
								<li class="footer"><a href="#">See All Messages</a></li>
							</ul>
						</li>
						<!-- /.messages-menu -->
		
						<!-- Notifications Menu -->
						<li class="dropdown notifications-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
								class="label label-warning">10</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 10 notifications</li>
								<li>
									<!-- Inner Menu: contains the notifications -->
									<ul class="menu">
										<li>
											<!-- start notification --> <a href="#"> <i
												class="fa fa-users text-aqua"></i> 5 new members joined today
										</a>
										</li>
										<!-- end notification -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul>
						</li>
						<!-- Tasks Menu -->
						<li class="dropdown tasks-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-flag-o"></i> <span
								class="label label-danger">9</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 9 tasks</li>
								<li>
									<!-- Inner menu: contains the tasks -->
									<ul class="menu">
										<li>
											<!-- Task item --> <a href="#"> <!-- Task title and progress text -->
												<h3>
													Design some buttons <small class="pull-right">20%</small>
												</h3> <!-- The progress bar -->
												<div class="progress xs">
													<!-- Change the css width attribute to simulate progress -->
													<div class="progress-bar progress-bar-aqua"
														style="width: 20%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">20% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all tasks</a></li>
							</ul>
						</li>
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar--> <img
								src="<c:url value="/resources/ui/admin/dist/img/avatar5.png" />"
								class="user-image" alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">
									<shiro:authenticated>
										<shiro:principal type="com.sorcererpaws.SpringShiro.entity.User" property="name" />
									</shiro:authenticated>
								</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img
									src="<c:url value="/resources/ui/admin/dist/img/avatar5.png" />"
									class="img-circle" alt="User Image">
		
									<p>
										<shiro:authenticated>
											<shiro:principal type="com.sorcererpaws.SpringShiro.entity.User" property="name" />
										</shiro:authenticated> - Web Developer <small>Member since
											Nov. 2012</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="<c:url value="/logout" />" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
		
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
		
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="<c:url value="/resources/ui/admin/dist/img/avatar5.png" />" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>
							<shiro:authenticated>
								<shiro:principal type="com.sorcererpaws.SpringShiro.entity.User" property="name" />
							</shiro:authenticated>
						</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
		
				<!-- search form (Optional) -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
		
				<!-- Sidebar Menu -->
				<ul class="sidebar-menu">
					<li class="header">HEADER</li>
					<!-- Optionally, you can add icons to the links -->
					<c:set value="" var="dashboardURL" />
					<shiro:hasRole name="admin">
						<c:set value="/admin/dashboard" var="dashboardURL"></c:set>
					</shiro:hasRole>
					<shiro:hasRole name="lab">
						<c:set value="/lab/dashboard" var="dashboardURL"></c:set>
					</shiro:hasRole>
					<li class="active"><a href="<c:url value="${dashboardURL}" />">
						<i class="fa fa-tachometer" aria-hidden="true"></i> <span>Dashboard</span></a>
					</li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>
		<sitemesh-decorator:body />
		
		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div class="pull-right hidden-xs">Anything you want</div>
			<!-- Default to the left -->
			<strong>Copyright &copy; 2016 <a href="<c:url value="/" />">Sorcerer Paws</a>.
			</strong> All rights reserved.
		</footer>
		
		<!-- Add the sidebar's background. This div must be placed
		       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
		
		<!-- Delete confirm dialog -->
		<div class="modal fade" id="deleteConfirm" tabindex="-1" role="dialog"
			data-keyboard="false"
			data-backdrop="static">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title text-center">Warning</h4>
					</div>
					<div class="modal-body text-center">
						<p class="deleteMsg"></p>
						<h3 class="delName"></h3>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning btn-sm deleteTarget">Delete</a>
						<a href="#" class="btn btn-default btn-sm cancelBtn" data-dismiss="modal">Cancel</a>
					</div>
				</div>
			</div>
		</div>
	</div>
    <!-- jQuery Version 1.11.1 -->
    <script src="<c:url value="/resources/ui/bootstrap/js/jquery.js" /> "></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url  value="/resources/ui/bootstrap/js/bootstrap.min.js" /> "></script>
    
    <!-- DataTables -->
	<script src="<c:url value="/resources/ui/plugins/datatables/jquery.dataTables.min.js" />"></script>
	<script src="<c:url value="/resources/ui/plugins/datatables/dataTables.bootstrap.min.js" />"></script>
    
    <!-- AdminLTE App -->
	<script src="<c:url value="/resources/ui/admin/dist/js/app.min.js"/>"></script>
	
	<!-- Custom JS -->
	<script type="text/javascript" src="<c:url value="/resources/ui/admin/js/custom.js"/>"></script>
</body>

</html>