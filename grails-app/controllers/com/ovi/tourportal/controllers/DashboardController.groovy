package com.ovi.tourportal.controllers

import com.ovi.tourportal.Tour
import com.ovi.tourportal.TourBooking
import com.ovi.tourportal.TourBookingService
import com.ovi.tourportal.TourService
import com.ovi.tourportal.User
import com.ovi.tourportal.UserService


import java.sql.Timestamp
import java.text.SimpleDateFormat;


class DashboardController {

    UserService userService
    TourService tourService
    TourBookingService tourBookingService

    def index() {
        User user = userService.getAuthentication()?.user
        def list = tourService.list()
        if (user.role?.equals('ROLE_ADMIN')) {
            render(view: "adminDashboard", model: [list: list, user: user])
        } else if (user.role?.equals('ROLE_MEMBER')) {
            def newList = tourService.getListForMember()
            render(view: "memberDashboard", model: [list: newList, user: user])

        }
    }

    def memberList() {
        if (!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'authentication', action: '403')
            return
        }
        User user = userService.getAuthentication()?.user
        def list = userService.getMemberList()
        render(view: "memberList", model: [list: list, user: user])
    }

    def memberTourList() {
        User user = userService.getAuthentication()?.user
        def memberBookingCount = TourBooking.findAllByUser(user)
        [list: memberBookingCount, user: user]
    }

    def bookedTourList() {
        if (!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'authentication', action: '403')
            return
        }
        User user = userService.getAuthentication()?.user
        def userBookingCount = tourBookingService.memberBookedTourList()
        [list: userBookingCount, user: user]
    }

    def tourWiseBookedList() {
        if (!userService.getAuthentication().user.role.toString().equals('ROLE_ADMIN')) {
            redirect(controller: 'authentication', action: '403')
            return
        }
        User user = userService.getAuthentication()?.user
        def userBookingCount = tourBookingService.tourWiseMemberList()
        [list: userBookingCount, user: user]
    }
}
