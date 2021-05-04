package dados;

import Dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDAOJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nome, sobrenome, email, telefone, salario"
            + " FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nome, sobrenome, email, telefone, salario"
            + " FROM cliente WHERE id_cliente = ?";

    private static final String SQL_INSERT = "INSERT INTO cliente(nome, sobrenome, email, telefone, salario) "
            + " VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente "
            + " SET nome=?, sobrenome=?, email=?, telefone=?, salario=? WHERE id_cliente=?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                double salario = rs.getDouble("salario");

                cliente = new Cliente(idCliente, nome, sobrenome, email, telefone, salario);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(rs);
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return clientes;

    }
    
    public Cliente encontrar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1); //Posicionamento no primeiro registro encontrado
            String nome = rs.getString("nome");
            String sobrenome = rs.getString("sobrenome");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            double salario = rs.getDouble("salario");
            
            cliente.setNome(nome);
            cliente.setSobrenome(sobrenome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setSalario(salario);
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(rs);
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return cliente;
    }

    public int inserir(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setDouble(5, cliente.getSalario());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return rows;
    }
    
    public int atualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setDouble(5, cliente.getSalario());
            stmt.setInt(6, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return rows;  
    }
    
    public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexao.getConnection();
            stmt.setInt(1, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return rows;   
    }  
}
