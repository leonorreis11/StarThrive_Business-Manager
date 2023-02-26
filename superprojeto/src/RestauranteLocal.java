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
public class RestauranteLocal extends Restaurante implements Serializable {
    //Atributos
    private int numMesasEsp;
    private double custoLicenca;
    
    /**
     * Método construtor por omissão
     */
    public RestauranteLocal(){
        
    }
    
    /**
    * Método construtor da classe
    * @param nome Nome da empresa
    * @param distrito Distrito da empresa
    * @param loc Localização da empresa
    * @param valorFaturacao Valor médio de faturação anual
    * @param numEmpregados Número de empregados de mesa
    * @param custoSalario Custo do salário médio anual
    * @param numClientes Número médio de clientes diários
    * @param numDiasFunc Número de dias de funcionamento por ano
     * @param numMesasInt Número de mesas interiores
     * @param numMesasEsp Número de mesas na esplanada
     * @param custoLicenca Custo de licença anual por mesa de esplanada
    */
    public RestauranteLocal(String nome, String distrito, Localizacao loc, double valorFaturacao,int numEmpregados,double custoSalario,int numClientes, int numDiasFunc, int numMesasInt,int numMesasEsp,double custoLicenca ) {
        super("RestauranteLocal", nome, distrito, loc, valorFaturacao, numEmpregados, custoSalario, numClientes, numDiasFunc, numMesasInt);
        this.numMesasEsp=numMesasEsp;
        this.custoLicenca=custoLicenca;
    }
    
    /**
    * Método de acesso externo ao Número de mesas na esplanada
    * @return Número de mesas na esplanada
    */
    public int getNumMesasEsp() {
        return numMesasEsp;
    }
    
    /**
    * Método de alteração externa ao Número de mesas na esplanada
    * @param numMesasEsp Número de mesas na esplanada
    */
    public void setNumMesasEsp(int numMesasEsp) {
        this.numMesasEsp = numMesasEsp;
    }
    
    /**
    * Método de acesso externo ao Custo de licença anual por mesa de esplanada
    * @return Custo de licença anual por mesa de esplanada
    */
    public double getCustoLicenca() {
        return custoLicenca;
    }
    
    /**
    * Método de alteração externa ao Custo de licença anual por mesa de esplanada
    * @param custoLicenca Custo de licença anual por mesa de esplanada
    */
    public void setCustoLicenca(double custoLicenca) {
        this.custoLicenca = custoLicenca;
    }
    
        /**
     * Calcula a despesa anual da empresa 
     * @return Despesa anual
     */
    @Override
    public double calculaDespesa(){
        return super.calculaDespesa() + numMesasEsp * custoLicenca;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return ( super.calculaReceita() + numMesasEsp * super.valorFaturacao) * numDiasFunc;
    }
    
    /**
     * Calcula a capacidade de clientes por dia do restaurante 
     * @return capacidade de clientes
     */
    @Override
    public int devolveCapacidade(){
        return super.devolveCapacidade()+numMesasEsp;
    }

    @Override
    public String toString() {
        return "\nRestauranteLocal" + super.toString() + "\nNº mesas esplanada: " + numMesasEsp + "\nCusto Licença: " + custoLicenca + '€';
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
        if(parametro.equalsIgnoreCase("Número de mesas na esplanada")){
            this.setNumMesasEsp((int)value);

            return true;
        }
        if(parametro.equalsIgnoreCase("Custo de Licença")){
            this.setCustoLicenca(value);
            return true;
        }
        return false;
    }
    
    
}
