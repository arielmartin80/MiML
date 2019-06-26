package com.example.myml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends AppCompatActivity {

    @BindView (R.id.tv_resultado)
    TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        String dato = getIntent().getStringExtra("dato");
        tv_resultado.setText(dato);

    }

    //metodo para ir a la descripcion
    @OnClick(R.id.item1)
    public void IrADescripcion(View view){
        Intent i = new Intent(this, DescriptionActivity.class);
        i.putExtra("dato", tv_resultado.getText().toString());
        startActivity(i);
    }


}
