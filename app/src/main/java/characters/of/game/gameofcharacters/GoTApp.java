package characters.of.game.gameofcharacters;

import android.app.Application;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

/**
 * Created by abhinandan on 04/12/15.
 */
public class GoTApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Picasso picasso = new Picasso.Builder(this)
                .loggingEnabled(true)
                .memoryCache(new LruCache(1024 * 1024 * 30))
                .build();

        Picasso.setSingletonInstance(picasso);
    }


}
