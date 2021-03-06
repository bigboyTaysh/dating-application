/*
 * To change this lacense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and /pen the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;	
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*"
 *
 * @author pc
 */

/**
 *
 * @author pc
 */

public class OldFrame extends JFrame{
    
    private JLabel info,info2;
    private static JTextField login;
    private JPasswordField haslo;
    private JButton zaloguj,wyjdz;
    private JFrame f;
    
    
    
    OldFrame(Baza baza){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(500,450);
        setLayout(null); 
        setTitle("Logowanie");
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        add(info2 = new JLabel("", JLabel.CENTER));
        info2.setBounds(100, 60, 300, 20);
        
        add(info = new JLabel("Login:"));
        info.setBounds(170, 100, 80, 20);
        
        add(login = new JTextField(10));
        login.setBounds(275, 100, 80, 20);
        
        add(info = new JLabel("Hasło:"));
        info.setBounds(170, 120, 80, 20);
        
        add(haslo = new JPasswordField(10));
        haslo.setBounds(275, 120, 80, 20);
        
        
        add(zaloguj = new JButton("Zaloguj"));
        zaloguj.setBounds(150, 250, 100, 30);
        
        add(wyjdz = new JButton("Cofnij"));
        wyjdz.setBounds(255, 250, 100, 30);
        
        zaloguj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            if(login.getText().equals("admin")){
                    if(haslo.getText().equals("admin")){
                        f = new Admin(baza); 
                        dispose();
                        f.setVisible(true);
                    }
            }
            
            for(int i=0; i<baza.sizeListaKlientow(); i++){
                if(login.getText().equals(baza.getListaKlientow(i).getLogin())){
                    if(haslo.getText().equals(baza.getListaKlientow(i).getHaslo())){
                        f = new ProfileFrame(baza, baza.getListaKlientow(i)); 
                        dispose();
                        f.setVisible(true);
                    }
                }
            }
               
            info2.setForeground(Color.red);
            info2.setText("Niepoprawny login lub hasło.");
            
        } } );
        
        wyjdz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f = new MainFrame();
                dispose();
        } } );
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(f==null || !f.isVisible()){
                    f = new Exit();
                    f.setVisible(true);
                }    
        } } );
        
        setVisible(true);
    }
}
