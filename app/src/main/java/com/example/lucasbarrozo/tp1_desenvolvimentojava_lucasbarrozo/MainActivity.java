package com.example.lucasbarrozo.tp1_desenvolvimentojava_lucasbarrozo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String mNomeSalvo = "Nome";
    private String mTelefoneSalvo = "Telefone";
    private String mEmailSalvo = "Email";
    private String mCidadeSalvo = "Cidade";
    private EditText mEdtNome;
    private EditText mEdtTelefone;
    private EditText mEdtEmail;
    private EditText mEdtCidade;
    private Button mBtnSalvar;
    private Button mBtnLimpar;
    private Button mBtnVisualizarContatos;
    private final int WRITE_EXTERNAL_STORAGE_PERMISSION_CODE = 1;
    private final int READ_EXTERNAL_STORAGE_PERMISSION_CODE = 2;
    private List<String> mListaNomes = new ArrayList<>();
    private List<String> mListaTelefones = new ArrayList<>();
    private List<String> mListaEmails = new ArrayList<>();
    private List<String> mListaCidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtNome = findViewById(R.id.edtNome);
        mEdtTelefone = findViewById(R.id.edtTelefone);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtCidade = findViewById(R.id.edtCidade);

        mBtnSalvar = findViewById(R.id.btnSalvar);
        mBtnSalvar.setOnClickListener(salvarContato);
    }

    public View.OnClickListener salvarContato = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Contact contato = new Contact();

            String nome = mEdtNome.getText().toString().trim();
            String telefone = mEdtTelefone.getText().toString().trim();
            String email = mEdtEmail.getText().toString().trim();
            String cidade = mEdtCidade.getText().toString().trim();

            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cidade.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Formulário Incompleto!", Toast.LENGTH_SHORT).show();
            } else if (mListaNomes.contains(nome)) {
                Toast.makeText(getApplicationContext(), "Contato já cadastrado", Toast.LENGTH_SHORT).show();
            } else {

                contato.setNome(nome);
                contato.setTelefone(telefone);
                contato.setEmail(email);
                contato.setCidade(cidade);

                mListaNomes.add(contato.getNome());
                StringBuilder nomes = new StringBuilder("");

                for(String nomeContato : mListaNomes) {
                    nomes.append(nomeContato).append("-");
                }

                try {

                    FileOutputStream fos = openFileOutput(mNomeSalvo, Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(),"Falha ao carregar nomes", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"Falha ao carregar nomes", Toast.LENGTH_SHORT).show();
                }

                mListaTelefones.add(contato.getTelefone());
                StringBuilder telefones = new StringBuilder();
                for (String telefoneContato : mListaTelefones)
                    telefones.append(telefoneContato).append("-");

                try {
                    FileOutputStream fos = openFileOutput(mTelefoneSalvo, Context.MODE_PRIVATE);

                    fos.write(telefones.toString().getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Falha ao carregar telefone!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Falha ao carregar telefone!", Toast.LENGTH_SHORT).show();
                }

                mListaEmails.add(contato.getEmail());
                StringBuilder emails = new StringBuilder("");
                for (String emailContato : mListaEmails)
                    emails.append(emailContato).append("-");

                try {
                    FileOutputStream fos = openFileOutput(mEmailSalvo, Context.MODE_PRIVATE);

                    fos.write(emails.toString().getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Falha ao carregar email!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Falha ao carregar email!", Toast.LENGTH_SHORT).show();
                }

                mListaCidades.add(contato.getCidade());
                StringBuilder cidades = new StringBuilder("");
                for (String cidadeContato : mListaCidades)
                    cidades.append(cidadeContato).append("-");

                try {
                    FileOutputStream fos = openFileOutput(mCidadeSalvo, Context.MODE_PRIVATE);

                    fos.write(cidades.toString().getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Falha ao carregar cidade!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Falha ao carregar cidade!", Toast.LENGTH_SHORT).show();
                }

                mEdtCidade.setText("-");
                mEdtTelefone.setText("-");
                mEdtEmail.setText("-");
                mEdtNome.setText("-");
                mEdtNome.requestFocus();

                Toast.makeText(getApplicationContext(),"Contato salvo!",Toast.LENGTH_SHORT).show();
            }
        }
    };


}
