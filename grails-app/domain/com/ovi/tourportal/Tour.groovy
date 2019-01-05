package com.ovi.tourportal

class Tour {
    Date dateCreated
    Date lastUpdated

    Integer id
    String title
    String description
    String image

    int day
    Date fromDate
    Date toDate
    User member
    Date lastDate

    static hasMany = [tourPackage: TourPackage]


    static constraints = {
        image(nullable: true, blank: true)
        member(nullable: true, blank: true)
        tourPackage(nullable: true)
        description type: 'text'
        title(unique: true)
        fromDate(nullable: false)
        toDate(nullable: false)
        lastDate(nullable: false)

    }

    static mapping = {
        version(false)
        tourPackage(cascade: 'all-delete-orphan')
        member(cascade: 'all-delete-orphan')
    }

    @Override
    String toString() {
        title
    }
}
