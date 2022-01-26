package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName;
    private EditText edtBirthdate;
    private EditText edtKelas;
    private EditText edtAddress;
    private EditText edtHobby;
    private Button btnSave;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtBirthdate = findViewById(R.id.edt_birthdate);
        edtKelas = findViewById(R.id.edt_kelas);
        edtAddress = findViewById(R.id.edt_address);
        edtHobby = findViewById(R.id.edt_hobby);
        btnSave = findViewById(R.id.btn_save);
        tvResult = findViewById(R.id.tv_result);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        if (v.getId() == R.id.btn_save) {
            String inputName = edtName.getText().toString().trim();
            String inputBirthdate = edtBirthdate.getText().toString().trim();
            String inputKelas = edtKelas.getText().toString().trim();
            String inputAddress = edtAddress.getText().toString().trim();
            String inputHobby = edtHobby.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidString = false;

            if (TextUtils.isEmpty(inputName)){
                isEmptyFields = true;
                edtName.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputBirthdate)){
                isEmptyFields = true;
                edtBirthdate.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputKelas)){
                isEmptyFields = true;
                edtKelas.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputAddress)){
                isEmptyFields = true;
                edtAddress.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHobby)){
                isEmptyFields = true;
                edtHobby.setError("Field ini tidak boleh kosong");
            }

            String name = toString(inputName);
            String birthdate = toString(inputBirthdate);
            String kelas = toString(inputKelas);
            String address = toString(inputAddress);
            String hobby = toString(inputHobby);

            if (name == null){
                isInvalidString = true;
                edtName.setError("Field ini harus berupa nama yang valid");
            }

            if (birthdate == null){
                isInvalidString = true;
                edtBirthdate.setError("Field ini harus berupa tanggal yang valid");
            }

            if (kelas == null){
                isInvalidString = true;
                edtKelas.setError("Field ini harus berupa kelas yang valid");
            }

            if (address == null){
                isInvalidString = true;
                edtAddress.setError("Field ini harus berupa alamat yang valid");
            }

            if (hobby == null){
                isInvalidString = true;
                edtHobby.setError("Field ini harus berupa hobi yang valid");
            }

            if (!isEmptyFields && !isInvalidString){
                String output1 = "Nama: "+ name;
                String output2 = "TTL: "+ birthdate;
                String output3 = "Kelas: "+kelas;
                String output4 = "Alamat: "+address;
                String output5 = "Hobi: "+hobby;
                tvResult.setText(String.valueOf(output1)+"\n"
                        +(output2)+"\n"
                        +(output3)+"\n"
                        +(output4)+"\n"
                        +(output5));
            }
            }
        }


    private String toString(String str) {
        try{
            return String.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
