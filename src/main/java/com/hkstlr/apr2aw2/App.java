package com.hkstlr.apr2aw2;

import static io.undertow.Handlers.resource;
import io.undertow.Undertow;
import io.undertow.server.handlers.resource.FileResourceManager;
import java.io.File;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(final String[] args) {
        try {
            Undertow server = Undertow.builder()
                    .addHttpListener(8080, "localhost")
                    .setHandler(
                            resource(new FileResourceManager(new File("src/main/webapp"), 1024))
                            .setDirectoryListingEnabled(false)
                            .setWelcomeFiles("index.html","/apr2aw/index.html")
                            )
                    .build();
                    
            server.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
