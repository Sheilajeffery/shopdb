<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>Shop sample | Home</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">My Shop</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-customer">New Customer</a></li>
					<li><a href="all-customers">All Customers</a></li>
					<li><a href="all-products">All Products</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode== 'MODE_HOME'}">
			<div class="container " id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Customers Manager</h1>
				</div>
			</div>
			<div class="container text-center " id="tasksDiv">
				<h3>My Products</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>id</th>
								<th>name</th>
								<th>description</th>
								<th>price</th>
								<th>stock</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr>
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td>${product.description}</td>
									<td>${product.price}</td>
									<td>${product.stock}</td>
									<td><a href="update-product?id=${product.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-product?id=${product.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
								<tr></tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>   
		</c:when>
		
		<c:when test="${mode== 'MODE_PRODUCTS'}">
			<div class="container text-center " id="tasksDiv">
				<h3>My Products</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>id</th>
								<th>name</th>
								<th>description</th>
								<th>price</th>
								<th>stock</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr>
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td>${product.description}</td>
									<td>${product.price}</td>
									<td>${product.stock}</td>
									<td><a href="update-product?id=${product.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-product?id=${product.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
								<tr></tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>   
		</c:when>
		
		<c:when test="${mode== 'MODE_CUSTOMERS'}">
			<div class="container text-center " id="tasksDiv">
				<h3>My Customers</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>id</th>
								<th>username</th>
								<!--<th>password</th>  -->
								<th>email</th>
								<th>surname</th>
								<th>name</th>
								<th>address</th>
								<th>phone</th>
								<th>cnp</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="customer" items="${customers}">
								<tr>
									<td>${customer.id}</td>
									<td>${customer.username}</td>
									<!--<td>${customer.password}</td>-->
									<td>${customer.email}</td>
									<td>${customer.surname}</td>
									<td>${customer.name}</td>
									<td>${customer.address}</td>
									<td>${customer.phone}</td>
									<td>${customer.cnp}</td>
									<td><a href="update-customer?id=${customer.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-customer?id=${customer.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
								<tr></tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode== 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Customers</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-customer">
					<input type="hidden" name="id" value="${customer.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${customer.username}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="password"
								value="${customer.password}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email"
								value="${customer.email}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Surname</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="surname"
								value="${customer.surname}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${customer.name}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Address</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="address"
								value="${customer.address}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Phone</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="phone"
								value="${customer.phone}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">CNP</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="cnp"
								value="${customer.cnp}" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>

	</c:choose>



	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>

</html>