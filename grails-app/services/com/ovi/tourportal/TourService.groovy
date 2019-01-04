package com.ovi.tourportal

import grails.web.servlet.mvc.GrailsParameterMap

import java.sql.Timestamp
import java.text.SimpleDateFormat


class TourService {

    GlobalConfigService globalConfigService
    UserService userService
    TourPackageService tourPackageService

    def save(GrailsParameterMap params) {
        Tour tour = new Tour(params)
        tour.member = userService.getCurrentMember()
        def response = AppUtil.saveResponse(false, tour)
        if (tour.validate()) {
            response.isSuccess = true
            tour.save(flush: true)
            if (params.amount) {
                tourPackageService.saveTourPackages(tour, params.amount, params.name)
            }
        }
        return response
    }

    def update(Tour tour, GrailsParameterMap params) {
        tour.properties = params
        def response = AppUtil.saveResponse(false, tour)
        if (tour.validate()) {
            response.isSuccess = true
            tour.save(flush: true)
            if (params.amount) {
                tourPackageService.updateTourPackages(tour, params.amount, params.name , params.packageId)
            }
        }
        return response
    }

    def get(Serializable id) {
        return Tour.get(id)
    }


    def getListForMember(){
        Date date= new Date()
        def currentDate=AppUtil.getDateToTimestamp(date)
        def MemberList = Tour.findAllByLastDateGreaterThanEquals(currentDate)
        return  MemberList
    }


    def list(){
        return Tour.list()
    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: globalConfigService.itemsPerPage()
        List<Tour> tourList = Tour.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }

            eq("member", userService.getCurrentMember())
        }
        return [list: tourList, count: Tour.count()]
    }

    def delete(Tour tour) {
        def tourBooking = TourBooking.findAllByTour(tour)
        if (tourBooking.tour.size() == 0) {
            tour.delete(flush: true)
            true
        }
    }
}
