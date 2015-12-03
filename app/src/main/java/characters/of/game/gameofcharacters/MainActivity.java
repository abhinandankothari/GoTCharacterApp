package characters.of.game.gameofcharacters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterList = (ListView) findViewById(R.id.character_list);
        characterList.setAdapter(new GotAdapter(this, GoTCharacter.GOT_CHARACTERS));
        characterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GoTCharacter gotCharacter = GoTCharacter.GOT_CHARACTERS[position];
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.characterKey, gotCharacter);
                startActivity(intent);
            }
        });
    }

}
