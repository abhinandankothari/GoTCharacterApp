package characters.of.game.gameofcharacters;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abhinandan on 04/12/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GoT.db";
    public static final int VERSION = 1;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSql = "CREATE TABLE " + GoTCharacter.GOT_TABLE + "(" +
                GoTCharacter._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                GoTCharacter.NAME + " TEXT," +
                GoTCharacter.THUMB_URL + " TEXT," +
                GoTCharacter.FULL_URL + " TEXT," +
                GoTCharacter.HOUSE + " TEXT," +
                GoTCharacter.HOUSE_RES_ID + " INTEGER," +
                GoTCharacter.DESCRIPTION + " TEXT);";

        db.execSQL(createSql);

        ContentValues values = new ContentValues();
        for (GoTCharacter gotchar : GoTCharacter.GOT_CHARACTERS) {
            values.put(GoTCharacter.NAME, gotchar.name);
            values.put(GoTCharacter.THUMB_URL, gotchar.thumbUrl);
            values.put(GoTCharacter.FULL_URL, gotchar.fullUrl);
            values.put(GoTCharacter.HOUSE, gotchar.house);
            values.put(GoTCharacter.HOUSE_RES_ID, gotchar.houseResId);
            values.put(GoTCharacter.DESCRIPTION, gotchar.description);
            db.insert(GoTCharacter.GOT_TABLE, null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int getRowCount() {
        return (int) DatabaseUtils.longForQuery(getReadableDatabase(), "select count(*) from " + GoTCharacter.GOT_TABLE, new String[0]);
    }
}
