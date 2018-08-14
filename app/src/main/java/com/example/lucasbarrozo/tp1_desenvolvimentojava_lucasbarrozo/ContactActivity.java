package com.example.lucasbarrozo.tp1_desenvolvimentojava_lucasbarrozo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mListaNomes = new ArrayList<>();
    private List<String> mListaTelefones = new ArrayList<>();
    private List<String> mListaEmails = new ArrayList<>();
    private List<String> mListaCidades = new ArrayList<>();
    private Button mNovoContato;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mNovoContato = findViewById(R.id.btnNovoContato);
        mNovoContato.setOnClickListener(irFormulario);

        mListView = findViewById(R.id.listViewContatos);

        final Intent intent = getIntent();
        mListaNomes = intent.getStringArrayListExtra("nomes");
        mListaTelefones = intent.getStringArrayListExtra("telefones");
        mListaEmails = intent.getStringArrayListExtra("emails");
        mListaCidades = intent.getStringArrayListExtra("cidades");

        mListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.names, R.id.txtNomeContatos, mListaNomes));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent informacoesContatoIntent = new Intent(ContactActivity.this, ContactInformation.class);
                informacoesContatoIntent.putExtra("nomes", mListaNomes.get(position));
                informacoesContatoIntent.putExtra("telefones", mListaTelefones.get(position));
                informacoesContatoIntent.putExtra("emails", mListaEmails.get(position));
                informacoesContatoIntent.putExtra("cidades", mListaCidades.get(position));
                startActivity(informacoesContatoIntent);

            }
        });
    }

    View.OnClickListener irFormulario = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
