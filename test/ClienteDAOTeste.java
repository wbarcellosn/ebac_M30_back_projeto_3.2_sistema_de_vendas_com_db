
import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exceptions.DAOException;
import main.exceptions.MaisDeUmRegistroException;
import main.exceptions.TableException;
import main.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * @author winic
 */

public class ClienteDAOTeste {

    private IClienteDAO clienteDao;

    public ClienteDAOTeste() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Winicius");
        cliente.setSobrenome("Barcellos");
        cliente.setCidade("Vitória");
        cliente.setEndereco("Rua dos perdidos");
        cliente.setEstado("ES");
        cliente.setNumero(10);
        cliente.setTelefone(27987654321L);
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Winicius");
        cliente.setSobrenome("Barcellos");
        cliente.setCidade("Vitória");
        cliente.setEndereco("Rua dos perdidos");
        cliente.setEstado("ES");
        cliente.setNumero(10);
        cliente.setTelefone(27987654321L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }


    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Winicius");
        cliente.setSobrenome("Barcellos");
        cliente.setCidade("Vitória");
        cliente.setEndereco("Rua dos perdidos");
        cliente.setEstado("ES");
        cliente.setNumero(10);
        cliente.setTelefone(27987654321L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Winicius");
        cliente.setSobrenome("Barcellos");
        cliente.setCidade("Vitória");
        cliente.setEndereco("Rua dos perdidos");
        cliente.setEstado("ES");
        cliente.setNumero(10);
        cliente.setTelefone(27987654321L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setSobrenome("Barcellos Nunes");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Barcellos Nunes", clienteAlterado.getSobrenome());

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678900L);
        cliente.setNome("Winicius");
        cliente.setSobrenome("Barcellos");
        cliente.setCidade("Vitória");
        cliente.setEndereco("Rua dos perdidos");
        cliente.setEstado("ES");
        cliente.setNumero(10);
        cliente.setTelefone(27987654321L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf(12345678901L);
        cliente2.setNome("Maria");
        cliente2.setSobrenome("José da Silva");
        cliente2.setCidade("Vitória");
        cliente2.setEndereco("Rua dos perdidos");
        cliente2.setEstado("ES");
        cliente2.setNumero(15);
        cliente2.setTelefone(27987654320L);
        Boolean retorno2 = clienteDao.cadastrar(cliente2);
        assertTrue(retorno2);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }
}
