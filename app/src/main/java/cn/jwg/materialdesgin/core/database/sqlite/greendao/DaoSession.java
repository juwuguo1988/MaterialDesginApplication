package cn.jwg.materialdesgin.core.database.sqlite.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cn.jwg.materialdesgin.core.database.sqlite.bean.MedicPlan;
import cn.jwg.materialdesgin.core.database.sqlite.bean.UserBean;

import cn.jwg.materialdesgin.core.database.sqlite.greendao.MedicPlanDao;
import cn.jwg.materialdesgin.core.database.sqlite.greendao.UserBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig medicPlanDaoConfig;
    private final DaoConfig userBeanDaoConfig;

    private final MedicPlanDao medicPlanDao;
    private final UserBeanDao userBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        medicPlanDaoConfig = daoConfigMap.get(MedicPlanDao.class).clone();
        medicPlanDaoConfig.initIdentityScope(type);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        medicPlanDao = new MedicPlanDao(medicPlanDaoConfig, this);
        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);

        registerDao(MedicPlan.class, medicPlanDao);
        registerDao(UserBean.class, userBeanDao);
    }
    
    public void clear() {
        medicPlanDaoConfig.clearIdentityScope();
        userBeanDaoConfig.clearIdentityScope();
    }

    public MedicPlanDao getMedicPlanDao() {
        return medicPlanDao;
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

}
