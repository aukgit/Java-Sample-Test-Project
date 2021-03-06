/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Interfaces.IExtraFeeCalculator;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class Registration {

    private LinkedList<Course> clist = new LinkedList<>();

    

    public boolean addCourse(Course c) {
        Course c2 = getCourse(c.getId());
        if (c2 == null) {
            clist.add(c);
            return true;
        }

        return false;
    }

    public Course getCourse(String id) {
        if (clist.isEmpty()) {
            return null;
        }

        for (Course course : clist) {
            if (course.getId().equals(id)) {
                return course;
            }
        }

        return null;
    }

    /**
     * @returns registered course list.
     */
    public LinkedList<Course> getRegisteredCourseList() {
        return clist;
    }

    /**
     *
     * @returns summation of each course's total payment.
     */
    public int getTotal() {
        int total = 0;
        for (Course course : clist) {
            total += course.getSubTotal();
        }

        return total;
    }

    public int getGrandTotal() {
        return getExtraFeeAmount() + getTotal();
    }

    public int getExtraFeeAmount() {
        ArrayList<IExtraFeeCalculator> calcs = CourseFactory.getInstance().getExtraCalculators();
        if(calcs.isEmpty()){
            return 0;
        }
        
        int extraSum = 0,
            total = getTotal();

        for (IExtraFeeCalculator calc : calcs) {
            extraSum += calc.getExtraAmount(total);
        }

        return extraSum;
    }

}
