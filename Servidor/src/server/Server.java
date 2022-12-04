package server;

import controller.Statements;
import data.Employee;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {

    Statements statements = new Statements();

    public static void main(String[] args) {
        try {
            Server obj = new Server();
            obj.run(args);
        } catch (Exception e) {
        }

    }

    public void run(String[] args) throws Exception {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(5002);

            Employee employee;

            while (true) {
                Socket client = server.accept();
                ObjectInputStream objectInput = new ObjectInputStream(client.getInputStream());
                employee = (Employee) objectInput.readObject();
                InetAddress location = client.getInetAddress();
                String remoteIp = location.getHostAddress();
                switch (employee.getAction()) {
                    case 1 -> {
                        if (statements.insertEmployee(employee)) {
                            employee.setMessage("ok");
                        } else {
                            employee.setMessage("error");
                        }
                        SentData(client, employee);
                    }
                    case 2 -> {
                        if (statements.updateEmployee(employee)) {
                            employee.setMessage("ok");
                        } else {
                            employee.setMessage("error");
                        }
                        SentData(client, employee);
                    }
                    case 3 -> {
                        employee = statements.searchEmployee(employee.getId());
                        employee.setMessage("search");
                        SentData(client, employee);
                    }
                    case 4 -> {
                        if (statements.deleteEmployee(employee)) {
                            employee.setMessage("ok");
                        } else {
                            employee.setMessage("error");
                        }
                        SentData(client, employee);

                    }
                    case 5 -> {
                        employee.setMessage("complete");
                        employee.setManager(statements.getManagers());
                        employee.setPosition(statements.getPositons());
                        employee.setDepartment(statements.getDepartments());
                        employee.setCountry(statements.getCountries());
                        SentData(client, employee);
                    }
                    case 6 -> {
                        employee.setCity(statements.getCities(employee.getCountryID()));
                        employee.setMessage("ok");
                        SentData(client, employee);
                    }
                    default -> {
                        employee.setMessage("none");
                        SentData(client, employee);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "It´s imposible to start the server. ", e);
        }

    }

    public void SentData(Socket socket, Employee employee) {
        try {
            OutputStream outputToClient = socket.getOutputStream();
            ObjectOutputStream dataToClient = new ObjectOutputStream(outputToClient);
            dataToClient.writeObject(employee);
            dataToClient.close();
            socket.close();
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "It´s imposible to send the object. ", e);

        }

    }

}
