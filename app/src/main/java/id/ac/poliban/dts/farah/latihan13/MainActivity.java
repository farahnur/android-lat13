package id.ac.poliban.dts.farah.latihan13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        Button btSave = findViewById(R.id.btSave);
        Button btLoad = findViewById(R.id.btLoad);

        btLoad.setOnClickListener(v -> startActivity(new Intent(this, Main2Activity.class)));
        btSave.setOnClickListener(v -> {
            String file = "farah";
            SharedPreferences sp = getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            String lname = etLastName.getText().toString();
            String fname = etFirstName.getText().toString();

            edit.putString("fname", fname);
            edit.putString("lname", lname);
            edit.apply();

            Toast.makeText(this, "Saved it", Toast.LENGTH_SHORT).show();
        });
    }
}
