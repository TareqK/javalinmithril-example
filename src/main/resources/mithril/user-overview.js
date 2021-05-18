/*
 @package io.javalin.mithril.demo;
 @import io.javalin.mithril.demo.AppFrame;
 @import io.javalin.mithril.demo.UserModel;
 */

class UserOverview {
    constructor(vnode) {
    }
    oninit(vnode) {
        return UserModel.fetch();
    }

    view(vnode) {
        return m(AppFrame, {content:
                    m("ul.user-overview-list", UserModel.list.map(function (user) {
                        return m("li",
                                m("a", {href: `/users/${user.id}`}, `${user.name} (${user.email})`)
                                )
                    })
                            )
        })
    }
}

