import com.ovi.tourportal.UserService

class SecurityInterceptor {

    UserService userService

    SecurityInterceptor() {
        matchAll().excludes(controller: "authentication")

    }

    boolean before() {
        if (!userService.isAuthenticated()) {
            redirect(controller: "authentication", action: "login")
            return false
        }
        return true
    }

}
