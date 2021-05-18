/*
 @package io.javalin.mithril.demo;
 */
class AppFrame {
    constructor(content) {
    }

    view(vnode) {
        return m("div.app-frame", [
            m("header", [
                m("span", "Javalin Mithril Demo App"),
                window.javalin.state.currentUser ? m("span", `Current User : '${window.javalin.state.currentUser}'`) : null,
            ]),
            vnode.attrs.content
        ]
                )
    }
}
