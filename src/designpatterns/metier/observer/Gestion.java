/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author BARCA
 */
public class Gestion {
    public static void main(String[] args) {
        //LocalDate xmas = LocalDate.parse(2, DateTimeFormatter.ISO_DATE)
         SessionCours s1 = new SessionCours(3,/* LocalDate.parse("2019/04/11", DateTimeFormatter.ISO_DATE), LocalDate.parse("2019/05/5", DateTimeFormatter.ISO_DATE),*/ 23,1,2);
         SessionCours s2 = new SessionCours(4,/* LocalDate.parse("2019/04/15",DateTimeFormatter.ISO_DATE),LocalDate.parse("2019/05/06",DateTimeFormatter.ISO_DATE),*/ 15,1,2);
         Formateur f1= new Formateur(3,"13400","paul","pogba","5","rue de bobo","mons",6030,"0486531113");
         Formateur f2= new Formateur(4,"14567","george","marc","","rue de toto","charleroi",6040,"0486521112");
         
         s1.addObserver(f1);
         s1.addObserver(f2);
         s2.addObserver(f1);
         
         s1.setIdlocal(1);
         s2.setIdlocal(2);
    }
    
}
