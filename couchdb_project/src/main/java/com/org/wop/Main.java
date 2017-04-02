package com.org.wop;

import java.util.List;

import org.lightcouch.CouchDbClient;
import org.lightcouch.DesignDocument;
import org.lightcouch.Response;

import com.org.wop.model.User;

public class Main
{

    public static void main(String[] args)
    {
        CouchDbClient userdbClient = new CouchDbClient("userdb", true, "http", "127.0.0.1", 5984, null, null);

        System.out.println("connected to: " + userdbClient.getDBUri());

        DesignDocument designDoc = userdbClient.design().getFromDesk("userdb");
        Response response = userdbClient.design().synchronizeWithDb(designDoc);

        final int numberOfDocs = 10000;
        final long startCreation = System.currentTimeMillis();
        List<User> users = userdbClient.view("userdb/by_all").includeDocs(true).query(User.class);

        if (users.size() == 0)
        {
            StringBuffer buff1 = new StringBuffer();
            StringBuffer buff2 = new StringBuffer();
            StringBuffer buff3 = new StringBuffer();
            StringBuffer buff4 = new StringBuffer();
            StringBuffer buff5 = new StringBuffer();

            for (int i = 0; i < numberOfDocs; i++)
            {
                int index = i + 1;

                User user = new User();
                user.setFirstName(buff1.append(User.FIRSTNAME).append(index).toString());
                user.setLastName(buff2.append(User.LASTNAME).append(index).toString());
                user.setEmail(buff3.append(user.getFirstName()).append(User.DOT).append(user.getLastName())
                        .append(User.AT).append("gmail.com").toString());
                user.setUsername(buff4.append(User.USERNAME).append(index).toString());
                user.setPassword(buff5.append(User.PASSWORD).append(index).toString());

                userdbClient.save(user);

                buff1.setLength(0);
                buff2.setLength(0);
                buff3.setLength(0);
                buff4.setLength(0);
                buff5.setLength(0);

                System.out.println(index);
            }
        } else
        {
            for (User user : users)
            {
                System.out.println(user.toString());
            }
        }

        final long endCreation = System.currentTimeMillis();
        final long durationOfCreation = endCreation - startCreation;
        final long durationInSec = durationOfCreation / 1000;

        System.out.println("\n" + "end of " + numberOfDocs + " users creation" + "\n" + "Duration: "
                + durationOfCreation + " ms" + "\n" + "Duration: " + durationInSec + " s");

        // userdbClient.context().deleteDB("userdb", "delete database");
        userdbClient.shutdown();
        System.out.println("connection closed");

    }
}
