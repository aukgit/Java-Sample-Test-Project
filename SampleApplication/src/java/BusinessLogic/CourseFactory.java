/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.LinkedList;

/**
 *
 * @author Md. Alim Ul Karim Think of this class as a virtual database. Collects
 * all initial courses.
 */
public class CourseFactory {

    private LinkedList<Course> clist = new LinkedList<>();

    public void addCourse(String id, String title, int credit, int tutionPerCredit) {
        Course c = getCourse(id);
        if (c == null) {
            c = new Course();
            c.setId(id);
            c.setTitle(title);
            c.setCredit(credit);
            c.setTutionPerCredit(tutionPerCredit);

            clist.add(c);
        }
    }

    public Course getCourse(String id) {
        if (!clist.isEmpty()) {
            for (Course course : clist) {
                if (course.getId().equals(id)) {
                    return course;
                }
            }
        }
        return null;
    }
}
