/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

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
public class LocalDAOTest {
    
    static Connection dbConnect;

    public LocalDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
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
        Local obj = new Local(0,"TeS",10,"description");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local expResult = new Local(0,"TeS",10,"description");
        Local result = instance.create(obj);
        
        assertEquals("sigle différents",expResult.getSigle(), result.getSigle());
        assertEquals("places différents",expResult.getPlaces(), result.getPlaces());
        assertEquals("description différents",expResult.getDescription(), result.getDescription());
        //etc
        assertNotEquals("id non généré",expResult.getIdlocal(),result.getIdlocal());
        int idlocal=result.getIdlocal();
        obj=new Local(0,"TeS",10,"description");
        try{
            Local result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        }
        catch(SQLException e){}
        instance.delete(result);

    }

    /**
     * Test of read method, of class LocalDAO.
     */
    @Test
    public void testRead() throws Exception {
       
        System.out.println("read");
        int idlocal = 0;
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local obj = new Local(0,"TeS",10,"description");
        Local expResult = instance.create(obj);
        idlocal=expResult.getIdlocal();
        Local result = instance.read(idlocal);
        assertEquals("sigle différents",expResult.getSigle(), result.getSigle());
        assertEquals("places différents",expResult.getPlaces(), result.getPlaces());
        assertEquals("description différents",expResult.getDescription(), result.getDescription());
        //etc
        assertEquals("id différents",expResult.getIdlocal(),result.getIdlocal());
        try{
            result=instance.read(0);
            fail("exception d'id inconnu non générée");
        }
        catch(SQLException e){}
       instance.delete(result);

    }

    /**
     * Test of readSigle method, of class LocalDAO.
     */
    @Test
    public void testReadSigle() throws Exception {
       System.out.println("readSigle");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local obj = new Local(0,"TeS",10,"description");
        Local expResult = instance.create(obj);
        String Sigle=expResult.getSigle();
        Local result = instance.readSigle(Sigle);
        assertEquals("sigle différents",expResult.getSigle(), result.getSigle());
        assertEquals("places différents",expResult.getPlaces(), result.getPlaces());
        assertEquals("description différents",expResult.getDescription(), result.getDescription());
        //etc
        /*assertEquals("id différents",expResult.getIdlocal(),result.getIdlocal());
        try{
            result=instance.readSigle(Sigle);
            fail("exception de sigle inconnu ");
        }
        catch(SQLException e){}
        */
       instance.delete(result);

    }

    /**
     * Test of update method, of class LocalDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Local obj = new Local(0,"TeS",10,"description");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setPlaces(5);
        //etc
        obj.setDescription("description");
        //etc
        Local expResult=obj;
        Local result = instance.update(obj);
        assertEquals(expResult.getPlaces(), result.getPlaces());
        //etc
        assertEquals(expResult.getDescription(), result.getDescription());
        //etc
        instance.delete(obj);
    }

    /**
     * Test of delete method, of class LocalDAO.
     */
    @Test
    public void testDelete() throws Exception {
       System.out.println("delete");
        Local obj = new Local(0,"TeS",10,"description");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.readSigle(obj.getSigle());
            fail("exception de record introuvable non générée");
        }
        catch(SQLException e){}
        //TODO vérifier qu'on a bien une exception en cas de record parent de clé étrangère

    }

    /**
     * Test of rechLocalDesc method, of class LocalDAO.
     */
    @Test
    public void testRechLocalDesc() throws Exception {
        System.out.println("rechLocalDesc");
        Local obj1 = new Local(0,"TeS",10,"description");
        Local obj2 = new Local(0,"TeS",10,"description");
        String localRdesc = "TestDescription";
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        
      
        List<Local> result = instance.rechLocalDesc(localRdesc);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
       
    }
    
}
