package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }*/
    static HashMap<String, Double> productList = new HashMap<>();
    ArrayList<Integer> changeMoney = new ArrayList<>();

    Integer[] changePence = {1,2,5,10,20,50};
    Integer[] changePounds = {1,2};

    public static int lessMoney(int input, int cost){

        int difference = cost - input;
        System.out.println(difference);
        if(productList.containsKey(difference)){
            return difference;
        }

        return 0;

    }



    public static void main(String[] args) throws IOException {
        //product List
        productList.put("cola", 1.45);
        productList.put("chips", 0.40);
        productList.put("gum", 0.15);

        double currentProduct = 0;


        System.out.println("Which product that you want? write cola chips or gum");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s, moneyinsert;
        s= in.readLine();

        if(!productList.containsKey(s)){
            System.out.println("Sorry Product not available");
        }
        else {
            currentProduct = productList.get(s);
            System.out.println("Please insert this amount: " + productList.get(s));
        }
        double parseMoney = Double.parseDouble(in.readLine());
        if(parseMoney < currentProduct){
            System.out.println("Sorry not enough money, insert "+NumberFormat.getCurrencyInstance().format(Math.abs((parseMoney - currentProduct))) +" more");

        }
        else if(parseMoney > currentProduct){

        }

        }

    }


