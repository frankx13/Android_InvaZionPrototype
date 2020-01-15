package com.nadawoo.nadazonepluspandamobile.invazionprototype;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button connection;
    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection = findViewById(R.id.connection);
        createAccount = findViewById(R.id.create_account);

        //LOGIN
        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO replace with true auth when release
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Connection success", Toast.LENGTH_SHORT).show();
                finish();
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
//
//                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
//                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
//                //this is what I did to added the layout to the alert dialog
//                View layout = inflater.inflate(R.layout.auth_dialog_item, null);
//                final EditText usernameInput = layout.findViewById(R.id.auth_mail);
//                final EditText passwordInput = layout.findViewById(R.id.auth_password);
//
//                alert.setView(layout);
//                alert.setTitle("Enter credentials");
//                alert.setMessage("Log-in with an username, password is optional");
//                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        //provide user with caution before uninstalling
//                        //also here should be added a AsyncTask that going to read the password and once its checked the password is correct the app will be removed
//                        String username = usernameInput.getText().toString().trim();
//                        String password = passwordInput.getText().toString().trim();
//                        if (username.equals("") && password.equals("")) {
//                            Toast.makeText(MainActivity.this, "No credentials entered", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
//                            startActivity(intent);
//                            Toast.makeText(MainActivity.this, "Connection success", Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                    }
//                });
//                alert.show();
            }
        });

        //LOGUP
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Emplacement de création de compte", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
