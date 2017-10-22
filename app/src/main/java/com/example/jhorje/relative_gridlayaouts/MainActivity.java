package com.example.jhorje.relative_gridlayaouts;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.id.list;

public class MainActivity extends Activity {

    private GridLayout gridFotos;
    private RelativeLayout rl;
    private TextView album01, foto01, foto2;
    private ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar elementos de la vista
        album01 = (TextView) findViewById(R.id.album1) ;
        gridFotos = (GridLayout) findViewById(R.id.gridFotos);
        foto01 = (TextView) findViewById(R.id.formatoFoto);
        rl = (RelativeLayout) findViewById(R.id.relative);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.album1:
                System.out.println("Has pulsado el album 01");
                gridFotos.setBackgroundColor(getColor(R.color.Red));
                generarFotos(40);
                break;
            case R.id.album2:
                System.out.println("Has pulsado el album 02");
                gridFotos.setBackgroundColor(getColor(R.color.Blue));
                generarFotos(50);
                break;
            case R.id.album3:
                System.out.println("Has pulsado el album 03");
                gridFotos.setBackgroundColor(getColor(R.color.Green));
                generarFotos(80);
                break;
            case R.id.album4:
                System.out.println("Has pulsado el album 04");
                gridFotos.setBackgroundColor(getColor(R.color.Black));
                generarFotos(100);
                break;
        }
    }

    public void generarFotos (int cantidad) {
        System.out.println("Borrando elementos");
        gridFotos.removeAllViews();

        //Comienzo a generar fotos
        int total = cantidad;
        int column = 2;
        int row = cantidad / column;

        for (int i=0; i < cantidad; i++)  {
            //Genera TextView clonado del base
            TextView tv = generaFormatoFoto(i+1);

            //Asigna valores de los LayoutParams
            GridLayout.LayoutParams lp = new GridLayout.LayoutParams(findViewById(R.id.gridFotosIn).getLayoutParams());

            //Convierte calcula los pixeles equivalentes a 5dpi
            int numMarg = Math.round(5 * this.getResources().getDisplayMetrics().density);
            lp.setMargins(numMarg,numMarg,numMarg,numMarg);

            //Asigna parametros Layout al nuevo elemento
            tv.setLayoutParams(lp);

            //Añade elemento a la GridView
            gridFotos.addView(tv);
        }

    }

    public TextView generaFormatoFoto(int num){
        System.out.println("Se ha clonado " + num + " texto");
        TextView cloned = new TextView(this);
        cloned.setLayoutParams(foto01.getLayoutParams());
        cloned.setBackground(foto01.getBackground());
        cloned.setText("Foto " + num);
        cloned.setTextAlignment(foto01.getTextAlignment());
        cloned.setTextSize(20);
        cloned.setWidth(5);

        return cloned;
    }
}
