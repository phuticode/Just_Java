package com.example.android.justjava;

import android.annotation.TargetApi;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//This app displays a coffee order form
public class MainActivity extends AppCompatActivity {

    //global variables
    int quantity = 0;
    int price = 5;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private com.google.android.gms.common.api.GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new com.google.android.gms.common.api.GoogleApiClient.Builder(this).addApi(com.google.android.gms.appindexing.AppIndex.API).build();
    }
    //This is a method that is called when the order button is clicked

    public void submitOrder(View view) {

        String priceMesage = "Amount due R" + price;
        displayMessage(priceMesage);
    }

    private int calculatePrice(int price) {
        price = quantity * price;
        return price;

    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    //this is a method that increments number of coffees

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    //this is a method that minuses number of coffees
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);

    }

    //This is a method displays the given quantity value on the device
    private void display(int number) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    //This is a method displays the given price value on the device
    @TargetApi(Build.VERSION_CODES.N)
    private void displayPrice(int number) {
        TextView priceTextView = (TextView)
                findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        com.google.android.gms.appindexing.Action viewAction = com.google.android.gms.appindexing.Action.newAction(
                com.google.android.gms.appindexing.Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.justjava/http/host/path")
        );
        com.google.android.gms.appindexing.AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        com.google.android.gms.appindexing.Action viewAction = com.google.android.gms.appindexing.Action.newAction(
                com.google.android.gms.appindexing.Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.justjava/http/host/path")
        );
        com.google.android.gms.appindexing.AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
