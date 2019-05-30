# Bildschirmarbeiter Application OSGi

This project provides a simple abstract class `OsgiApplication` (_launcher_) for use with JavaFX which extends [`Application`](https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html) and manages an OSGi Framework.

The lifecycle of the managed OSGi Framework is tied to the lifecycle of the JavaFX Application.

| JavaFX Application  | OSGi Framework                                                                                                                                                                                                   |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| _application init_  | _framework setup and start_, installing and starting provided bundles                                                                                                                                            |
| _application start_ | registering primary [`Screen`](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Screen.html) and primary [`Stage`](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html) as OSGi services |
| _application stop_  | _framework stop_                                                                                                                                                                                                 |
