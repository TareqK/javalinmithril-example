/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javalin.javalinmithril.demo.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.javalinmithril.demo.model.User;
import io.javalin.javalinmithril.demo.model.User.UserDetails;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author tareq
 */
public class UserController {

    private static final Set<User> users = new HashSet<>();

    static {
        users.add(new User("1", "John", "john@fake.co", new UserDetails("21.02.1964", "2773 JB")));
        users.add(new User("2", "Mary", "mary@fake.co", new UserDetails("12.05.1994", "1222 JB")));
        users.add(new User("3", "Dave", "dave@fake.co", new UserDetails("01.05.1984", "1833 JB")));
        users.add(new User("4", "Jane", "jane@fake.co", new UserDetails("30.12.1989", "1532 JB")));
        users.add(new User("5", "Eric", "eric@fake.co", new UserDetails("14.09.1973", "2131 JB")));
        users.add(new User("6", "Gina", "gina@fake.co", new UserDetails("16.08.1977", "1982 JB")));
        users.add(new User("7", "Ryan", "ryan@fake.co", new UserDetails("07.11.1988", "1638 JB")));
        users.add(new User("8", "Judy", "judy@fake.co", new UserDetails("05.01.1959", "2983 JB")));
    }

    public static void getAll(Context ctx) {
        ctx.json(users.stream().map(User::clone).map(user -> {
            user.userDetails = null;
            return user;
        }).collect(Collectors.toList()));
    }

    public static void getOne(Context ctx) {
        ctx.json(users.stream().filter(user -> user.id.equals(ctx.pathParam("user-id"))).findFirst().orElseThrow(NotFoundResponse::new));
    }

}
