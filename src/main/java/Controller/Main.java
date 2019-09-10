/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Config.App;
import View.FrmMain;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Daryl Ospina
 */
public class Main {

    public static HttpServer server;
    public static String BASE_URI = "http://localhost:8080/analizador_lexico/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrmMain mainWindow = new FrmMain();

        java.awt.EventQueue.invokeLater(() -> {
            Main.startServer();
        });

        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }

    private static void startServer() {
        final ResourceConfig configApp = new App();
        Main.server = GrizzlyHttpServerFactory.createHttpServer(URI.create(Main.BASE_URI), configApp);
    }

}
