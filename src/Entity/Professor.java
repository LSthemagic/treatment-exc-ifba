package Entity;

import java.util.Objects;

public class Professor {
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private String rg;
    private String endereco;
    private Dependente[] dependentes;


    public Professor(String nome, int idade, String sexo, String cpf, String rg, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
    }

    public Professor(String nome, int idade, String sexo, String cpf, String rg, String endereco, Dependente[] dependentes) {
        this(nome, idade, sexo, cpf, rg, endereco);
        this.dependentes = dependentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Dependente[] getDependentes() {
        return dependentes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(cpf, professor.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}