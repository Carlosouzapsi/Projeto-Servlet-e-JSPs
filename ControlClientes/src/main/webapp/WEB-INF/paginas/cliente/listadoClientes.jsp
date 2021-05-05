<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Lista de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Salário</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iterar cada elemento da lista de clientes -->
                            <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${cliente.nome} ${cliente.sobrenome}</td>
                                    <td <fmt:formatNumber value="${cliente.salario}" type="currency"/>${cliente.salario}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?acao=editar&idCliente=${cliente.idCliente}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Inicio botões dos totais -->
            <div class="col-md-3">
                <div>
                    <div class="card text-center bg-danger text-white mb-3">
                        <div class="card-body">
                            <h3>Salário Total</h3>
                            <h4 class="display-4">
                                <fmt:formatNumber value="${salarioTotal}" type="currency"/>
                            </h4>
                        </div>
                    </div>  
                </div>
                <div>
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">
                            <h3>Total Clientes</h3>
                            <h4 class="display-4">
                                <li class="fas fa-users"></li> ${totalClientes}
                                
                            </h4>
                        </div>
                    </div>
                </div>
                <!-- Final botões para os totais -->
            </div>
        </div>    
</section>
                                
<!-- Adicionar MODAL cliente -->
<jsp:include page="/WEB-INF/paginas/cliente/adicionarCliente.jsp"></jsp:include>
