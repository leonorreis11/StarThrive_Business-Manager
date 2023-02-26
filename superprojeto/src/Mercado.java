/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Mercado extends EmpresaMercearia implements Serializable {
    //Atributos
    private String tipo;
    private double area;


    /**
     * Método construtor por omissão
     */
    public Mercado(){

    }

    /**
     * Método construtor da classe
     * @param nome Nome da empresa
     * @param distrito Distrito da empresa
     * @param loc Localização da empresa
     * @param valorFaturacao Valor médio de faturação anual
     * @param tipo Tipo de mercado
     * @param area Area de corredores
     */
    public Mercado(String nome, String distrito, Localizacao loc, double valorFaturacao, int custo_limpeza, String tipo, int area) {
        super("Mercado", nome, distrito, loc, valorFaturacao, custo_limpeza);
        this.tipo = tipo;
        this.area = area;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }


    @Override
    public String toString() {
        return "\nMercado" + super.toString() + "\nTipo de mercado: " + tipo + "\nArea de corredores: " + area;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return area * super.valorFaturacao;
    }
    
    /**
     * Alterar o parametro do objeto
     * @param parametro parametro que se pretende editar
     * @param value novo valor do parametro
     * @return true - parametro editado, false - parametro não editado
     */
    @Override
    public boolean editarDouble(String parametro, double value){
        super.editarDouble(parametro, value);
        if(parametro.equalsIgnoreCase("Area")){
            this.setArea(value);
            return true;
        }
        return false;         
    }
    
    /**
     * 
     * @param parametro
     * @param value
     * @return 
     */
    @Override
    public boolean editarString(String parametro, String value){
        if(parametro.equalsIgnoreCase("Tipo")){
            this.setTipo(value);
            return true;
        }
        return false;
    }
}
