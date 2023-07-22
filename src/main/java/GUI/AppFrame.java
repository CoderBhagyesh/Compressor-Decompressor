package GUI;

import comp_decomp.compress;
import comp_decomp.decompress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton deCompressButton;

    AppFrame() {
        this.setLayout(null);
        this.setTitle("Compressor_Decompressor");
        compressButton = new JButton("Compress File");
        compressButton.addActionListener(this);
        deCompressButton = new JButton("Decompress File");
        deCompressButton.addActionListener(this);
        compressButton.setBounds(100,250,200,30);
        deCompressButton.setBounds(400,250,200,30);
        this.setSize(800,600);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(compressButton);
        this.add(deCompressButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    compress.method(file);
                }
                catch(Exception ee) {
                        JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if(e.getSource()==deCompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    decompress.method(file);
                }
                catch(Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
