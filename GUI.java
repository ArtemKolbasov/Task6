package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class GUI {
    private JFrame jFrame = getJFrame();
    private JPanel jPanel = new JPanel();

    public GUI(){
        jFrame.add(jPanel);

        JTextArea textArea = new JTextArea(10, 45);
        JTextField textField = new JTextField(45);
        textArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(textArea);

        JLabel inputArrayLabel = new JLabel("Введите числа");
        JLabel inputSLabel = new JLabel("Введите число S");

        JTextArea jTextAreaOutput = new JTextArea(10, 45);
        JScrollPane jScrollPane1Output= new JScrollPane(jTextAreaOutput);

        JButton jButtonEnterArray = new JButton("Find");
        jButtonEnterArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String inputString = textArea.getText();
                int s = Integer.parseInt(textField.getText());
                jTextAreaOutput.setText(Logic.findPairString(inputString, s));

            }
        });

        JButton jButtonFromFile = new JButton("Load from file");
        jButtonFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory( new File("src\\com\\company"));

                if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    try {
                        FileReader fr = new FileReader(jFileChooser.getSelectedFile());
                        Scanner scn = new Scanner(fr);
                        StringBuilder str = new StringBuilder();
                        while (scn.hasNextLine()){
                            str.append(scn.nextLine());
                        }
                        textArea.setText(String.valueOf(str));

                    } catch (Exception e){
                        System.out.println("Error: " + e);
                    }
                }
            }
        });

        JButton jButtonToFile = new JButton("Save into file");
        jButtonToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                String result = jTextAreaOutput.getText();

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File("src\\com\\company"));

                if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try (FileWriter fw = new FileWriter(jFileChooser.getSelectedFile())){
                        fw.write(text);
                        fw.write("\n");
                        fw.write(result);
                    }
                    catch (Exception e) {
                        System.out.println("Save file error");
                    }
                }

            }
        });

        jPanel.add(inputSLabel);
        jPanel.add(textField);
        jPanel.add(inputArrayLabel);
        jPanel.add(jScrollPane);

        jPanel.add(jButtonToFile);
        jPanel.add(jButtonFromFile);
        jPanel.add(jButtonEnterArray);

        jPanel.add(jScrollPane1Output);
        jPanel.revalidate();
    }

    private JFrame getJFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(700, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}
