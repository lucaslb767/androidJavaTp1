package com.example.lucasbarrozo.tp1_desenvolvimentojava_lucasbarrozo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

        mEdt
    }
}
