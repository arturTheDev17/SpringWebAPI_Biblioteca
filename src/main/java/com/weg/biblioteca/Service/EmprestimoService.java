package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Emprestimo;
import com.weg.biblioteca.Repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
     * Insere um emprestimo no banco de dados, com datas de inicio e prazo de devolucao automaticas
     * @param emprestimo Objeto do tipo emprestimo
     * @return Objeto do tipo emprestimo com o id gerado automaticamente pelo banco de dados
     */
    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setDataInicioEmprestimo(LocalDate.now());
        emprestimo.setDataPrazoDevolucao(emprestimo.getDataInicioEmprestimo().plusDays(7));
        emprestimo.setDataFimEmprestimo(null);
        return postEmprestimo(emprestimo);
    }

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

    public String getStatusEmprestimo(Integer id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));

        if (emprestimo.getDataFimEmprestimo() == null) {
            return "Emprestimo em andamento";
        } else {
            return "Emprestimo finalizado";
        }
    }

    /**
     * Exclui um emprestimo do banco de dados
     * @param id ID do emprestimo
     */
    public void removeEmprestimo(Integer id) {
        emprestimoRepository.deleteById(id);
    }

    /**
     * Finaliza um emprestimo no banco de dados, calculando a multa e atualizando o emprestimo
     * @param id ID do emprestimo
     * @return Valor da multa calculada
     */
    public Double finalizarEmprestimo(Integer id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
        if (emprestimo.getDataFimEmprestimo() != null) {

            emprestimo.setDataFimEmprestimo(LocalDate.now());
            LocalDate dataPrazo = emprestimo.getDataPrazoDevolucao();
            LocalDate dataDevolucao = emprestimo.getDataFimEmprestimo();

            if (dataDevolucao.isAfter(dataPrazo)) {
                emprestimo.setMulta(((double) ChronoUnit.DAYS.between(dataDevolucao, dataPrazo)) * 0.1);
            }

            emprestimoRepository.save(emprestimo);
            return emprestimo.getMulta();
        } else {
            return null;
        }
    }

    /**
     * Atualiza um emprestimo no banco de dados a partir do id
     * @param id ID do emprestimo
     * @param emprestimo Objeto do tipo emprestimo
     * @return Objeto do tipo emprestimo
     */
    public Emprestimo updateEmprestimo(Integer id, Emprestimo emprestimo) {
        emprestimo.setDataFimEmprestimo(null);
        emprestimo.setId(id);
        return emprestimoRepository.save(emprestimo);
    }
}
