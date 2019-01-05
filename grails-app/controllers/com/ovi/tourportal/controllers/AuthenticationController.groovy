package com.ovi.tourportal.controllers

import com.ovi.tourportal.AppUtil
import com.ovi.tourportal.User
import com.ovi.tourportal.UserService


class AuthenticationController {

    UserService userService

    def index() {
        redirect(controller: "dashboard", action: "index")
    }

    def login() {
    }


    def registration() {
        [member: flash.redirectParams]
    }

    def doLogin() {

        if (userService.doLogin(params.email, params.password)) {
            redirect(controller: "dashboard", action: "index")
        } else {
            redirect(controller: "authentication", action: "login")
        }

    }

    def doRegistration() {
        def response = userService.registerMember(params)
        if (response.isSuccess) {
            userService.setMemberAuthorization(response.model)

            redirect(controller: "dashboard", action: "index")
        } else {
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }

    def doChangePassword() {
        if (userService.isAuthenticated()) {
            def response = userService.changePassword(params.password, params.newPassword, params.renewPassword)
            flash.message = response
            if (response.success) {
                redirect(controller: "dashboard", action: "index")
            } else {
                redirect(controller: "authentication", action: "changePassword")
            }
        } else {
            redirect(controller: "authentication", action: "login")
        }
    }

    def changePassword() {
        if (!userService.isAuthenticated()) {
            redirect(controller: "dashboard", action: "index")
        }
    }


    def forgotPassword() {
        if (userService.isAuthenticated()) {
            redirect(controller: "dashboard", action: "index")
        }
    }


    def logout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }


    def deleteMember (Integer id){

        def response = userService.get(id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "tour", action: "index")
        } else {
            response = userService.delete(response)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "member.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "unable.to.delete"))
            }
            redirect(controller: "dashboard", action: "memberList")
        }
    }

    def '403'(){}
}
