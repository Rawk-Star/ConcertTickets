package com.rawks.jeremy.concerttickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    final double costPerTicket = 79.99;  // Cost for one ticket
    int numberOfTickets;                 // Number of tickets entered by user
    double totalCost;                    // Total cost of tickets
    String groupChoice;                  // Artist selected by user

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Java object representations of all widgets
        final EditText tickets = findViewById(R.id.txtTickets);
        final Spinner group = findViewById(R.id.txtGroup);
        final Button cost = findViewById(R.id.btnCost);
        final TextView result = findViewById(R.id.txtResult);

        cost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Get the number of tickets entered by the user
                String strNumberOfTickets = tickets.getText().toString();

                if (strNumberOfTickets.length() > 0)
                {
                    numberOfTickets = Integer.parseInt(strNumberOfTickets);

                    // Calculate the total cost of the tickets
                    totalCost = costPerTicket * numberOfTickets;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    groupChoice = group.getSelectedItem().toString();
                    result.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));
                }
                else
                {
                    // User has not specified how many tickets they want
                    result.setText("Specify number of tickets");
                }
            }
        });
    }
}