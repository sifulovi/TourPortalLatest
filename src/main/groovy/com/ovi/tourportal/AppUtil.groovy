package com.ovi.tourportal

import org.grails.web.util.WebUtils

import java.sql.Timestamp
import java.text.SimpleDateFormat

class AppUtil {



    static getDateToTimestamp(){
        Date date = new Date()
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S")
        def currentDate = dateFormat.format(date)
        Date parsedDate = dateFormat.parse(currentDate)
        Timestamp timestamp = new Timestamp(parsedDate.getTime())
        return timestamp
    }


    static saveResponse(Boolean isSuccess, def model) {
        return [isSuccess: isSuccess, model: model]
    }

    static getAppSession() {
        return WebUtils.retrieveGrailsWebRequest().session
    }

    static infoMessage(String message, boolean status = true) {
        return [info: message, success: status]
    }

    static infoBookedMessage(String message) {
        return [info: message]
    }

}
