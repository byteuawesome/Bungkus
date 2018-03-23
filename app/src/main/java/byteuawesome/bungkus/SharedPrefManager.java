package byteuawesome.bungkus;


import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by Laptop's on 2017-09-26.
 */

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static String missingValueError = "Data Is Missing!";

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_ID = "userid";

    private final String KEY_PRODUCT_ID = "productid";
    private final String KEY_PRODUCT_NAME = "productname";
    private final String KEY_PRODUCT_PRICE = "productprice";
    private final String KEY_PRODUCT_STOCK = "productstock";
    private final String KEY_PRODUCT_DESCRIPTION = "productdescription";

    private final String KEY_SERVER_DATE = "sdate";

    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id, String username, String date) {

        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_SERVER_DATE, date);
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedpreferences.getString(KEY_USERNAME, null) != null) {
            return true;
        }

        return false;
    }

    public String getUsername() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(KEY_USERNAME, null);
    }

    public boolean logout() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.clear();
        editor.apply();
        return true;

    }


    public String getServerDate(){
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(KEY_SERVER_DATE, null);
    }

    public boolean setServerDateToApp(String date){


        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(KEY_SERVER_DATE, date);
        editor.apply();
        return true;
    }




    public boolean saveProductData(int id, String pname, String pprice, String pstock, String pdesc) {

        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putInt(KEY_PRODUCT_ID, id);
        editor.putString(KEY_PRODUCT_NAME, pname);
        editor.putString(KEY_PRODUCT_PRICE, pprice);
        editor.putString(KEY_PRODUCT_STOCK, pstock);
        editor.putString(KEY_PRODUCT_DESCRIPTION, pdesc);
        editor.apply();
        return true;
    }

    public String getKeyProductName() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(KEY_PRODUCT_NAME, missingValueError);
    }

    public String getKeyProductPrice() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(KEY_PRODUCT_PRICE, missingValueError);
    }

    public String getKeyProductStock() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(KEY_PRODUCT_STOCK, missingValueError);
    }

    public String getKeyProductDescription() {
        SharedPreferences sharedpreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(KEY_PRODUCT_DESCRIPTION, missingValueError);
    } // Get Saved Product Data


}