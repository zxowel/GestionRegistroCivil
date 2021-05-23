package cl.inacap.GestionModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.GestionModel.dto.cliente;

@Local
public interface clienteDAOLocal {
	
	void save(cliente Cliente);
	
	void delete (cliente Cliente);
	
	List<cliente> filterByName(String solicitud);

}
