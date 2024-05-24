/**
 * @author winic
 */

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;
import main.service.ClienteService;
import main.service.IClienteService;
import mocks.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTeste {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTeste() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException, DAOException {
        cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Winicius");
        cliente.setSobrenome("Barcellos");
        cliente.setTelefone(27987654321L);
        cliente.setEndereco("Rua dos Perdidos");
        cliente.setNumero(10);
        cliente.setCidade("Vitória");
        cliente.setEstado("ES");

        clienteService.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() throws DAOException {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws DAOException {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        cliente.setSobrenome("Barcellos Nunes");
        clienteService.alterar(cliente);

        Assert.assertEquals("Barcellos Nunes", cliente.getSobrenome());
    }
}
