package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Emprestimo;
import com.weg.biblioteca.Repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Operações, lógica de negócios e comunicação com o banco de dados relacionadas aos emprestimos
 */
@Service
@AllArgsConstructor
public class EmprestimoService {
    /**
     * @see EmprestimoRepository
     */
    private EmprestimoRepository emprestimoRepository;

    /**
     * Insere um emprestimo no banco de dados
     * @param emprestimo Objeto do tipo emprestimo
     * @return Objeto do tipo emprestimo com o id gerado automaticamente pelo banco de dados
     */
    public Emprestimo postEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    /**
     * Retorna uma lista de emprestimos do banco de dados
     * @return Lista de emprestimos
     */
    public List<Emprestimo> getEmprestimos() {
        return emprestimoRepository.findAll();
    }

    /**
     * Retorna um emprestimo do banco de dados a partir do id
     * @param id ID do emprestimo
     * @return Objeto do tipo emprestimo
     */
    public Emprestimo getEmprestimo(Integer id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
    }

    /**
     * Exclui um emprestimo do banco de dados
     * @param id ID do emprestimo
     */
    public void removeEmprestimo(Integer id) {
        emprestimoRepository.deleteById(id);
    }

    /**
     * Atualiza um emprestimo no banco de dados a partir do id
     * @param id ID do emprestimo
     * @param emprestimo Objeto do tipo emprestimo
     * @return Objeto do tipo emprestimo
     */
    public Emprestimo updateEmprestimo(Integer id, Emprestimo emprestimo) {
        emprestimo.setId(id);
        return emprestimoRepository.save(emprestimo);
    }
}
