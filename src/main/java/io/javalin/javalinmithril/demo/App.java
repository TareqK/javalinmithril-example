/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javalin.javalinmithril.demo;

import io.javalin.Javalin;
import io.javalin.core.security.Role;
import static io.javalin.core.security.SecurityUtil.roles;
import io.javalin.core.util.Header;
import io.javalin.http.Context;
import io.javalin.javalinmithril.demo.controller.UserController;
import io.javalin.plugin.rendering.mithril.JavalinMithril;
import io.javalin.plugin.rendering.mithril.MithrilComponent;
import static java.util.Collections.singletonMap;

/**
 *
 * @author tareq
 */
public class App {

    private Javalin app;

    public enum AppRole implements Role {
        ANYONE,
        LOGGED_IN;
    }

    void start() {
        app = Javalin.create();
        app.config.enableWebjars();
        app.config.accessManager((handler, ctx, permittedRoles) -> {
            if (permittedRoles.contains(AppRole.ANYONE) || (permittedRoles.contains(AppRole.LOGGED_IN) && currentUser(ctx) != null)) {
                handler.handle(ctx);
            } else {
                ctx.status(401).header(Header.WWW_AUTHENTICATE, "Basic");
            }
        });

        JavalinMithril.configure(config -> {
            config.isDev(true)
                    .stateFunction((ctx) -> singletonMap("currentUser", currentUser(ctx)));
        });

        app.get("/", new MithrilComponent("io.javalin.mithril.demo.HelloWorld"), roles(AppRole.ANYONE));
        app.get("/users", new MithrilComponent("io.javalin.mithril.demo.UserOverview"), roles(AppRole.ANYONE));
        app.get("/users/:user-id", new MithrilComponent("io.javalin.mithril.demo.UserProfile"), roles(AppRole.LOGGED_IN));
        app.error(404, "html", new MithrilComponent("io.javalin.mithril.demo.NotFound"));

        app.get("/api/users", UserController::getAll, roles(AppRole.ANYONE));
        app.get("/api/users/:user-id", UserController::getOne, roles(AppRole.LOGGED_IN));
        app.exception(Exception.class, (ex, ctx) -> {
            ex.printStackTrace();
        });
        app.start(8000);
    }

    private String currentUser(Context ctx) {
        return ctx.basicAuthCredentialsExist() ? ctx.basicAuthCredentials().getUsername() : null;

    }

}
