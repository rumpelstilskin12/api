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
            
            Formateur f1 = new Formateur.FormateurBuilder()
                    .setIdform(0)//zero
                    .setMatricule("13456")
                    .setNom("paul")
                    .setPrenom("marc").setNum("12")
                    .setRue("rue des anges")
                    .setLocalite("jannah").setCp(6070).setTel("0486531718").build();
                    
                 
            System.out.println(f1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
        
        try{
            Formateur f2 = new Formateur.FormateurBuilder()
                    .setIdform(1)
                    .setMatricule("16768")
                    .setNom("paul")
                    .setPrenom("marc").setNum("13")
                    .setRue("rue louis")
                    .setLocalite("hebs").setCp(6080).setTel("127927192").build();
            
            System.out.println(f2);
            
        }catch(Exception e){
            System.out.println("erreur"+e);
        }
    }
       
        
        
}
    
    

    

