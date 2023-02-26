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

/**
 *
 * @author User
 */
public class GuiCafe extends GuiCriarEmpresa implements Serializable {
    //Atributos
    private JLabel labelNumCafes, labelNumEmpregados, labelCustoSalario, labelNumClientes, labelVazia; 
    private JTextField textNumCafes, textNumEmpregados, textCustoSalario, textNumClientes;
            
    public GuiCafe(GestorEmpresas StarThrive){
        super(StarThrive);
        labelFat = new JLabel("Valor médio de faturação anual\n por café vendido por dia(€): ");
        labelNumEmpregados = new JLabel("Nº de empregados de mesa: ");
        textNumEmpregados = new JTextField(10); 
        labelCustoSalario = new JLabel("Custo do salário médio anual: ");
        textCustoSalario = new JTextField(10); 
        labelNumClientes = new JLabel("Nº médio de clientes diário: ");
        textNumClientes = new JTextField(10); 
        labelNumCafes = new JLabel("Nº médio de cafés vendidos por dia: ");
        textNumCafes = new JTextField(10);  
        
        JPanel panel = new JPanel();                //Adicionar ao panel1 os elementos
        panel.setLayout(new GridLayout(9, 3));
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
        panel.add(labelNumEmpregados);
        panel.add(textNumEmpregados);
        panel.add(labelCustoSalario);
        panel.add(textCustoSalario);
        panel.add(labelNumClientes);
        panel.add(textNumClientes);
        panel.add(labelNumCafes);
        panel.add(textNumCafes);
        
        
        buttonSair.setBounds(200, 170, 100, 25);
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
                            && !(textNumCafes.getText().equals("")) ){
                        
                        String nome = textNome.getText();
                        if(StarThrive.verificaNome("Cafe", nome)){

                            String valAl = textAlt.getText();
                            String valLong = textLong.getText();
                            double valFat = Double.parseDouble(textFat.getText());
                            int numEmpregados = Integer.parseInt(textNumEmpregados.getText());
                            int numClientes = Integer.parseInt(textNumClientes.getText());
                            double salario = Double.parseDouble(textCustoSalario.getText());
                            int numCafes = Integer.parseInt(textNumCafes.getText());

                            Cafe cafe = new Cafe(nome,textDistrito.getText(), new Localizacao(valAl, valLong), valFat, numEmpregados,salario,numClientes,numCafes);
                            StarThrive.adicionarEmpresa(cafe);
                            StarThrive.atualizaFichObj(fObj);
                            JOptionPane.showMessageDialog(null, "Empresa registada com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                        }else
                            JOptionPane.showMessageDialog(null, "Não é possível a utilização do nome inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Todos os parâmetros são de preenchimento obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException ex) {
                    textAlt.setBackground(Color.red);
                    textLong.setBackground(Color.red);
                    textFat.setBackground(Color.red);
                    textNumCafes.setBackground(Color.red);
                    textAlt.setText("");
                    textLong.setText("");
                    textAlt.setText("");
                    textNumCafes.setBackground(Color.red);
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
