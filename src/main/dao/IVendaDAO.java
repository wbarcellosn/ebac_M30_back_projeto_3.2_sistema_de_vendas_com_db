package main.dao;

import main.dao.generic.IGenericDAO;
import main.domain.Venda;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
