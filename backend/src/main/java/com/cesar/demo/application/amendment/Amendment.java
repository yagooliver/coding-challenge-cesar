package com.cesar.demo.application.amendment;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "emenda")
public class Amendment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "codigoEmenda", nullable = false)
    private String codigoEmenda;
    @Column(name = "ano", nullable = false)
    private Integer ano;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "nomeautor", nullable = true)
    private String nomeAutor;
    @Column(name = "numeroemenda", nullable = true)
    private String numeroEmenda;
    @Column(name = "localidadeDoGasto", nullable = true)
    private String localidadeDoGasto;
    @Column(name = "funcao", nullable = true)
    private String funcao;
    @Column(name = "subfuncao", nullable = true)
    private String subfuncao;
    @Column(name = "valorEmpenhado", nullable = true)
    private String valorEmpenhado;
    @Column(name = "valorLiquidado", nullable = true)
    private String valorLiquidado;
    @Column(name = "valorPago", nullable = true)
    private String valorPago;
    @Column(name = "valorRestoInscrito", nullable = true)
    private String valorRestoInscrito;
    @Column(name = "valorRestoCancelado", nullable = true)
    private String valorRestoCancelado;
    @Column(name = "valorRestoPago", nullable = true)
    private String valorRestoPago;
    @Column(name = "valorRestoAPagar", nullable = true)
    private String valorRestoAPagar;
}
