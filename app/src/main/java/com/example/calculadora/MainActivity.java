package com.example.calculadora;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numerozero;
    private Button numeroum;
    private Button numerodois;
    private Button numerotres;
    private Button numeroquatro;
    private Button numerocinco;
    private Button numeroseis;
    private Button numerosete;
    private Button numerooito;
    private Button numeronove;
    private Button abre_colchetes;
    private Button fecha_colchetes;
    private Button soma;
    private Button subtracao;
    private Button multiplicacao;
    private Button divisao;
    private Button igual;
    private Button ponto;
    private Button porcentagem;


    private ImageView backspace;
    private TextView expressao, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponente();
        getSupportActionBar().hide();

        numerozero.setOnClickListener(this);
        numeroum.setOnClickListener(this);
        numerodois.setOnClickListener(this);
        numerotres.setOnClickListener(this);
        numeroquatro.setOnClickListener(this);
        numerocinco.setOnClickListener(this);
        numeroseis.setOnClickListener(this);
        numerosete.setOnClickListener(this);
        numerooito.setOnClickListener(this);
        numeronove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        abre_colchetes.setOnClickListener(this);
        fecha_colchetes.setOnClickListener(this);
        porcentagem.setOnClickListener(this);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length() -1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression expression = new ExpressionBuilder(expressao.getText().toString()).build();
                double result = expression.evaluate();
                long longResult = (long) result;

                if (result == (double) longResult){

                    resultado.setText((CharSequence) String.valueOf(longResult));

                }else {
                    resultado.setText((CharSequence) String.valueOf(resultado));

                }
            }
        });











    }

    private void IniciarComponente(){
        numerozero = findViewById(R.id.zero);
        numeroum = findViewById(R.id.um);
        numerodois = findViewById(R.id.dois);
        numerotres = findViewById(R.id.tres);
        numeroquatro = findViewById(R.id.quatro);
        numerocinco = findViewById(R.id.cinco);
        numeroseis = findViewById(R.id.seis);
        numerosete = findViewById(R.id.sete);
        numerooito = findViewById(R.id.oito);
        numeronove = findViewById(R.id.nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        abre_colchetes = findViewById(R.id.abre_colchetes);
        fecha_colchetes = findViewById(R.id.fecha_colchetes);
        porcentagem = findViewById(R.id.porcentagem);
        backspace = findViewById(R.id.backspace);
        expressao = findViewById(R.id.expressao);
        resultado = findViewById(R.id.resultado);




    }

    public void AscrecentarExpressao(String string, boolean limpar_dados){

        if(resultado.getText().equals("")){
            expressao.setText(" ");
        }

        if(limpar_dados){
            resultado.setText(" ");
            expressao.append(string);
        }else{
            expressao.append(resultado.getText());
            expressao.append(string);
            resultado.setText(" ");

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.zero:
                AscrecentarExpressao("0", true);
                break;
            case R.id.um:
                AscrecentarExpressao("1", true);
                break;
            case R.id.dois:
                AscrecentarExpressao("2", true);
                break;
            case R.id.tres:
                AscrecentarExpressao("3", true);
                break;
            case R.id.quatro:
                AscrecentarExpressao("4", true);
                break;
            case R.id.cinco:
                AscrecentarExpressao("5", true);
                break;
            case R.id.seis:
                AscrecentarExpressao("6", true);
                break;
            case R.id.sete:
                AscrecentarExpressao("7", true);
                break;
            case R.id.oito:
                AscrecentarExpressao("8", true);
                break;
            case R.id.nove:
                AscrecentarExpressao("9", true);
                break;
            case R.id.ponto:
                AscrecentarExpressao(".", true);
                break;
            case R.id.soma:
                AscrecentarExpressao("+", false);
                break;
            case R.id.subtracao:
                AscrecentarExpressao("-", false);
                break;
            case R.id.divisao:
                AscrecentarExpressao("/", false);
                break;
            case R.id.multiplicacao:
                AscrecentarExpressao("*", false);
                break;
            case R.id.abre_colchetes:
                AscrecentarExpressao("(", true);
                break;
            case R.id.fecha_colchetes:
                AscrecentarExpressao(")", true);
                break;
            case R.id.igual:
                AscrecentarExpressao("=", true);
                break;

        }
    }
}