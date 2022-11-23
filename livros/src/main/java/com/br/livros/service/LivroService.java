package com.br.livros.service;

import com.br.livros.entity.Livro;
import com.br.livros.exeption.LivrotNaoEncontradoException;
import com.br.livros.http.response.LivroResponse;
import com.br.livros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository repository;

    public void salvar(Livro livro) {
        repository.save(livro);
    }

    public List<LivroResponse> findAll() {
        List<Livro> entity = repository.findAll();
        List<LivroResponse> response = new ArrayList<>();

        for (Livro e : entity) {
            LivroResponse livro = new LivroResponse();
            livro.setTitulo(e.getTitulo());
            livro.setAutor(e.getAutor());
            livro.setEdicao(e.getEdicao());
        }
        return response;
    }

    public LivroResponse findByid(Long id) throws LivrotNaoEncontradoException {
        Optional<Livro> entity = repository.findById(id);
        if (entity.isPresent()) {
            Livro e = entity.get();
            LivroResponse livro = new LivroResponse();

            return livro;
        } else {
            throw new LivrotNaoEncontradoException();
        }
    }

    public void deletebyId(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Livro livro) throws LivrotNaoEncontradoException {
        Optional<Livro> res = repository.findById(id);
        if (res.isPresent()) {
            Livro livro1 = res.get();
            livro1.setTitulo(livro1.getTitulo());
            livro1.setEdicao(livro1.getEdicao());
            livro1.setAutor(livro1.getAutor());

            repository.save(livro1);
        } else {
            throw new LivrotNaoEncontradoException();
        }
    }
}

