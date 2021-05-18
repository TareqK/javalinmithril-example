/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javalin.javalinmithril.demo.model;

/**
 *
 * @author tareq
 */
public class User implements Cloneable {

    public String id;
    public String name;
    public String email;
    public UserDetails userDetails = new UserDetails();

    public User() {

    }

    public User(String id, String name, String email, UserDetails userDetails) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userDetails = userDetails;
    }

    @Override
    public User clone() {
        return new User(id, name, email, userDetails);
    }

    public static class UserDetails {

        public String dateOfBirth;
        public String salary;

        public UserDetails() {

        }

        public UserDetails(String dateOfBirth, String salary) {
            this.dateOfBirth = dateOfBirth;
            this.salary = salary;
        }
    }

}
