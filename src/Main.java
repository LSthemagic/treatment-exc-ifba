import Entity.Dependente;
import Entity.Professor;
import Model.SistemaAcademico;

public class Main {
    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();
        try {

            Dependente[] dependentes = {new Dependente("João", 8, "Masculino")};
            Professor professor1 = new Professor("Carlos", 45, "Masculino", "12345678900", "1234567", "Rua A, 123", dependentes);
            sistema.adicionarProfessor(professor1);
            sistema.adicionarProfessor(professor1);
            sistema.excluirProfessor("00000000000");
            sistema.pesquisarProfessor("00000000000");
        }catch (Exception e){
            sistema.otheLog(e.getMessage());
        }finally {
            for (String log : sistema.getLogs()) {
                System.out.println("Log de Erro: " + log);
            }
        }
    }
}