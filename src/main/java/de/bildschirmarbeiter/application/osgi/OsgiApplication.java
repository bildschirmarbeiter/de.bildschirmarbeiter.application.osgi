package de.bildschirmarbeiter.application.osgi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;

import javax.annotation.Nonnull;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class OsgiApplication extends Application {

    protected FrameworkFactory frameworkFactory;

    protected Framework framework;

    @Override
    public void init() throws Exception {
        frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
        framework = frameworkFactory.newFramework(configuration());
        framework.start();

        final BundleContext context = framework.getBundleContext();
        final List<Bundle> bundles = new ArrayList<>();
        for (final String path : bundles()) {
            final String url = String.format("file:%s", path);
            final Bundle bundle = context.installBundle(url);
            bundles.add(bundle);
        }
        for (final Bundle bundle : bundles) {
            bundle.start();
        }
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Screen screen = Screen.getPrimary();
        framework.getBundleContext().registerService(Screen.class, screen, null);
        framework.getBundleContext().registerService(Stage.class, primaryStage, null);
    }

    @Override
    public void stop() throws Exception {
        framework.stop();
        framework.waitForStop(timeout());
        super.stop();
    }

    @Nonnull
    protected Map<String, String> configuration() {
        return Collections.emptyMap();
    }

    @Nonnull
    protected List<String> bundles() {
        return Collections.emptyList();
    }

    @Nonnull
    protected Long timeout() {
        return 1000L;
    }

    protected void readLines(@Nonnull final InputStream inputStream, @Nonnull final List<String> list) {
        final Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine().trim();
            if (!line.isEmpty() && !line.startsWith("#")) {
                list.add(line);
            }
        }
    }

}
