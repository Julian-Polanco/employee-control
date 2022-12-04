package client;

import data.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class InsertEmployee extends javax.swing.JFrame {

    private Employee employee = new Employee();

    public InsertEmployee() {
        initComponents();
        employee = Client.getSelects();
        for (String i : employee.getManager()) {
            String[] ManagerList = i.split(";");
            Manager list = new Manager();
            list.setId(Integer.parseInt(ManagerList[0]));
            list.setFirstName(ManagerList[1]);
            this.manager.addItem(list);
        }
        for (String i : employee.getPosition()) {
            String[] PositionList = i.split(";");
            Position list = new Position();
            list.setId(Integer.parseInt(PositionList[0]));
            list.setPositionName(PositionList[1]);
            this.position.addItem(list);
        }
        for (String i : employee.getDepartment()) {
            String[] DepartmentList = i.split(";");
            Department list = new Department();
            list.setId(Integer.parseInt(DepartmentList[0]));
            list.setDepartmentName(DepartmentList[1]);
            this.department.addItem(list);
        }
        for (String i : employee.getCountry()) {
            String[] CountryList = i.split(";");
            Country list = new Country();
            list.setId(Integer.parseInt(CountryList[0]));
            list.setCountryName(CountryList[1]);
            this.Country.addItem(list);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        birthDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        commission = new javax.swing.JTextField();
        position = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        manager = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Country = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        city = new javax.swing.JComboBox<>();
        adress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 800));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel1.setText("Cedula");
        jLabel1.setToolTipText("");

        id.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        id.setPreferredSize(new java.awt.Dimension(250, 30));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel2.setText("Nombres");
        jLabel2.setToolTipText("");

        firstName.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        firstName.setPreferredSize(new java.awt.Dimension(250, 30));
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos");
        jLabel3.setToolTipText("");

        lastName.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        lastName.setPreferredSize(new java.awt.Dimension(250, 30));
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel4.setText("Email");
        jLabel4.setToolTipText("");

        email.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        email.setPreferredSize(new java.awt.Dimension(250, 30));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        birthDate.setDateFormatString("dd-MM-yyyy");
        birthDate.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        birthDate.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de nacimiento");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel6.setText("Sueldo");
        jLabel6.setToolTipText("");

        salary.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        salary.setPreferredSize(new java.awt.Dimension(250, 30));
        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel7.setText("Comisión");
        jLabel7.setToolTipText("");

        commission.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        commission.setPreferredSize(new java.awt.Dimension(250, 30));
        commission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commissionActionPerformed(evt);
            }
        });

        position.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        position.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel8.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel8.setText("Cargo");
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel9.setText("Gerente");
        jLabel9.setToolTipText("");

        manager.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        manager.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel10.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel10.setText("Departamento");
        jLabel10.setToolTipText("");

        department.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        department.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel11.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        jLabel11.setText("Inserta un nuevo empleado");
        jLabel11.setToolTipText("");

        back.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        back.setText("Volver");
        back.setPreferredSize(new java.awt.Dimension(120, 40));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        insertBtn.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        insertBtn.setText("Insertar");
        insertBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel12.setText("Pais");
        jLabel12.setToolTipText("");

        Country.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        Country.setPreferredSize(new java.awt.Dimension(250, 30));
        Country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel13.setText("Ciudad");
        jLabel13.setToolTipText("");

        city.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        city.setPreferredSize(new java.awt.Dimension(250, 30));

        adress.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        adress.setPreferredSize(new java.awt.Dimension(250, 30));
        adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adressActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel14.setText("Dirección");
        jLabel14.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel9)
                    .addComponent(manager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel8))
                    .addComponent(commission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed

    }//GEN-LAST:event_idActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed

    }//GEN-LAST:event_firstNameActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed

    }//GEN-LAST:event_lastNameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed

    }//GEN-LAST:event_emailActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed

    }//GEN-LAST:event_salaryActionPerformed

    private void commissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commissionActionPerformed

    }//GEN-LAST:event_commissionActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Home home = new Home();
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        try {
            Manager managerObj = (Manager) this.manager.getSelectedItem();
            int managerId = managerObj == null ? 0 : managerObj.getId();

            Department departmentObj = (Department) this.department.getSelectedItem();
            int departmentId = departmentObj == null ? 0 : departmentObj.getId();

            Position positionObj = (Position) this.position.getSelectedItem();
            int positionId = positionObj == null ? 0 : positionObj.getId();

            Country countryObj = (Country) this.Country.getSelectedItem();
            int countryId = countryObj == null ? 0 : countryObj.getId();

            City cityObj = (City) this.city.getSelectedItem();
            int cityId = cityObj == null ? 0 : cityObj.getId();
            
            employee.setAction(1);
            employee.setId(Integer.parseInt(this.id.getText()));
            employee.setFirstName(this.firstName.getText());
            employee.setLastName(this.lastName.getText());
            employee.setEmail(this.email.getText());
            employee.setBirthDate(this.birthDate.getDate());
            employee.setSalary(Integer.parseInt(this.salary.getText()));
            employee.setCommission(Integer.parseInt(this.commission.getText()));
            employee.setManagerId(managerId);
            employee.setDepartmentId(departmentId);
            employee.setPositionId(positionId);
            employee.setCityId(cityId);
            employee.setCountryID(countryId);
            employee.setAdress(adress.getText());
            if (Client.Insert(this.employee)) {
                JOptionPane.showMessageDialog(null, "Datos insertados correctamente.");
                Home home = new Home();
                this.setVisible(false);
                home.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ups, algo salio mal, porfavor intenta mas tarde o revisa tus datos.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor revisa los datos e intenta nuevamente.");
        } catch (HeadlessException e) {

        }
    }//GEN-LAST:event_insertBtnActionPerformed

    private void adressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adressActionPerformed

    private void CountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryActionPerformed
        Country countryObj = (Country) this.Country.getSelectedItem();
        employee = Client.getCity(countryObj.getId());
        this.city.removeAllItems();
        for (String i : employee.getCity()) {
            String[] CityList = i.split(";");
            City list = new City();
            list.setId(Integer.parseInt(CityList[0]));
            list.setCityName(CityList[1]);
            this.city.addItem(list);
        }
    }//GEN-LAST:event_CountryActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> Country;
    private javax.swing.JTextField adress;
    private javax.swing.JButton back;
    private com.toedter.calendar.JDateChooser birthDate;
    private javax.swing.JComboBox<City> city;
    private javax.swing.JTextField commission;
    private javax.swing.JComboBox<Department> department;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField id;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lastName;
    private javax.swing.JComboBox<Manager> manager;
    private javax.swing.JComboBox<Position> position;
    private javax.swing.JTextField salary;
    // End of variables declaration//GEN-END:variables
}
