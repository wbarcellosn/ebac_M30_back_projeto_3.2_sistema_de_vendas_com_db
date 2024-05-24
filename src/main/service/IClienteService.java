/**
 * @author winic
 */
package main.service;

import main.domain.Cliente;
import main.exceptions.DAOException;
import main.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;
}
