<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<table class="table is-hovered is-bordered">
				<thead class="has-background-primary">
					<tr>
						<th>Nº de atencion</th>
						<th>Nombre del cliente</th>
						<th>Tipo de solicitud</th>
						<th>accion</th>
				</thead>
				<tbody>
					<c:forEach var="clientes" items="${clientes}">
						<tr>
							<td>${clientes.NumSolicitud}</td>
							<td>${clientes.Nombre }</td>
							<td>${clientes.solicitud }</td>
							<td>
								<a href="AtenderSolicitudesController.do?atender="${clientes.NumSolicitud} class="has-text-succes">atender</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</body>
</html>