To run the client file to run the application if you already have javafx installed, else:
Do these following steps:

Open Eclipse -> Help -> Eclipse Marketplace
Search for "javafx"
You'll see e(fx)eclipse, install it.
After installation, restart eclipse
Then create new project File > New > Project(don't select Java project).
Then Select JavaFX > JavaFX Project
Then click Next, give project name and click Finish
You'll get "The import javafx cannot be resolved"
Download JavaFX in here JavaFX
Extract the folder and place it downloads folder (or anyplace)
Then in eclipse right click the project and select properties
Choose Java Build Path
Then select Libraries tab (you'll see tabs on the top)
You'll see Classpath > JavaFX SDK
Click on Classpath, then click Add external JARs from the right.
Then from the download JavaFX (placed in downloads folder or somewhere you've placed).
Choose all the .jars file in Downloads/javafx-sdk-11.0.2/lib/(all .jar(s) file) and click open.
Then click Apply and Apply and close.
Then you won't get red underlines or (error).
Then right click on project > Run as > Run configuration
Choose the arguments tab and type this in VM arguments.
    --module-path /path/to/JavaFX/lib  --add-modules=javafx.controls,javafx.fxml

(Important) Then uncheck the box that says "Use the -XstartOnFirstThread..."
Click Apply and Run.
