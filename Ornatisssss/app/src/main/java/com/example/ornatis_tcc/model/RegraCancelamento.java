package com.example.ornatis_tcc.model;

public class RegraCancelamento
{
    private int valor_acima_de_100;
    private int porcentagem_sobre_valor_servico;
    private int horas_tolerancia;

    //CONSTRUTOR VAZIO
    public RegraCancelamento() { }


    //CONSTRUTOR COM OS ATRIBUTOS
    public RegraCancelamento(int valor_acima_de_100, int porcentagem_sobre_valor_servico, int horas_tolerancia)
    {
        this.valor_acima_de_100 = valor_acima_de_100;
        this.porcentagem_sobre_valor_servico = porcentagem_sobre_valor_servico;
        this.horas_tolerancia = horas_tolerancia;
    }

    public int getValor_acima_de_100()
    {
        return valor_acima_de_100;
    }

    public void setValor_acima_de_100(int valor_acima_de_100)
    {
        this.valor_acima_de_100 = valor_acima_de_100;
    }

    public int getPorcentagem_sobre_valor_servico()
    {
        return porcentagem_sobre_valor_servico;
    }

    public void setPorcentagem_sobre_valor_servico(int porcentagem_sobre_valor_servico)
    {
        this.porcentagem_sobre_valor_servico = porcentagem_sobre_valor_servico;
    }

    public int getHoras_tolerancia()
    {
        return horas_tolerancia;
    }

    public void setHoras_tolerancia(int horas_tolerancia)
    {
        this.horas_tolerancia = horas_tolerancia;
    }
}
