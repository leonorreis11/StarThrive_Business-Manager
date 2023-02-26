/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;

import java.io.Serializable;

public abstract class EmpresaMercearia extends Empresa implements Serializable {
    //Atributos
    protected double custoLimpeza;


    /**
     * Método construtor por omissão
     */
    public EmpresaMercearia(){

    }
    
    /**
     * Método construtor da classe
     * @param categoria Categoria da empresa
     * @param nome Nome da empresa
     * @param distrito Distrito da empresa
     * @param loc Localização da empresa
     * @param valorFaturacao Valor médio de faturação anual
     * @param custo_limpeza Custo anual de limpeza do estabelecimento
     */

    public EmpresaMercearia(String categoria, String nome, String distrito, Localizacao loc, double valorFaturacao, int custo_limpeza) {
        super(categoria, nome, distrito, loc, valorFaturacao);
        this.custoLimpeza = custo_limpeza;
    }



    public double getCustoLimpeza() {
        return custoLimpeza;
    }

    public void setCustoLimpeza(double custoLimpeza) {
        this.custoLimpeza = custoLimpeza;
    }


    @Override
    public String toString() {
        return super.toString() + "\nCusto de limpeza: " + custoLimpeza;
    }
    
    /**
     * Calcula a despesa anual da empresa 
     * @return Despesa anual
     */
    @Override
    public double calculaDespesa(){
        return custoLimpeza;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return -1;
    }
    
    /**
     * Alterar o parametro do objeto
     * @param parametro parametro que se pretende editar
     * @param value novo valor do parametro
     */
    @Override
    public boolean editarDouble(String parametro, double value){
        super.editarDouble(parametro, value);
        if(parametro.equalsIgnoreCase("Custo Limpeza")){
            this.setCustoLimpeza(value);
            return true;
        }
        return false;         
    }




}