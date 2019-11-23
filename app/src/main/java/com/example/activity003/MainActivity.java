package com.example.activity003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //add this line
        setContentView(R.layout.activity_main);
    }

    public void orderCoffee(View view)
    {
        double coffee_price = 4.0;
        String creamS="",chocS="";
        TextView txtQty = (TextView) findViewById(R.id.txtQty);
        CheckBox cream = (CheckBox) findViewById(R.id.creamCheckbox);
        CheckBox choc = (CheckBox) findViewById(R.id.choclateCheckbox);
        TextView txtSummary = (TextView) findViewById(R.id.txtSummary);
        int qty = Integer.parseInt(txtQty.getText().toString());

        if(cream.isChecked() && choc.isChecked())
        {

            coffee_price = (coffee_price*qty) + (1.5*qty);
            creamS="yes";
            chocS="yes";
        }
        else if(choc.isChecked())
        {
            coffee_price = (coffee_price*qty) + (1.0*qty);
            creamS="no";
            chocS="yes";
        }
        else if(cream.isChecked())
        {
            coffee_price = (coffee_price*qty) + (0.5*qty);
            creamS="yes";
            chocS="no";
        }

        txtSummary.setText("Add whipped cream? "+creamS+" \nAdd chocolate? "+chocS+" \nQuantity: "+qty+"\nPrice: $"+coffee_price+"\nTHANK YOU!");
    }

    public void incQty(View view)
    {
        TextView txtQty = (TextView) findViewById(R.id.txtQty);
        int qty = Integer.parseInt(txtQty.getText().toString());
        qty += 1;

        txtQty.setText(String.valueOf(qty));
    }

    public void decQty(View view)
    {
        TextView txtQty = (TextView) findViewById(R.id.txtQty);
        int qty = Integer.parseInt(txtQty.getText().toString());
        qty -= 1;

        txtQty.setText(String.valueOf(qty));
    }

}
