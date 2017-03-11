/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class TypeAdapter {
    
    
    public int[] convert(String [] strs){
        if(strs == null){
            return null;
        }
        int [] output = new int[strs.length];
        int i = 0;
        for (String str : strs) {
            output[i++] = Integer.parseInt(str);
        }
        
        return output;
    }
    
}
