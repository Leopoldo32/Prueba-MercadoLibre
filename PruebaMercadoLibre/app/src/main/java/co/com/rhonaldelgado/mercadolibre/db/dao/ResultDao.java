package co.com.rhonaldelgado.mercadolibre.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.rhonaldelgado.mercadolibre.db.entity.ResultEntity;

@Dao
public interface ResultDao {

    @Insert
    void insert(ResultEntity resultEntity);

    @Update
    void update(ResultEntity resultEntity);

    @Query("DELETE FROM result_table")
    void deleteAll();

    @Query("SELECT * FROM result_table ORDER BY title ASC")
    LiveData<List<ResultEntity>> getAll();

    @Query("SELECT * FROM result_table WHERE idRoom = :roomId")
    LiveData<List<ResultEntity>> getResultsById(int roomId);
}
