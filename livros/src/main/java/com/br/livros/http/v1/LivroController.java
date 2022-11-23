package com.br.livros.http.v1;

import com.br.livros.entity.Livro;
import com.br.livros.exeption.LivrotNaoEncontradoException;
import com.br.livros.http.response.LivroResponse;
import com.br.livros.service.LivroService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/livro")
@CrossOrigin
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Livro livro) {
        service.salvar(livro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LivroResponse> findAll() {
        return service.findAll();
    }

    @SneakyThrows
    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroResponse findByid(@RequestParam("id") Long id) {
        return service.findByid(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deletebyId(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Livro livro) throws LivrotNaoEncontradoException {
        service.atualizar(id, livro);
    }
}
