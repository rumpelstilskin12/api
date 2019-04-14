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
 
       
        Cours obj = new Cours(0, "testmatiere",8);
        CoursDAO instance = new CoursDAO();
        instance.setConnection(dbConnect);
        Cours expResult = new Cours(0, "testmatiere",8);
        Cours result = instance.create(obj);

        assertEquals("Matieres différentes", expResult.getMatiere(), result.getMatiere());
        assertEquals("Heures différentes", expResult.getHeures(), result.getHeures());
        //etc
        assertNotEquals("id non généré", expResult.getIdcours(), result.getIdcours());
        int idcours = result.getIdcours();
 
        obj = new Cours(0, "testmatiere",8);
 
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
        instance.setConnection(dbConnect);
        Cours obj = new Cours(0, "testmatiere", 8);
        Cours expResult = instance.create(obj);
        idcours = expResult.getIdcours();
        Cours result = instance.read(idcours);
        assertEquals("Matiere différentes", expResult.getMatiere(), result.getMatiere());
        assertEquals("Heures différentes", expResult.getHeures(), result.getHeures());

        assertEquals("id différents", expResult.getIdcours(), result.getIdcours());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    
    /**
     * Test of update method, of class CoursDAO.
     */
    @Test
    public void testUpdate() throws Exception {
         System.out.println("update");

        CoursDAO instance = new CoursDAO();
        Cours obj = new Cours(0, "testmatiere", 8);
        instance.setConnection(dbConnect);

        obj = instance.create(obj);
      //  obj.setMatiere("TestUpdateMatiere");
        obj.setHeures(50);

        Cours expResult = obj;
        Cours result = instance.update(obj);
       // assertEquals(expResult.getMatiere(), result.getMatiere());
        assertEquals(expResult.getHeures(), result.getHeures());

        instance.delete(obj);
    }

    /**
     * Test of delete method, of class CoursDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Cours obj = new Cours(0, "testmatiere", 8);
        CoursDAO instance = new CoursDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdcours());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
    }

    /**
     * Test of rechCoursMat method, of class CoursDAO.
     */
    @Test
    public void testRechCoursMat() throws Exception {
        System.out.println("rechCoursMat");
        String matiererech = "";
       
       
        Cours obj1 = new Cours(0,"testmatiere",10);
        Cours obj2 = new Cours(0,"testmatiere2",8);
        matiererech = "testmatiere";
        CoursDAO instance = new CoursDAO();
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
       
     
        List<Cours> result = instance.rechCoursMat(matiererech);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
    }
    
}
