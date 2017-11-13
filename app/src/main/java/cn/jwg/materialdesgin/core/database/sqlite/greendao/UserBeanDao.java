package cn.jwg.materialdesgin.core.database.sqlite.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.jwg.materialdesgin.core.database.sqlite.bean.UserBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_BEAN".
*/
public class UserBeanDao extends AbstractDao<UserBean, Void> {

    public static final String TABLENAME = "USER_BEAN";

    /**
     * Properties of entity UserBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property UId = new Property(0, String.class, "uId", false, "U_ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Area = new Property(2, String.class, "area", false, "AREA");
        public final static Property Address = new Property(3, String.class, "address", false, "ADDRESS");
        public final static Property Avatar = new Property(4, String.class, "avatar", false, "AVATAR");
        public final static Property Tel = new Property(5, String.class, "tel", false, "TEL");
        public final static Property Birthday = new Property(6, long.class, "birthday", false, "BIRTHDAY");
        public final static Property Sex = new Property(7, int.class, "sex", false, "SEX");
        public final static Property Status = new Property(8, int.class, "status", false, "STATUS");
        public final static Property Type = new Property(9, int.class, "type", false, "TYPE");
        public final static Property Height = new Property(10, String.class, "height", false, "HEIGHT");
        public final static Property Weight = new Property(11, String.class, "weight", false, "WEIGHT");
        public final static Property Waistline = new Property(12, String.class, "waistline", false, "WAISTLINE");
        public final static Property Marriage = new Property(13, int.class, "marriage", false, "MARRIAGE");
        public final static Property Education = new Property(14, int.class, "education", false, "EDUCATION");
        public final static Property Ethnicity = new Property(15, String.class, "ethnicity", false, "ETHNICITY");
    }


    public UserBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UserBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_BEAN\" (" + //
                "\"U_ID\" TEXT," + // 0: uId
                "\"NAME\" TEXT," + // 1: name
                "\"AREA\" TEXT," + // 2: area
                "\"ADDRESS\" TEXT," + // 3: address
                "\"AVATAR\" TEXT," + // 4: avatar
                "\"TEL\" TEXT," + // 5: tel
                "\"BIRTHDAY\" INTEGER NOT NULL ," + // 6: birthday
                "\"SEX\" INTEGER NOT NULL ," + // 7: sex
                "\"STATUS\" INTEGER NOT NULL ," + // 8: status
                "\"TYPE\" INTEGER NOT NULL ," + // 9: type
                "\"HEIGHT\" TEXT," + // 10: height
                "\"WEIGHT\" TEXT," + // 11: weight
                "\"WAISTLINE\" TEXT," + // 12: waistline
                "\"MARRIAGE\" INTEGER NOT NULL ," + // 13: marriage
                "\"EDUCATION\" INTEGER NOT NULL ," + // 14: education
                "\"ETHNICITY\" TEXT);"); // 15: ethnicity
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        String uId = entity.getUId();
        if (uId != null) {
            stmt.bindString(1, uId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(3, area);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(4, address);
        }
 
        String avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindString(5, avatar);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(6, tel);
        }
        stmt.bindLong(7, entity.getBirthday());
        stmt.bindLong(8, entity.getSex());
        stmt.bindLong(9, entity.getStatus());
        stmt.bindLong(10, entity.getType());
 
        String height = entity.getHeight();
        if (height != null) {
            stmt.bindString(11, height);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(12, weight);
        }
 
        String waistline = entity.getWaistline();
        if (waistline != null) {
            stmt.bindString(13, waistline);
        }
        stmt.bindLong(14, entity.getMarriage());
        stmt.bindLong(15, entity.getEducation());
 
        String ethnicity = entity.getEthnicity();
        if (ethnicity != null) {
            stmt.bindString(16, ethnicity);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        String uId = entity.getUId();
        if (uId != null) {
            stmt.bindString(1, uId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(3, area);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(4, address);
        }
 
        String avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindString(5, avatar);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(6, tel);
        }
        stmt.bindLong(7, entity.getBirthday());
        stmt.bindLong(8, entity.getSex());
        stmt.bindLong(9, entity.getStatus());
        stmt.bindLong(10, entity.getType());
 
        String height = entity.getHeight();
        if (height != null) {
            stmt.bindString(11, height);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(12, weight);
        }
 
        String waistline = entity.getWaistline();
        if (waistline != null) {
            stmt.bindString(13, waistline);
        }
        stmt.bindLong(14, entity.getMarriage());
        stmt.bindLong(15, entity.getEducation());
 
        String ethnicity = entity.getEthnicity();
        if (ethnicity != null) {
            stmt.bindString(16, ethnicity);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public UserBean readEntity(Cursor cursor, int offset) {
        UserBean entity = new UserBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // uId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // area
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // address
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // avatar
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // tel
            cursor.getLong(offset + 6), // birthday
            cursor.getInt(offset + 7), // sex
            cursor.getInt(offset + 8), // status
            cursor.getInt(offset + 9), // type
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // height
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // weight
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // waistline
            cursor.getInt(offset + 13), // marriage
            cursor.getInt(offset + 14), // education
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15) // ethnicity
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserBean entity, int offset) {
        entity.setUId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setArea(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAddress(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAvatar(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTel(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBirthday(cursor.getLong(offset + 6));
        entity.setSex(cursor.getInt(offset + 7));
        entity.setStatus(cursor.getInt(offset + 8));
        entity.setType(cursor.getInt(offset + 9));
        entity.setHeight(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setWeight(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setWaistline(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setMarriage(cursor.getInt(offset + 13));
        entity.setEducation(cursor.getInt(offset + 14));
        entity.setEthnicity(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(UserBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(UserBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(UserBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
