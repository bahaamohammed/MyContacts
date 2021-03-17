package com.bahaadev.mycontacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddContact extends AppCompatActivity {

    EditText etContactName,etContactPhone,etContactAddress;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etContactName = findViewById(R.id.etContactName);
        etContactPhone = findViewById(R.id.etContactPhone);
        etContactAddress = findViewById(R.id.etContactAddress);

    }

    public void saveToFirebase(View v){
        String contactName = etContactName.getText().toString();
        String contactPhone = etContactPhone.getText().toString();
        String contactAddress = etContactAddress.getText().toString();

        Map<String,Object> contact = new HashMap<>();
        contact.put("name",contactName);
        contact.put("phone",contactPhone);
        contact.put("address",contactAddress);

        db.collection("contacts").add(contact)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(AddContact.this, "Success to Add Contact", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddContact.this, "Failed to Add Contact", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}