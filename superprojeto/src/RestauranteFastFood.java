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
public class RestauranteFastFood extends Restaurante implements Serializable {
    //Atributos
    private int numClientesDrive;
    private double valorFatCliente;
    
    /**
     * Método construtor por omissão
     */
    public RestauranteFastFood(){
        
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
     * @param numClientesDrive Número médio diário de clientes drive-thru
     * @param valorFatCliente Valor médio diário de faturação por cada cliente drive-thru
    */
    public RestauranteFastFood(String nome, String distrito, Localizacao loc, double valorFaturacao,int numEmpregados,double custoSalario,int numClientes, int numDiasFunc, int numMesasInt,int numClientesDrive,double valorFatCliente) {
        super("RestauranteFastFood", nome, distrito, loc, valorFaturacao,numEmpregados, custoSalario, numClientes, numDiasFunc, numMesasInt);
        this.numClientesDrive=numClientesDrive;
        this.valorFatCliente=valorFatCliente;
    }
    
    /**
    * Método de acesso externo ao Número médio diário de clientes drive-thru
    * @return Número médio diário de clientes drive-thru
    */
    public int getNumClientesDrive() {
        return numClientesDrive;
    }
    
    /**
    * Método de alteração externa ao Número médio diário de clientes drive-thru
    * @param numClientesDrive Número médio diário de clientes drive-thru
    */
    public void setNumClientesDrive(int numClientesDrive) {
        this.numClientesDrive = numClientesDrive;
    }
    
    /**
    * Método de acesso externo ao Valor médio diário de faturação por cada cliente drive-thru
    * @return Valor médio diário de faturação por cada cliente drive-thru
    */
    public double getValorFatCliente() {
        return valorFatCliente;
    }
    
    /**
    * Método de alteração externa ao Valor médio diário de faturação por cada cliente drive-thru
    * @param valorFatCliente Valor médio diário de faturação por cada cliente drive-thru
    */
    public void setValorFatCliente(double valorFatCliente) {
        this.valorFatCliente = valorFatCliente;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return ( super.calculaReceita() + numClientesDrive * valorFatCliente) * numDiasFunc;
    }

    @Override
    public String toString() {
        return "\nRestauranteFastFood" + super.toString() + "\nNº clientes drive-thru: " + numClientesDrive + "\nValor de faturação por cliente drive-thru: " + valorFatCliente + '€';
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
        if(parametro.equalsIgnoreCase("Número de clientes drive")){
            this.setNumClientesDrive((int)value);
            return true;
        }
        if(parametro.equalsIgnoreCase("Valor Faturação Cliente Drive")){
            this.setValorFatCliente(value);
            return true;
        }
        return false;
    }
}
