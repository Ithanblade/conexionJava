import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    private JButton btn;
    public JPanel panel1;
    private JTextField text;
    private JLabel cedula;
    private JLabel nombre;
    private JLabel nota1;
    private JLabel nota2;

    public form1() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cedulaE="";
                String url="jdbc:mysql://localhost:3306/estudiantes2024A";
                String user="root";
                String password="123456";
                cedulaE= text.getText();

                try(Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");


                    String query="select * from estudiantes where cedula='"+cedulaE+"'";

                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    System.out.println("");


                    while (resultSet.next()){
                        cedula.setText("Cedula: " + resultSet.getString("cedula"));
                        nombre.setText("Nombre: " + resultSet.getString("nombre"));
                        nota1.setText("Nota1: " + resultSet.getString("b1"));
                        nota2.setText("Nota2: " + resultSet.getString("b2"));

                    }


                }
                catch(SQLException e1){
                    System.out.println(e1.getMessage());

                }

            }
        });
    }
}
