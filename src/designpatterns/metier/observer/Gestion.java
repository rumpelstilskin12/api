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
         Local loc1 = new Local(1,"local 1",10,"description local 1");
         Local loc2 = new Local(2,"local 2",20,"description local 2");
         Formateur f1= new Formateur(1,"13400","paul","pogba","5","rue de bobo","mons",6030,"0486531113");
         Formateur f2= new Formateur(2,"14567","george","marc","","rue de toto","charleroi",6040,"0486521112");
         
         loc1.addObserver(f1);
         loc1.addObserver(f2);
         loc2.addObserver(f1);
         
         loc1.setSigle("F40");
         loc2.setSigle("M16");
    }
    
}
