/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class GuiCriarEmpresa extends JFrame implements Serializable {


    File fObj = new File("starthrive.dat");

    //Atributos
    protected GestorEmpresas StarThrive;  
    protected JLabel labelNome, labelDistrito, labelAlt, labelLong, labelFat; 
    protected JTextField textNome, textDistrito, textAlt, textLong, textFat;
    protected JButton buttonAdd, buttonSair;
    private GuiCafe guiCafe;
    
    public GuiCriarEmpresa(GestorEmpresas StarThrive){

        this.StarThrive=StarThrive;
        labelNome = new JLabel("Nome da empresa:");    //Nome
        labelDistrito = new JLabel("Distrito:");    //Distrito
        labelAlt = new JLabel("Altitude:");    //Altitude
        labelLong = new JLabel("Longitude:");    //Longitude
        labelFat = new JLabel("Valor médio de faturação anual (€):");    //Valor de faturação
        textNome = new JTextField(10);      
        textDistrito = new JTextField(10);      
        textAlt = new JTextField(10);      
        textLong = new JTextField(10);   
        textFat = new JTextField(10); 
        
        buttonAdd = new JButton("Adicionar"); //Botão de criar empresa
        buttonSair = new JButton("SAIR"); //Botão de sair
       
    }

}
