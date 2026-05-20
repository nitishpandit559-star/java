import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeGUI extends JFrame implements ActionListener {

    JLabel lblId, lblName, lblDepartment, lblSalary;

    JTextField txtId, txtName, txtDepartment, txtSalary;

    JButton btnAdd, btnView, btnUpdate, btnDelete, btnClear;

    JTextArea area;

    EmployeeManagement emp = new EmployeeManagement();

    public EmployeeGUI() {

        setTitle("Employee Management System");

        setSize(600, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // TOP PANEL
        JPanel top = new JPanel();

        top.setLayout(new GridLayout(4, 2));

        lblId = new JLabel("Employee ID");
        lblName = new JLabel("Employee Name");
        lblDepartment = new JLabel("Department");
        lblSalary = new JLabel("Salary");

        txtId = new JTextField();
        txtName = new JTextField();
        txtDepartment = new JTextField();
        txtSalary = new JTextField();

        top.add(lblId);
        top.add(txtId);

        top.add(lblName);
        top.add(txtName);

        top.add(lblDepartment);
        top.add(txtDepartment);

        top.add(lblSalary);
        top.add(txtSalary);

        add(top, BorderLayout.NORTH);

        // BUTTON PANEL
        JPanel middle = new JPanel();

        btnAdd = new JButton("Add");
        btnView = new JButton("View");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        middle.add(btnAdd);
        middle.add(btnView);
        middle.add(btnUpdate);
        middle.add(btnDelete);
        middle.add(btnClear);

        add(middle, BorderLayout.CENTER);

        // TEXT AREA
        area = new JTextArea();

        JScrollPane pane = new JScrollPane(area);

        add(pane, BorderLayout.SOUTH);

        // ACTION LISTENER
        btnAdd.addActionListener(this);
        btnView.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            int id = Integer.parseInt(txtId.getText());

            String name = txtName.getText();

            String department = txtDepartment.getText();

            double salary = Double.parseDouble(txtSalary.getText());

            // ADD
            if (e.getSource() == btnAdd) {

                Employee empObj =
                    new Employee(id, name, department, salary);

                emp.addEmployee(empObj);

                area.setText("Employee Added Successfully!");
            }

            // VIEW
            if (e.getSource() == btnView) {

                area.setText(emp.viewEmployees());
            }

            // UPDATE
            if (e.getSource() == btnUpdate) {

                boolean status =
                    emp.updateEmployee(id, name, department, salary);

                if (status) {

                    area.setText("Employee Updated Successfully!");
                }

                else {

                    area.setText("Employee Not Found!");
                }
            }

            // DELETE
            if (e.getSource() == btnDelete) {

                boolean status = emp.deleteEmployee(id);

                if (status) {

                    area.setText("Employee Deleted Successfully!");
                }

                else {

                    area.setText("Employee Not Found!");
                }
            }

            // CLEAR
            if (e.getSource() == btnClear) {

                txtId.setText("");
                txtName.setText("");
                txtDepartment.setText("");
                txtSalary.setText("");

                area.setText("");
            }

        }

        catch (Exception ex) {

            area.setText("Please Enter Valid Data!");
        }
    }

    public static void main(String[] args) {

        new EmployeeGUI();
    }
}
