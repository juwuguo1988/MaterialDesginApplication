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

    private static MedicPlanDao medicPlanDao = GreenDaoUtils.getSingleTon().getDaoSession().getMedicPlanDao();


    /**
     * 将medicPlan入库
     */
    public static void saveMedicPlan(MedicPlan medicPlan) {
        medicPlanDao.save(medicPlan);
    }


    /**
     * 修改服药计划
     */
    public static void updateMedicPlan(MedicPlan medicPlan) {
        MedicPlan tempMedicPlan = getMedicPlanByMedicPlanId(medicPlan.getMid(), medicPlan.getPlanId());
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

            medicPlanDao.update(tempMedicPlan);
        }

    }

    public static void deleteMedicPlanByPlanId(long id, String planId) {
        MedicPlan medicPlan = getMedicPlanByMedicPlanId(id, planId);
        if (medicPlan != null) {
            medicPlanDao.delete(medicPlan);
        }
    }


    public static void deleteAllMedicPlan() {
        medicPlanDao.deleteAll();
    }

    /**
     * 获取所有服药计划
     */

    public static List<MedicPlan> getAllMedicPlans() {
        return medicPlanDao.loadAll();
    }

    /**
     *
     */
    public static List<MedicPlan> getMedicPlansByMedicName() {
        Cursor cursor = medicPlanDao.getDatabase().rawQuery("select * from MEDIC_PLAN where TAKE_AT = 480", null);
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
     * where ( cycleDays = 0 and ended is null ) or
     * ( cycleDays = -1 and ended is null and remindFirstAt  > " + System.currentTimeMillis() + " ) ", null);
     */

    public static List<MedicPlan> getAllMedicPlan() {
        QueryBuilder qb = medicPlanDao.queryBuilder();
        qb.where(qb.or(qb.and(MedicPlanDao.Properties.CycleDays.eq(0), MedicPlanDao.Properties.Ended.isNull()),
                qb.and(MedicPlanDao.Properties.CycleDays.eq(-1), MedicPlanDao.Properties.Ended.isNull(),
                        MedicPlanDao.Properties.RemindFirstAt.gt(System.currentTimeMillis()))));
        return qb.list();
    }

    /**
     * return mSQLiteDB.rawQuery("select * from " + MedicPlanTable.TABLE_NAME +
     * " where ( cycleDays = 0 and ended is null and started <= " + (System.currentTimeMillis() + 1000) + " )
     * or ( cycleDays = -1 and ended is null and remindFirstAt  >= "  + System.currentTimeMillis() + "
     * and started <= " + (System.currentTimeMillis() + 1000) + " )", null);
     */

    public static List<MedicPlan> getNextMedicPlanReminder() {
        QueryBuilder qb = medicPlanDao.queryBuilder();
        qb.where(qb.or(qb.and(MedicPlanDao.Properties.CycleDays.eq(0),
                MedicPlanDao.Properties.Ended.isNull(),
                MedicPlanDao.Properties.Started.le(System.currentTimeMillis() + 1000)),
                qb.and(MedicPlanDao.Properties.CycleDays.eq(-1),
                        MedicPlanDao.Properties.Ended.isNull(),
                        MedicPlanDao.Properties.RemindFirstAt.ge(System.currentTimeMillis()),
                        MedicPlanDao.Properties.Started.le(System.currentTimeMillis() + 1000))));
        return qb.list();
    }

    /**
     * 通过服药计划id 查询服药计划
     */
    public static MedicPlan getMedicPlanByMedicPlanId(Long id, String medicPlanId) {
        return medicPlanDao.queryBuilder().where(MedicPlanDao.Properties.PlanId.eq(medicPlanId),
                MedicPlanDao.Properties.Mid.eq(id)).build().unique();
    }

}
