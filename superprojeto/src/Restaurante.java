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
public abstract class Restaurante extends EmpresaRestauracao implements Serializable {
    //Atributos
    protected int numDiasFunc;
    private int numMesasInt;
    
    /**
     * Método construtor por omissão
     */
    public Restaurante(){
        
    }
    
    /**
    * Método construtor da classe
    * @param categoria Categoria da empresa
    * @param nome Nome da empresa
    * @param distrito Distrito da empresa
    * @param loc Localização da empresa
    * @param valorFaturacao Valor médio de faturação anual
    * @param numEmpregados Número de empregados de mesa
    * @param custoSalario Custo do salário médio anual
    * @param numClientes Número médio de clientes diários
    * @param numDiasFunc Número de dias de funcionamento por ano
    * @param numMesasInt Número de mesas interiores
    */
    public Restaurante(String categoria, String nome, String distrito, Localizacao loc, double valorFaturacao,int numEmpregados,double custoSalario,int numClientes, int numDiasFunc, int numMesasInt) {
        super(categoria, nome, distrito, loc, valorFaturacao,numEmpregados, custoSalario, numClientes);
        this.numDiasFunc=numDiasFunc;
        this.numMesasInt=numMesasInt;
    }
    
    /**
    * Método de acesso externo ao Número de dias de funcionamento por ano
    * @return Número de dias de funcionamento por ano
    */
    public int getNumDiasFunc() {
        return numDiasFunc;
    }
    
    /**
    * Método de alteração externa ao Número de dias de funcionamento por ano
    * @param numDiasFunc Número de dias de funcionamento por ano
    */
    public void setNumDiasFunc(int numDiasFunc) {
        this.numDiasFunc = numDiasFunc;
    }
    
    /**
    * Método de acesso externo ao Número de mesas interiores
    * @return Número de mesas interiores
    */
    public int getNumMesasInt() {
        return numMesasInt;
    }
    
    /**
    * Método de alteração externa ao Número de mesas interiores
    * @param numMesasInt Número de mesas interiores
    */
    public void setNumMesasInt(int numMesasInt) {
        this.numMesasInt = numMesasInt;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return numMesasInt* super.valorFaturacao;
    }
    
    /**
     * Calcula a capacidade de clientes por dia do restaurante 
     * @return capacidade de clientes
     */
    @Override
    public int devolveCapacidade(){
        return numMesasInt;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "\nNº dias de funcionamento: " + numDiasFunc + "\nNº mesas no interior: " + numMesasInt ;
    }
    
        /**
     * Alterar o parametro do objeto
     * @param parametro parametro que se pretende editar
     * @param value novo valor do parametro
     * @return true - parametro editado, false - parametro não editado
     */
    @Override
    public boolean editarDouble(String parametro, double value){
        if(super.editarDouble(parametro, value))
            return true;
        if(parametro.equalsIgnoreCase("Número de dias de funcionamento")){
            this.setNumDiasFunc((int)value);
            return true;
        }
        if(parametro.equalsIgnoreCase("Número de mesas interiores")){
            this.setNumMesasInt((int)value);
            return true;
        }
        return false;
    }
    
    
}
