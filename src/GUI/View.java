    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import codeFiles.Compress;
import codeFiles.Decompress;
import static java.awt.Color.orange;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author saiga
 */
public class View extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100 , 200, 30);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100 , 200, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.getContentPane().setBackground(orange);
        this.setSize(500,300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== compressButton){
           JFileChooser filechooser = new JFileChooser();
           int response = filechooser.showSaveDialog(null);
           
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               try{
                   Compress.method(file);
                   }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null, excp.toString());
               }
           }
       }
        if(e.getSource()== decompressButton){
           JFileChooser filechooser = new JFileChooser();
           int response = filechooser.showSaveDialog(null);
           
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               try{
                   Decompress.method(file);
                   }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null, excp.toString());
               }
           }
       }
    }
    
    public static void main(String[] args){
        View view = new View();
        view.setVisible(true);
    }    

   
}
