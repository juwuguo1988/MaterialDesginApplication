package cn.jwg.materialdesgin.core.database.sqlite.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.jwg.materialdesgin.core.database.sqlite.bean.MedicPlan;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEDIC_PLAN".
*/
public class MedicPlanDao extends AbstractDao<MedicPlan, Long> {

    public static final String TABLENAME = "MEDIC_PLAN";

    /**
     * Properties of entity MedicPlan.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Mid = new Property(0, Long.class, "mid", true, "_id");
        public final static Property PlanId = new Property(1, String.class, "planId", false, "PLAN_ID");
        public final static Property TakeAt = new Property(2, int.class, "takeAt", false, "TAKE_AT");
        public final static Property MedicineId = new Property(3, String.class, "medicineId", false, "MEDICINE_ID");
        public final static Property MedicineName = new Property(4, String.class, "medicineName", false, "MEDICINE_NAME");
        public final static Property MedicineHash = new Property(5, String.class, "medicineHash", false, "MEDICINE_HASH");
        public final static Property MedicineVia = new Property(6, int.class, "medicineVia", false, "MEDICINE_VIA");
        public final static Property Count = new Property(7, int.class, "count", false, "COUNT");
        public final static Property Dosage = new Property(8, int.class, "dosage", false, "DOSAGE");
        public final static Property CycleDays = new Property(9, int.class, "cycleDays", false, "CYCLE_DAYS");
        public final static Property Zone = new Property(10, int.class, "zone", false, "ZONE");
        public final static Property PositionNo = new Property(11, int.class, "positionNo", false, "POSITION_NO");
        public final static Property DosageUnit = new Property(12, String.class, "dosageUnit", false, "DOSAGE_UNIT");
        public final static Property Started = new Property(13, Long.class, "started", false, "STARTED");
        public final static Property Ended = new Property(14, Long.class, "ended", false, "ENDED");
        public final static Property RemindFirstAt = new Property(15, Long.class, "remindFirstAt", false, "REMIND_FIRST_AT");
        public final static Property BoxUuid = new Property(16, String.class, "boxUuid", false, "BOX_UUID");
        public final static Property PlanSeqWithBox = new Property(17, String.class, "planSeqWithBox", false, "PLAN_SEQ_WITH_BOX");
    }


    public MedicPlanDao(DaoConfig config) {
        super(config);
    }
    
    public MedicPlanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEDIC_PLAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: mid
                "\"PLAN_ID\" TEXT," + // 1: planId
                "\"TAKE_AT\" INTEGER NOT NULL ," + // 2: takeAt
                "\"MEDICINE_ID\" TEXT," + // 3: medicineId
                "\"MEDICINE_NAME\" TEXT," + // 4: medicineName
                "\"MEDICINE_HASH\" TEXT," + // 5: medicineHash
                "\"MEDICINE_VIA\" INTEGER NOT NULL ," + // 6: medicineVia
                "\"COUNT\" INTEGER NOT NULL ," + // 7: count
                "\"DOSAGE\" INTEGER NOT NULL ," + // 8: dosage
                "\"CYCLE_DAYS\" INTEGER NOT NULL ," + // 9: cycleDays
                "\"ZONE\" INTEGER NOT NULL ," + // 10: zone
                "\"POSITION_NO\" INTEGER NOT NULL ," + // 11: positionNo
                "\"DOSAGE_UNIT\" TEXT," + // 12: dosageUnit
                "\"STARTED\" INTEGER," + // 13: started
                "\"ENDED\" INTEGER," + // 14: ended
                "\"REMIND_FIRST_AT\" INTEGER," + // 15: remindFirstAt
                "\"BOX_UUID\" TEXT," + // 16: boxUuid
                "\"PLAN_SEQ_WITH_BOX\" TEXT);"); // 17: planSeqWithBox
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEDIC_PLAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MedicPlan entity) {
        stmt.clearBindings();
 
        Long mid = entity.getMid();
        if (mid != null) {
            stmt.bindLong(1, mid);
        }
 
        String planId = entity.getPlanId();
        if (planId != null) {
            stmt.bindString(2, planId);
        }
        stmt.bindLong(3, entity.getTakeAt());
 
        String medicineId = entity.getMedicineId();
        if (medicineId != null) {
            stmt.bindString(4, medicineId);
        }
 
        String medicineName = entity.getMedicineName();
        if (medicineName != null) {
            stmt.bindString(5, medicineName);
        }
 
        String medicineHash = entity.getMedicineHash();
        if (medicineHash != null) {
            stmt.bindString(6, medicineHash);
        }
        stmt.bindLong(7, entity.getMedicineVia());
        stmt.bindLong(8, entity.getCount());
        stmt.bindLong(9, entity.getDosage());
        stmt.bindLong(10, entity.getCycleDays());
        stmt.bindLong(11, entity.getZone());
        stmt.bindLong(12, entity.getPositionNo());
 
        String dosageUnit = entity.getDosageUnit();
        if (dosageUnit != null) {
            stmt.bindString(13, dosageUnit);
        }
 
        Long started = entity.getStarted();
        if (started != null) {
            stmt.bindLong(14, started);
        }
 
        Long ended = entity.getEnded();
        if (ended != null) {
            stmt.bindLong(15, ended);
        }
 
        Long remindFirstAt = entity.getRemindFirstAt();
        if (remindFirstAt != null) {
            stmt.bindLong(16, remindFirstAt);
        }
 
        String boxUuid = entity.getBoxUuid();
        if (boxUuid != null) {
            stmt.bindString(17, boxUuid);
        }
 
        String planSeqWithBox = entity.getPlanSeqWithBox();
        if (planSeqWithBox != null) {
            stmt.bindString(18, planSeqWithBox);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MedicPlan entity) {
        stmt.clearBindings();
 
        Long mid = entity.getMid();
        if (mid != null) {
            stmt.bindLong(1, mid);
        }
 
        String planId = entity.getPlanId();
        if (planId != null) {
            stmt.bindString(2, planId);
        }
        stmt.bindLong(3, entity.getTakeAt());
 
        String medicineId = entity.getMedicineId();
        if (medicineId != null) {
            stmt.bindString(4, medicineId);
        }
 
        String medicineName = entity.getMedicineName();
        if (medicineName != null) {
            stmt.bindString(5, medicineName);
        }
 
        String medicineHash = entity.getMedicineHash();
        if (medicineHash != null) {
            stmt.bindString(6, medicineHash);
        }
        stmt.bindLong(7, entity.getMedicineVia());
        stmt.bindLong(8, entity.getCount());
        stmt.bindLong(9, entity.getDosage());
        stmt.bindLong(10, entity.getCycleDays());
        stmt.bindLong(11, entity.getZone());
        stmt.bindLong(12, entity.getPositionNo());
 
        String dosageUnit = entity.getDosageUnit();
        if (dosageUnit != null) {
            stmt.bindString(13, dosageUnit);
        }
 
        Long started = entity.getStarted();
        if (started != null) {
            stmt.bindLong(14, started);
        }
 
        Long ended = entity.getEnded();
        if (ended != null) {
            stmt.bindLong(15, ended);
        }
 
        Long remindFirstAt = entity.getRemindFirstAt();
        if (remindFirstAt != null) {
            stmt.bindLong(16, remindFirstAt);
        }
 
        String boxUuid = entity.getBoxUuid();
        if (boxUuid != null) {
            stmt.bindString(17, boxUuid);
        }
 
        String planSeqWithBox = entity.getPlanSeqWithBox();
        if (planSeqWithBox != null) {
            stmt.bindString(18, planSeqWithBox);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MedicPlan readEntity(Cursor cursor, int offset) {
        MedicPlan entity = new MedicPlan( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // mid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // planId
            cursor.getInt(offset + 2), // takeAt
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // medicineId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // medicineName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // medicineHash
            cursor.getInt(offset + 6), // medicineVia
            cursor.getInt(offset + 7), // count
            cursor.getInt(offset + 8), // dosage
            cursor.getInt(offset + 9), // cycleDays
            cursor.getInt(offset + 10), // zone
            cursor.getInt(offset + 11), // positionNo
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // dosageUnit
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // started
            cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14), // ended
            cursor.isNull(offset + 15) ? null : cursor.getLong(offset + 15), // remindFirstAt
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // boxUuid
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17) // planSeqWithBox
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MedicPlan entity, int offset) {
        entity.setMid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPlanId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTakeAt(cursor.getInt(offset + 2));
        entity.setMedicineId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMedicineName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMedicineHash(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMedicineVia(cursor.getInt(offset + 6));
        entity.setCount(cursor.getInt(offset + 7));
        entity.setDosage(cursor.getInt(offset + 8));
        entity.setCycleDays(cursor.getInt(offset + 9));
        entity.setZone(cursor.getInt(offset + 10));
        entity.setPositionNo(cursor.getInt(offset + 11));
        entity.setDosageUnit(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setStarted(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setEnded(cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14));
        entity.setRemindFirstAt(cursor.isNull(offset + 15) ? null : cursor.getLong(offset + 15));
        entity.setBoxUuid(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPlanSeqWithBox(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MedicPlan entity, long rowId) {
        entity.setMid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MedicPlan entity) {
        if(entity != null) {
            return entity.getMid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MedicPlan entity) {
        return entity.getMid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
