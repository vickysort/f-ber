<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html ng-app="myApp">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Quintype füber</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0-alpha.2/css/bootstrap.css">

<!-- Custom styles for this template -->
<link rel="stylesheet" href="<c:url value='/resources/css/dashboard.css'/>">
</head>

<body ng-controller="CabController">

	<nav class="navbar navbar-dark navbar-fixed-top bg-inverse">
		<button type="button" class="navbar-toggler hidden-sm-up" data-toggle="collapse" data-target="#navbar"
			aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Quintype füber</a>
		<div id="navbar">
			<nav class="nav navbar-nav pull-xs-left">
				<a class="nav-item nav-link" ui-sref="dashboard">Dashboard</a> 
				<a class="nav-item nav-link" ui-sref="help">Help</a>
			</nav>
			<!-- <form class="pull-xs-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form> -->
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a ui-sref="dashboard">Dashboard <span class="sr-only">(current)</span></a></li>
					<li><a ui-sref="bookcab">Book Cab</a></li>
					<li><a ui-sref="travellog">Travel Logs</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- <h1 class="page-header">Taxi4Sure</h1> -->

				<!-- <div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200"
							height="200" class="img-fluid" alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200"
							height="200" class="img-fluid" alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200"
							height="200" class="img-fluid" alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200"
							height="200" class="img-fluid" alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div> -->

				<div ui-view></div>
				
			</div>
		</div>
	</div>


	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.0.0-alpha.2/js/bootstrap.js"></script>
	<script type="text/javascript" src="webjars/angularjs/1.3.8/angular.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script type="text/javascript" src="<c:url value='/resources/js/holder.min.js'/>"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script type="text/javascript" src="<c:url value='/resources/js/ie10-viewport-bug-workaround.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/angular-ui-router.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/app.js'/>"></script>
</body>
</html>