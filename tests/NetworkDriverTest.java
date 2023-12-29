import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkDriverTest {

    @Test
    void initConnection(){
        try{
            NetworkDriver networkDriver = new NetworkDriver();
            return;
        }catch(Exception e){
            fail("Connection couldn't be established. Check server status and login info");
        }
    }

    @Test
    void dbEditAccess(){
        try{
            NetworkDriver networkDriver = new NetworkDriver();
            Statement testStatement = networkDriver.network.createStatement();
            testStatement.executeUpdate("create table testtable (testcolumn varchar(20);");
            testStatement.executeUpdate("insert into testtable values ('testvalue')");
            ResultSet searchSet = testStatement.executeQuery("select * from testtable;");
            String value;
            while (searchSet.next()) {
                value = searchSet.getString("testcolumn");
            }
            assertEquals(value,"testvalue");
            Statement removeStatement = networkDriver.network.createStatement();
            removeStatement.executeUpdate("delete from testtable where testcolumn='testvalue';");
            ResultSet emptySet = testStatement.executeQuery("select * from testtable;");
            String shouldBeEmpty = null;
            while (emptySet.next()) {
                shouldBeEmpty = searchSet.getString("testcolumn");
            }
            assertNull(shouldBeEmpty);
            Statement dropStatement = networkDriver.network.createStatement();
            dropStatement.executeUpdate("drop table testtable;");
            return;
        }catch(Exception e){
            fail("Connection established but user needs database edit access");
        }
    }
}