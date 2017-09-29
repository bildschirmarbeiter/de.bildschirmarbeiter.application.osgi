# Bildschirmarbeiter Application OSGi

This project provides a simple abstract class `OsgiApplication` for use with JavaFX which extends [`Application`](https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html) and manages an OSGi Framework.

The lifecycle of the OSGi Framework is tied to the lifecycle of the JavaFX Application.

| JavaFX Application | OSGi Framework                                                                                                                                                                                                  |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| _init_             | _start_, installing and starting provided bundles                                                                                                                                                               |
| _start_            | registering primary [`Screen`](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Screen.html) and primary [`Stage`](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html) as OSGi service |
| _stop_             | _stop_                                                                                                                                                                                                          |
