/**
 * @author winic
 */
package main.dao.factory;

import main.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {

    public static Cliente convert(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("ID_CLIENTE"));
        cliente.setNome(rs.getString(("NOME")));
        cliente.setSobrenome(rs.getString(("SOBRENOME")));
        cliente.setCpf(rs.getLong(("CPF")));
        cliente.setTelefone(rs.getLong(("TEL")));
        cliente.setEndereco(rs.getString(("ENDERECO")));
        cliente.setNumero(rs.getInt(("NUMERO")));
        cliente.setCidade(rs.getString(("CIDADE")));
        cliente.setEstado(rs.getString(("ESTADO")));
        return cliente;
    }
}
