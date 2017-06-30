package com.t5online.geolocationmodule;

import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.t5online.nebulacore.Nebula;
import com.t5online.nebulacore.bridge.NebulaActivity;
import com.t5online.nebulacore.bridge.NebulaWebView;
import com.t5online.nebulacore.service.GeolocationService;
import com.t5online.nebulacore.service.PluginService;

import shared.plugin.GeolacationPlugin;

public class MainActivity extends NebulaActivity {

    public static final String TARGET_URL = "http://www.t5online.com:9080/nebula/test/geolocation.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (NebulaWebView) findViewById(R.id.webView);
        webView.loadUrl(TARGET_URL);
    }

    @Override
    public void registerServices() {
        super.registerServices();
        Nebula.registerService(new GeolocationService(this), GeolocationService.SERVICE_KEY_GEOLOCATION);
    }

    @Override
    public void loadPlugins() {
        super.loadPlugins();
        PluginService pluginService = (PluginService) Nebula.getService(PluginService.SERVICE_KEY_PLUGIN);
        pluginService.addPlugin("shared.plugin.GeolacationPlugin", GeolacationPlugin.PLUGIN_GROUP_GEOLOACTION);
    }

    @Override
    public int getWebViewFrameID() {
        return R.id.activity_main;
    }
}
