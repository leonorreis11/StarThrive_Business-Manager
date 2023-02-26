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
public class Pastelaria extends EmpresaRestauracao implements Serializable {
    //Atributos
    private int numBolos;
    
    /**
     * Método construtor por omissão
     */
    public Pastelaria(){
        
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
    * @param numBolos Número de bolos que vendem por dia
    */
    public Pastelaria(String nome, String distrito, Localizacao loc, double valorFaturacao,int numEmpregados,double custoSalario,int numClientes, int numBolos) {
        super("Pastelaria", nome, distrito, loc, valorFaturacao,numEmpregados, custoSalario, numClientes);
        this.numBolos=numBolos;
    }
    
    /**
    * Método de acesso externo ao Número de bolos que vendem por dia
    * @return Número de bolos que vendem por dia
    */
    public int getNumBolos() {
        return numBolos;
    }
    
    /**
    * Método de alteração externa ao Número de bolos que vendem por dia
    * @param numBolos Número de bolos que vendem por dia
    */
    public void setNumBolos(int numBolos) {
        this.numBolos = numBolos;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return numBolos * super.valorFaturacao;
    }

    @Override
    public String toString() {
        return "\nPastelaria" + super.toString() +  "\nNº de bolos: " + numBolos ;
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
        if(parametro.equalsIgnoreCase("Número de Bolos vendidos por dia")){
            this.setNumBolos((int)value);
            return true;
        }
        return false;
    }
    
   
}
