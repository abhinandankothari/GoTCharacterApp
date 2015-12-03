package characters.of.game.gameofcharacters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GotAdapter extends BaseAdapter {

    private GoTCharacter[] characters;
    private LayoutInflater layoutInflater;

    public GotAdapter(Context context, GoTCharacter[] characters) {
        this.characters = characters;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return characters.length;
    }

    @Override
    public GoTCharacter getItem(int position) {
        return characters[position];
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
        characterThumb.setImageResource(getItem(position).resId);
        characterName.setText(getItem(position).name);

        return view;
    }

}
