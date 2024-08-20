package Model;

import Entity.Professor;
import Entity.exceptions.MaximumProfessorsReachedException;
import Entity.exceptions.ProfessorAlreadyExistsException;
import Entity.exceptions.ProfessorException;
import Entity.exceptions.ProfessorNotFoundException;

import java.util.ArrayList;

public class SistemaAcademico {
    private ArrayList<Professor> professores;
    private ArrayList<String> logs;

    public SistemaAcademico() {
        this.professores = new ArrayList<>();
        this.logs = new ArrayList<>();
    }


    public void adicionarProfessor(Professor professor) {
        try {


            if (professores.size() >= 5) {
                throw new MaximumProfessorsReachedException("Limite de 5 professores atingido.");
            }

            for (Professor p : professores) {
                if (p.getCpf().equals(professor.getCpf())) {
                    throw new ProfessorAlreadyExistsException("Professor com CPF " + professor.getCpf() + " já existe.");
                }
            }

            professores.add(professor);
        } catch (ProfessorException e) {
            logs.add(e.getMessage());
        }
    }


    public void excluirProfessor(String cpf) {
        try {
            boolean removido = professores.removeIf(p -> p.getCpf().equals(cpf));

            if (!removido) {
                throw new ProfessorNotFoundException("Professor com CPF " + cpf + " não encontrado.");
            }
        } catch (ProfessorException e) {
            logs.add(e.getMessage());
        }
    }


    public Professor pesquisarProfessor(String cpf) {
        try {
            for (Professor p : professores) {
                if (p.getCpf().equals(cpf)) {
                    return p;
                }
            }

            throw new ProfessorNotFoundException("Professor com CPF " + cpf + " não encontrado.");
        }catch (ProfessorException e){
            logs.add(e.getMessage());
            return null;
        }
    }

    public void otheLog(String m){
        logs.add(m);
    }


    public ArrayList<String> getLogs() {
        return logs;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }
}
