package com.ovi.tourportal.controllers

import com.ovi.tourportal.AppUtil
import com.ovi.tourportal.Tour
import com.ovi.tourportal.TourBooking
import com.ovi.tourportal.TourService
import com.ovi.tourportal.User
import com.ovi.tourportal.UserService

class TourController {

    TourService tourService
    UserService userService

    def index() {
        if(!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'authentication', action: '403')
            return
        }
        User user = userService.getAuthentication()?.user
        def response = tourService.list(params)
        [list: response.list, total: response.count, user: user]
    }

    def show(Integer id) {
        User user = userService.getAuthentication()?.user
        def response = Tour.get(id)
        if (!response) {
            redirect(controller: "tour", action: "index")
        } else {
            [list: response, user: user ]
        }
    }

    def create() {
        if(!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'authentication', action: '403')
            return
        }

        User user = userService.getAuthentication()?.user
        [tour: flash.redirectParams, user: user]
    }

    def save() {

        def response = tourService.save(params)
        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "tour", action: "index")
        } else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "tour", action: "create")
        }
    }

    def edit(Tour tour) {
        if(!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
        User user = userService.getAuthentication()?.user
        render(view: "edit", model: [tour: tour, user: user, message: flash.redirectParams])
    }


    def update(Tour tour) {
        if(!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')){
            redirect(controller: 'auth', action: '403')
            return
        }
         if (!tour) {
             flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
             redirect(controller: "tour", action: "index")
         } else {
             def response = tourService.update(tour, params)
             if (!response.isSuccess) {
                 flash.redirectParams = response.model
                 flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                 redirect(controller: "tour", action: "edit")
             } else {
                 flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                 redirect(controller: "tour", action: "index")
             }
         }

    }

    def delete(Integer id) {
        def response = tourService.get(id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "tour", action: "index")
        } else {
            response = tourService.delete(response)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "tour.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "tour", action: "index")
        }
    }


}
