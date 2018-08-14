package com.example.lucasbarrozo.tp1_desenvolvimentojava_lucasbarrozo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ContactInformation extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);

        TextView mTxtNome = findViewById(R.id.txtNomeContato);
        TextView mTxtTelefone = findViewById(R.id.txtTelefoneContato);
        TextView mTxtEmail = findViewById(R.id.txtEmailContato);
        TextView mTxtCidade = findViewById(R.id.txtCidadeContato);

        Intent intent = getIntent();
        String nomeContato = (String) intent.getSerializableExtra("nomes");
        String telefoneContato = (String) intent.getSerializableExtra("telefones");
        String emailContato = (String) intent.getSerializableExtra("emails");
        String cidadeContato = (String) intent.getSerializableExtra("cidades");

        mTxtNome.setText(nomeContato);
        mTxtTelefone.setText(telefoneContato);
        mTxtEmail.setText(emailContato);
        mTxtCidade.setText(cidadeContato);
    }
}
