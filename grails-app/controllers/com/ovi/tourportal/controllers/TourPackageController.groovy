package com.ovi.tourportal.controllers

import com.ovi.tourportal.TourPackageService
import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TourPackageController {

    TourPackageService tourPackageService

    def tourPackages() {
        [tourPackages: tourPackageService.getTourPackageByTourId(params.id)]
    }

    def delete(Integer id){
        render(tourPackageService.deleteTourPackages(id) as JSON)
    }
}
