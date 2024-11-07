package disasterManagement;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Client extends Application {
	
	public String selDis;
	public String status1;
	public String loc1;
    
	@Override
    
    public void start(final Stage primaryStage) {

        // Initial button on the main window
        Button b1 = new Button("Enter Application");
        b1.setStyle(
        		"-fx-background-radius: 15;" +
        		"-fx-padding: 8 15 8 15;" + 
        		"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
        		);

        DropShadow shadow = new DropShadow();
        shadow.setRadius(5);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
        shadow.setColor(Color.GRAY);
        b1.setEffect(shadow);
        
        
        Label l1 = new Label("Welcome To The Application!");
        l1.setTextFill(Color.LIGHTGRAY);
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(l1, b1);
        root.setStyle("-fx-background-color: #3E4A5A;"); // Light blue background

        // Text Fields
        TextField name = new TextField();
        name.setPromptText("Enter Your Name");
        name.setMaxWidth(200);
        name.setStyle(
                "-fx-background-color: transparent;" +      // Make background transparent
                "-fx-border-width: 0 0 2 0;" +             // Bottom border only
                "-fx-border-color: linear-gradient(to left, #ff6bcb, #ff9472);" + // Gradient color for underline
                "-fx-prompt-text-fill: lightgray;" + 
                "-fx-text-fill: lightgray;"
            );
        
        
        TextField contact = new TextField();
        contact.setPromptText("Guardian Contact Number");
        contact.setMaxWidth(200);
        contact.setStyle(
                "-fx-background-color: transparent;" +      // Make background transparent
                "-fx-border-width: 0 0 2 0;" +             // Bottom border only
                "-fx-border-color: linear-gradient(to left, #ff6bcb, #ff9472);" + // Gradient color for underline
                "-fx-prompt-text-fill: lightgray;" + 
                "-fx-text-fill: lightgray;"
            );
        
        //Button
        Button b2 = new Button("Enter");
        b2.setStyle(
        		"-fx-background-radius: 15; "
        		+ "-fx-padding: 8 15 8 15; "
        		+ "-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
        		);
        
        shadow.setRadius(5);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
        shadow.setColor(Color.GRAY);
        b2.setEffect(shadow);
        
        //Focus Req
    	name.setOnKeyPressed(event ->{
        	if(event.getCode().getName().equals("Enter")) {
        		
        		contact.requestFocus();
        		
        	}
        });
    	
    	contact.setOnKeyPressed(event ->{
        	if(event.getCode().getName().equals("Enter")) {
        		
        		b2.requestFocus();
        		
        	}
        });
    	
    	//Button 5 and Number
    	Button b5 = new Button("Enter");
    	b5.setStyle(
        		"-fx-background-radius: 15;" +
        		"-fx-padding: 8 15 8 15;" + 
        		" -fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
        		);
    	
    	shadow.setRadius(5);
    	shadow.setOffsetX(2);
    	shadow.setOffsetY(2);
    	shadow.setColor(Color.GRAY);
    	b5.setEffect(shadow);
    	
    	TextField Number = new TextField();
    	Number.setPromptText("Enter The Number");
        Number.setMaxWidth(200);
        Number.setStyle(
                "-fx-background-color: transparent;" +      // Make background transparent
                "-fx-border-width: 0 0 2 0;" +             // Bottom border only
                "-fx-border-color: linear-gradient(to left, #ff6bcb, #ff9472);" + // Gradient color for underline
                "-fx-prompt-text-fill: lightgray;" + 
                "-fx-text-fill: lightgray;"
            );
        
        Number.setOnKeyPressed(event ->{
        	if(event.getCode().getName().equals("Enter")) {
        		
        		b5.requestFocus();
        		
        	}
        });
    	
    	

        // EventHandler for Button 1
        b1.setOnAction(new EventHandler<ActionEvent>() {
            
        	@Override
            
            public void handle(ActionEvent event) {
            	
                // Label and Button in the new window
                Label l2 = new Label("Enter Information");
                l2.setTextFill(Color.LIGHTGRAY);

                // VBox layout for new window with label and button
                VBox layout = new VBox(10);
                layout.setAlignment(Pos.CENTER);
                layout.getChildren().addAll(l2, name, contact, b2);
                layout.setStyle("-fx-background-color: #3E4A5A;"); // Light blue background

                // Set up the new window scene
                Scene newScene = new Scene(layout, 450, 250);

                // New Window
                Stage newWindow = new Stage();
                newWindow.setTitle("User Information");
                newWindow.setScene(newScene);

                // New Window Position
                newWindow.setX(primaryStage.getX());
                newWindow.setY(primaryStage.getY()); 
                
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), newScene.getRoot());
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
                
                newWindow.show();
                primaryStage.close();
                
                

                // EventHandler for Button 2 in the new window
                b2.setOnAction(new EventHandler<ActionEvent>() {
                    
                	@Override
                    
                    public void handle(ActionEvent event) {
                        
                    	// Retrieve name and contact
                        String Name = name.getText();
                        String cont = contact.getText();
                        
                        //Validates the name
                        if (Name.trim().isEmpty()) {
                            
                        	Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter your name.");
                            alert.setTitle("Input Error");
                            alert.setHeaderText(null);
                            alert.showAndWait();
                            
                            return; // Exit the method if validation fails
                        }
                        
                        // Validate the contact number
                        if (!cont.matches("\\d{10}")) {
                            
                        	// Show an alert if the input is not exactly 10 digits
                            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a valid 10-digit contact number.");
                            alert.setTitle("Input Error");
                            alert.setHeaderText(null);
                            alert.showAndWait();
                            
                            return; // Exit the method if validation fails
                        }
                        // Proceed to the next stage with validated input
                        
                        
                        Label l3 = new Label("Disaster Management App");
                        l3.setTextFill(Color.LIGHTGRAY);
                        
                        Button b3 = new Button("Alert Contact");
                        b3.setStyle(
                        		"-fx-background-radius: 15;" +
                                "-fx-padding: 8 15 8 15;" + 
                                " -fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
                                		);
                      
                        shadow.setRadius(5);
                        shadow.setOffsetX(2);
                        shadow.setOffsetY(2);
                        shadow.setColor(Color.GRAY);
                        b3.setEffect(shadow);
                        
                        Button b4 = new Button("Enter");
                        b4.setStyle(
                        		"-fx-background-radius: 15;" +
                                "-fx-padding: 8 15 8 15;" + 
                                " -fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
                                		);
                        
                        shadow.setRadius(5);
                        shadow.setOffsetX(2);
                        shadow.setOffsetY(2);
                        shadow.setColor(Color.GRAY);
                        b4.setEffect(shadow);
                        
                        Button b7 = new Button("Disaster Safety Protocol");
                        b7.setStyle(
                        		"-fx-background-radius: 15;" +
                                "-fx-padding: 8 15 8 15;" + 
                                " -fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
                                        		);
                        
                        shadow.setRadius(5);
                        shadow.setOffsetX(2);
                        shadow.setOffsetY(2);
                        shadow.setColor(Color.GRAY);
                        b4.setEffect(shadow);
                        
                        Button b6 = new Button("Back");//Disaster Window Back
                        b6.setStyle(
                        		"-fx-background-radius: 15;" +
                                "-fx-padding: 8 15 8 15;" + 
                                " -fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
                                        		);
                        
                        shadow.setRadius(5);
                        shadow.setOffsetX(2);
                        shadow.setOffsetY(2);
                        shadow.setColor(Color.GRAY);
                        b4.setEffect(shadow);
                        
                        Button b8 = new Button("Back");//LogIn Back
                        b8.setStyle(
                        		"-fx-background-radius: 15;" +
                                "-fx-padding: 8 15 8 15;" + 
                                " -fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #ff7e5f, #feb47b);"
                                        		);
                        
                        shadow.setRadius(5);
                        shadow.setOffsetX(2);
                        shadow.setOffsetY(2);
                        shadow.setColor(Color.GRAY);
                        b4.setEffect(shadow);
                        
                        VBox layout = new VBox(10);
                        layout.setAlignment(Pos.CENTER);
                        layout.getChildren().addAll(l3, b3, b7,b8);
                        layout.setStyle("-fx-background-color: #3E4A5A;");
                        
                        Scene s3 = new Scene(layout, 450, 250);
                        Stage disasterWindow = new Stage();
                        
                        disasterWindow.setTitle("Disaster Management Application");
                        disasterWindow.setScene(s3);
                        disasterWindow.setX(newWindow.getX());
                        disasterWindow.setY(newWindow.getY());
                        
                        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s3.getRoot());
                        fadeTransition.setFromValue(0);
                        fadeTransition.setToValue(1);
                        fadeTransition.play();
                        
                        disasterWindow.show();
                        newWindow.close();

                        //For Drop Down Menu
                        ComboBox<String> status = new ComboBox<>();
                        status.getItems().addAll("Safe","Not Safe","Rescued","Trapped");
                        
                        status.setPromptText("Select Status");
                        status.setStyle(
                                "-fx-background-color: transparent; " +   
                                "-fx-text-fill: lightgray; " +    
                                "-fx-prompt-text-fill: lightgray;" +
                                "-fx-background-radius: 15; " +             
                                "-fx-border-radius: 15; " +                 
                                "-fx-popup-border-radius: 15;"             
                            );

                        
                        ComboBox<String> loc = new ComboBox<>();
                        loc.getItems().addAll("At Home", "At School", "At College","At Park","At Gym","At Mall");
                        loc.setPromptText("Select Location");
                        loc.setStyle(
                                "-fx-background-color: transparent; " +   
                                "-fx-text-fill: lightgray; " + 
                                "-fx-prompt-text-fill: lightgray;" +
                                "-fx-background-radius: 15; " +             
                                "-fx-border-radius: 15; " +                 
                                "-fx-popup-border-radius: 15;"             
                            );

                        
                        
                        b3.setOnAction(new EventHandler<ActionEvent>() {
                            
                        	@Override
                            
                            public void handle(ActionEvent event) {
                                
                                VBox layout = new VBox(10);
                                layout.setAlignment(Pos.CENTER);
                                layout.getChildren().addAll(status,loc,Number,b5,b8);
                                layout.setStyle("-fx-background-color: #3E4A5A;");
                                
                                
                                Scene s4 = new Scene(layout,450,250);
                                Stage alert = new Stage();
                                
                                alert.setTitle("Alert");
                                alert.setScene(s4);
                                alert.setX(newWindow.getX());
                                alert.setY(newWindow.getY());
                                
                                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s4.getRoot());
                                fadeTransition.setFromValue(0);
                                fadeTransition.setToValue(1);
                                fadeTransition.play();
                                
                                alert.show();
                                disasterWindow.close();
                                
                                b8.setOnAction(new EventHandler<ActionEvent>() {
                                	
                                	@Override
                                	
                                	public void handle(ActionEvent event) {
                                		alert.close();
                                		disasterWindow.show();
                                		
                                	}
                                });
                                
                                b5.setOnAction(new EventHandler <ActionEvent>() {
                                	
                                	@Override
                                	
                                	public void handle(ActionEvent event) {
                                		
                                		String num = Number.getText();
                                		
                                		// Validate Number Input
                                        if (!num.matches("\\d{10}")) {
                                            
                                        	Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter exactly 10 digits.");
                                            alert.setTitle("Input Error");
                                            alert.setHeaderText(null);
                                            alert.showAndWait();
                                            
                                            return; // Exit the method if validation fails
                                        }
                                		
                                		disasterWindow.show();
                                		alert.close();
                                		
                                	}
                                	
                                });
                            }
                        });
                        
                        //For Status Selection
                        status.setOnAction(e -> {
                        	
                        	status1 = status.getValue();
                        	
                		});
                        
                        //For Location Selection
                        loc.setOnAction(e -> {
                        	
                        	loc1 = loc.getValue();
                        	
                		});
                                             
                        
                        ComboBox<String> dcb = new ComboBox<>();
                        dcb.getItems().addAll("Earthquake","Tsunami","Hurricane","Flood","Wildfire","Tornado","Hailstorm","Volcanic Eruption","Landslide","Avalanche");
                        dcb.setPromptText("Select Disaster");
                        dcb.setStyle(
                                "-fx-background-color: transparent; " +   
                                "-fx-text-fill: lightgray; " +
                                "-fx-prompt-text-fill: lightgray;" +
                                "-fx-background-radius: 15; " +             
                                "-fx-border-radius: 15; " +                 
                                "-fx-popup-border-radius: 15;"             
                            );
                        

                        
                        Label nl = new Label("Choose A Disaster : ");
                    	nl.setTextFill(Color.LIGHTGRAY);
                    	
                        b7.setOnAction(new EventHandler<ActionEvent>() {
                        	
                        	@Override
                        	
                        	public void handle(ActionEvent event) {
                        		
                        		VBox layout = new VBox(10);
                        		layout.setAlignment(Pos.CENTER);
                        		layout.getChildren().addAll(nl,dcb,b4,b6);
                        		layout.setStyle("-fx-background-color: #3E4A5A;");
                        		
                        		Scene s7 = new Scene(layout,450,250);
                        		Stage st7 = new Stage();
                        		
                        		st7.setTitle("Disaster Selection");
                        		st7.setScene(s7);
                        		st7.setX(newWindow.getX());
                        		st7.setY(newWindow.getY());
                        		
                        		FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s7.getRoot());
                                fadeTransition.setFromValue(0);
                                fadeTransition.setToValue(1);
                                fadeTransition.play();
                        		
                        		st7.show();
                        		disasterWindow.close();
                        	}
                        });
                        
                        //For Disaster Selection
                        dcb.setOnAction(e -> {
                        	
                        	selDis = dcb.getValue();
                        	
                		});
                        
                        
                        
                        
                        
                        b4.setOnAction(new EventHandler<ActionEvent>() {
                            
                        	@Override
                            
                            public void handle(ActionEvent event) {
                                
                            	if(Server.dis == 1 || selDis == "Hurricane") {
                                	
                                	Label disas = new Label("Stay Informed: Keep track of weather updates through reliable sources such as the National Hurricane Center, local news, or weather apps. Monitor alerts and warnings to stay aware of the hurricane's path and intensity.\r\n"
                                			+ "\r\n"
                                			+ "Follow Evacuation Orders: If local authorities issue evacuation orders, follow them promptly. Know your evacuation routes in advance and have a plan for where you will go. Ensure your vehicle is fueled and ready to leave if necessary.\r\n"
                                			+ "\r\n"
                                			+ "Secure Your Home: If you cannot evacuate, take steps to secure your home. Board up windows and doors with plywood or shutters, secure outdoor items that could become projectiles, and move valuable items to higher ground in case of flooding.\r\n"
                                			+ "\r\n"
                                			+ "Prepare an Emergency Kit: Assemble an emergency kit with essential supplies, including non-perishable food, water (at least one gallon per person per day), medications, flashlights, batteries, a first aid kit, and important documents. Include items for pets if you have them.\r\n"
                                			+ "\r\n"
                                			+ "Stay Indoors and Away from Windows: During the hurricane, stay indoors in a safe location, preferably in an interior room or basement, away from windows and doors. Avoid using candles or other open flames due to the risk of fire, and do not go outside until authorities declare it safe.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	@Override
                                    	
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                
                                else if(Server.dis == 2 || selDis == "Tsunami") {
                                	
                                	Label disas = new Label("Move to Higher Ground Immediately: If you are near the coast and feel strong ground shaking or receive a tsunami warning, evacuate to higher ground or an elevated building as quickly as possible. Do not wait for further warnings or instructions.\r\n"
                                			+ "\r\n"
                                			+ "Avoid the Beach and Low-Lying Areas: Stay away from the beach, harbors, and low-lying coastal areas. Tsunamis can cause dangerous currents and flooding, which can be life-threatening.\r\n"
                                			+ "\r\n"
                                			+ "Follow Evacuation Routes: If you are in an area that is prone to tsunamis, familiarize yourself with the evacuation routes in advance. Follow official evacuation signs and listen to emergency services for instructions.\r\n"
                                			+ "\r\n"
                                			+ "Stay Informed: Keep a battery-operated radio or use your smartphone to stay updated on the situation. Pay attention to alerts from local authorities and emergency services about the tsunami status and any evacuation orders.\r\n"
                                			+ "\r\n"
                                			+ "Help Others if Possible: If it is safe to do so, assist those who may need help evacuating, including the elderly, children, or those with disabilities. However, prioritize your own safety and do not put yourself in danger.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	@Override
                                    	
                                    	
                                    	public void handle(ActionEvent event) {
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                
                                else if(Server.dis == 3||selDis == "Earthquake") {
                                	
                                	Label disas = new Label("Drop, Cover, and Hold On: As soon as you feel shaking, drop to your hands and knees to prevent being knocked over. Take cover under a sturdy piece of furniture (like a table or desk) to protect yourself from falling debris. If there is no shelter nearby, cover your head and neck with your arms and stay in place until the shaking stops.\r\n"
                                			+ "\r\n"
                                			+ "Stay Indoors: If you are indoors, stay there! Do not run outside during the shaking, as falling debris can be more dangerous. Move away from windows, glass, mirrors, and heavy furniture that may fall.\r\n"
                                			+ "\r\n"
                                			+ "If You Are Outside: Move to an open area away from buildings, trees, streetlights, and utility wires. Stay in that area until the shaking stops to avoid the risk of falling debris.\r\n"
                                			+ "\r\n"
                                			+ "If You Are in a Vehicle: Pull over to a safe location away from overpasses, bridges, trees, and utility poles. Stay inside the vehicle with your seatbelt fastened until the shaking stops. After the shaking stops, proceed cautiously, avoiding damaged roads or bridges.\r\n"
                                			+ "\r\n"
                                			+ "After the Earthquake: Once the shaking has stopped, check yourself and others for injuries and provide first aid if needed. Be prepared for aftershocks, which can follow the main quake. Listen to emergency information from authorities and be cautious when entering buildings, as there may be hazards like gas leaks or structural damage.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                
                                else if(Server.dis == 4||selDis == "Flood") {
                                	
                                	Label disas = new Label("Move to Higher Ground: If you’re in a low-lying area or near a body of water, head for higher ground as quickly as possible. Avoid walking or driving through floodwaters, as even shallow, fast-moving water can be dangerous.\r\n"
                                			+ "\r\n"
                                			+ "Turn Off Utilities: If it’s safe to do so, turn off electricity, gas, and water supplies at the main switches to prevent potential fires, electrocution, or gas leaks.\r\n"
                                			+ "\r\n"
                                			+ "Avoid Floodwaters: Stay away from flooded areas and avoid coming into contact with floodwaters, which can be contaminated with chemicals, sewage, or debris. Even six inches of moving water can knock a person down, and one foot of water can sweep a car away.\r\n"
                                			+ "\r\n"
                                			+ "Listen for Alerts and Updates: Tune in to local news, NOAA Weather Radio, or emergency services for real-time information and evacuation instructions. Follow any directives from authorities promptly.\r\n"
                                			+ "\r\n"
                                			+ "Prepare an Emergency Kit: If possible, have an emergency kit ready, including essentials like food, water, medication, flashlights, batteries, and a first aid kit. In case evacuation becomes necessary, it’s helpful to have these items already packed and accessible.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                
                                else if(Server.dis == 5||selDis == "Wildfire") {
                                	
                                	Label disas = new Label("Evacuate if Advised: If authorities issue an evacuation order, leave immediately and follow recommended routes. Don’t wait to be told twice, as wildfires can spread rapidly.\r\n"
                                			+ "\r\n"
                                			+ "Close All Doors and Windows: Before leaving or if sheltering in place, close all doors, windows, and vents to prevent embers and smoke from entering. If possible, shut off gas and fuel lines to reduce the risk of fire entering your home.\r\n"
                                			+ "\r\n"
                                			+ "Prepare an Emergency Kit: Have an emergency kit ready with essential items such as water, non-perishable food, medications, a first aid kit, and important documents. Keep it easily accessible in case you need to leave on short notice.\r\n"
                                			+ "\r\n"
                                			+ "Stay Informed: Monitor local news, alerts, or a NOAA Weather Radio for the latest updates on the fire’s path and evacuation zones. This will help you stay aware of any changing conditions.\r\n"
                                			+ "\r\n"
                                			+ "Keep Flammable Items Away from Your Home: If you have time, remove any flammable materials like firewood, furniture, or plants from around your house. Clear gutters and roofs of dry leaves and debris to help protect your home from embers.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                else if(Server.dis == 6||selDis == "Tornado") {
                                	
                                	Label disas = new Label("Seek Shelter Immediately: Go to a designated storm shelter or the lowest level of a sturdy building, preferably in a basement or an interior room with no windows, like a closet or bathroom.\r\n"
                                			+ "\r\n"
                                			+ "Protect Your Head and Neck: Use your arms, a mattress, or sturdy items to shield your head and neck from debris. Crouch low and cover yourself to stay safe from flying objects.\r\n"
                                			+ "\r\n"
                                			+ "Stay Informed: Monitor a reliable source like a NOAA Weather Radio, local news, or weather app for alerts and updates. Tornadoes can develop and change quickly, so stay alert to warnings.\r\n"
                                			+ "\r\n"
                                			+ "Avoid Windows and Doors: Stay away from windows, doors, and outside walls. Flying glass and debris are common in tornadoes and can be deadly.\r\n"
                                			+ "\r\n"
                                			+ "Wait for the All-Clear: Do not leave your shelter until local authorities have given the all-clear signal, as secondary tornadoes or severe weather can follow an initial tornado.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                else if(Server.dis == 7||selDis == "Hailstorm") {
                                	
                                	Label disas = new Label("Stay Indoors: If a hailstorm is approaching, stay inside to avoid injury from falling hailstones, which can be very dangerous, especially if large.\r\n"
                                			+ "\r\n"
                                			+ "Protect Your Windows: Close curtains, blinds, or shades to prevent shattered glass from flying inside if hailstones break a window. If possible, move to a windowless room.\r\n"
                                			+ "\r\n"
                                			+ "Move Pets and Valuables to Safety: Keep pets indoors and move any valuable or fragile items away from windows or outside areas where they could be damaged by hail.\r\n"
                                			+ "\r\n"
                                			+ "Seek Shelter in a Covered Space if Outdoors: If caught outside, find immediate shelter under a sturdy structure, but avoid trees, as hail can damage branches, causing them to fall.\r\n"
                                			+ "\r\n"
                                			+ "Wait Until the Storm Passes: Avoid leaving your shelter until the storm has fully passed, as hail often accompanies other severe weather like thunderstorms or strong winds.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    		
                                    	}
                                    });
                                }
                                else if(Server.dis == 8||selDis == "Volcanic Eruption") {
                                	
                                	Label disas = new Label("Follow Evacuation Orders: If authorities issue evacuation orders, leave immediately. Volcanic eruptions can escalate quickly, so it's crucial to act fast and follow established evacuation routes.\r\n"
                                			+ "\r\n"
                                			+ "Wear Protective Gear: If you're in an area with falling ash, wear a mask or cloth over your nose and mouth to avoid inhaling ash particles. Also, wear long sleeves, pants, goggles, and a hat to protect your skin and eyes.\r\n"
                                			+ "\r\n"
                                			+ "Stay Indoors and Seal Openings: Ash can easily infiltrate buildings, so stay indoors with windows and doors closed. Seal any gaps to keep ash from entering, especially around windows and doors.\r\n"
                                			+ "\r\n"
                                			+ "Avoid Low-Lying Areas: Lava flows and mudflows (lahars) can travel down slopes and flood plains quickly. Stay on higher ground to avoid these dangerous flows, which can be hot, fast-moving, and carry debris.\r\n"
                                			+ "\r\n"
                                			+ "Prepare an Emergency Kit: Assemble a kit with essentials like water, food, a flashlight, batteries, a first aid kit, and necessary medications. Volcanic ash can disrupt services, so it’s important to be prepared to be self-sufficient for several days.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    	}
                                    });
                                }
                                
                                else if(Server.dis == 9||selDis == "Landslide") {
                                	
                                	Label disas = new Label("Stay Alert to Warnings: Pay attention to landslide warnings from authorities, especially if you live in a hilly or mountainous area, particularly after heavy rainfall or an earthquake. Evacuate immediately if advised to do so.\r\n"
                                			+ "\r\n"
                                			+ "Move to Higher Ground: If you’re outdoors, move away from the path of the landslide and seek higher, stable ground. Avoid river valleys and other low-lying areas where mud, debris, and water may flow.\r\n"
                                			+ "\r\n"
                                			+ "Listen for Unusual Noises: Cracking trees, rumbling, or unusual sounds of debris movement can signal a landslide. If you hear these sounds, evacuate immediately.\r\n"
                                			+ "\r\n"
                                			+ "Stay Indoors if Safe: If you’re indoors and can’t evacuate, move to the upper floors and take cover under sturdy furniture. Stay away from doors and windows that could be shattered by debris.\r\n"
                                			+ "\r\n"
                                			+ "Be Prepared Post-Landslide: After the landslide, stay away from the site as further movement may occur. Report broken utilities, check for trapped individuals, and be cautious around landslide debris, which may be unstable.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    	}
                                    });
                                }
                                
                                else if(Server.dis == 10||selDis == "Avalanche") {
                                	
                                	Label disas = new Label("Move Sideways to Escape: If you see an avalanche coming and you’re able to, move diagonally to the side of the slope to get out of its path. Avalanches usually follow the steepest descent, so moving sideways can help you avoid the direct flow.\r\n"
                                			+ "\r\n"
                                			+ "Drop Heavy Gear: If you’re carrying a backpack, skis, or any other heavy equipment, drop it immediately to lighten your load and improve your chances of staying on top of the snow.\r\n"
                                			+ "\r\n"
                                			+ "Try to Stay on Top: As the avalanche approaches, try swimming motions to stay on top of the snow and keep your head above the flow. This can help prevent you from being buried deeply.\r\n"
                                			+ "\r\n"
                                			+ "Create an Air Pocket: If you’re getting buried, cup your hands in front of your mouth to create an air pocket, allowing you to breathe if you get trapped under the snow. The pocket can provide valuable air until help arrives.\r\n"
                                			+ "\r\n"
                                			+ "Stay Calm and Signal for Help: Once the snow stops moving, stay calm to conserve oxygen. If possible, try to dig toward the surface or make noise to alert rescuers. Avoid shouting unless you hear rescuers nearby, as it may waste oxygen.");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,1024,720);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    	}
                                    });
                                }
                                
                                else {
                                	
                                	Label disas = new Label("No Disaster!");
                                	disas.setTextFill(Color.LIGHTGRAY);
                                	
                                	VBox layout = new VBox(10);
                                    layout.setAlignment(Pos.CENTER);
                                    layout.getChildren().addAll(disas,b6);
                                    layout.setStyle("-fx-background-color: #3E4A5A;");
                                    
                                    Scene s5 = new Scene(layout,450,250);
                                    Stage dis = new Stage();
                                    
                                    dis.setTitle("Disaster Safety Protocol");
                                    dis.setScene(s5);
                                    dis.setX(newWindow.getX());
                                    dis.setY(newWindow.getY());
                                    
                                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), s5.getRoot());
                                    fadeTransition.setFromValue(0);
                                    fadeTransition.setToValue(1);
                                    fadeTransition.play();
                                    
                                    dis.show();
                                    disasterWindow.close();
                                    
                                    b6.setOnAction(new EventHandler <ActionEvent>() {
                                    	
                                    	@Override
                                    	public void handle(ActionEvent event) {
                                    		
                                    		dis.close();
                                    		disasterWindow.show();
                                    	}
                                    });
                                    
                                }
                                
                            }
                        });
                       
                    }
                });
            }
        });

        
        // Initial scene setup
        Scene s1 = new Scene(root, 450, 250);
        primaryStage.setTitle("Welcome To The Application");
        primaryStage.setScene(s1);
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {

	//Server.main(args); <- run this to use the server
        launch(args);
        
    }
}
