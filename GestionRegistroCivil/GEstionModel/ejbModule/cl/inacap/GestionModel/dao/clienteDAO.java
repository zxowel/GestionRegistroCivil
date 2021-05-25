package cl.inacap.GestionModel.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.GestionModel.dto.cliente;

/**
 * Session Bean implementation class clienteDAO
 */
@Stateless
@LocalBean
public class clienteDAO implements clienteDAOLocal {
	
	private static List<cliente> clientes = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public clienteDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void save(cliente Cliente) {
		clientes.add(Cliente);
		
	}

	@Override
	public void delete(cliente Cliente) {
		clientes.remove(Cliente);
		
	}

	@Override
	public List<cliente> getAll() {
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public List<cliente> filterByInt(int NumSolicitud) {
		// TODO Auto-generated method stub
		return clientes.stream().filter(c->c.getNumSolicitud().contains(NumSolicitud)).collect(Collectors.toList());
	}




	

}
