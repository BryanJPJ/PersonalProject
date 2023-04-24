package personalproject.demo.utils;

public class RouteFileUploadImage {
    private static String pathImageUser = "src/main/resources/static/images/user-photos/";
    private static String pathImageEvent = "src/main/resources/static/images/event-photos/";
    private static String pathImageAboutUs = "src/main/resources/static/images/aboutus-photos/";
    private static String pathImageTravel = "src/main/resources/static/images/travel-photos/";

    public static String pathToSaveImage(String typeOfImage) {
        if (typeOfImage == "imageUser") {
            return pathImageUser;
        }

        if (typeOfImage == "imageEvent") {
            return pathImageEvent;
        }

        if (typeOfImage == "imageAboutUs") {
            return pathImageAboutUs;
        }

        if (typeOfImage == "imageTravel") {
            return pathImageTravel;
        }

        return null;
    }
}
