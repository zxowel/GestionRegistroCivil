package cl.inacap.GestionWeb.controllers;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cl.inacap.GestionModel.dao.clienteDAOLocal;
import cl.inacap.GestionModel.dto.cliente;


/**
 * Servlet implementation class AgregarSolicitudController
 */
@WebServlet("/AgregarSolicitudController.do")
public class AgregarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AtomicInteger atomic = new AtomicInteger();
	@Inject
	private clienteDAOLocal clientedao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/AgregarSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> error = new ArrayList<>();
		
		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {error.add("debe ingresar un nombre");
		}else{
			try { String[] aux = nombre.split(" ");  }
			catch (Exception e) {
				error.add("debe de ingresar nombre(s) y apellido(s) separados por un espacio vacio ");
			}
		}
		
		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {error.add("debe ingresar un rut");}
		else {
			try { 
				String[] aux = rut.split("-");
				String aux1 = aux[0];
				String aux2 = aux[1];
				int largo = aux1.length();
				int suma=0 ;
				int constante=2;
				int dig= 0;
				
				for (int i=largo-1;i>=0;i--) {
					suma = suma + Integer.parseInt(aux1.substring(i,i+1)) * constante;
					constante=constante +1;
					if(constante == 8) {constante = 2;}
				}
				
				dig = 11 - (suma%11);
				if (dig == 10 && aux2.toUpperCase().equals("K")){
					
				}else {
					if (dig==11 && aux2.equals("0")){
						
					}else {
						if (dig == Integer.parseInt(aux2)) {
							
						} else {error.add("ingrese rut valido");}
					}
				}					
			}catch (Exception ex) {error.add("rut invalido");}	
		}
		
		String tipo = request.getParameter("tipo-select").trim();
		String solicitudtxt = request.getParameter("solicitud-txt").trim();
		if (tipo.equals("Retiro de cédula de identidad")) {
			try {
				int solicitud=Integer.parseInt(solicitudtxt);
			}catch(Exception ex) {error.add("no hay numero de solicitud");}
		}
		
		
		if (error.isEmpty()){	
			atomic.incrementAndGet();
			cliente Cliente = new cliente();	
			
			Cliente.setNumSolicitud(atomic);	
			Cliente.setNombre(nombre);
			Cliente.setRut(rut);
			Cliente.setSolicitud(tipo);
			
			clientedao.save(Cliente);
			
			request.setAttribute("mensaje", "solicitud agregada");
			
			request.getRequestDispatcher("AtenderSolicitudController.do").forward(request, response);
			
		}else { request.setAttribute("error", error);}
		
		doGet(request,response);
	}
	
}


