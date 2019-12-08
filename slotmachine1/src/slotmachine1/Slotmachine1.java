/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine1;

import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import javafx.util.Duration;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.stage.WindowEvent;

import java.util.Optional;
import java.io.File;  
import java.util.HashSet;
  
import javafx.application.Application;  
import javafx.scene.Group;  
import javax.swing.JOptionPane;

import javafx.geometry.Pos;
/**
 *
 * @author Sean
 */
public class Slotmachine1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button spin = new Button();
        Button quit = new Button();
        
        
        boolean win;
        
        BorderPane Machine = new BorderPane();
        
        primaryStage.setWidth(320);
        primaryStage.setHeight(250);
        primaryStage.setResizable(false);
        HBox butts = new HBox();
        butts.getChildren().add(spin);
        butts.getChildren().add(quit);
        Machine.setTop(butts);
        
        Image image1 = new Image("image1.png");
        Image image2 = new Image("image2.png");
        Image image3 = new Image("image3.png");
        
        HBox wheels = new HBox();
        ImageView wheel1 = new ImageView();
        wheel1.setFitWidth(100);
        wheel1.setFitHeight(150);
        ImageView wheel2 = new ImageView();
        wheel2.setFitWidth(100);
        wheel2.setFitHeight(150);
        ImageView wheel3 = new ImageView();
        wheel3.setFitWidth(100);
        wheel3.setFitHeight(150);
        wheels.getChildren().add(wheel1);
        wheels.getChildren().add(wheel2);
        wheels.getChildren().add(wheel3);
        Machine.setCenter(wheels);
        
        FlowPane cash = new FlowPane();
        Label OnHand = new Label(  "      Jackpot: ");
        Label JackPot = new Label( "      Your Wallet: ");
        Label Prize = new Label("1000");
        Label Money = new Label("1000");
        cash.getChildren().addAll(OnHand, Money, JackPot, Prize);
        Machine.setBottom(cash);
        
        wheel1.setImage(image1);
        wheel2.setImage(image2);
        wheel3.setImage(image3);
        Scene scene = new Scene(Machine, 300, 200 ,Color.RED);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        


          
        //by setting this property to true, the audio will be played   
       // mp.setAutoPlay(true);  
        primaryStage.setTitle("Sean's Slot Machine");  
        primaryStage.show();  
           
       
        spin.setText("Spin");
        quit.setText("Quit");
        

       
       
        
        
        spin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("false");
                
        String path = "/Users/Sean/Desktop/slotmachine1/src/winmusic.mp3";  
        //Instantiating Media class  
        Media media = new Media(new File(path).toURI().toString());  
        //Instantiating MediaPlayer class   
        MediaPlayer mp = new MediaPlayer(media); 
        mp.play();
                        //String path = "/Users/Sean/Desktop/slotmachine1/src/slotmusic.mp3";
                        /*
        String path = "/Users/Sean/Desktop/slotmachine1/src/spinnoise.mp3";
        //Instantiating Media class    
        Media slotnoise = new Media(new File(path).toURI().toString());  
        //Instantiating MediaPlayer class   
        MediaPlayer mp1 = new MediaPlayer(slotnoise);   
        mp1.play();
*/
          
                play(Prize, Money, spin, primaryStage);
                
                        
                        EventHandler<ActionEvent> eventHandler = e ->
                        {
                        spin.setDisable(true);
                        int x = setwheel(wheel1, image1, image2, image3);
                        int y = setwheel(wheel2, image1, image2, image3);
                        int z = setwheel(wheel3, image1, image2, image3);
                            
                        };
                        
                        Timeline animation = new Timeline(
                        new KeyFrame( Duration.millis(50) ,eventHandler));
                        animation.setCycleCount(100);
                        animation.play();
                        animation.setOnFinished(e -> mymethod(wheel1, wheel2, wheel3, image1, image2, image3, Prize, Money, mp, spin));
                        

                
                        /*
                    
                int a = setwheel(wheel1, image1, image2, image3);
                int b = setwheel(wheel2, image1, image2, image3);
                int c = setwheel(wheel3, image1, image2, image3);
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(" ");
                boolean win = score(a,b,c);
                */
                //updatelabels(win,Prize, Money, mp);
                //
                //mp.stop();
            }
            
        });
        

        
quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                final Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);

                Label exitLabel = new Label("Are you sure you want to exit?");
                exitLabel.setAlignment(Pos.BASELINE_CENTER);

                Button yesBtn = new Button("Yes");
                yesBtn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        dialogStage.close();
                        primaryStage.close();

                    }
                });
                Button noBtn = new Button("No");

                noBtn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        dialogStage.close();

                    }
                });

                HBox hBox = new HBox();
                hBox.setAlignment(Pos.BASELINE_CENTER);
                hBox.setSpacing(40.0);
                hBox.getChildren().addAll(yesBtn, noBtn);

                VBox vBox = new VBox();
                vBox.setSpacing(40.0);
                vBox.getChildren().addAll(exitLabel, hBox);

                dialogStage.setScene(new Scene(vBox));
                dialogStage.show();
            }
        });
        
        
  
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        public void mymethod(ImageView wheel1, ImageView wheel2, ImageView wheel3, Image image1, Image image2, Image image3, Label prize, Label money,MediaPlayer mp, Button spin)
                {
                mp.pause();
                
                
                
                spin.setDisable(false);                       
                int a = setwheel(wheel1, image1, image2, image3);
                int b = setwheel(wheel2, image1, image2, image3);
                int c = setwheel(wheel3, image1, image2, image3);
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(" ");
                boolean win = score(a,b,c);
                updatelabels(win,prize, money, mp);
                
                
                
                }
    
    public void animate(ImageView wheel, Image im1, Image im2, Image im3)
    {
        int a;
        a=(int)(Math.random() * 1+3);
        if (a==1)
        {
            wheel.setImage(im1);
        }
        else if (a==2)
        {
            wheel.setImage(im2);
        }
        else if (a==3)
        {
            wheel.setImage(im3);
        }
    }
    
    public int setwheel(ImageView wheel, Image im1, Image im2, Image im3)
    {
       int num;
        num = (int)(Math.random() * 3 + 1);
        
        if (num==1)
        {
            wheel.setImage(im1);
        }
        else if (num==2)
        {
            wheel.setImage(im2);
        }
        else if (num==3)
        {
            wheel.setImage(im3);
        }
        return num;
    }
    
    public boolean score(int a, int b, int c)
    {
        if (a==b && a==c)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public void updatelabels(boolean win,Label person,Label bank, MediaPlayer mp)
    {
        
        if (win == true)
        {
           mp.stop(); 
           // String path1 = "/Users/Sean/Desktop/slotmachine1/src/winsound.wave";
            //Media winmus = new Media(new File(path1).toURI().toString());
            //MediaPlayer mp1 = new MediaPlayer(winmus);
            //mp1.play();
        String path = "/Users/Sean/Desktop/slotmachine1/src/AirHorn.wav";
        String patha = "/Users/Sean/Desktop/slotmachine1/src/horn.mp3";  
        //Instantiating Media class  
        Media medias = new Media(new File(path).toURI().toString());  
        //Instantiating MediaPlayer class   
        MediaPlayer mp1 = new MediaPlayer(medias); 
        mp1.setVolume(100);
        mp1.play();
        
        
            
        
              //play good music
              int cash = Integer.parseInt(person.getText());
              int bankmoney = Integer.parseInt(bank.getText());
              
              cash += bankmoney;
              bankmoney =1000;
              
              person.setText(Integer.toString(cash));
              bank.setText(Integer.toString(bankmoney));
              System.out.println("winner");
        }
        else
        {
            //play bad music
        }
        
    }
    
    public void play(Label person, Label bank, Button spin, Stage primaryStage)
    {
              int cash = Integer.parseInt(person.getText());
              int bankmoney = Integer.parseInt(bank.getText());
              //cash=0;
              cash -=1;
              bankmoney+=1;
              
              if (cash <=0)
                      {
                           
                          
                final Stage loseStage = new Stage();
                loseStage.initModality(Modality.WINDOW_MODAL);

                Label exitLabel = new Label("You LOST?");
                exitLabel.setAlignment(Pos.BASELINE_CENTER);

                Button yesBtn = new Button("I accept defeat");
                yesBtn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        loseStage.close();
                        primaryStage.close();

                    }
                });
   

                HBox hBox = new HBox();
                hBox.setAlignment(Pos.BASELINE_CENTER);
                hBox.setSpacing(40.0);
                hBox.getChildren().addAll(yesBtn);

                VBox vBox = new VBox();
                vBox.setSpacing(40.0);
                vBox.getChildren().addAll(exitLabel, hBox);

                loseStage.setScene(new Scene(vBox));
                loseStage.show();
            
        }
         
              else{
              person.setText(Integer.toString(cash));
              bank.setText(Integer.toString(bankmoney));
              }
              
              
    }   

    
    //Music 
        //Always running
        //victory
    //animation
    //cash
}





