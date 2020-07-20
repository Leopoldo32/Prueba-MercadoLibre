package co.com.rhonaldelgado.mercadolibre.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import co.com.rhonaldelgado.mercadolibre.retrofit.Address;

@Entity(tableName = "result_table")
public class ResultEntity {

    @PrimaryKey(autoGenerate = true)
    public int idRoom;
    private String id;
    private String title;
    private String price;
    private String currency;
    private String thumbnail;
    private String condition;
    private String permalink;
    private String state_id;
    private String state_name;
    private String city_id;
    private String city_name;


    public ResultEntity(String id, String title, String price, String currency, String thumbnail, String condition, String permalink, String state_id, String state_name, String city_id, String city_name) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.thumbnail = thumbnail;
        this.condition = condition;
        this.permalink = permalink;
        this.state_id = state_id;
        this.state_name = state_name;
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
