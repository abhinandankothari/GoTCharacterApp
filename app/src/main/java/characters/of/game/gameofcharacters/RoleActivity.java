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

public class RoleActivity extends AppCompatActivity {

    static final int RESULT_CODE = 1000;
    ImageView imageView;
    EditText fileName;
    Button button;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        imageView = (ImageView) findViewById(R.id.image_profile);
        fileName = (EditText) findViewById(R.id.fileName);
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
                if (fileName.getText().toString().trim().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RoleActivity.this);
                    builder.setMessage("NO IMAGE SELECTED")
                            .setTitle("WARNING");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                Log.d("selected radio group", radioGroup.getCheckedRadioButtonId() + "");

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
            fileName.setText(picturePath);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
