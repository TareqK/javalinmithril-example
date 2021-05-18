/*
 @package io.javalin.mithril.demo;
 */

class UserModel {

}

UserModel.list = [];
UserModel.current = null;
UserModel.fetch = function () {
    m.request("/api/users").then(function (result) {
        UserModel.list = result;
    })
};

UserModel.fetchOne = function (id) {
    m.request(`/api/users/${id}`).then(function (result) {
        UserModel.current = result;
    })
};
