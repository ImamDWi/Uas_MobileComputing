package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Createdata extends Activity implements OnClickListener{
    //inisilisasi elemen-elemen pada layout
    private Button buttonSubmit;
    private EditText edNama;
    private EditText edMerk;
    private EditText edHarga;

    //inisialisasi kontroller/Data Source
    private DBDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdata);

        buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(this);

        edNama = (EditText) findViewById(R.id.nama_barang);
        edHarga = (EditText) findViewById(R.id.harga_barang);
        edMerk = (EditText) findViewById(R.id.merk_barang);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSource(this);

        //membuat sambungan baru ke database
        dataSource.open();
    }

    //Ketika Tombol Submit diklik
    @Override
    public void onClick(View v) {
        // Inisialisasi data barang
        String nama = null;
        String merk = null;
        String harga = null;

        //@SuppressWarnings("unused")

        //inisialisasi barang baru
        Barang barang = null;
        if(edNama.getText()!=null && edMerk.getText()!=null &&edHarga.getText()!=null)
        {
            /* jika field nama, merk, dan harga tidak boleh dikosongkan
             * maka masukkan ke dalam data barang*/
            nama = edNama.getText().toString();
            merk = edMerk.getText().toString();
            harga = edHarga.getText().toString();

        }

        switch(v.getId())
        {
            case R.id.button_submit:
                // insert data barang baru
                barang = dataSource.createBarang(nama, merk, harga);

                //konfirmasi
                Toast.makeText(this, "Data Tersimpan\n" +
                        "nama" + barang.getNama_barang() +
                        "merk" + barang.getMerk_barang() +
                        "harga" + barang.getHarga_barang(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}



