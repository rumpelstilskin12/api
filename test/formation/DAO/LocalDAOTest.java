/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.Cours;
import formation.metier.Formateur;
import formation.metier.Infos;
import formation.metier.Local;
import formation.metier.SessionCours;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
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
public class LocalDAOTest {
    
  
    static Connection dbConnect;
 
    public LocalDAOTest() {
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
     * Test of create method, of class LocalDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
 
       
        Local obj = new Local(0, "TeS",10, "TestDescription");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local expResult = new Local(0, "TeS",10, "TestDescription");
        Local result = instance.create(obj);
 
        assertEquals("Sigle différents", expResult.getSigle(), result.getSigle());
        assertEquals("Places différents", expResult.getPlaces(), result.getPlaces());
        assertEquals("Description différents", expResult.getDescription(), result.getDescription());
        //etc
        assertNotEquals("id non généré", expResult.getIdlocal(), result.getIdlocal());
        int idlocal = result.getIdlocal();
 
        obj = new Local(0, "TestSigle2",10, "TestDescription");
 
        try {
            obj = instance.create(obj);
            fail("exception de doublon non générée");
            instance.delete(obj);
 
        } catch (SQLException e) {
        }
 
        instance.delete(result);
    }
 
    /**
     * Test of readSigle method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSigle() throws Exception {
        System.out.println("readSigle");
        String sigle="";
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local obj = new Local(0,"TeS",10,"description");
        Local expResult = instance.create(obj);
        sigle=expResult.getSigle();
        Local result = instance.readSigle(sigle);
        assertEquals("Sigles différents",expResult.getSigle(), result.getSigle());//sigle different
        try{
            result=instance.read(0);
            fail("Exception d'un code inconnu");
        }
        catch(SQLException e){}
       instance.delete(result);

    }
 
    /**
     * Test of read method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
       
        System.out.println("read");
        int idlocal = 0;
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local obj = new Local(0, "TeS",10, "TestDescription");
        Local expResult = instance.create(obj);
        idlocal = expResult.getIdlocal();
        Local result = instance.read(idlocal);
        assertEquals("Sigle différents", expResult.getSigle(), result.getSigle());
        assertEquals("Places différents", expResult.getPlaces(), result.getPlaces());
        assertEquals("Description différents", expResult.getDescription(), result.getDescription());
        //etc
        assertEquals("id différents", expResult.getIdlocal(), result.getIdlocal());
        try {
            result = instance.read(0); //0 est la seule valeur dans la bdd qui n'est pas donné dans la bdd car l'auto incrément commence à 1
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }
 
    /**
     * Test of update method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Local obj = new Local(0, "TeS",10, "TestDescription");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setSigle("TeS");
       
        Local expResult = obj;
        Local result = instance.update(obj);
        assertEquals(expResult.getSigle(), result.getSigle());
 
        instance.delete(obj);
 
    }
 
    /**
     * Test of delete method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
 
        System.out.println("delete");
        Local obj = new Local(0, "TeS",10, "TestDescription");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdlocal());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
         obj=instance.create(obj);
        Cours cours=new Cours(0,"testmatiere",10);
       CoursDAO coursd= new CoursDAO();
       coursd.setConnection(dbConnect);
       cours=coursd.create(cours);
       
        Formateur formateur=new Formateur(0,"Testmatricule","Testnom","Testprenom","10","Testrue","Testlocalite",6025,"Testtel");
        FormateurDAO formateurd=new FormateurDAO();
        formateurd.setConnection(dbConnect);
        formateur=formateurd.create(formateur);
        
        SessionCours sessionCours=new SessionCours(0,LocalDate.of(2018, Month.APRIL, 12),LocalDate.of(2019, Month.MARCH, 13),15,obj.getIdlocal(),cours.getIdcours());
        SessionCoursDAO sessionCoursd= new SessionCoursDAO();
        sessionCoursd.setConnection(dbConnect);
        sessionCours=sessionCoursd.create(sessionCours);
        
        
        Infos infos = new Infos(0,10,formateur.getIdform(),sessionCours.getIdsesscours());
        InfosDAO infosd= new InfosDAO();
        infosd.setConnection(dbConnect);
        infos=infosd.create(infos);
        
        try{
            instance.delete(obj);
            fail("Exception de record de parent clé etrangere");
        }
        catch(Exception e){}
        infosd.delete(infos);
        sessionCoursd.delete(sessionCours);
        formateurd.delete(formateur);
        coursd.delete(cours);
        instance.delete(obj);
        
    }
 
    /**
     * Test of rechDescription method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRechDescription() throws Exception {
        System.out.println("rechDescription");
        String descriptionrech = "";
       
       
        Local obj1 = new Local(0,"TeS",10,"testdescription");
        Local obj2 = new Local(0,"TsF",8,"testdescription");
        descriptionrech = "testdescription";
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
       
     
        List<Local> result = instance.rechLocalDesc(descriptionrech);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
    }

    
}
