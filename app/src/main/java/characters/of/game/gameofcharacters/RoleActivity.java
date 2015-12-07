package characters.of.game.gameofcharacters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RoleActivity extends AppCompatActivity {

    static final int RESULT_CODE = 1000;
    ImageView imageView;
    EditText characterName;
    Button button;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        imageView = (ImageView) findViewById(R.id.image_profile);
        characterName = (EditText) findViewById(R.id.text_character_name);
        button = (Button) findViewById(R.id.addCharacter);
        radioGroup = (RadioGroup) findViewById(R.id.houseRadioGroup);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, RESULT_CODE);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String housename = null;
                int housedrawable = 0;
                if (characterName.getText().toString().trim().isEmpty()) {
                    characterName.setError("Cannot be empty");
                    return;
                }
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    new AlertDialog.Builder(RoleActivity.this).setMessage("NO HOUSE")
                            .setTitle("WARNING")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                }
                            })
                            .setCancelable(true)
                            .show();
                    return;
                }
                else {

                    switch (radioGroup.getCheckedRadioButtonId())
                    {
                        case R.id.radio_baratheon:
                            housedrawable = R.drawable.baratheon;
                            housename = "Baretheon";
                            break;
                        case R.id.radio_stark:
                            housedrawable = R.drawable.stark;
                            housename = "Stark";
                            break;
                        case R.id.radio_lannister:
                            housedrawable = R.drawable.lannister;
                            housename = "Lannister" ;
                            break;
                        case R.id.radio_bolton:
                            housedrawable = R.drawable.bolton;
                            housename =  "Bolton";
                            break;
                    }
                }

                String filePath = (String) imageView.getTag();
                if (filePath == null) {
                    new AlertDialog.Builder(RoleActivity.this).setMessage("No Image")
                            .setTitle("WARNING")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                }
                            })
                            .setCancelable(true)
                            .show();
                    return;
                }

                GoTCharacter newCharacter =  new GoTCharacter(characterName.getText().toString(), filePath, filePath, true, housename, housedrawable, "From the app");
                DbHelper helper = DbHelper.getInstance(RoleActivity.this);
                helper.addcharacter(newCharacter);
                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(data.getData(), projection, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(projection[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Log.d("GOT", picturePath);
            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            imageView.setImageBitmap(bitmap);
            imageView.setTag("file://" + picturePath);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
