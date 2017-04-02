package com.org.wop.model;

import java.util.List;

import org.lightcouch.Document;

/**
 * Class representing the conceptual object of a User with the same structure
 * than its serialized document in the database
 * 
 * @author ArnaudTessandier
 *
 */
public class User extends Document
{
    public final static String LINE_SEPARATOR        = System.lineSeparator();
    public final static String SPACE_AND_DOUBLE_DOTS = ": ";
    public final static String AT                    = "@";
    public final static String DOT                   = ".";

    public final static String FIRSTNAME = "firstname";
    public final static String LASTNAME  = "lastname";
    public final static String EMAIL     = "email";
    public final static String USERNAME  = "username";
    public final static String PASSWORD  = "password";
    public final static String TICKETS   = "tickets";

    private String       firstName;
    private String       lastName;
    private String       email;
    private String       username;
    private String       password;
    private List<Ticket> tickets;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Ticket> getTickets()
    {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets)
    {
        this.tickets = tickets;
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();

        buff.append(User.FIRSTNAME).append(SPACE_AND_DOUBLE_DOTS).append(this.getFirstName()).append(LINE_SEPARATOR)
                .append(User.LASTNAME).append(SPACE_AND_DOUBLE_DOTS).append(this.getLastName()).append(LINE_SEPARATOR)
                .append(User.EMAIL).append(SPACE_AND_DOUBLE_DOTS).append(this.getEmail()).append(LINE_SEPARATOR)
                .append(User.USERNAME).append(SPACE_AND_DOUBLE_DOTS).append(this.getUsername()).append(LINE_SEPARATOR)
                .append(User.PASSWORD).append(SPACE_AND_DOUBLE_DOTS).append(this.getPassword()).append(LINE_SEPARATOR);

        return buff.toString();
    }
}
