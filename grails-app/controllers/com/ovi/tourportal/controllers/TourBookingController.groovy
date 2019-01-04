package com.ovi.tourportal.controllers

import com.ovi.tourportal.AppUtil
import com.ovi.tourportal.TourBookingService


class TourBookingController {

    TourBookingService tourBookingService

    def create(Integer id) {
        def response = tourBookingService.save(id)

        if (response.isSuccess) {
            flash.message = AppUtil.infoMessage(g.message(code: "booking"))
            redirect(controller: "dashboard", action: "index")
        } else {
            flash.message = AppUtil.infoMessage(g.message(code: "booked"))
            redirect(controller: "dashboard", action: "index")
        }
    }

    def delete(Integer id) {
        def response = tourBookingService.get(id)
        if (!response) {
            flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "dashboard", action: "memberTourList")
        } else {
            response = tourBookingService.delete(response)
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "tour.delete"), false)
            } else {
                flash.message = AppUtil.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "dashboard", action: "memberTourList")
        }
    }

}
