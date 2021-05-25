<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="vendor/bulma/css/bulma.min.css" rel="stylesheet" />
</head>
<body>
	<header>
		<nav class="navbar has-background-link" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
					 <a role="button" class="navbar-burger" aria-label="menu"
					aria-expanded="false" data-target="navbarBasicExample"> <span
					aria-hidden="true"></span> <span aria-hidden="true"></span> <span
					aria-hidden="true"></span>
				</a>
			</div>

			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item" href="index.jsp"> Home </a> 
					<a class="navbar-item" href="AgregarSolicitudController.do"> agregar solicitud </a>
					<a class="navbar-item" href="AtenderSolicitudController.do"> atender solicitud </a>
				</div>

			</div>
		</nav>
	</header>
