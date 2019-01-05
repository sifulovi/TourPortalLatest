package com.ovi.tourportal

import grails.web.servlet.mvc.GrailsParameterMap

class UserService {

    UserService userService

    private static final String AUTHORIZED = "AUTHORIZED"

    def registerMember(GrailsParameterMap params) {
        User member = new User(params)
        member.role="ROLE_MEMBER"  //member role added
        def response = AppUtil.saveResponse(false, member)
        if (member.validate()) {
            response.isSuccess = true
            member.save()
        }
        return response
    }

    def setMemberAuthorization(User user) {
        def authorization = [isLoggedIn: true, user: user]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password){
        User user = User.findByEmailAndPassword(email , password)
        if (user){
            setMemberAuthorization(user)
            return true
        }
        return false
    }

    boolean isAuthenticated(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn){
            return true
        }
        return false
    }

    def getMember(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        return authorization?.user
    }

    def getMemberName(){
        def user = getMember()
        return "${user.firstName} ${user.lastName}"
    }

    def getCurrentMember(){
        return getMember()
    }

    def getMemberList(){
        def list = User.findAllByRole("ROLE_MEMBER")
        return  list
    }

    def getAuthentication() {
        return AppUtil.getAppSession()[AUTHORIZED]
    }

    def changePassword(String oldPassword, String newPassword, String retrievePassword){
        User member = getCurrentMember()
        if (!newPassword || !retrievePassword || !newPassword.equals(retrievePassword)) {
            return AppUtil.infoMessage("Your Entered Password Not Matched.", false)
        } else if (member && !member.password.equals(oldPassword.encodeAsMD5())) {
            return AppUtil.infoMessage("Incorrect Old Password.", false)
        } else {
            member = User.get(member.id)
            member.password = newPassword
            member.save(flush: true)
            setMemberAuthorization(member)
        }
        return AppUtil.infoMessage("Password Changed")
    }

    def get(Serializable id) {
        return User.get(id)
    }

    def delete(User member){
        member.delete(flush: true)

    }


}
