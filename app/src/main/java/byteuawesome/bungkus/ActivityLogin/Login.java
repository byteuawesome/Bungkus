package byteuawesome.bungkus.ActivityLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.StringRequest;

import byteuawesome.bungkus.ActivityDashboard.Dashboard;
import byteuawesome.bungkus.ActivitySignUp.SignUp;
import byteuawesome.bungkus.R;
import byteuawesome.bungkus.RequestHandler;

public class Login extends AppCompatActivity {

    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.Button_Login_Login);
        btnSignUp = (Button)findViewById(R.id.Button_Login_SignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , Dashboard.class ));
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , SignUp.class ));
                finish();
            }
        });

    }


}
