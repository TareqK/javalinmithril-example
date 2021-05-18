/*
 @package io.javalin.mithril.demo;
 @import io.javalin.mithril.demo.AppFrame;
 */
class HelloWorld {
    constructor() {

    }

    view(vnode) {
        return m(AppFrame, {content: [
                m("h1.hello-world", "Hello World !"),
                m("a", {href: "/users"}, "View user Overview"),
            ]
        })
    }
}
