package br.com.fiap.CondicoesAmbientais.service;

import br.com.fiap.CondicoesAmbientais.dto.UsuarioDTO;
import br.com.fiap.CondicoesAmbientais.exception.UsuarioNãoEncontradoException;
import br.com.fiap.CondicoesAmbientais.model.Usuario;
import br.com.fiap.CondicoesAmbientais.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO){
        String senhacrip = new BCryptPasswordEncoder().encode(usuarioDTO.senha());
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhacrip);

        Usuario usuariosalvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuariosalvo);
    }
    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioDTO.idUsuario());
        if (usuarioOptional.isPresent()){
            Usuario usuario = new Usuario();
            BeanUtils.copyProperties(usuarioDTO, usuario);

            return new UsuarioDTO(usuarioRepository.save(usuario));
        }else{
            throw new UsuarioNãoEncontradoException("Não existe");
        }
    }
    public UsuarioDTO buscarPorId(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return new UsuarioDTO(usuarioOptional.get());
        } else {
            throw new UsuarioNãoEncontradoException("Não existe!");
        }
    }
    public List<UsuarioDTO> listarTodos(){
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }
    public void excluir(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        }else{
            throw new UsuarioNãoEncontradoException("Não existe");
        }
    }
}
