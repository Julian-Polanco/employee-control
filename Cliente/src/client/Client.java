package client;

import data.Employee;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private static Home home = new Home();

    public static void main(String[] args) {
        home.setVisible(true);
    }

    public static Boolean Insert(Employee employee) {
        try {
            Socket socket = new Socket("localhost", 5002);
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.writeObject(employee);

            ObjectInputStream inputFromServer;
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            employee = (Employee) inputFromServer.readObject();
            return employee.getMessage().equals("ok");
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "It´s imposible to connect with the server. ", e);
        }
        return null;
    }

    public static Employee getSelects() {
        try {
            Employee employee = new Employee();
            employee.setAction(5);
            Socket socket = new Socket("localhost", 5002);
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.writeObject(employee);

            ObjectInputStream inputFromServer;
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            employee = (Employee) inputFromServer.readObject();
            return employee;
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "It´s imposible to connect with the server. ", e);
            return null;
        }
    }

    public static Employee getCity(int countryId) {
        try {
            Employee employee = new Employee();
            employee.setAction(6);
            employee.setCountryID(countryId);
            Socket socket = new Socket("localhost", 5002);
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.writeObject(employee);

            ObjectInputStream inputFromServer;
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            employee = (Employee) inputFromServer.readObject();
            return employee;
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "It´s imposible to connect with the server. ", e);
            return null;
        }
    }

    public static Employee searchEmployee(int id) {
        try {
            Employee employee = new Employee();
            employee.setAction(3);
            employee.setId(id);
            Socket socket = new Socket("localhost", 5002);
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.writeObject(employee);

            ObjectInputStream inputFromServer;
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            employee = (Employee) inputFromServer.readObject();
            return employee;
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "It´s imposible to connect with the server. ", e);
            return null;
        }
    }

    public static Boolean updateEmployee(Employee employee) {
        try {
            employee.setAction(2);
            Socket socket = new Socket("localhost", 5002);
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.writeObject(employee);

            ObjectInputStream inputFromServer;
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            employee = (Employee) inputFromServer.readObject();
            return employee.getMessage().equals("ok");
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "It´s imposible to connect with the server. ", e);
            return null;
        }
    }

    public static Boolean deleteEmployee(Employee employee) {
        try {
            employee.setAction(4);
            Socket socket = new Socket("localhost", 5002);
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            outputToServer.writeObject(employee);

            ObjectInputStream inputFromServer;
            inputFromServer = new ObjectInputStream(socket.getInputStream());
            employee = (Employee) inputFromServer.readObject();
            return employee.getMessage().equals("ok");
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, "It´s imposible to connect with the server. ", e);
            return null;
        }
    }
}
