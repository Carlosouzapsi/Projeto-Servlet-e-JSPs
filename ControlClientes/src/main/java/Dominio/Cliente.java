package Dominio;

public class Cliente {
    
    private int idCliente;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private double salario;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nome, String sobrenome, String email, String telefone, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.salario = salario;
    }

    public Cliente(int idCliente, String nome, String sobrenome, String email, String telefone, double salario) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.salario = salario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", telefone=" + telefone + ", salario=" + salario + '}';
    }
    
}
