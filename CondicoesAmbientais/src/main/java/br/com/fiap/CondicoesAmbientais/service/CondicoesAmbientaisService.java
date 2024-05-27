package br.com.fiap.CondicoesAmbientais.service;

import br.com.fiap.CondicoesAmbientais.dto.CondicoesAmbientaisDTO;
import br.com.fiap.CondicoesAmbientais.exception.UsuarioNãoEncontradoException;
import br.com.fiap.CondicoesAmbientais.model.CondicoesAmbientais;
import br.com.fiap.CondicoesAmbientais.repository.CondicoesAmbientaisRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicoesAmbientaisService {
    @Autowired
    private CondicoesAmbientaisRepository condicoesAmbientaisRepository;
    public CondicoesAmbientaisDTO salvar(CondicoesAmbientaisDTO condicoesAmbientaisDTO){
        CondicoesAmbientais condicoesAmbientais = new CondicoesAmbientais();
        BeanUtils.copyProperties(condicoesAmbientaisDTO, condicoesAmbientais);
         CondicoesAmbientais condicoesAmbientaisSalvo = condicoesAmbientaisRepository.save(condicoesAmbientais);
         return new CondicoesAmbientaisDTO(condicoesAmbientaisSalvo);
    }

    public CondicoesAmbientaisDTO atualizar(CondicoesAmbientaisDTO condicoesAmbientaisDTO){
        Optional<CondicoesAmbientais> condicoesAmbientaisOptional = condicoesAmbientaisRepository.findById(condicoesAmbientaisDTO.id());
        if (condicoesAmbientaisOptional.isPresent()){
            CondicoesAmbientais condicoesAmbientais = new CondicoesAmbientais();
            BeanUtils.copyProperties(condicoesAmbientaisDTO, condicoesAmbientais);

            return new CondicoesAmbientaisDTO(condicoesAmbientaisRepository.save(condicoesAmbientais));
        }else{
            throw new UsuarioNãoEncontradoException("Não existe");
        }
    }
    public CondicoesAmbientaisDTO buscarPorId(Long id){
        Optional<CondicoesAmbientais> condicoesAmbientaisOptional =
                condicoesAmbientaisRepository.findById(id);
        if (condicoesAmbientaisOptional.isPresent()){
            return new CondicoesAmbientaisDTO(condicoesAmbientaisOptional.get());
        } else {
            throw new UsuarioNãoEncontradoException("Não existe!");
        }
    }
    public List<CondicoesAmbientaisDTO> listarTodos(){
        return condicoesAmbientaisRepository.findAll().stream().map(CondicoesAmbientaisDTO::new).toList();
    }
    public void excluir(Long id){
        Optional<CondicoesAmbientais> condicoesAmbientaisOptional = condicoesAmbientaisRepository.findById(id);
        if (condicoesAmbientaisOptional.isPresent()){
             condicoesAmbientaisRepository.delete(condicoesAmbientaisOptional.get());
        }else{
            throw new UsuarioNãoEncontradoException("Não existe");
        }
    }




}
