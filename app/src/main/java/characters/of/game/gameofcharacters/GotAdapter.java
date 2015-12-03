package characters.of.game.gameofcharacters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GotAdapter extends BaseAdapter {

    private String[] characters;
    private LayoutInflater layoutInflater;

    public GotAdapter(Context context, String[] characters) {
        this.characters = characters;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return characters.length * 1000;
    }

    @Override
    public String getItem(int position) {
        return characters[position % characters.length];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        } else {
            view = convertView;
        }

        ((TextView) view).setText(getItem(position));
        return view;
    }

}
