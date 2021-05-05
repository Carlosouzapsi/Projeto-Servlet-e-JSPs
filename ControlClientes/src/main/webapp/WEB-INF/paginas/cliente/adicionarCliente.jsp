<div class="modal fade" id="adicionarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Adicionar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?acao=inserir" 
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" name="nome" required>
                    </div>
                    <div class="form-group">
                        <label for="sobrenome">Sobrenome</label>
                        <input type="text" class="form-control" name="sobrenome" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="telefone">Telefone</label>
                        <input type="tel" class="form-control" name="telefone" required>
                    </div>
                    <div class="form-group">
                        <label for="salario">Salário</label>
                        <input type="number" class="form-control" name="salario" required step="any">
                    </div>
                   
                </div>
                 <div class="modal-footer">
                     <button class="btn btn-primary" type="submit">Salvar</button>
                 </div>
            </form>
        </div>
    </div>
</div>  
