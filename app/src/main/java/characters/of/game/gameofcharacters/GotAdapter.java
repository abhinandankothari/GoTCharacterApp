package characters.of.game.gameofcharacters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GotAdapter extends BaseAdapter {

    private Context context;
    private GoTCharacter[] characters;
    private LayoutInflater layoutInflater;
    private final Cursor cursor;

    public GotAdapter(Context context, GoTCharacter[] characters) {
        this.context = context;
        this.characters = characters;
        layoutInflater = LayoutInflater.from(context);
        DbHelper dbHelper = new DbHelper(context);
        cursor = dbHelper.getAllRows();
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public GoTCharacter getItem(int position) {
        cursor.moveToPosition(position);
        return new GoTCharacter(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                true,
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getString(6)
        );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.got_list_view, parent, false);
        } else {
            view = convertView;
        }

        ImageView characterThumb = (ImageView) view.findViewById(R.id.character_thumb);
        TextView characterName = (TextView) view.findViewById(R.id.character_name);
        GoTCharacter item = getItem(position);
        Picasso.with(context)
                .load(item.thumbUrl)
                .placeholder(R.drawable.profile_placeholder)
                .error(R.drawable.profile_placeholder_error)
                .into(characterThumb);
        characterName.setText(item.name);
        return view;
    }

}
