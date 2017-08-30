package com.sonngsoft.gui.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
public class MainActivity extends AppCompatActivity {

    public Button button1;
    private InterstitialAd myInter;

    EditText et;
    public void pegatexto(String arg){
        TextView textView;
        textView=(TextView)findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        //Colaraquiprabaixo
        arg=arg.trim();
        arg=arg.toLowerCase();
        arg=arg.replaceAll("   "," ");
        arg=arg.replaceAll("  "," ");
        arg=arg+" ";
        int interrog=0;
        int exclam=0;
        int reticen=0;
        double aspo =0;
        int i;
        String tempo="";
        for(i=0; i<arg.length();i++){
            if(arg.charAt(i)=='!'){exclam++;}
        }
        for(i=0; i<arg.length();i++){
            if(arg.charAt(i)=='?'){interrog++;}
        }
        for(i=0; i<arg.length();i++){
            if(arg.charAt(i)=='.'&&arg.charAt(i+1)=='.'&&arg.charAt(i)=='.'){reticen++;}
        }
        for(i=0; i<arg.length();i++){
            if(arg.charAt(i)=='\"'){aspo=aspo+0.5;}
        }
        arg=arg.replaceAll("!","");
        arg=arg.replaceAll("\\?","");
        arg=arg.replaceAll(",","");
        arg=arg.replaceAll("\\.","");
        arg=arg.replaceAll("\"","");
        arg=arg.replaceAll("\\{","");
        arg=arg.replaceAll("\\}","");
        arg=arg.replaceAll("\\[","");
        arg=arg.replaceAll("\\]","");
        arg=arg.replaceAll("\\(","");
        arg=arg.replaceAll("\\)","");
        arg=arg.replaceAll("\\'","");
        arg=arg.replaceAll("\\*","");
        arg=arg.replaceAll("\\+","");
        arg=arg.replaceAll("\\=","");
        arg=arg.replaceAll("\\¥","");
        arg=arg.replaceAll("   "," ");
        arg=arg.replaceAll("  "," ");
        int numeroespaco = 0;
        int x;
        int conta=1;

        for(i=0;i<arg.length();i++){if(arg.charAt(i)==' '){numeroespaco++;}}
        //encontrando tamanho do Array "b"

        String[] b=new String[numeroespaco];
        i=0;
        x=0;
        while(x<numeroespaco){
            while(arg.charAt(i)!=' '){
                tempo += arg.charAt(i);i++;}
            b[x]=tempo;
            tempo="";
            x++;
            i++;

        }
        Arrays.sort(b);
        //String[] novo={};
        List<String> novo= new ArrayList<>();
        int f;
        for (f=0;f<(b.length-1);f++){
            if (b[f].equals(b[f+1])){
                conta=conta+1;}
            else{
                if(conta<100){
                    if(conta<10){
                        //novo.splice(0,0,"00"+conta+" "+b[f]);conta=1;}
                        novo.add("00"+conta+" "+b[f]);conta=1;}
                    else{
                        //novo.splice(0,0,"0"+conta+" "+b[f]);conta=1;}}}};
                        novo.add("0"+conta+" "+b[f]);conta=1;}}}}
        conta=1;
        f=b.length-1;
        while (f>0){
            if(b[f].equals(b[f-1])){
                conta++;f--;}else{break;}
        }
        if(conta<100){
            if(conta<10){
                //novo.splice(0,0,"00"+conta+" "+b[f]);conta=1;}
                novo.add("00"+conta+" "+b[f]);}
            else{
                //novo.splice(0,0,"0"+conta+" "+b[f]);conta=1;}}}};
                novo.add("0"+conta+" "+b[f]);}}
        String[] novo2=new String[novo.size()];
        novo2=novo.toArray(novo2);
        Arrays.sort(novo2);
        Collections.reverse(Arrays.asList(novo2));
        String[] novofinal = new String[novo2.length];
        String[] numerofinal = new String[novo2.length];
        float[] numerofinal2 = new float[novo2.length];
        double[] numerof2 = new double[novo2.length];
        for(i=0;i<novofinal.length;i++){
            novofinal[i]=novo2[i].substring(4);
            numerofinal[i]=novo2[i].substring(0,3);
            numerofinal2[i]=Float.parseFloat(numerofinal[i]);
            numerofinal2[i]=numerofinal2[i]/b.length;
            numerof2[i]=(double)numerofinal2[i];

        }
        //calculando teste z para a palavra "a"
        float zA=0f;
        for(i=0;i<novofinal.length;i++){
            if ("a".equals(novofinal[i])){
                //teste z a
                zA=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.05)),2.0)))/0.01);
            }else{}
        }
        //calculando teste z para a palavra "de"
        float zDe=0f;
        for(i=0;i<novofinal.length;i++){
            if ("de".equals(novofinal[i])){
                //teste z de
                zDe=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.049)),2.0)))/0.01);
            }else{}
        }
        //calculando teste z para a palavra "o"
        float zO=0f;
        for(i=0;i<novofinal.length;i++){
            if ("o".equals(novofinal[i])){
                //teste z de
                zO=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.031)),2.0)))/0.004);
            }else{}
        }
        //calculando teste z para a palavra "que"
        float zQue=0f;
        for(i=0;i<novofinal.length;i++){
            if ("que".equals(novofinal[i])){
                //teste z de
                zQue=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.027)),2.0)))/0.0035);
            }else{}
        }
        //calculando teste z para a palavra "do"
        float zDo=0f;
        for(i=0;i<novofinal.length;i++){
            if ("do".equals(novofinal[i])){
                //teste z de
                zDo=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.016)),2.0)))/0.002);
            }else{}
        }
        //calculando teste z para a palavra "e"
        float zE=0f;
        for(i=0;i<novofinal.length;i++){
            if ("e".equals(novofinal[i])){
                //teste z de
                zE=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.022)),2.0)))/0.005);
            }else{}
        }
        //calculando teste z para a palavra "da"
        float zDa=0f;
        for(i=0;i<novofinal.length;i++){
            if ("da".equals(novofinal[i])){
                //teste z de
                zDa=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.018)),2.0)))/0.004);
            }else{}
        }
        //calculando teste z para a palavra "é"
        float zEh=0f;
        for(i=0;i<novofinal.length;i++){
            if ("é".equals(novofinal[i])){
                //teste z de
                zEh=(float) ((float) (Math.sqrt(Math.pow(((numerof2[i]-0.017)),2.0)))/0.003);
            }else{}
        }
        float zfinal = (zA+zDe+zO+zQue+zDo+zE+zDa+zEh)/8;
        String resultext = "";
        if(zfinal<=3){
            if(zfinal<=2){
                if(zfinal<=1){resultext="Ótimo";
                }else{resultext="Bom";}
            }else{resultext="Aceitável";}
        }else{resultext="Ruim";}
        String novoa="";
        if (b.length<320){novoa="Insira um texto com pelo menos 320 palavras";}else{
            novoa ="Qualidade do texto: "+resultext+"\n"+"\n"+"Total de Palavras: "+b.length+"\n"+"Número de Interrogações: "+interrog+"\n"+"Número de Exclamações: "+exclam+"\n"+"Número de Reticências: "+reticen+"\n"+"Número de Aspas(par): "+aspo+"\n"+"\n";
            for(i=0;i<novo2.length;i++){
                novoa = novoa+"Palavra: "+novofinal[i]+"     Quant.: "+numerofinal[i]+"\n";
            }}textView.setText(novoa);
    }

        public void init(){

            button1 = (Button)findViewById(R.id.button1);


            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et = (EditText) findViewById(R.id.editText);
                    String text= et.getEditableText().toString();
                    pegatexto(text);
                    myInter.show();

                }
            });
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this,"ca-app-pub-9351879656570560~6515714734");
        myInter=new InterstitialAd(this);
        myInter.setAdUnitId("ca-app-pub-9351879656570560/6376113933");
        myInter.loadAd(new AdRequest.Builder().build());
        setContentView(R.layout.activity_main);
        init();



    }
}
