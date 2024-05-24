import main.dao.IProdutoDAO;
import main.domain.Produto;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;
import main.service.IProdutoService;
import main.service.ProdutoService;
import mocks.ProdutoDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author winic
 */

public class ProdutoServiceTeste {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTeste() {
        IProdutoDAO dao = new ProdutoDAOMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setDepartamento("Departamento 1");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() throws DAOException {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() throws DAOException {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException {
        produto.setNome("Produto Alterado");
        produtoService.alterar(produto);

        Assert.assertEquals("Produto Alterado", produto.getNome());
    }
}
