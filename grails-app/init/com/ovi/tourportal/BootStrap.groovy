package com.ovi.tourportal

class BootStrap {


    def init = { servletContext ->

        User admin = new User()
        admin.firstName ="Admin"
        admin.lastName ="admin"
        admin.email="admin@gmail.com"
        admin.role="ROLE_ADMIN"
        admin.password="123456"
        admin.phoneNo="01677759373"

        admin.save(failOnError :true)

    }

    def destroy = {
    }
}
