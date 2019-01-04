package com.ovi.tourportal


class GlobalConfigService {

    UserService userService

    public static boolean isBuilding = false;
    public static boolean isGeneratingSchema = false;

    def itemsPerPage() {
        return 5
    }

    public static String getUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }

}
