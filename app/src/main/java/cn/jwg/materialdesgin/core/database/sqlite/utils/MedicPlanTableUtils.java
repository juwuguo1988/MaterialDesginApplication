package cn.jwg.materialdesgin.core.database.sqlite.utils;

import android.database.Cursor;
import cn.jwg.materialdesgin.core.database.sqlite.bean.MedicPlan;
import cn.jwg.materialdesgin.core.database.sqlite.greendao.MedicPlanDao;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.query.QueryBuilder;


/**
 * Created by Juwuguo on 2017/10/13.
 * 针对服药计划表的操作
 */

public class MedicPlanTableUtils {

    private static final int INTERVAL = 1000 * 60 * 60 * 24;// 24h

    private static MedicPlanDao medicPlanDao;

    public static MedicPlanDao getSingleTon() {
        medicPlanDao = GreenDaoUtils.getSingleTon().getDaoSession().getMedicPlanDao();
        return medicPlanDao;
    }

    /**
     * 将medicPlan入库
     */
    public static void saveMedicPlan(MedicPlan medicPlan) {
        MedicPlanTableUtils.getSingleTon().save(medicPlan);
    }


    /**
     * 修改服药计划
     */
    public static void updateMedicPlan(MedicPlan medicPlan) {
        MedicPlan tempMedicPlan = getMedicPlanByMedicPlanId(medicPlan.getPlanId());
        if (tempMedicPlan != null) {
            tempMedicPlan.setBoxUuid(medicPlan.getBoxUuid());
            tempMedicPlan.setCount(medicPlan.getCount());
            tempMedicPlan.setCycleDays(medicPlan.getCycleDays());
            tempMedicPlan.setDosage(medicPlan.getDosage());
            tempMedicPlan.setDosageUnit(medicPlan.getDosageUnit());
            tempMedicPlan.setStarted(medicPlan.getStarted());
            tempMedicPlan.setEnded(medicPlan.getEnded());
            tempMedicPlan.setMedicineHash(medicPlan.getMedicineHash());
            tempMedicPlan.setMedicineId(medicPlan.getMedicineId());
            tempMedicPlan.setMedicineName(medicPlan.getMedicineName());
            tempMedicPlan.setMedicineVia(medicPlan.getMedicineVia());
            tempMedicPlan.setPlanSeqWithBox(medicPlan.getPlanSeqWithBox());
            tempMedicPlan.setPositionNo(medicPlan.getPositionNo());
            tempMedicPlan.setRemindFirstAt(medicPlan.getRemindFirstAt());
            tempMedicPlan.setTakeAt(medicPlan.getTakeAt());
            tempMedicPlan.setZone(medicPlan.getZone());

            MedicPlanTableUtils.getSingleTon().update(tempMedicPlan);
        }

    }

    public static void deleteMedicPlanByPlanId(String planId) {
        MedicPlan medicPlan = getMedicPlanByMedicPlanId(planId);
        if (medicPlan != null) {
            MedicPlanTableUtils.getSingleTon().delete(medicPlan);
        }
    }


    public static void deleteAllMedicPlan() {
        MedicPlanTableUtils.getSingleTon().deleteAll();
    }

    public static List<MedicPlan> getAllMedicPlans() {
        return MedicPlanTableUtils.getSingleTon().loadAll();
    }

