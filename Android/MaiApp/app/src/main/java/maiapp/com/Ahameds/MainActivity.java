package maiapp.com.Ahameds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;

public class MainActivity extends AppCompatActivity {


    public EditText email,password;
    Button signin,signup;
    FirebaseAuth FireBase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        email = findViewById(R.id.email);
        password = findViewById(R.id.pswd1);
        signin = (Button) findViewById(R.id.sin);
        signup = (Button) findViewById(R.id.sup1);

        FireBase = FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ProEmail = email.getText().toString().trim();
                String ProP1 = password.getText().toString().trim();


                if(TextUtils.isEmpty(ProEmail)){
                    Toast.makeText(MainActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                    return ;
                }

                if(TextUtils.isEmpty(ProP1)){
                    Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(ProP1.length()<6){
                    Toast.makeText(MainActivity.this, "Password Too Short", Toast.LENGTH_SHORT).show();
                    return ;
                }

                FireBase.signInWithEmailAndPassword(ProEmail, ProP1).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(MainActivity.this,LogInActivity.class));
                                } else {
                                    Toast.makeText(MainActivity.this, "Sign In unsuccessfull! Try Again! :(", Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });

        };

        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();

            }
        });

    }

    public void openRegisterActivity(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }




}
