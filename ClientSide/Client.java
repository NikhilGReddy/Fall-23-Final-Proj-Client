package ClientSide;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Client extends Application{


    private static BufferedReader fromServer;

    public static void main(String[] args) {
        try {
            //new Client().setUpNetworking();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root,400, 401);
        Object clientController = fxmlLoader.getController();
        ClientController.client = this;
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*private void setUpNetworking() throws Exception {
        String host;
        @SuppressWarnings("resource")
        Socket socket = new Socket(host, 4242);
        System.out.println("Connecting to... " + socket);
        Client.fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Client.toServer = new PrintWriter(socket.getOutputStream());

        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String input;
                try {
                    while ((input = fromServer.readLine()) != null) {
                        //System.out.println("From server: " + input);
                        Message message = gson.fromJson(input, Message.class);
                        processRequest(message);
                    }
                } catch (Exception e) {
                    System.out.println("Server Error: Restart the Server and Try Again.");
                }
            }
        });*/
}