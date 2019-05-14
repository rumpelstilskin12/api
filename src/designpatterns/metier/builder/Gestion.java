/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.builder;

/**
 *
 * @author BARCA
 */
public class Gestion {
    
   
       public static void main(String[] args)  {
        
        try {
            Formateur f1 = new Formateur.FormateurBuilder(1,"16789","George","Archi").setLocalite("mons").build();
            System.out.println(f1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
        
            try {
            Formateur f2 = new Formateur.FormateurBuilder(0,"13008","Henry","George").setLocalite("mons").build();
                    
                System.out.println(f2);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
        
    }
}
    
    

    