    /**
     *
     */
    public static List<MedicPlan> getMedicPlansByMedicName() {
        Cursor cursor = MedicPlanTableUtils.getSingleTon().getDatabase().rawQuery("select * from MEDIC_PLAN where TAKE_AT = 480", null);
        ArrayList<MedicPlan> beans = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                beans.add(new MedicPlan().cursorToBean(cursor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return beans;
    }

    /**
     * 获取所有服药计划
     * return mSQLiteDB.rawQuery("select * from " + MedicPlanTable.TABLE_NAME + "
     * where ( cycleDays = 0 and ended is null )
     * or ( cycleDays = 1 and ended is null )
     * or( cycleDays = -1 and ended is null and remindFirstAt  > " + System.currentTimeMillis() + " ) ", null);
     */

    public static List<MedicPlan> getAllMedicPlan() {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(qb.or(qb.and(MedicPlanDao.Properties.CycleDays.eq(0), MedicPlanDao.Properties.Ended.isNull()),
                qb.and(MedicPlanDao.Properties.CycleDays.eq(1), MedicPlanDao.Properties.Ended.isNull()),
                qb.and(MedicPlanDao.Properties.CycleDays.eq(-1), MedicPlanDao.Properties.Ended.isNull(),
                        MedicPlanDao.Properties.RemindFirstAt.gt(System.currentTimeMillis()))));
        return qb.list();
    }

    /**
     * "select * from " + MedicPlanTable.TABLE_NAME + " where ended is null or ended > " + (System.currentTimeMillis() - INTERVAL)
     */

    public static List<MedicPlan> getNextMedicReminderAndRecord() {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(qb.or(MedicPlanDao.Properties.Ended.isNull(),
                MedicPlanDao.Properties.Ended.gt(System.currentTimeMillis() - INTERVAL)));
        return qb.list();
    }


    /**
     * 查询在当前服药时间内被修改的服药计划
     * "select * from " + MedicPlanTable.TABLE_NAME
     * + " where started < " + reminderTime + " and " + reminderTime + " < ended and takeAt = " + takeAt
     */
    public static List<MedicPlan> getUpdateMedicPlanReminder(long reminderTime, int takeAt) {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(MedicPlanDao.Properties.Started.lt(reminderTime),
                MedicPlanDao.Properties.Ended.gt(reminderTime),
                MedicPlanDao.Properties.TakeAt.eq(takeAt));
        return qb.list();
    }

    /**
     * where ( cycleDays = 0 and ended is null and started <= " + (System.currentTimeMillis() + 1000) + " )
     * or ( cycleDays = 1 and ended is null and started <= " + (System.currentTimeMillis() + 1000) + " )
     * or ( cycleDays = -1 and ended is null and remindFirstAt  >= "  + System.currentTimeMillis() + "
     * and started <= " + (System.currentTimeMillis() + 1000) + " )"
     */

    public static List<MedicPlan> getNextMedicPlanReminder() {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(qb.or(qb.and(MedicPlanDao.Properties.CycleDays.eq(0),
                MedicPlanDao.Properties.Ended.isNull(),
                MedicPlanDao.Properties.Started.le(System.currentTimeMillis() + 1000)),
                qb.and(MedicPlanDao.Properties.CycleDays.eq(1),
                        MedicPlanDao.Properties.Ended.isNull(),
                        MedicPlanDao.Properties.Started.le(System.currentTimeMillis() + 1000)),
                qb.and(MedicPlanDao.Properties.CycleDays.eq(-1),
                        MedicPlanDao.Properties.Ended.isNull(),
                        MedicPlanDao.Properties.RemindFirstAt.ge(System.currentTimeMillis()),
                        MedicPlanDao.Properties.Started.le(System.currentTimeMillis() + 1000))));
        return qb.list();
    }

    /**
     *
     * @param medicPlanId
     * @param timestamp
     */
    public static void deleteMedicPlanByMedicPlanId(String medicPlanId, long timestamp) {
        MedicPlan medicPlan = getMedicPlanByMedicPlanId(medicPlanId);
        if (medicPlan != null) {
            medicPlan.setEnded(timestamp);
            MedicPlanTableUtils.getSingleTon().update(medicPlan);
        }
    }

    /**
     * @param takeAt
     * @return
     */

    public static List<MedicPlan> getMedicPlansByTakeAt(int takeAt) {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(MedicPlanDao.Properties.TakeAt.eq(takeAt), MedicPlanDao.Properties.Ended.isNull());
        return qb.list();
    }

    /**
     * select * from " + MedicPlanTable.TABLE_NAME + " where medicineHash = " + "'" + medicHash + "' and " + "(( cycleDays = 0 and ended is
     * null and started <  " + System.currentTimeMillis() + " ) or ( cycleDays = 1 and ended is null and started <  " +
     * System.currentTimeMillis() + " ) or ( cycleDays = -1 and ended is null and remindFirstAt  > "  + System.currentTimeMillis() + " and
     * started < " + System.currentTimeMillis() + " ))", null);
     */

    public static List<MedicPlan> getMedicPlansByMedicHash(String medicHash) {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(MedicPlanDao.Properties.MedicineHash.eq(medicHash),
                qb.or(qb.and(MedicPlanDao.Properties.CycleDays.eq(0),
                        MedicPlanDao.Properties.Ended.isNull(),
                        MedicPlanDao.Properties.Started.le(System.currentTimeMillis())),
                        qb.and(MedicPlanDao.Properties.CycleDays.eq(1),
                                MedicPlanDao.Properties.Ended.isNull(),
                                MedicPlanDao.Properties.Started.le(System.currentTimeMillis())),
                        qb.and(MedicPlanDao.Properties.CycleDays.eq(-1),
                                MedicPlanDao.Properties.Ended.isNull(),
                                MedicPlanDao.Properties.RemindFirstAt.ge(System.currentTimeMillis()),
                                MedicPlanDao.Properties.Started.le(System.currentTimeMillis()))));
        return qb.list();
    }

    /**
     * "select * from " + MedicPlanTable.TABLE_NAME
     * + " where takeAt = " + takeAt
     * + " and " + MedicPlanTable.MEDIC_CYCLE_DAYS + " = " + cycleday
     * + " and ended is null
     */

    public static List<MedicPlan> getMedicPlansByTakeAtAndCycleDay(int takeAt, int cycleDay) {
        QueryBuilder qb = MedicPlanTableUtils.getSingleTon().queryBuilder();
        qb.where(MedicPlanDao.Properties.TakeAt.eq(takeAt),
                MedicPlanDao.Properties.CycleDays.eq(cycleDay),
                MedicPlanDao.Properties.Ended.isNull());
        return qb.list();
    }

    /**
     * 通过服药计划id 查询服药计划
     */
    public static MedicPlan getMedicPlanByMedicPlanId(String medicPlanId) {
        return MedicPlanTableUtils.getSingleTon().queryBuilder().where(MedicPlanDao.Properties.PlanId.eq(medicPlanId)).build().unique();
    }

}
