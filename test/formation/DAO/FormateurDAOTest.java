/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import static formation.DAO.CoursDAOTest.dbConnect;
import formation.metier.Formateur;
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
public class FormateurDAOTest {
    static Connection dbConnect;
    public FormateurDAOTest() {
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
     * Test of create method, of class FormateurDAO.
     */
    @Test
    public void testCreate() throws Exception {
       System.out.println("create");
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 6030, "TestTel");
        FormateurDAO instance = new FormateurDAO();

        instance.setConnection(dbConnect);

        Formateur expResult = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 6030, "TestTel");
        Formateur result = instance.create(obj);

        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Nom différents", expResult.getNom(), result.getNom());
        assertEquals("Prenom différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Numero différents", expResult.getNumero(), result.getNumero());
        assertEquals("Rue différentes", expResult.getRue(), result.getRue());
        assertEquals("Localite différentes", expResult.getLocalite(), result.getLocalite());
        assertEquals("CP différents", expResult.getCp(), result.getCp());
        assertEquals("Tel différentes", expResult.getTel(), result.getTel());

        assertNotEquals("Identifiant non généré", expResult.getIdform(), result.getIdform());
        int idform = result.getIdform();

        obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero2", "TestRue2", "TestLocalite2", 6020, "TestTel");

        try {
            obj = instance.create(obj);
            fail("exception de doublon non générée");
            instance.delete(obj);

        } catch (SQLException e) {
        }

        obj = new Formateur(0, "TestMatricule2", "TestNom2", "TestPrenom2", "TestNumero2", "TestRue2", "TestLocalite2", 200, "TestTel2");

        try {
            obj = instance.create(obj);
            fail("exception de code postal non générée");
            instance.delete(obj);

        } catch (Exception e) {
        }

        instance.delete(result);
    }

    /**
     * Test of read method, of class FormateurDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idform = 0;
        FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 6030, "TestTel");
        Formateur expResult = instance.create(obj);
        idform = expResult.getIdform();
        Formateur result = instance.read(idform);

        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Nom différents", expResult.getNom(), result.getNom());
        assertEquals("Prenom différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Numero différents", expResult.getNumero(), result.getNumero());
        assertEquals("Rue différentes", expResult.getRue(), result.getRue());
        assertEquals("Localite différentes", expResult.getLocalite(), result.getLocalite());
        assertEquals("CP différents", expResult.getCp(), result.getCp());
        assertEquals("Tel différentes", expResult.getTel(), result.getTel());

        assertEquals("id différents", expResult.getIdform(), result.getIdform());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of readMatricule method, of class FormateurDAO.
     */
    @Test
    public void testReadMatricule() throws Exception {
        System.out.println("readMatricule");
        String matricule = "";
        
         FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite",6030, "TestTel");
        Formateur expResult = instance.create(obj);
        matricule = expResult.getMatricule();
        Formateur result = instance.readMatricule(matricule);

        assertEquals("Sigles differents", expResult.getMatricule(), result.getMatricule());

        try {
            result = instance.read(0);
            fail("Exception d'un code inconnu non géneré");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class FormateurDAO.
     */
    @Test
    public void testUpdate() throws Exception {
       System.out.println("update");

        FormateurDAO instance = new FormateurDAO();
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 6030, "TestTel");
        instance.setConnection(dbConnect);

        obj = instance.create(obj);
        obj.setNom("TestUpdateNom");
        obj.setPrenom("TestUpdatePrenom");
        obj.setNumero("TestUpdateNum");
        obj.setRue("TestUpdateRue");
        obj.setLocalite("TestUpdateLoc");
        obj.setCp(1111);
        obj.setTel("TestUpdateTel");

        Formateur expResult = obj;
        Formateur result = instance.update(obj);
        assertEquals("Nom différents", expResult.getNom(), result.getNom());
        assertEquals("Prenom différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Numero différents", expResult.getNumero(), result.getNumero());
        assertEquals("Rue différentes", expResult.getRue(), result.getRue());
        assertEquals("Localite différentes", expResult.getLocalite(), result.getLocalite());
        assertEquals("CP différents", expResult.getCp(), result.getCp());
        assertEquals("Tel différentes", expResult.getTel(), result.getTel());

        instance.delete(obj);
    }

    /**
     * Test of delete method, of class FormateurDAO.
     */
    @Test
    public void testDelete() throws Exception {
         System.out.println("delete");
        Formateur obj =  new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite",6030, "TestTel");
        FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdform());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
    }
    }
    /**
     * Test of rechFormNom method, of class FormateurDAO.
     */
    @Test
    public void testRechFormNom() throws Exception {
     System.out.println("rechercheNomFormateur");
        String nomrech = "";
       
       
        Formateur obj1 = new Formateur(0,"testmatricule","testnom","testprenom","numero","rue","localite",6030,"testtel");
        Formateur obj2 = new Formateur(0,"testmatricule2","testnom2","testprenom2","numero2","rue2","localite2",6050,"testtel2");
        nomrech = "testnom";
        FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
       
     
        List<Formateur> result = instance.rechFormNom(nomrech);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);   
    }
    
}
