package main;
/**
 * @author Walter Wawra
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Concert.java file is used to create Concert objects that will be used to populate the Event arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 *
 * Logos class which gives logos
 */
public class Logos {
    /**
     * Description: the main and first logo seen by user
     */
    public static String mainLogo() {
        String tmLogo = 
        "                           _______      __        __  __  ____\n" +
        "                          /_  __(_)____/ /_____  / /_/  |/  (_)___  ___  _____\n" +
        "                           / / / / ___/ //_/ _ \\/ __/ /|_/ / / __ \\/ _ \\/ ___/\n" +
        "                          / / / / /__/ ,< /  __/ /_/ /  / / / / / /  __/ /\n" +
        "                         /_/ /_/\\___/_/|_|\\___/\\__/_/  /_/_/_/ /_/\\___/_/";

        return tmLogo;
        
    }
    /**
     * Description: prompt the user with a menu Logo
     */
    public static String menuLogo() {
        String mLogo = 
        "                                          __  ___\n" +
        "                                         /  |/  /__  ____  __  __\n" +
        "                                        / /|_/ / _ \\/ __ \\/ / / /\n" +
        "                                       / /  / /  __/ / / / /_/ /\n" +
        "                                      /_/  /_/\\___/_/ /_/\\__,_/";

        return mLogo;
    }
    /**
     * Description: the change logo 
     */
    public static String changeLogo() {
        String cLogo = 
        "             ________                              ______      __\n" +
        "            / ____/ /_  ____ _____  ____ ____     / ____/___ _/ /____  ____ _____  _______  __\n" +
        "           / /   / __ \\/ __ `/ __ \\/ __ `/ _ \\   / /   / __ `/ __/ _ \\/ __ `/ __ \\/ ___/ / / /\n" +
        "          / /___/ / / / /_/ / / / / /_/ /  __/  / /___/ /_/ / /_/  __/ /_/ / /_/ / /  / /_/ /\n" +
        "          \\____/_/ /_/\\__,_/_/ /_/\\__, /\\___/   \\____/\\__,_/\\__/\\___/\\__, /\\____/_/   \\__, /\n" +
        "                                 /____/                             /____/           /____/\n";

        return cLogo;
    }
    /**
     * Description: the show logo.  
     */
    public static String showLogo() {
        String sLogo = 
        "                 _____ __                     ______      __\n" +
        "                / ___// /_  ____ _      __   / ____/___ _/ /____  ____ _____  _______  __\n" +
        "                \\__ \\/ __ \\/ __ \\ | /| / /  / /   / __ `/ __/ _ \\/ __ `/ __ \\/ ___/ / / /\n" +
        "               ___/ / / / / /_/ / |/ |/ /  / /___/ /_/ / /_/  __/ /_/ / /_/ / /  / /_/ /\n" +
        "              /____/_/ /_/\\____/|__/|__/   \\____/\\__,_/\\__/\\___/\\__, /\\____/_/   \\__, /\n" +
        "                                                               /____/           /____/\n";

        return sLogo;
    }
    /**
     * Description: logo of printing event
     */
    public static String printLogo() {
        String pLogo = 
        "                            ____       _       __     ______                 __\n" +
        "                           / __ \\_____(_)___  / /_   / ____/   _____  ____  / /_\n" +
        "                          / /_/ / ___/ / __ \\/ __/  / __/ | | / / _ \\/ __ \\/ __/\n" +
        "                         / ____/ /  / / / / / /_   / /___ | |/ /  __/ / / / /_\n" +
        "                        /_/   /_/  /_/_/ /_/\\__/  /_____/ |___/\\___/_/ /_/\\__/\n";

        return pLogo;
    }
    /**
     * Description: Exit logo
     */
    public static String exitingLogo() {
        String eLogo =
        "           ______     _ __  _                _______      __        __  __  ____\n" +
        "          / ____/  __(_) /_(_)___  ____ _   /_  __(_)____/ /_____  / /_/  |/  (_)___  ___  _____\n" +
        "         / __/ | |/_/ / __/ / __ \\/ __ `/    / / / / ___/ //_/ _ \\/ __/ /|_/ / / __ \\/ _ \\/ ___/\n" +
        "        / /____>  </ / /_/ / / / / /_/ /    / / / / /__/ ,< /  __/ /_/ /  / / / / / /  __/ /\n" +
        "       /_____/_/|_/_/\\__/_/_/ /_/\\__, /    /_/ /_/\\___/_/|_|\\___/\\__/_/  /_/_/_/ /_/\\___/_/\n" +
        "                                /____/\n";

        return eLogo;
    }
}