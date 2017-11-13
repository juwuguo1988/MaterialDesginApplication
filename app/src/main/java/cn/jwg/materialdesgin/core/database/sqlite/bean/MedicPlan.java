package cn.jwg.materialdesgin.core.database.sqlite.bean;

import android.database.Cursor;
import cn.jwg.materialdesgin.core.database.sqlite.greendao.MedicPlanDao;
import com.google.gson.annotations.SerializedName;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Juwuguo on 2017/10/13.
 */

@Entity
public class MedicPlan {

    @Id(autoincrement = true)
    private Long mid = null;
    @SerializedName(value = "id")
    private String planId;
    private int takeAt;
    private String medicineId;
    private String medicineName;
    private String medicineHash;
    private int medicineVia;
    private int count;
    private int dosage;
    private int cycleDays;
    private int zone;
    private int positionNo;
    private String dosageUnit;
    private Long started;
    private Long ended;
    private Long remindFirstAt;
    private String boxUuid;
    private String planSeqWithBox;

    public MedicPlan() {

    }


    @Generated(hash = 743860685)
    public MedicPlan(Long mid, String planId, int takeAt, String medicineId,
            String medicineName, String medicineHash, int medicineVia, int count,
            int dosage, int cycleDays, int zone, int positionNo, String dosageUnit,
            Long started, Long ended, Long remindFirstAt, String boxUuid,
            String planSeqWithBox) {
        this.mid = mid;
        this.planId = planId;
        this.takeAt = takeAt;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineHash = medicineHash;
        this.medicineVia = medicineVia;
        this.count = count;
        this.dosage = dosage;
        this.cycleDays = cycleDays;
        this.zone = zone;
        this.positionNo = positionNo;
        this.dosageUnit = dosageUnit;
        this.started = started;
        this.ended = ended;
        this.remindFirstAt = remindFirstAt;
        this.boxUuid = boxUuid;
        this.planSeqWithBox = planSeqWithBox;
    }


    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public int getTakeAt() {
        return takeAt;
    }

    public void setTakeAt(int takeAt) {
        this.takeAt = takeAt;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineHash() {
        return medicineHash;
    }

    public void setMedicineHash(String medicineHash) {
        this.medicineHash = medicineHash;
    }

    public int getMedicineVia() {
        return medicineVia;
    }

    public void setMedicineVia(int medicineVia) {
        this.medicineVia = medicineVia;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getCycleDays() {
        return cycleDays;
    }

    public void setCycleDays(int cycleDays) {
        this.cycleDays = cycleDays;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(int positionNo) {
        this.positionNo = positionNo;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public Long getStarted() {
        return started;
    }

    public void setStarted(Long started) {
        this.started = started;
    }

    public Long getEnded() {
        return ended;
    }

    public void setEnded(Long ended) {
        this.ended = ended;
    }

    public Long getRemindFirstAt() {
        return remindFirstAt;
    }

    public void setRemindFirstAt(Long remindFirstAt) {
        this.remindFirstAt = remindFirstAt;
    }

    public String getBoxUuid() {
        return boxUuid;
    }

    public void setBoxUuid(String boxUuid) {
        this.boxUuid = boxUuid;
    }

    public String getPlanSeqWithBox() {
        return planSeqWithBox;
    }

    public void setPlanSeqWithBox(String planSeqWithBox) {
        this.planSeqWithBox = planSeqWithBox;
    }


    public MedicPlan cursorToBean(Cursor cursor) {
        MedicPlan mp = new MedicPlan();
        mp.setMid(cursor.getLong(cursor.getColumnIndex(MedicPlanDao.Properties.Mid.columnName)));
        mp.setPlanId(cursor.getString(cursor.getColumnIndex(MedicPlanDao.Properties.PlanId.columnName)));
        mp.setTakeAt(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.TakeAt.columnName)));
        mp.setCycleDays(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.CycleDays.columnName)));
        mp.setMedicineId(cursor.getString(cursor.getColumnIndex(MedicPlanDao.Properties.MedicineId.columnName)));
        mp.setCount(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.Count.columnName)));
        mp.setPositionNo(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.PositionNo.columnName)));
        mp.setMedicineName(cursor.getString(cursor.getColumnIndex(MedicPlanDao.Properties.MedicineName.columnName)));
        mp.setStarted(cursor.getLong(cursor.getColumnIndex(MedicPlanDao.Properties.Started.columnName)));
        mp.setEnded(cursor.getLong(cursor.getColumnIndex(MedicPlanDao.Properties.Ended.columnName)));
        mp.setDosage(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.Dosage.columnName)));
        mp.setZone(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.Zone.columnName)));
        mp.setDosageUnit(cursor.getString(cursor.getColumnIndex(MedicPlanDao.Properties.DosageUnit.columnName)));
        mp.setMedicineVia(cursor.getInt(cursor.getColumnIndex(MedicPlanDao.Properties.MedicineVia.columnName)));
        mp.setMedicineHash(cursor.getString(cursor.getColumnIndex(MedicPlanDao.Properties.MedicineHash.columnName)));
        mp.setRemindFirstAt(cursor.getLong(cursor.getColumnIndex(MedicPlanDao.Properties.RemindFirstAt.columnName)));

        return mp;
    }

}
