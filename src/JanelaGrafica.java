/**
 *
 * @author Jv Loreti
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaGrafica extends JFrame implements ActionListener{
    private JPanel panel;
    private JLabel lblAposta;
    private JTextField txtAposta;
    private JButton btnJogar;
    private JButton btnNovoJogo;
    
    private Jogo jogo;
    
    public JanelaGrafica(){
        criarComponentes();
        configurarJanelaGrafica();
    }
    
    private void criarComponentes(){
        panel = new JPanel();
        lblAposta = new JLabel("Insira sua aposta: ");
        txtAposta = new JTextField(5);
        btnJogar = new JButton("Jogar");
        btnNovoJogo = new JButton("Novo jogo");
        
        txtAposta.setEnabled(false);
        btnJogar.setEnabled(false);
        
        btnJogar.addActionListener(this);
        btnNovoJogo.addActionListener(this);
        
        panel.add(lblAposta);
        panel.add(txtAposta);
        panel.add(btnJogar);
        panel.add(btnNovoJogo);
        
        add(panel);
    }
    
    private void configurarJanelaGrafica(){
        super.setTitle("Jogo de Dados");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == btnNovoJogo){
            jogo = new Jogo();
            
            txtAposta.setEnabled(true);
            btnJogar.setEnabled(true);
            
            System.out.println(". . . Dados lançados.");
            //System.out.println(jogo);
        }else{
            if(event.getSource() == btnJogar){
                int aposta = Integer.parseInt(txtAposta.getText());
                boolean checkAposta = jogo.jogar(aposta);
                if(checkAposta){
                    JOptionPane.showMessageDialog(null, "Você acertou ;)");
                    jogo = null;
                    
                    txtAposta.setEnabled(false);
                    btnJogar.setEnabled(false);
                }else{
                    int tentativas = jogo.getTentativas();
                    JOptionPane.showMessageDialog(null, "Você errou. " + tentativas + " tentativas restantes.");
                    if(tentativas == 0){
                        JOptionPane.showMessageDialog(null, "Jogo encerrado.");
                        jogo = null;
                        
                        txtAposta.setEnabled(false);
                        btnJogar.setEnabled(false);
                    }
                }
            }
        }
        txtAposta.grabFocus();
        txtAposta.setText("");
    }
}
