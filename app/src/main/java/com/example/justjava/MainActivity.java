/**
 * MainActivity.java
 * By : ChocolateCharlie
 * Last Updates : 03 - 01 - 2018
 */

package com.example.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



/**
 * MainActivity class
 * @author ChocolateCharlie
 *
 * Coffee machine :
 * - choose a drink pressing buttons (default is coffee)
 * - ajust number of sugar teaspoons desired (default is 0, min is 0, max is 5)
 * - show price
 * - show a message when the order button is pressed
 */
public class MainActivity extends AppCompatActivity {

    int price = 5;      /* The price */
    int teaspoons = 0;  /* The number of sugar teaspoons */
    String drink = "coffee"; /* The drink */

/**
 * onCreate
 * @param savedInstanceState
 *
 * This method is called at the creation of the class.
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        /* ************************************ */
        /*          DISPLAY METHODS             */
        /* ************************************ */

/**
 * displayTeaspoons
 * @param number
 *
 * This method displays the number of teaspoons.
 */
    private void displayTeaspoons(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.teaspoons_text_view);
        quantityTextView.setText("" + number);
    }

/**
 * displayPrice
 * @param message
 *
 * This method displays price.
 */
    private void displayPrice(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

/**
 * displayMessage
 * @param message
 *
 * This method displays a message under the order button.
 */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_text_view);
        priceTextView.setText(message);
    }

        /* ************************************ */
        /*         SUGAR TEASPOONS METHODS      */
        /* ************************************ */

/**
 * incrementSugar
 * @param view
 *
 * This method is called when the plus button is clicked.
 * Increment teaspoons (global variable).
 */
    public void incrementSugar(View view) {
        if (teaspoons != 5)
        {
            teaspoons = teaspoons + 1;
            price = price + 1;
        }

        displayTeaspoons(teaspoons);
        displayPrice("$" + price);
    }

/**
 * decrementSugar
 * @param view
 *
 * This method is called when the minus button is clicked.
 * Decrement teaspoons (global variable).
 */
    public void decrementSugar(View view) {
        if (teaspoons != 0)
        {
            teaspoons = teaspoons - 1;
            price = price - 1;
        }

        displayTeaspoons(teaspoons);
        displayPrice("$" + price);
    }

        /* ************************************ */
        /*         CHOOSING DRINK METHODS       */
        /* ************************************ */

/**
 * chooseCoffee
 * @param view
 *
 * This method is called when the coffee button is clicked.
 * - change the drink (global variable) name
 * - update price
 */
    public void chooseCoffee(View view) {
        drink = "coffee";

        price = 5 + teaspoons;

        displayPrice("$" + price);
    }

/**
 * chooseCappuccino
 * @param view
 *
 * This method is called when the cappuccino button is clicked.
 * - change the drink (global variable) name
 * - update price
 */
    public void chooseCappuccino(View view) {
        drink = "cappuccino";

        price = 12 + teaspoons;

        displayPrice("$" + price);
    }

/**
 * chooseChocolate
 * @param view
 *
 * This method is called when the hot chocolate button is clicked.
 * - change the drink (global variable) name
 * - update price
 */
    public void chooseChocolate(View view) {
        drink = "hot chocolate";

        price = 6 + teaspoons;

        displayPrice("$" + price);
    }

/**
 * chooseSoup
 * @param view
 *
 * This method is called when the soup button is clicked.
 * - change the drink (global variable) name
 * - reset sugar to zero
 * - update price
 */
    public void chooseSoup(View view) {
        drink = "soup";
        teaspoons = 0;

        price = 2 + teaspoons;

        displayPrice("$" + price);
        displayTeaspoons(teaspoons);
    }

        /* ************************************ */
        /*            ORDER METHODS             */
        /* ************************************ */

/**
 * submitOrder
 * @param view
 *
 * This method is called when the order button is clicked.
 * It prints a message under the order button.
  */
    public void submitOrder(View view) {
            displayMessage("You have ordered a " + drink + " with " + teaspoons + " teaspoons of sugar.\nTotal : $" + price);
        }
}