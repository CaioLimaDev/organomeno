package br.com.organomemo.receitas;

import br.com.organomemo.notaFiscal.NotaFiscal;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RECEITAS", schema = "dbo")
public class Receitas extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECEITA")
    private Integer id;
    @Column(name = "RECEITA_DESCRICAO")
    private String descricao;
    @Column(name = "RECEITA_VALOR_BRUTO")
    private Double valorBruto;
    @Column(name = "RECEITA_VALOR_LIQUIDO")
    private Double valorLiquido;
    @Column(name = "RECEITA_DATA_ENTRADA")
    private Date dataEntrada;
    @Column(name = "NOTA_FISCAL_VINCULADA")
    private NotaFiscal notaFiscal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}
