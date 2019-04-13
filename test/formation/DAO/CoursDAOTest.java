/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import static formation.DAO.LocalDAOTest.dbConnect;
import formation.metier.Cours;
import formation.metier.Local;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import myconnections.DBConnection;
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
public class CoursDAOTest {
      static Connection dbConnect;
    public CoursDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
          dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("Connexion invalide");
            System.exit(1);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CoursDAO.
     */
    @Test
    public void testCreate() throws Exception {
       System.out.println("create");
 
       
        Cours obj = new Cours(0, "testmatiere",10);
        CoursDAO instance = new CoursDAO();
        instance.setConnection(dbConnect);
        Cours expResult = new Cours(0, "testmatiere",10);
        Cours result = instance.create(obj);
 
        assertEquals("Idcours différents", expResult.getIdcours(), result.getIdcours());
        assertEquals("Matieres différentes", expResult.getMatiere(), result.getMatiere());
        assertEquals("Heures différentes", expResult.getHeures(), result.getHeures());
        //etc
        assertNotEquals("id non généré", expResult.getIdcours(), result.getIdcours());
        int idcours = result.getIdcours();
 
        obj = new Cours(0, "testmatiere2",10);
 
        try {
            obj = instance.create(obj);
            fail("exception de doublon non générée");
            instance.delete(obj);
 
        } catch (SQLException e) {
        }
 
        instance.delete(result);
    }

    /**
     * Test of read method, of class CoursDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idcours = 0;
        CoursDAO instance = new CoursDAO();
        Cours expResult = null;
        Cours result = instance.read(idcours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CoursDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Cours obj = null;
        CoursDAO instance = new CoursDAO();
        Cours expResult = null;
        Cours result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CoursDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Cours obj = null;
        CoursDAO instance = new CoursDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechCoursMat method, of class CoursDAO.
     */
    @Test
    public void testRechCoursMat() throws Exception {
        System.out.println("rechCoursMat");
        String coursRechMatiere = "";
        CoursDAO instance = new CoursDAO();
        List<Cours> expResult = null;
        List<Cours> result = instance.rechCoursMat(coursRechMatiere);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
