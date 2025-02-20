package com.weg.biblioteca.Service;

import com.weg.biblioteca.Model.Livro;
import com.weg.biblioteca.Model.Usuario;
import com.weg.biblioteca.Repository.LivroRepository;
import com.weg.biblioteca.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Operações, lógica de negócios e comunicação com o banco de dados relacionadas aos usuarios
 */
@Service
@AllArgsConstructor
public class UsuarioService {
    /**
     * @see UsuarioRepository
     */
    private UsuarioRepository usuarioRepository;
    
    /**
     * Insere um usuario no banco de dados
     * @param usuario Objeto do tipo usuario
     * @return Objeto do tipo usuario com o id gerado automaticamente pelo banco de dados
     */
    public Usuario postUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Retorna uma lista de usuarios do banco de dados
     * @return Lista de usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Retorna um usuario do banco de dados a partir do id
     * @param id ID do usuario
     * @return Objeto do tipo usuario
     */
    public Usuario getUsuario(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    /**
     * Exclui um usuario do banco de dados
     * @param id ID do usuario
     */
    public void removeUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Atualiza um usuario no banco de dados a partir do id
     * @param id ID do usuario
     * @param usuario Objeto do tipo usuario
     * @return Objeto do tipo usuario
     */
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }
}
