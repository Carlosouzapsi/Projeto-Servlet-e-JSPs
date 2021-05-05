package web;

import Dominio.Cliente;
import dados.ClienteDAOJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao != null) {
            switch (acao) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                default:
                    this.acaoDefault(request, response);

            }
        } else {
            this.acaoDefault(request, response);
        }
    }

    private void acaoDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDAOJDBC().listar();
        System.out.println("cliente = " + clientes);
        HttpSession session = request.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("totalClientes", clientes.size());
        session.setAttribute("salarioTotal", this.calcularSalarioTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSalarioTotal(List<Cliente> clientes) {
        double salarioTotal = 0;
        for (Cliente cliente : clientes) {
            salarioTotal += cliente.getSalario();
        }
        return salarioTotal;
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperar o Id do Cliente:
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDAOJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao != null) {
            switch (acao) {
                case "inserir":
                    this.inserirCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.acaoDefault(request, response);

            }
        } else {
            this.acaoDefault(request, response);
        }

    }
    
    private void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperando os valores do formulário adicionar cliente:
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        double salario = 0;
        String salarioString = request.getParameter("salario");
        if (salarioString != null && !"".equals(salarioString)) {
            salario = Double.parseDouble(salarioString);
        }

        //Criamos o objeto de cliente
        Cliente cliente = new Cliente(nome, sobrenome, email, telefone, salario);

        //Inserir na base de dados:
        int registrosModificados = new ClienteDAOJDBC().inserir(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos a acao default:
        this.acaoDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperando os valores do formulário editar cliente:
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        double salario = 0;
        String salarioString = request.getParameter("salario");
        if (salarioString != null && !"".equals(salarioString)) {
            salario = Double.parseDouble(salarioString);
        }

        //Criamos o objeto de cliente
        Cliente cliente = new Cliente(idCliente, nome, sobrenome, email, telefone, salario);

        //modificar objeto na base de dados:
        int registrosModificados = new ClienteDAOJDBC().atualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos a acao default:
        this.acaoDefault(request, response);
    }

}
