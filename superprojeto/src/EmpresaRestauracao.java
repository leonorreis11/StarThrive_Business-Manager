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
public abstract class EmpresaRestauracao extends Empresa implements Serializable {
    //Atributos
    protected int numEmpregados;
    protected double custoSalario;
    private int numClientes;
    
    /**
     * Método construtor por omissão
     */
    public EmpresaRestauracao(){
        
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
    */
    public EmpresaRestauracao(String categoria,String nome, String distrito, Localizacao loc, double valorFaturacao,int numEmpregados,double custoSalario,int numClientes) {
        super(categoria, nome, distrito, loc, valorFaturacao);
        this.numEmpregados=numEmpregados;
        this.custoSalario=custoSalario;
        this.numClientes=numClientes;  
    }
   
    
    /**
    * Método de acesso externo ao Número de empregados
    * @return Número de empregados
    */
    public int getNumEmpregados() {
        return numEmpregados;
    }
    
    /**
    * Método de alteração externa ao Número de empregados
    * @param numEmpregados Número de empregados
    */
    public void setNumEmpregados(int numEmpregados) {
        this.numEmpregados = numEmpregados;
    }
    
    /**
    * Método de acesso externo ao Custo do salário médio anual 
    * @return Custo do salário médio anual
    */
    public double getCustoSalario() {
        return custoSalario;
    }
    
    /**
    * Método de alteração externa ao Custo do salário médio anual 
    * @param custoSalario Custo do salário médio anual
    */
    public void setCustoSalario(double custoSalario) {
        this.custoSalario = custoSalario;
    }
    
    /**
    * Método de acesso externo ao Número médio de clientes diários
    * @return Número médio de clientes diários
    */
    public int getNumClientes() {
        return numClientes;
    }
    
    /**
    * Método de alteração externa ao Número médio de clientes diários
    * @param numClientes Número médio de clientes diários
    */
    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNº de empregados: " + numEmpregados + 
                "\nCusto do salário médio anual: " + custoSalario + "€\nNúmero médio de clientes diários: " + numClientes ;
    }
    
    /**
     * Calcula a despesa anual da empresa 
     * @return Despesa anual
     */
    @Override
    public double calculaDespesa(){
        return numEmpregados * custoSalario;
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
        if(parametro.equalsIgnoreCase("Custo Salário")){
            this.setCustoSalario(value);
            return true;
        }
        if(parametro.equalsIgnoreCase("Número Clientes")){
            this.setNumClientes((int)value);
            return true;
        }
        if(parametro.equalsIgnoreCase("Número Empregados")){
            this.setNumEmpregados((int)value);
            return true;
        }
        return false;         
    }
   
}
