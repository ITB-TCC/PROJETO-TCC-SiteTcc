package com.itb.tcc.amazbook.amazbook.modules.endereco.model;


import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME", length = 120, nullable = false)
    private String nome;

    @Column(name = "TELEFONE", length = 120, nullable = false)
    private String telefone;

    @Column(name = "RUA", length = 120, nullable = false)
    private String rua;

    @Column(name = "PONTO_DE_REFERENCIA", length = 100, nullable = false)
    private String pontoDeReferencia;
;
    @Column(name = "CIDADE", length = 50, nullable = false)
    private String cidade;

    @Column(name = "ESTADO", length = 100, nullable = false)
    private String estado;

    @Column(name = "NUMERO", nullable = false)
    private Short numero;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cliente"))
    private Usuario usuario;

    public static Endereco of(EnderecoRequest enderecoRequest, Usuario usuario) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRequest, endereco);
        return Endereco
                .builder()
                .id(endereco.getId())
                .nome(enderecoRequest.getNome())
                .telefone(enderecoRequest.getTelefone())
                .rua(enderecoRequest.getRua())
                .pontoDeReferencia(enderecoRequest.getPontoDeReferencia())
                .cidade(enderecoRequest.getCidade())
                .estado(enderecoRequest.getEstado())
                .numero(enderecoRequest.getNumero())
                .usuario(usuario)
                .build();
    }
}
