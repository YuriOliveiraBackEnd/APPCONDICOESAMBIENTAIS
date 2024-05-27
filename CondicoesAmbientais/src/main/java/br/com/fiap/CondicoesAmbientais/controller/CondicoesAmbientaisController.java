package br.com.fiap.CondicoesAmbientais.controller;

import br.com.fiap.CondicoesAmbientais.dto.CondicoesAmbientaisDTO;
import br.com.fiap.CondicoesAmbientais.model.CondicoesAmbientais;
import br.com.fiap.CondicoesAmbientais.service.CondicoesAmbientaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CondicoesAmbientaisController {
    @Autowired
    private CondicoesAmbientaisService service;

    @PostMapping("/condicoesAmbientais")
    @ResponseStatus(HttpStatus.CREATED)
    public CondicoesAmbientaisDTO salvar(@RequestBody @Valid CondicoesAmbientaisDTO condicoesAmbientaisDTO){
        return service.salvar(condicoesAmbientaisDTO);
    }
    @GetMapping("/condicoesAmbientais")
    @ResponseStatus(HttpStatus.OK)
    public List<CondicoesAmbientaisDTO> listartodos(){
        return service.listarTodos();
    }

    @GetMapping("/condicoesAmbientais/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CondicoesAmbientaisDTO ListarPorID(@PathVariable Long id){
       return  service.buscarPorId(id);
    }
    @DeleteMapping("/condicoesAmbientais/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
    @PutMapping("/condicoesAmbientais")
    @ResponseStatus(HttpStatus.OK)
    public CondicoesAmbientaisDTO atualizar(@RequestBody @Valid  CondicoesAmbientaisDTO condicoesAmbientaisDTO){
        return service.atualizar(condicoesAmbientaisDTO);
    }


}
