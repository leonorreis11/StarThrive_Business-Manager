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
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiRestauranteFastFood extends GuiCriarEmpresa implements Serializable {
    //Atributos
    private JLabel labelNumBolos, labelNumEmpregados, labelCustoSalario, labelNumClientes, numDiasFunc, 
            numMesasInt,numClientesDrive,valorFatDrive; 
    private JTextField textNumEmpregados, textCustoSalario, textNumClientes, tnumDiasFunc, 
            tnumMesasInt,tnumClientesDrive,tvalorFatDrive;
            
    public GuiRestauranteFastFood(GestorEmpresas StarThrive){
        super(StarThrive);
        labelFat = new JLabel("Valor médio de faturação de cada mesa \n" +
"por dia (€):");
        labelNumEmpregados = new JLabel("Nº de empregados de mesa: ");
        textNumEmpregados = new JTextField(10); 
        labelCustoSalario = new JLabel("Custo do salário médio anual: ");
        textCustoSalario = new JTextField(10); 
        labelNumClientes = new JLabel("Nº médio de clientes diário: ");
        textNumClientes = new JTextField(10);     
        numDiasFunc = new JLabel("Nº de dias de funcionamento por ano: ");
        tnumDiasFunc = new JTextField(10);  
        numMesasInt = new JLabel("Nº de mesas no interior: ");
        tnumMesasInt = new JTextField(10); 
        numClientesDrive = new JLabel("Nº médio diário de clientes drive-thru: ");
        tnumClientesDrive = new JTextField(10); 
        valorFatDrive = new JLabel("Valor médio diário de \n" +
"faturação por cliente drive-thru (€): ");
        tvalorFatDrive = new JTextField(10); 
        
        
        JPanel panel = new JPanel();                //Adicionar ao panel1 os elementos
        panel.setLayout(new GridLayout(13, 2));
        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDistrito);
        panel.add(textDistrito);
        panel.add(labelAlt);
        panel.add(textAlt);
        panel.add(labelLong);
        panel.add(textLong);
        panel.add(labelFat);
        panel.add(textFat);
        panel.add(buttonAdd);
        panel.add(labelNumEmpregados);
        panel.add(textNumEmpregados);
        panel.add(labelCustoSalario);
        panel.add(textCustoSalario);
        panel.add(labelNumClientes);
        panel.add(textNumClientes);   
        panel.add(numDiasFunc);
        panel.add(tnumDiasFunc);
        panel.add(numMesasInt);
        panel.add(tnumMesasInt);
        panel.add(numClientesDrive);
        panel.add(tnumClientesDrive);
        panel.add(valorFatDrive);
        panel.add(tvalorFatDrive);
        
        buttonSair.setBounds(200, 170, 100, 25);
        JPanel panel2 = new JPanel();  
        panel2.add(buttonAdd);
        panel2.add(buttonSair);
        
        // Main panel - BorderLayout
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(panel, BorderLayout.CENTER);
        panelMain.add(panel2, BorderLayout.SOUTH);

        buttonAdd.addActionListener(new ButtonListener());
        buttonSair.addActionListener(new ButtonListener());
        this.add(panelMain);                   
    }
    
    // Inner class
    private class ButtonListener implements ActionListener {    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonAdd) {
                try{
                    if(!(textNome.getText().equals("")) && !(textDistrito.getText().equals(""))
                            && !(textAlt.getText().equals("")) && !(textLong.getText().equals("")) 
                           && !(textFat.getText().equals("")) && !(textNumEmpregados.getText().equals(""))
                            && !(textNumClientes.getText().equals("")) && !(textCustoSalario.getText().equals(""))
                            && !(tnumDiasFunc.getText().equals("")) && !(tnumMesasInt.getText().equals("")) &&
                             !(tnumClientesDrive.getText().equals("")) && !(tvalorFatDrive.getText().equals("")) ){
                        String nome = textNome.getText();
                        if(StarThrive.verificaNome("RestauranteFastFood", nome)){
                            textAlt.setBackground(Color.white);
                            textLong.setBackground(Color.white);
                            textFat.setBackground(Color.white);
                            textNumEmpregados.setBackground(Color.white);
                            textCustoSalario.setBackground(Color.white); 
                            textNumClientes.setBackground(Color.white);
                            String valAl = textAlt.getText();
                            String valLong = textLong.getText();
                            double valFat = Double.parseDouble(textFat.getText());
                            int numEmpregados = Integer.parseInt(textNumEmpregados.getText());
                            int numClientes = Integer.parseInt(textNumClientes.getText());
                            double salario = Double.parseDouble(textCustoSalario.getText());
                            int numDiasFunc = Integer.parseInt(tnumDiasFunc.getText());
                            int numMesasInt = Integer.parseInt(tnumMesasInt.getText());
                            int numMesasEsp = Integer.parseInt(tnumClientesDrive.getText());
                            double custoLicenca = Double.parseDouble(tvalorFatDrive.getText());
                            RestauranteFastFood restFastFood = new RestauranteFastFood(nome,textDistrito.getText(), new Localizacao(valAl, valLong), valFat, numEmpregados,salario,numClientes,numDiasFunc,numMesasInt, numMesasEsp, custoLicenca);
                            StarThrive.adicionarEmpresa(restFastFood);
                            StarThrive.atualizaFichObj(fObj);
                        }else
                            JOptionPane.showMessageDialog(null, "Não é possível a utilização do nome inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(null, "Todos os parâmetros são de preenchimento obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valores inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro na criação da empresa.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else if(e.getSource() == buttonSair){
                if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        }
    }
    
}
