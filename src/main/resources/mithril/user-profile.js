@package io.javalin.mithril.demo;
@import io.javalin.mithril.demo.AppFrame;
@import io.javalin.mithril.demo.UserModel;
class UserProfile {
    constructor(vnode) {
    }
    oninit(vnode){
        return UserModel.fetchOne(window.javalin.pathParams["user-id"]);
    }

    view(vnode) {
        return m(AppFrame,{content:
            UserModel.current ? m("dl",[
                m("dt","User ID"),
                m("dd",UserModel.current.id),
                m("dt","User Name"),
                m("dd",UserModel.current.name),
                m("dt","Email"),
                m("dd",UserModel.current.email),
                m("dt","Birthday"),
                m("dd",UserModel.current.userDetails.dateOfBirth),
                m("dt","Salary"),
                m("dd",UserModel.current.userDetails.salary)
            ]) : null
        })
    }
}