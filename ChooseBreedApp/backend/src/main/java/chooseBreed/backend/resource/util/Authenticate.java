package chooseBreed.backend.resource.util;

import org.mindrot.jbcrypt.BCrypt;

public class Authenticate {

    public static boolean authenticate(String user, String pass, String correctUser, String correctPass){
        return user.equals(correctUser) && BCrypt.checkpw(pass, correctPass);
    }
}
