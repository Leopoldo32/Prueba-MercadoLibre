package co.com.rhonaldelgado.mercadolibre.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.com.rhonaldelgado.mercadolibre.db.dao.ResultDao;
import co.com.rhonaldelgado.mercadolibre.db.entity.ResultEntity;

@Database(entities = {ResultEntity.class}, version = 1)
public abstract class MeLiRoomDatabase extends RoomDatabase {

    public abstract ResultDao resultDao();
    private static volatile MeLiRoomDatabase INSTANCE;

    public static MeLiRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (MeLiRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MeLiRoomDatabase.class, "meli_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}
