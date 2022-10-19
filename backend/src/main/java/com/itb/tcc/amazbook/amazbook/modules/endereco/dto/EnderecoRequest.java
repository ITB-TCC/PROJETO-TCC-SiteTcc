package com.itb.tcc.amazbook.amazbook.modules.endereco.dto;

import lombok.Data;

@Data
public class EnderecoRequest {


    private String nome;
    private String telefone;
    private String rua;
    private String pontoDeReferencia;
    private String cidade;
    private String estado;
    private Short numero;
    private Integer userId;
}
