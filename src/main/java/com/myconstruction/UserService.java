package com.myconstruction;
import java.util.HashMap;
import java.util.Map;
public class UserService {


	 private static Map<String, String> users = new HashMap<>();

	    static {
	        users.put("admin", "password");
	        users.put("user", "user123");
	    }

	    public boolean authenticate(String username, String password) {
	        // Verifica si el usuario existe y si la contraseña es correcta.
	        return users.containsKey(username) && users.get(username).equals(password);
	    }
}
