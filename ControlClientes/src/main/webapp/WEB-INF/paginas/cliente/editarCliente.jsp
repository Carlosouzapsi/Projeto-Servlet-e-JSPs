<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7c7ce18096.js" crossorigin="anonymous"></script>

        <title>Editar Clientes</title>
    </head>
    <body>
        <!-- Cabeçalho -->
        <jsp:include page="/WEB-INF/paginas/comuns/cabecalho.jsp"></jsp:include>

            <form action="${pageContext.request.contextPath}/ServletControlador?acao=modificar&idCliente=${cliente.idCliente}" method="POST" class="was-validated">

            <!-- Botões de Navegação -->
            <jsp:include page="/WEB-INF/paginas/comuns/botoesNavegacaoEdicao.jsp"></jsp:include>

                <section id="details">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>Editar Cliente</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="nome">Nome</label>
                                            <input type="text" class="form-control" name="nome" required value="${cliente.nome}">
                                        </div>
                                        <div class="form-group">
                                            <label for="sobrenome">Sobrenome</label>
                                            <input type="text" class="form-control" name="sobrenome" required value="${cliente.sobrenome}">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="email" class="form-control" name="email" required value="${cliente.email}">
                                        </div>
                                        <div class="form-group">
                                            <label for="telefone">Telefone</label>
                                            <input type="tel" class="form-control" name="telefone" required value="${cliente.telefone}">
                                        </div>
                                        <div class="form-group">
                                            <label for="salario">Salário</label>
                                            <input type="number" class="form-control" name="salario" required value="${cliente.salario}" step="any">
                                        </div>

                                    </div>
                                </div>
                            </div> 
                        </div>
                    </div>
                </section>
            </form>

            <!-- Rodapé da página -->
        <jsp:include page="/WEB-INF/paginas/comuns/rodapePagina.jsp"></jsp:include>





        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
