import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    private JButton btn;
    public JPanel panel1;
    private JTextField text;
    private JLabel cedula;

    public form1() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cedulaE="";
                String url="jdbc:mysql://localhost:3306/estudiantes2024A";
                String user="root";
                String password="123456";


                try(Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");


                    String query="select * from estudiantes where cedula='"+cedulaE+"'";

                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    System.out.println("");

                    cedulaE= text.getText();
                    cedula.setText("Cedula: " + cedulaE + " \n" + "Nombre: "+ resultSet.getString("nombre")+ "\n"+ "Nota bimestre 1: " + resultSet.getString("b1")
                    + "\nNota bimestre 2: " + resultSet.getString("b2"));


                    while (resultSet.next()){
                        System.out.println("ESTUDIANTE " + resultSet.getString("nombre"));
                        System.out.println("El estudiante con cedula " + resultSet.getString("cedula") + " con nombre " + resultSet.getString("nombre")
                                + " tiene una nota en el primer bimestre de " + resultSet.getString("b1") + " y una nota en el segundo bimestre de " + resultSet.getString("b2"));

                        float nota1=resultSet.getFloat("b1");
                        float nota2=resultSet.getFloat("b2");
                        float suma=nota1+nota2;

                        System.out.println("La nota total es de: " + suma);

                        if(suma<28){

                            System.out.println("Para no quedarse a supletorio le faltan " + String.format("%.2f",28-suma) +" puntos");
                        }else{
                            System.out.println("El estudiante pasa la materia sin supletorio");
                        }

                        System.out.println("");


                    }


                }
                catch(SQLException e1){
                    System.out.println(e1.getMessage());

                }

            }
        });
    }
}
