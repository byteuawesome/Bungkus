package byteuawesome.bungkus;

import android.support.annotation.NonNull;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Laptop on 2/18/2018.
 */

public class Constant {

    private static String SERVER_URL = "192.168.137.207";

    private static String ROOT_URL = "http://"+SERVER_URL+"/bungkus_backend/android/v1/";

    public static String URL_REGISTER = ROOT_URL + "registerUser.php";

    public static String URL_LOGIN = ROOT_URL + "userLogin.php";

    public static String URL_SEARCH_PRODUCT = ROOT_URL + "searchProduct.php";




    @NonNull
    public static String formatCurrency(Integer i) {
        String string = String.valueOf(i);

        if (string.length() > 3) {
            return "Rp. " + String.valueOf(NumberFormat.getNumberInstance(Locale.GERMANY).format(i));
        } else if (string.length() == 0 || string.contentEquals("0") || string.isEmpty()) {
            return "Rp. " + "-";
        } else {
            return "Rp. " + string;
        }
    }

    @NonNull
    public static String formatCurrency(String string) {

        if (string.length() > 3) {
            return "Rp. " + String.valueOf(NumberFormat.getNumberInstance(Locale.GERMANY).format(Integer.parseInt(string)));
        } else if (string.length() == 0 || string.contentEquals("0") || string.isEmpty()) {
            return "Rp. " + "-";
        } else {
            return "Rp. " + string;
        }
    }

}
