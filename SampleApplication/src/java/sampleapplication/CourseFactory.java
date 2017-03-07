/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampleapplication;

import java.util.LinkedList;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class CourseFactory {
    private LinkedList<Course> clist;
    
    private void addCourse(string id, string title, int credit, int ){
        
    }    
    
    private Course getCourse(String id){
        for (Course course : clist) {
             if(course.getId().equals(id)){
                return course;
            }
        }
        
        return null;
    }
}
