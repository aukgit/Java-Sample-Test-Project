/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampleapplication;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private int tutionPerCredit;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * @return the tutionPerCredit
     */
    public int getTutionPerCredit() {
        return tutionPerCredit;
    }

    /**
     * @param tutionPerCredit the tutionPerCredit to set
     */
    public void setTutionPerCredit(int tutionPerCredit) {
        this.tutionPerCredit = tutionPerCredit;
    }
    
    public int getSubTotal(){
        return getCredit() * getTutionPerCredit();
    }

}
