@package io.javalin.mithril.demo;
@import io.javalin.mithril.demo.AppFrame;

class NotFound{
    constructor(){
        
    }
    
    view(vnode){
        m(AppFrame,{
            content:m("h1","Page Not Found (error 404)")
        })
    }
}


