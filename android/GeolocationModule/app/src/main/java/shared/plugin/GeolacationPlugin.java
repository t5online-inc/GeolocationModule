package shared.plugin;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.t5online.nebulacore.Nebula;
import com.t5online.nebulacore.plugin.Plugin;
import com.t5online.nebulacore.service.GeolocationService;

import org.json.JSONObject;

/**
 * Created by sungju on 2017. 6. 26..
 */

public class GeolacationPlugin extends Plugin {

    public void get(int interval) {

        GeolocationService geolocationService = (GeolocationService) Nebula.getService(GeolocationService.SERVICE_KEY_GEOLOCATION);
        geolocationService.startObserve(interval*1000, new GeolocationService.GeolocationListener() {
            @Override
            public void geolocationService(Location location) {
                try {
                    JSONObject object = new JSONObject();
                    object.put("lat", location.getLatitude());
                    object.put("long", location.getLongitude());
                    resolve(object);
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
        });
    }

    public void stop(){
        GeolocationService geolocationService = (GeolocationService) Nebula.getService(GeolocationService.SERVICE_KEY_GEOLOCATION);
        geolocationService.stopObserve();
    }
}
