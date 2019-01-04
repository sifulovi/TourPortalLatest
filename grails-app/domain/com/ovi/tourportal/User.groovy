package com.ovi.tourportal

class User {
    Integer id
    String firstName
    String lastName
    String email
    String phoneNo
    String role
    String password

    Date dateCreated
    Date lastUpdated

    static hasMany = [tour: Tour]

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        firstName(blank: false)
        phoneNo(blank: false,nullable: false,)
        lastName(nullable: true, blank: true)
    }

    static mapping = {
        version(false)
        tour(cascade: 'all-delete-orphan')
    }
    @Override
    String toString() {
        firstName + " " + lastName
    }


    /*def beforeInsert = {
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate = {
        this.password = this.password.encodeAsMD5()
    }
*/


}
