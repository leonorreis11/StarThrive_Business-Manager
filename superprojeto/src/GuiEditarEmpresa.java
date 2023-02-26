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
public class GuiEditarEmpresa extends JFrame implements Serializable {

    File fObj = new File("starthrive.dat");

    //Atributos
    protected GestorEmpresas StarThrive;
    protected JComboBox jComboCategoria, jComboParametro;
    protected JLabel labelCategoria,labelNome, labelParametro, labelNewValue; 
    protected JTextField textNome, textNewValue;
    protected JButton buttonAdd, buttonSair;
    
    public GuiEditarEmpresa(GestorEmpresas StarThrive){
        this.StarThrive=StarThrive;
        labelCategoria = new JLabel("Categoria:");    
        labelNome = new JLabel("Nome:");    
        labelNewValue = new JLabel("Novo valor:");   
        labelParametro = new JLabel("Parâmetro:");
        textNome = new JTextField(10);      
        textNewValue = new JTextField(10);      
        String[] types = {"Café", "Pastelaria","Restaurante Local", "Restaurantes Fast-Food","Frutaria", "Mercado"};
        jComboCategoria= new JComboBox(types);
        String[] types2 = {"Nome","Distrito","Valor Faturação", "Custo Salário","Número Clientes","Número Empregados",
        "Número de Cafés vendidos por dia","Número de Bolos vendidos por dia", "Número de dias de funcionamento", 
        "Número de mesas interiores","Número de mesas na esplanada", "Custo de Licença",
        "Número de clientes drive","Valor Faturação Cliente Drive","Custo anual de limpeza do estabelecimento",
        "Tipo de supermercado", "Área de corredores (m^2)", "Número de produtos"};
        jComboParametro= new JComboBox(types2);
        
        buttonAdd = new JButton("Editar"); //Botão de criar empresa
        buttonSair = new JButton("SAIR"); //Botão de sair
        
        
        JPanel panel = new JPanel();                //Adicionar ao panel1 os elementos
        panel.setLayout(new GridLayout(4, 2));
        panel.add(labelCategoria);
        panel.add(jComboCategoria);
        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelParametro);
        panel.add(jComboParametro);
        panel.add(labelNewValue);
        panel.add(textNewValue);
        
        buttonAdd.setBounds(150, 170, 100, 25);
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
                    String categoria="";
                    switch (jComboCategoria.getSelectedIndex ()) {
                        case 0: 
                            categoria = "Cafe";
                            break;
                        case 1: 
                            categoria = "Pastelaria";
                            break;
                        case 2: 
                            categoria = "RestauranteLocal";
                            break;
                        case 3: 
                            categoria = "RestauranteLocal";
                            break;
                        case 4: 
                            categoria = "RestauranteFastFood";
                            break;
                        case 5: 
                            categoria = "Frutaria";
                            break;
                        case 6: 
                            categoria =  "Mercado";
                            break;      
                    }
                    
                    Empresa emp = StarThrive.devolveEmp(textNome.getText(),categoria);
                    boolean control=false;
                    if(emp!=null){
                        double value;
                        String param="";
                        switch (jComboParametro.getSelectedIndex ()) {
                            case 0: 
                                param = "Nome";
                                control = emp.editarString(param, textNewValue.getText());
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 1: 
                                param = "Distrito";
                                control = emp.editarString(param, textNewValue.getText());
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 2: 
                                param = "Valor Faturação";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 3: 
                                param = "Custo Salário";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 4: 
                                param = "Número Clientes";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 5: 
                                param = "Número Empregados";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;   
                            case 6: 
                                param = "Número de Cafés vendidos por dia";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 7: 
                                param = "Número de Bolos vendidos por dia";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break; 
                            case 8: 
                                param = "Número de dias de funcionamento";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 9: 
                                param = "Número de mesas interiores";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break; 
                            case 10: 
                                param = "Número de mesas na esplanada";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break; 
                            case 11: 
                                param = "Custo de Licença";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break; 
                            case 12: 
                                param = "Número de clientes drive";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 13: 
                                param = "Valor Faturação Cliente Drive";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break; 
                            case 14: 
                                param = "Custo Limpeza";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 15: 
                                param = "Tipo";
                                control = emp.editarString(param, textNewValue.getText());
                                StarThrive.atualizaFichObj(fObj);
                                break;
                            case 16: 
                                param = "Area";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);

                                break;
                            case 17: 
                                param = "Número de produtos";
                                value = Double.parseDouble(textNewValue.getText());
                                control = emp.editarDouble(param, value);
                                StarThrive.atualizaFichObj(fObj);
                                break;
                        }
                            if(control)
                                JOptionPane.showMessageDialog(null, "Empresa editada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            else{
                                JOptionPane.showMessageDialog(null, "Não é possível editar esse parâmetro na empresa.", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                    }else
                        JOptionPane.showMessageDialog(null, "A empresa não está registada no sistema.", "Erro", JOptionPane.ERROR_MESSAGE); 
                  
                }catch(NumberFormatException ex) {
                    textNewValue.setText("");
                    JOptionPane.showMessageDialog(null, "Valores inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);  
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro a editar a empresa!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else if(e.getSource() == buttonSair){
                if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        }
    }
}
   
