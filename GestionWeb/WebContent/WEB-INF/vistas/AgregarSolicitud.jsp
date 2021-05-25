<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="../templates/header.jsp"></jsp:include>
	<main class="container mt-6">
		<c:if test="${mensaje!=null }">
			<div class="columns is centered mb-6">
				<div class="column is-8">
					<div class="notification is-succes">
						<p> ${mensaje} </p>
					</div>				
				</div>
			</div>
		</c:if>
		<c:if test="${error!= null}">
			<div class="columns is centered mb-6">
				<div class="comun is-6">
					<div class="notification is-warning">
						<h6>existen errores</h6>
						<ul>
							<c:forEach var="error" items="${error}">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
		<div class="columns is-centered">
			<div class="column is-6">
				<form method="post" action="AgregarSolicitudController.do">
					<div  class="card">
						<div class="card-header has-background-primary">
							<span class="card-header-title"> agregar solicitud</span>
						</div>
						<div class="card-content">
							<div class="field">
								<label class="label" for="rut-txt">Rut</label>
								<div class="control">
									<input type="text" id="rut-txt"  name="rut-txt" class="input" placeholder="ejm 12345678-9" />
								</div>
							</div>
							<div class="field">
								<label class="label" for="nombre-txt">Nombre</label>
								<div class="control">
									<input type="text"  id="nombre-txt" name="nombre-txt" class="input" placeholder="ejm Esteban Quito"/>
								</div>
							</div>
							<div class="field">
								<label class="label" for="tipo-select"> tipo de solicitud </label>
								<div class="control">
									<div class="select">
										<select name="tipo-select" id="tipo-select">
											<option> Solicitud de cédula de identidad</option>
											<option> Retiro de cédula de identidad </option>
											<option> Solicitud de certidicado de nacimiento </option>
											<option> Solicitud de certificado de defunción </option>
										</select>
									</div>
								</div>
							</div>
							<div class="field ">
								<label class="label" for="solicitud-txt">numero solicitud</label>
								<div class="control">
									<input type="number" id="solicitud-txt" name="solicitud-txt" class="input is-small"  />
								</div>
							</div>
						</div>
						<div class="card-footer">
							<div class="card-footer-item is-centered">
								<button type="submit"  class="button is ghost"> ingresar </button>
							</div>					
						</div>
					</div>
				</form>
			</div>	
		</div>
	</main>
	
</body>
</html>