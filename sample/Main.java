package sample;

import Classes.Route;
import Controllers.AdminController;
import Controllers.ClientController;
import Repositories.Repository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Repository routeRepository = new Repository();
        Route r1 = new Route("Cluj-Napoca","Suceava",9,16,100,50,1);
        Route r2 = new Route("Cluj-Napoca","Constanta",6,17,80,75,2);
        Route r3 = new Route("Timisoara","Bistrita",8,16,92,45,3);
        routeRepository.add(r1);
        System.out.print(r1);
        routeRepository.add(r2);
        routeRepository.add(r3);

        //CLIENT 1 SCENE
        AdminController adminCtrl = new AdminController();

        ClientController clientCtrl = new ClientController(routeRepository,"Client1");
        GuiController guiController=new GuiController(clientCtrl,adminCtrl);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("client.fxml"));
        loader.setController(guiController);
        Parent root =loader.load();
        primaryStage.setTitle("Client1");
        primaryStage.setScene(new Scene(root, 450, 350));
        primaryStage.show();

        //ADMIN SCENE
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("admin.fxml"));
        loader2.setController(guiController);
        Parent root2=loader2.load();
        Stage primaryStage2=new Stage();
        primaryStage2.setTitle("Admin");
        primaryStage2.setScene(new Scene(root2, 600, 400));
        primaryStage2.show();

        //CLIENT 2 SCENE
        ClientController clientCtrl2=new ClientController(routeRepository,"Client2");
        GuiController guiController2=new GuiController(clientCtrl2,adminCtrl);

        FXMLLoader loader3=new FXMLLoader(getClass().getResource("client.fxml"));
        loader3.setController(guiController2);
        Parent root3=loader3.load();
        Stage primaryStage3=new Stage();
        primaryStage3.setTitle("Client2");
        primaryStage3.setScene(new Scene(root3, 600, 400));
        primaryStage3.show();

    }
    public static void main(String[] args) { launch(args); }
}
