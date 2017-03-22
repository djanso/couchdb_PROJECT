package wop;

import java.util.List;

import org.lightcouch.CouchDbClient;
import org.lightcouch.DesignDocument;
import org.lightcouch.Response;

import wop.model.User;

public class Main {
	
	public static void main(String[] args) 
	{
		CouchDbClient userdbClient = new CouchDbClient("userdb", true, "http", "127.0.0.1", 5984, null, null);
		
		DesignDocument designDoc;
        designDoc = userdbClient.design().getFromDesk("userdb");
        Response response;
        response = userdbClient.design().synchronizeWithDb(designDoc);
        
        List<User> users= userdbClient.view("userdb/by_all").includeDocs(true).query(User.class);
        
        if(users.size() == 0)
        {
        	StringBuffer buff1 = new StringBuffer();
        	StringBuffer buff2 = new StringBuffer();
        	StringBuffer buff3 = new StringBuffer();
        	StringBuffer buff4 = new StringBuffer();
        	
        	for(int i=0; i<1000; i++)
        	{
        		int index = i+1;
        		
        		User user = new User();
        		user.setFirstName(buff1.append(User.FIRSTNAME).append(index).toString());
        		user.setLastName(buff2.append(User.LASTNAME).append(index).toString());
        		user.setUsername(buff3.append(User.USERNAME).append(index).toString());
        		user.setPassword(buff4.append(User.PASSWORD).append(index).toString());       		
        		
        		userdbClient.save(user);

        		buff1.setLength(0);
        		buff2.setLength(0);
        		buff3.setLength(0);
        		buff4.setLength(0);
        	}
        	
        	System.out.println("end of users creation");
        	// 1 min 20 pour insérer les 1000 docs (3min30 pdt l'installation d'un programme en parallèle..)
        }
        else
        {       	           
            StringBuffer buff = new StringBuffer();
            String lineSep = System.lineSeparator();
            String space = ": ";
            for(User user: users)
            {
            	buff.append(User.FIRSTNAME).append(space).append(user.getFirstName()).append(lineSep)
            		.append(User.LASTNAME).append(space).append(user.getLastName()).append(lineSep)
            		.append(User.USERNAME).append(space).append(user.getUsername()).append(lineSep)
            		.append(User.PASSWORD).append(space).append(user.getPassword()).append(lineSep);
            	
            	System.out.println(buff.toString());
            	buff.setLength(0);
            }
        }
        	        
        userdbClient.shutdown();;
        
        System.out.println("end of connection");
	}
}
