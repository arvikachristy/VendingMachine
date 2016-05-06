package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Main{
    static TreeMap<String, Product> productList = new TreeMap<>();
    static Double[] changePence = {0.01,0.02,0.05,0.10,0.20,0.50,1.0,2.0};
    static List<Double> moneyCheck = new ArrayList<>(Arrays.asList(changePence));
    ArrayList<Integer> changeMoney = new ArrayList<>();

    //condition where customer needs change
    public static String moreMoney(double input, double cost){
        double difference = Math.abs(input-cost);
        String finalPrint="";
        Collections.sort(moneyCheck, Collections.reverseOrder());
        ArrayList<Double> changeStore = new ArrayList();

        if(moneyCheck.contains(difference)){
            //if the money is part of the array return itself
            finalPrint = NumberFormat.getCurrencyInstance().format(Math.abs((difference)));
        }
        else{
            for(int x=0; x<moneyCheck.size();x++){
                if (difference >= moneyCheck.get(x)) {//if difference is big, keep reducing with it
                    changeStore.add(moneyCheck.get(x));
                    difference -= moneyCheck.get(x);
                    x=x-1; //check again, in case we need double value of this x
                }
            }
        }

        for(Double x: changeStore){
            StringBuilder sb = new StringBuilder();
            sb.append(NumberFormat.getCurrencyInstance().format(Math.abs(x)));
            sb.append(" ");
            finalPrint += sb;
        }
        return finalPrint;
    }

    //outside thread that wants to add product, can be used in the future implementatin
    synchronized public void addProduct(Product p)
    {
        productList.put(p.getKey(), p);
        notifyAll();
    }

    //For the time purpose, in this case we can take that cola chips and gum are the only one available
    public static void main(String[] args) throws IOException {
        //product List you can add or remove anything from here
        final Product cola = new Product("cola",10,1.45);
        final Product chips = new Product("chips",20,0.45);
        final Product gum = new Product("gum", 40,0.15);
        productList.put(cola.getKey(), cola);
        productList.put(chips.getKey(), chips);
        productList.put(gum.getKey(), gum);
        double currentProduct = 0;

        System.out.println("Which product that you want? write cola chips or gum");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s= in.readLine();

        if(!productList.containsKey(s)){
            System.out.println("Sorry Product not available");
        }
        else {
            Product obtainCost = productList.get(s);
            currentProduct = obtainCost.getPrice();
            System.out.println("Please insert this amount: " + obtainCost.getPrice());
        }
        double parseMoney = Double.parseDouble(in.readLine());

        while (parseMoney!=currentProduct) {
            if (parseMoney < currentProduct) {
                while (parseMoney < currentProduct) {
                    System.out.println("Sorry not enough money, insert " + NumberFormat.getCurrencyInstance().format(Math.abs((parseMoney - currentProduct))) + " more");
                    parseMoney += Double.parseDouble(in.readLine());//keep asking for money until it's enough
                }
            }
            if (parseMoney > currentProduct) {
                System.out.println("Here's your change of: " + moreMoney(parseMoney, currentProduct));
                parseMoney = currentProduct; //to neutralize & get out of loop
            }
        }

        System.out.println("Thank You For Your Purchase");

    }
}

