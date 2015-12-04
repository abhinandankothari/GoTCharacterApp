package characters.of.game.gameofcharacters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    public static final String characterKey = "character";
    public static final String LOG_TAG = "GOT_APP";
    Context context = this.context;

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

        Picasso.with(this).load("https://winteriscoming.net/wp-content/uploads/2011/04/jon-on-wall.jpg")
                .placeholder(R.drawable.profile_placeholder)
                .error(R.drawable.profile_placeholder_error)
                .into(characterImage);

        Picasso.with(this).load(character.houseResId)
                .placeholder(R.drawable.house_placeholder)
                .error(R.drawable.house_placeholder_error)
                .into(houseThumb);

//        houseThumb.setImageResource(character.houseResId);

        houseDetail.setText(character.description);
        houseName.setText(character.house);
    }

}
