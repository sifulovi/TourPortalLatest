package com.ovi.tourportal

import grails.gorm.transactions.Transactional

@Transactional
class TourBookingService {

    UserService userService
    TourService tourService

    def get(Serializable id) {
        return TourBooking.get(id)
    }

    def memberBookedTourList() {
        def list = TourBooking.list().groupBy { it?.user }
        return list
    }

    def tourWiseMemberList() {
        def list = TourBooking.list().groupBy { it?.tour }
        return list
    }

    def save(Long id) {
        User user = userService.getAuthentication()?.user
        def tour = tourService.get(id)
        def check = TourBooking.findByUserAndTour(user, tour)
        if (check?.tour?.id == tour?.id) {
            def response = AppUtil.saveResponse(false, tour)
            return response
        } else {
            TourBooking tourBooking = new TourBooking()
            tourBooking.user = userService.getCurrentMember()
            tourBooking.tour = tour
            def response = AppUtil.saveResponse(false, tour)
            if (tourBooking.validate()) {
                response.isSuccess = true
                tourBooking.save(flush: true)
            }
            return response
        }

    }

    def delete(TourBooking tourBooking) {
        try {
            tourBooking.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
}
