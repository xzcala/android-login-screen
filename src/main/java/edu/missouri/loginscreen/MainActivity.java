package edu.missouri.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView infoTextView;
    private Button loginButton;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            fieldChecker();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email_et);
        passwordEditText = findViewById(R.id.password_et);
        infoTextView = findViewById(R.id.info_tv);
        loginButton = findViewById(R.id.login_btn);

        loginButton.setEnabled(false);
        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                infoTextView.setText("Email: "+email+"\n"+"Password: "+password);

            }
        });

        infoTextView = findViewById(R.id.info_tv);
    }


    private void fieldChecker(){
        Button loginButton = findViewById(R.id.login_btn);

        if (emailEditText.getText().toString().length() > 0 && passwordEditText.getText().toString().length() > 0) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
        }
    }
}
