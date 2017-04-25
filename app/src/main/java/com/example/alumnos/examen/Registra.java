package com.example.alumnos.examen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.alumnos.examen.bean.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Registra extends AppCompatActivity {

    private EditText txtName;
    private EditText txtLastNames;
    private EditText txtUsuario;
    private EditText txtClave;
    private Spinner spinnerSex;
    private int usuarioId;
   // private List<String> listSex;

   // private RadioButton radioActive, radioInactive;
   // private RadioGroup radioGroupStatus;

   // private Switch switchMarried;
    //private TextView textViewMarried;

   // private TextInputLayout tilName,tilSex;

   // private RatingBar ratingBarScore;
   // private String score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        loadFiles();
        //switchLoad();
        //radioLoad();
        //ratingBarLoad();
       // spinnerLoad();
        //editLoad();
    // guardar usuario
        saveUsuario();

    }



    public void loadFiles(){
        txtName = (EditText) findViewById(R.id.txtName);
        txtLastNames = (EditText) findViewById(R.id.txtLastNames);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);

       // tilName=(TextInputLayout) findViewById(R.id.tilName);
        //tilSex=(TextInputLayout) findViewById(R.id.tilSex);


    }




 public void newUsuario() {
        Random rn = new Random();
        int answer = rn.nextInt(1000) + 1;

        Usuario usuario =new Usuario();
        usuario.setId(answer);
        usuario.setName(txtName.getText().toString());
        usuario.setLastNames(txtLastNames.getText().toString());
        usuario.setUsuario(txtUsuario.getText().toString());
        usuario.setClave(txtClave.getText().toString());


        MainActivity.listUsuario.add(usuario);

    }

// guardar usuario

        public void saveUsuario(){
        Button btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(usuarioId==0){
                    newUsuario();
                }else{
                    updateUsuario();
                }
                goMain();

            }
        });
    }
// fin guardar usuario



        public void updateUsuario() {
        List<Usuario> listUsuario2=new ArrayList<Usuario>();
        for (Usuario usuario:MainActivity.listUsuario){
            if(usuario.getId()==usuarioId){
                usuario.setName(txtName.getText().toString());
                usuario.setLastNames(txtLastNames.getText().toString());
                usuario.setUsuario(txtUsuario.getText().toString());
                usuario.setClave(txtClave.getText().toString());

                //person.setSex(String.valueOf(spinnerSex.getSelectedItem()));
            }
            listUsuario2.add(usuario);
        }
    }

    public void goMain(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public Usuario getUsuarioById(int usuarioId){
        List<Usuario> listUsuario = MainActivity.listUsuario ;

        for (Usuario usuario:listUsuario){
            if(usuario.getId()==usuarioId){
                return usuario;
            }
        }
        return null;
    }

    
}