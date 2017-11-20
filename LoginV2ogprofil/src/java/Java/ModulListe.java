/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.util.ArrayList;

/**
 *
 * @author nilsf
 */
public class ModulListe {
    
    private ArrayList<Modul> moduler;
    
    public ModulListe() {
     
        moduler = new ArrayList<Modul>();
    
}
     public void leggTilModul(Modul newModul) {
        
        moduler.add(newModul);
    
}
     
     public static void main(String [ ] args) {
        ModulListe mdl = new ModulListe();
        Modul mod = new Modul();
        mdl.leggTilModul(mod);
   
      
    }
}
