package com.br.livros.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class LivroResponse {

    private String titulo;
    private Integer edicao;
    private String autor;
}
