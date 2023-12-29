import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addFriend() {
        User conor = new User ("conorwell","12345");
        User henry = new User ("theHankstah", "12345");
        conor.addFriend(henry);
        assertEquals(conor.getFriends().get(0).getUsername(),"theHankstah");
        assertEquals(conor.getFriends().get(0).getPassword(),"12345");
    }

}