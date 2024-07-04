import javax.swing.*;
import javax.xml.transform.Source;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new form1() .panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
