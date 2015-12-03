package characters.of.game.gameofcharacters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String characterKey = "character";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        GoTCharacter character = extras.getParcelable(characterKey);

        TextView characterName = (TextView) findViewById(R.id.character_name);
        ImageView characterImage = (ImageView) findViewById(R.id.character_img);
        ImageView houseThumb = (ImageView) findViewById(R.id.house_thumb);
        TextView houseDetail = (TextView) findViewById(R.id.house_detail);
        TextView houseName = (TextView) findViewById(R.id.house_name);

        characterName.setText(character.name);
        characterImage.setImageResource(character.fullResId);
        houseThumb.setImageResource(character.houseResId);
        houseDetail.setText(character.description);
        houseName.setText(character.house);
    }
}
