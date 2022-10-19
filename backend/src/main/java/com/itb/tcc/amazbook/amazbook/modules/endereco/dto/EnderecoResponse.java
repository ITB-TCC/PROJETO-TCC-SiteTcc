package com.itb.tcc.amazbook.amazbook.modules.endereco.dto;

import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoResponse {

    private Integer id;
    private String nome;
    private String telefone;
    private String rua;
    private String pontoDeReferencia;
    private String cidade;
    private String estado;
    private Short numero;
    private UsuarioResponse usuario;

    public static EnderecoResponse of(Endereco endereco) {
        return EnderecoResponse
                .builder()
                .id(endereco.getId())
                .nome(endereco.getNome())
                .telefone(endereco.getTelefone())
                .rua(endereco.getRua())
                .pontoDeReferencia(endereco.getPontoDeReferencia())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .numero(endereco.getNumero())
                .usuario(UsuarioResponse.of(endereco.getUsuario()))
                .build();
    }
}
