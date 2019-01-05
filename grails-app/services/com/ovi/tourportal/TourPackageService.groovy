package com.ovi.tourportal

import grails.gorm.transactions.Transactional

@Transactional
class TourPackageService {

    TourService tourService

    def saveTourPackages(Tour tour, def amount, def name) {
        if (name instanceof String && amount instanceof String && !amount.equals("")) {
            new TourPackage(tour: tour, amount: amount, name: name).save(flush: true)
        } else {
            int index = 0
            amount.each {
                if (it) {
                    tour.addToTourPackage([name: name[index], amount: it]).save(flush: true)
                    index++
                }
            }
        }
    }


    def getTourPackageByTourId(Serializable id) {
        def tour = tourService.get(id)
        if (tour) {
            return TourPackage.createCriteria().list {
                eq("tour", tour)
            }
        }
        return []
    }

    def updateTourPackages(Tour tour, def amount, def name, def packageId) {
        if (name instanceof String && amount instanceof String ) {
            updateTourPackage(packageId, name, amount)
        } else {
            Integer index = 0
            String packageName
            String packageAmount
            def serviceAmountId
            amount.each {
                packageAmount = it
                packageName = name.getAt(index)
                serviceAmountId = getTourPackages(packageId, index)
                if (serviceAmountId) {
                    updateTourPackage(serviceAmountId, packageName, packageAmount)
                } else {
                    if (packageAmount) {
                        tour.addToTourPackage([name: name[index], amount: it]).save(flush: true)
                    }
                }
                index++
            }
        }
    }

    def updateTourPackage(def id, String packageName, String packageAmount) {
        TourPackage tourPackage = TourPackage.get(id)

        if (tourPackage) {
            tourPackage.name = packageName
            tourPackage.amount = Integer.valueOf(packageAmount)
            tourPackage.save(flush: true)
        }
    }

    private Integer getTourPackages(def packageId, Integer index) {
        try {
            return Integer.parseInt(packageId.getAt(index))
        } catch (Exception e) {
            return null
        }
    }


    def deleteTourPackages(Serializable id) {
        TourPackage tourPackage = TourPackage.get(id)
        if (tourPackage) {
            tourPackage.delete(flush: true)
            return AppUtil.infoMessage("Deleted")
        }
        return AppUtil.infoMessage("Unable to Delete", false)
    }


}
