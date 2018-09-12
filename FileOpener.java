package com.class2;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class FileOpener extends JFrame {

    //Declarations class wide

    JPanel topPanel;
    JTextArea input, search, info;
    JScrollPane scrollPane, scrollPane1;
    JButton findBut, searchBut;

    ArrayList<String> fileData = new ArrayList<String>();
    ArrayList<String> fileWords = new ArrayList<String>();

    String fileInfo, fileAsString, searchMessage;


    //Array for storing words, should probably be in a ArrayList

    String[] words;

    public static void main(String[] args) {
        FileOpener open = new FileOpener();

    }


    public FileOpener() {
        this.setTitle("Example");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Listeners
        ListenForButton lForButton = new ListenForButton();

        // Panels init
        topPanel = new JPanel();

        // TextAreas Init
        input = new JTextArea(2, 10);
        search = new JTextArea(2, 10);
        info = new JTextArea(5, 10);

        info.setText("Info will pop up here!");

        //ScrollPanes Init
        scrollPane = new JScrollPane(input );
        scrollPane1 = new JScrollPane(search);


        //Buttons init
        findBut = new JButton("Find");
        searchBut = new JButton("Search");

        // Adding listener to Buttons
        findBut.addActionListener(lForButton);
        searchBut.addActionListener(lForButton);


        //Add objects to panel
        topPanel.add(scrollPane);
        topPanel.add(findBut);
        topPanel.add(scrollPane1);
        topPanel.add(searchBut);

        //Add panel to frame
        this.add(topPanel, BorderLayout.CENTER);
        this.add(info, BorderLayout.SOUTH);
        this.setVisible(true);

    }


    //Seaching for words stored in the words[] array;

    private String search(String term) {

        int howMany = 0;

        for(int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().equals(term.toLowerCase())) {
                howMany++;
            }
        }

            if(howMany != 0){
                return "''" + term + "''" + " was found " + howMany + " times";
            }

        return "''" + term + "''" + " was not found";
    }

    //Method for getting text out of textfile, called by Buttonlistener

    private void getFileData(String filePath) {

        int lines = 0;

        try {

            BufferedReader textBuffer = new BufferedReader(new FileReader(filePath));

            StringBuilder builder = new StringBuilder();
            String nextLine = textBuffer.readLine();

            while (nextLine != null) {
                lines++;
                builder.append(nextLine);
                builder.append(System.lineSeparator());
                nextLine = textBuffer.readLine();
            }

            fileAsString = builder.toString();

            //Adds the words from the string made by Stringbuilder to an array word by word

            words = fileAsString.split("\\s+");

            fileData.add(2, "" + lines);


        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file");
            System.exit(0);
        } catch (IOException e){
            System.out.println("An I/O Error Occured");
            System.exit(0);
        }
    }

    //Method for getting filename and size, per now a bad solution

    private void getFileInfo(String filePath){
        File file = new File(filePath);
        System.out.println("Name: " + file.getName());
        fileData.add(0,file.getName());
        fileData.add(1,"" + file.getTotalSpace());

    }

    //File Chooser Prompt

    public String openFile(){

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();

        }
        return "";
    }


    private class ListenForButton implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getSource() == findBut){
                String term = openFile();
                getFileInfo(term);
                getFileData(term);
                info.setText("Name: "+ fileData.get(0) + "\n" + "File Size: " + fileData.get(1)
                        + "\nLines: " + fileData.get(2) + "\n");
                info.append(fileAsString);

            }

            if(e.getSource() == searchBut){
                info.setText(search(search.getText()));
                search.setText("");
            }
        }
    }



}
