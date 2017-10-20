package com.hkstlr.apr2aw2;

import io.undertow.Handlers;
import static io.undertow.Handlers.path;
import io.undertow.Undertow;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(final String[] args) {
        try {
            
            ClassPathResourceManager resourceManager = new ClassPathResourceManager(
                    App.class.getClassLoader(),"apr2aw");
            ResourceHandler resourceHandler = Handlers.resource(resourceManager)
                    .setResourceManager(resourceManager)
                    .setWelcomeFiles("index.html")
                    .setDirectoryListingEnabled(false);
            
            Undertow server = Undertow.builder()
                    .addHttpListener(8080, "localhost")
                    .setHandler(path()
                        .addPrefixPath("/",resourceHandler)
                        .addPrefixPath("/apr2aw/", resourceHandler)
                    )
                    .build();

            server.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
