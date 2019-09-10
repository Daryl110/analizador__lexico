/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Daryl Ospina
 */
public class App extends ResourceConfig{
    public App(){
        /* Injectables */
        register(new AppBinder());
        /* Controllers */
        packages(true, "Controller.API");
    }
}
