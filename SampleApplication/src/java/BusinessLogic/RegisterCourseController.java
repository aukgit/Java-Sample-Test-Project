/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class RegisterCourseController {

    private Registration reg;
    private JTable table;
    private boolean initializedTable = false;
    private DefaultTableModel model;


    public RegisterCourseController(JTable jtable) {
        table = jtable;
        makeNewRegistration();
        initializeCourses();

        // Remove dangaling pointers
        System.gc();
    }

    private void initializeCourses() {
        CourseFactory.getInstance().addCourse("CSE115", "Introduction to Programming", 3, 5500);
        CourseFactory.getInstance().addCourse("CSE413", "Microprocessor Lab", 2, 5500);
        CourseFactory.getInstance().addCourse("MAT116", "Precalculus", 3, 5500);
        CourseFactory.getInstance().addCourse("MAT350", "Math - V", 3, 5500);
        CourseFactory.getInstance().addCourse("CSE225", "Datastructure", 3, 5500);
        CourseFactory.getInstance().addCourse("MAT120", "Introduction to Calculus", 3, 5500);
        CourseFactory.getInstance().addCourse("CSE331", "Microprocessor Design", 3, 5500);
        CourseFactory.getInstance().addCourse("CSE311", "Introduction to database", 3, 5500);
        CourseFactory.getInstance().addCourse("CSE499", "Project", 3, 5500);
    }

    public void ClearTable() {
        DefaultTableModel defModel = getModel();
        int count = defModel.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            defModel.removeRow(i);
        }
    }

    /**
     * Create new registration.
     */
    public void makeNewRegistration() {
        configureTable();

        reg = new Registration();
        initializedTable = false;

    }

    /**
     * @return the reg
     */
    public Registration getRegistration() {
        return reg;
    }

    /**
     *
     * @param id : provide course id to add the course in the registration from
     * the course factory and add it to the table.
     * @return
     */
    public void addCourse(String id) throws Exception {
        if (id == null || id == "") {
            throw new Exception("Empty id is provided : " + id);
        }
        
        id = id.toUpperCase();
        Course c = CourseFactory.getInstance().getCourse(id);

        if (c != null) {
            if (reg.addCourse(c)) {
                addCourseToTable(c);
            }
        }

        // add that course to the table list.
        throw new Exception("Course not found in the course factory by the given id : " + id);
    }

    /**
     *
     * @param id : provide course id to add the course in the registration from
     * the course factory.
     * @return course if found in the course factory
     */
    public Course getCourseFromRegisteredList(String id) throws Exception {
        LinkedList<Course> list = reg.getRegisteredCourseList();
        for (Course course : list) {
            if (course.getId().equals(id)) {
                return course;
            }
        }

        throw new Exception("Course not found in the registered course list by the given id : " + id);
    }

    public void initializeJTableWithListData() {
        configureTable();

        for (Course course : reg.getRegisteredCourseList()) {
            addCourseToTable(course);
        }
    }

    public void addCourseToTable(Course c) {

        /*
         * 0 SL,
         * 1 Course ID,
         * 2 Title,
         * 3 Credit,
         * 4 Tuition / Credit,
         * 5 Cost
         */
        DefaultTableModel defmodel = getModel();
        int count = defmodel.getRowCount(),
                columnsCount = defmodel.getColumnCount();

        if (count == 0) {
            count = 1;
        }

        Object[] r = new Object[columnsCount];
        r[0] = count;
        r[1] = c.getId();
        r[2] = c.getTitle();
        r[3] = c.getCredit();
        r[4] = c.getTutionPerCredit();
        r[5] = c.getSubTotal();

        Object[] cal = new Object[columnsCount];

        cal[4] = "Total";
        cal[5] = reg.getTotal();

        if (count > 1) {
            defmodel.removeRow(count - 1);
        }

        defmodel.addRow(r);
        defmodel.addRow(cal);

    }

    private DefaultTableModel configureTable() {
        if (!initializedTable) {
            //table.removeAll();
            initializedTable = true;
            model = (DefaultTableModel) table.getModel();
            ClearTable();

            return model;
        }

        return getModel();
    }

    /**
     * @return the table
     */
    public JTable getJtable() {
        return table;
    }

    /**
     * @param jtable the table to set
     */
    public void setJtable(JTable jtable) {
        this.table = jtable;
    }

    /**
     * @return the model
     */
    public DefaultTableModel getModel() {
        return model;
    }

}
