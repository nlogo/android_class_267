package domain.company.simpleui.simpleui;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by user on 2016/6/23.
 */
public class SimpleUIApplication extends Application{

   @Override
    public void onCreate(){
       super.onCreate();

       ParseObject.registerSubclass(Order.class);
       ParseObject.registerSubclass(Drink.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4lJnFFsOjdqGrziKA0Yt8d3GRWjazfPmgHUca2Ty")
                .server("https://parseapi.back4app.com/")
                .clientKey("YFCsPD9YM5s3RhGf9I66bNmEyxVeLr2qKYnp7RwO")
                .enableLocalDataStore()
        .build()
        );
       FacebookSdk.sdkInitialize(this);
       AppEventsLogger.activateApp(this);
    }

}
