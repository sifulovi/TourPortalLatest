package com.ovi.tourportal

class TourPackage {

    Integer id
    String name
    Integer amount
    Tour tour


    Date dateCreated
    Date lastUpdated


    static constraints = {
    }

    static mapping = {
        version(false)
    }
}
