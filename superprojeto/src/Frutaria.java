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
public class Frutaria extends EmpresaMercearia implements Serializable {
    //Atributos
    private int numProdutos;

    /**
     * Método construtor por omissão
     */
    public Frutaria(){

    }

    /**
     * Método construtor da classe
     * @param nome Nome da empresa
     * @param distrito Distrito da empresa
     * @param loc Localização da empresa
     * @param valorFaturacao Valor médio de faturação anual
     * @param num_produtos Número de produtos
     */

    public Frutaria(String nome, String distrito, Localizacao loc, double valorFaturacao, int custo_limpeza, int num_produtos) {
        super("Frutaria", nome, distrito, loc, valorFaturacao, custo_limpeza);
        this.numProdutos = num_produtos;
    }

    public int getNumProdutos() {
        return numProdutos;
    }

    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }


    @Override
    public String toString() {
        return "\nFrutaria" + super.toString() + "\nNº de produtos: " + numProdutos;
    }
    
        /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return numProdutos * super.valorFaturacao;
    }
    
    /**
     * Alterar o parametro do objeto
     * @param parametro parametro que se pretende editar
     * @param value novo valor do parametro
     */
    @Override
    public boolean editarDouble(String parametro, double value){
        super.editarDouble(parametro, value);
        if(parametro.equalsIgnoreCase("Número de produtos")){
            this.setNumProdutos((int)value);
            return true;
        }
        return false;         
    }
}