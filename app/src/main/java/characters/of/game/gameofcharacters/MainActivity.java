package characters.of.game.gameofcharacters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterList = (ListView) findViewById(R.id.character_list);
        characterList.setAdapter(new GotAdapter(this, Strings.GOT_CHARACTERS_1));
    }

}
