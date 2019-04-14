/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.SessionCours;
import formation.metier.VueSessionCoursFormateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BARCA
 */
public class SessionCoursDAOTest {
    
    
    public SessionCoursDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class SessionCoursDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        SessionCours obj = null;
        SessionCoursDAO instance = new SessionCoursDAO();
        SessionCours expResult = null;
        SessionCours result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class SessionCoursDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idsesscours = 0;
        SessionCoursDAO instance = new SessionCoursDAO();
        SessionCours expResult = null;
        SessionCours result = instance.read(idsesscours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SessionCoursDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        SessionCours obj = null;
        SessionCoursDAO instance = new SessionCoursDAO();
        SessionCours expResult = null;
        SessionCours result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SessionCoursDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        SessionCours obj = null;
        SessionCoursDAO instance = new SessionCoursDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testRech() throws Exception {
          Scanner sc = new Scanner(System.in);
          System.out.println("rechNom");
       
        
        VueSessionCoursFormateurDAO vueSession = new VueSessionCoursFormateurDAO();
        System.out.println("Veuillez entrer l'id du formateur: ");
        int idform = sc.nextInt();
        sc.skip("\n");
        try {
            System.out.println(vueSession.affichageVue(idform));
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
        
        
        
    }
    
}
