package controller;

import data.Employee;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

public class Statements {

    public Set<String> getManagers() {
        String query = """
                      SELECT
                          "A1"."EMPL_ID"           "EMPL_ID",
                          "A1"."EMPL_NOMBRES"
                          || ' '
                          || "A1"."EMPL_APELLIDOS" "EMPL_NOMBRES"
                      FROM
                          "POLI01"."EMPLEADOS" "A1"
                      WHERE
                              "A1"."FIRED" = 0
                          AND "A1"."EMPL_CARGO_ID" = 5
                       """;

        try {
            Statement statement = ConnectionOracle.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<String> Manager = new HashSet<>();

            while (resultSet.next()) {
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    Manager.add(resultSet.getString(i) + ";" + resultSet.getString(i + 1));
                }
            }
            return Manager;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

    public Set<String> getPositons() {
        String query = """
                       SELECT
                           "A1"."CARGO_ID"     "CARGO_ID",
                           "A1"."CARGO_NOMBRE" "CARGO_NOMBRE"
                       FROM 
                           "POLI01"."CARGOS" "A1"
                       """;
        try {
            Statement statement = ConnectionOracle.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<String> Manager = new HashSet<>();

            while (resultSet.next()) {
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    Manager.add(resultSet.getString(i) + ";" + resultSet.getString(i + 1));
                }
            }
            return Manager;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

    public Set<String> getDepartments() {
        String query = """
                           SELECT
                               "A1"."DPTO_ID"     "DPTO_ID",
                               "A1"."DPTO_NOMBRE" "DPTO_NOMBRE"
                           FROM 
                               "POLI01"."DEPARTAMENTOS" "A1"
                       """;
        try {
            Statement statement = ConnectionOracle.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<String> Manager = new HashSet<>();

            while (resultSet.next()) {
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    Manager.add(resultSet.getString(i) + ";" + resultSet.getString(i + 1));
                }
            }
            return Manager;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

    public Set<String> getCountries() {
        String query = """
                               SELECT
                                   "A1"."PAIS_ID"     "PAIS_ID",
                                   "A1"."PAIS_NOMBRE" "PAIS_NOMBRE"
                               FROM
                                   "POLI01"."PAISES" "A1"
                       """;
        try {
            Statement statement = ConnectionOracle.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<String> Country = new HashSet<>();

            while (resultSet.next()) {
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    Country.add(resultSet.getString(i) + ";" + resultSet.getString(i + 1));
                }
            }
            return Country;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

    public Set<String> getCities(int CountryId) {
        String query = """
                       SELECT
                           "A1"."CIUD_ID"     "CIUD_ID",
                           "A1"."CIUD_NOMBRE" "CIUD_NOMBRE"
                       FROM
                           "POLI01"."CIUDADES" "A1"
                       WHERE
                           "A1"."CIUD_PAIS_ID" = ?
                       """;

        try {
            PreparedStatement statement = ConnectionOracle.connect().prepareStatement(query);
            statement.setInt(1, CountryId);
            ResultSet resultSet = statement.executeQuery();
            Set<String> City = new HashSet<>();
            while (resultSet.next()) {
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    City.add(resultSet.getString(i) + ";" + resultSet.getString(i + 1));
                }
            }
            return City;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

    public boolean insertEmployee(Employee employee) {
        String query = """
                       INSERT ALL INTO empleados (
                           empl_id,
                           empl_nombres,
                           empl_apellidos,
                           empl_e_mail,
                           empl_fecha_nacimiento,
                           empl_sueldo,
                           empl_comision,
                           empl_cargo_id,
                           empl_gerente_id,
                           empl_dpto_id
                       ) VALUES (
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?
                       ) INTO localizaciones (
                           loacaliz_ciudad_id,
                           localiz_direccion,
                           localiz_empl_id
                       ) VALUES (
                           ?,
                           ?,
                           ?
                       ) INTO historico (
                           emphist_cargo_id,
                           emphist_dpto_id,
                           emphist_empl_id
                       ) VALUES (
                           ?,
                           ?,
                           ?
                       ) SELECT
                             *
                         FROM
                             dual
                       """;
        try {
            PreparedStatement statement = ConnectionOracle.connect().prepareStatement(query);
            java.sql.Date date = new java.sql.Date(employee.getBirthDate().getTime());
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getEmail());
            statement.setDate(5, date);
            statement.setInt(6, employee.getSalary());
            statement.setInt(7, employee.getCommission());
            if (employee.getPositionId() == 0) {
                statement.setNull(8, java.sql.Types.NULL);
                statement.setNull(14, java.sql.Types.NULL);

            } else {
                statement.setInt(8, employee.getPositionId());
                statement.setInt(14, employee.getPositionId());

            }
            if (employee.getManagerId() == 0) {
                statement.setNull(9, java.sql.Types.NULL);
            } else {
                statement.setInt(9, employee.getManagerId());
            }
            if (employee.getDepartmentId() == 0) {
                statement.setNull(10, java.sql.Types.NULL);
                statement.setNull(15, java.sql.Types.NULL);

            } else {
                statement.setInt(10, employee.getDepartmentId());
                statement.setInt(15, employee.getDepartmentId());
            }
            if (employee.getCityId() == 0) {
                statement.setNull(11, java.sql.Types.NULL);
            } else {
                statement.setInt(11, employee.getCityId());
            }
            statement.setString(12, employee.getAdress());
            statement.setInt(13, employee.getId());
            statement.setInt(16, employee.getId());

            int row = statement.executeUpdate();
            return row >= 3;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return false;
        }
    }

    public Employee searchEmployee(int id) {

        String query = """
                          SELECT
                              emp.empl_id,
                              emp.empl_nombres,
                              emp.empl_apellidos,
                              emp.empl_e_mail,
                              emp.empl_fecha_nacimiento,
                              emp.empl_sueldo,
                              emp.empl_comision,
                              car.cargo_id
                              || ';'
                              || car.cargo_nombre,
                              emp2.empl_id
                              || ';'
                              || emp2.empl_nombres
                              || ' '
                              || emp2.empl_apellidos,
                              dep.dpto_id
                              || ';'
                              || dep.dpto_nombre,
                              pais.pais_id
                              || ';'
                              || pais.pais_nombre,
                              ciu.ciud_id
                              || ';'
                              || ciu.ciud_nombre,
                              loc.localiz_direccion
                          FROM
                                   empleados emp
                              JOIN cargos        car ON car.cargo_id = emp.empl_cargo_id
                              JOIN departamentos dep ON dep.dpto_id = emp.empl_dpto_id
                              LEFT JOIN empleados     emp2 ON emp2.empl_id = emp.empl_gerente_id
                              JOIN localizaciones loc on loc.localiz_empl_id = emp.empl_id
                              JOIN ciudades ciu on ciu.ciud_id = loc.loacaliz_ciudad_id
                              JOIN paises pais on pais.pais_id = ciu.ciud_pais_id
                          WHERE
                              emp.empl_id = ?
                       """;

        try {
            PreparedStatement statement = ConnectionOracle.connect().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Employee employee = new Employee();

            while (resultSet.next()) {
                Set<String> position = new HashSet<>();
                Set<String> manager = new HashSet<>();
                Set<String> department = new HashSet<>();
                Set<String> country = new HashSet<>();
                Set<String> city = new HashSet<>();

                employee.setId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setBirthDate(resultSet.getDate(5));
                employee.setSalary(resultSet.getInt(6));
                employee.setCommission(resultSet.getInt(7));
                position.add(resultSet.getString(8));
                employee.setPosition(position);
                manager.add(resultSet.getString(9));
                employee.setManager(manager);
                department.add(resultSet.getString(10));
                employee.setDepartment(department);
                country.add(resultSet.getString(11));
                employee.setCountry(country);
                city.add(resultSet.getString(12));
                employee.setCity(city);
                employee.setAdress(resultSet.getString(13));

                for (String i : employee.getPosition()) {
                    String[] PositionList = i.split(";");
                    employee.setPositionId(Integer.parseInt(PositionList[0]));
                }
                for (String i : employee.getDepartment()) {
                    String[] DepartmentList = i.split(";");
                    employee.setDepartmentId(Integer.parseInt(DepartmentList[0]));
                }

            }
            return employee;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

    public boolean updateEmployee(Employee employee) {

        Employee employeeBeforeUpdate = this.searchEmployee(employee.getId());
        int row = 0;
        if (employeeBeforeUpdate.getPositionId() != employee.getPositionId() || employeeBeforeUpdate.getDepartmentId() != employee.getDepartmentId()) {
            String queryHistorico = """
                                        INSERT INTO historico (
                                            emphist_cargo_id,
                                            emphist_dpto_id,
                                            emphist_empl_id
                                        ) VALUES (
                                            ?,
                                            ?,
                                            ?
                                        ) 
                                    """;
            try {
                PreparedStatement statementHistorico = ConnectionOracle.connect().prepareStatement(queryHistorico);
                statementHistorico.setInt(1, employee.getPositionId());
                statementHistorico.setInt(2, employee.getDepartmentId());
                statementHistorico.setInt(3, employee.getId());
                row = statementHistorico.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
                return false;
            }
        }

        String queryEmp = """
                       UPDATE empleados emp
                       SET
                           emp.empl_nombres = ?,
                           emp.empl_apellidos = ?,
                           emp.empl_e_mail = ?,
                           emp.empl_fecha_nacimiento = ?,
                           emp.empl_sueldo = ?,
                           emp.empl_comision = ?,
                           emp.empl_cargo_id = ?,
                           emp.empl_gerente_id = ?,
                           emp.empl_dpto_id = ?
                       WHERE
                           emp.empl_id = ?
                       """;
        try {
            PreparedStatement statementEmp = ConnectionOracle.connect().prepareStatement(queryEmp);
            java.sql.Date date = new java.sql.Date(employee.getBirthDate().getTime());
            statementEmp.setString(1, employee.getFirstName());
            statementEmp.setString(2, employee.getLastName());
            statementEmp.setString(3, employee.getEmail());
            statementEmp.setDate(4, date);
            statementEmp.setInt(5, employee.getSalary());
            statementEmp.setInt(6, employee.getCommission());
            statementEmp.setInt(7, employee.getPositionId());
            if (employee.getManagerId() == 0) {
                statementEmp.setNull(8, java.sql.Types.NULL);
            } else {
                statementEmp.setInt(8, employee.getManagerId());
            }
            statementEmp.setInt(9, employee.getDepartmentId());
            statementEmp.setInt(10, employee.getId());
            row = row + statementEmp.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return false;
        }

        String queryLoc = """
                           UPDATE localizaciones loc
                           SET
                               loc.localiz_direccion = ?,
                               loc.loacaliz_ciudad_id = ?
                           WHERE
                               loc.localiz_empl_id = ?
                       """;
        try {
            PreparedStatement statementLoc = ConnectionOracle.connect().prepareStatement(queryLoc);
            statementLoc.setString(1, employee.getAdress());
            statementLoc.setInt(2, employee.getCityId());
            statementLoc.setInt(3, employee.getId());
            row = row + statementLoc.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return false;
        }
        return row >= 1;
    }

    public boolean deleteEmployee(Employee employee) {

        int row = 0;
        String queryHistorico = """
                                    INSERT INTO historico (
                                        emphist_cargo_id,
                                        emphist_dpto_id,
                                        emphist_empl_id,
                                        emphist_fecha_retiro
                                    ) VALUES (
                                        ?,
                                        ?,
                                        ?,
                                        CURRENT_TIMESTAMP
                                    )
                                    """;
        try {
            PreparedStatement statementHistorico = ConnectionOracle.connect().prepareStatement(queryHistorico);
            statementHistorico.setInt(1, employee.getPositionId());
            statementHistorico.setInt(2, employee.getDepartmentId());
            statementHistorico.setInt(3, employee.getId());
            row = row + statementHistorico.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return false;
        }

        String queryEmp = """
                           UPDATE empleados emp
                           SET
                               emp.fired = 1
                           WHERE
                               emp.empl_id = ?
                       """;
        try {
            PreparedStatement statementEmp = ConnectionOracle.connect().prepareStatement(queryEmp);
            statementEmp.setInt(1, employee.getId());
            row = row + statementEmp.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return false;
        }
        return row >= 1;
    }

}
