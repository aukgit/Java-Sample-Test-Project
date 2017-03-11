/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class TypeAdapter {

    private TypeAdapter() {
    }

    ;
    
    public static int[] convert(String[] strs) {
        if (strs == null) {
            return null;
        }
        int[] output = new int[strs.length];
        int i = 0;
        for (String str : strs) {
            output[i++] = Integer.parseInt(str);
        }

        return output;
    }

    public static <T> T getNewClassOf(String className) {
        try {
            return (T) Class.forName(className).getConstructor(String.class).newInstance();
        } catch (Exception ex) {
            Logger.getLogger(TypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
