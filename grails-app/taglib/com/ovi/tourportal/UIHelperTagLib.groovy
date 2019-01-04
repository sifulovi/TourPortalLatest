package com.ovi.tourportal


class UIHelperTagLib {

    static namespace = "UIHelper"

    UserService userService

    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage ? g.message(code: attrs.errorMessage) : g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)) {
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

    def memberActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") { userService.getMemberName() }
        out << '<div class="dropdown-menu">'
        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item") {
            g.message(code: "logout")
        }
        out << "</div></li>"
    }

    def appAdmin = { attrs, body ->

        [
                [controller: "dashboard", action: "index", name: "dashboard"],
                [controller: "tour", action: "index", name: "Generate Tour"],
                [controller: "dashboard", action: "memberList", name: "List Of Member"],
                [controller: "dashboard", action: "bookedTourList", name: "Member Wise Booked Tour List"],
                [controller: "dashboard", action: "tourWiseBookedList", name: "Tour Wise Booked Member List"],
        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }
    def appMember = { attrs, body ->
        [
                [controller: "dashboard", action: "index", name: "List Of Tour"],
                [controller: "dashboard", action: "memberTourList", name: "My Booking List"],
        ].each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

}
