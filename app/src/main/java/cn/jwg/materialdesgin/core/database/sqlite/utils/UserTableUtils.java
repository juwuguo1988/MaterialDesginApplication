package cn.jwg.materialdesgin.core.database.sqlite.utils;

import cn.jwg.materialdesgin.core.database.sqlite.bean.UserBean;
import cn.jwg.materialdesgin.core.database.sqlite.greendao.UserBeanDao;
import java.util.List;


/**
 * Created by Juwuguo on 2017/10/13.
 * 针对用户表的操作
 */

public class UserTableUtils {

    private static UserBeanDao userBeanDao = GreenDaoUtils.getSingleTon().getDaoSession().getUserBeanDao();


    /**
     * 添加用户
     */
    public static void saveUser(UserBean userBean) {
        userBeanDao.save(userBean);
    }


    /**
     * 修改用户信息
     */
    public static void updateUserBean(UserBean userBean) {
        UserBean tempUserBean = getUserBeanByUserId(userBean.getUId());
        if (tempUserBean != null) {
            tempUserBean.setAddress(userBean.getAddress());
            tempUserBean.setArea(userBean.getArea());
            tempUserBean.setAvatar(userBean.getAvatar());
            tempUserBean.setBirthday(userBean.getBirthday());
            tempUserBean.setEducation(userBean.getEducation());
            tempUserBean.setEthnicity(userBean.getEthnicity());
            tempUserBean.setHeight(userBean.getHeight());
            tempUserBean.setMarriage(userBean.getMarriage());
            tempUserBean.setName(userBean.getName());
            tempUserBean.setSex(userBean.getSex());
            tempUserBean.setStatus(userBean.getStatus());
            tempUserBean.setTel(userBean.getTel());
            tempUserBean.setWaistline(userBean.getWaistline());
            tempUserBean.setWeight(userBean.getWeight());
            tempUserBean.setType(userBean.getType());

            userBeanDao.update(tempUserBean);
        }

    }

    /**
     * 删除所有用户
     */
    public static void deleteAllUser() {
        userBeanDao.deleteAll();
    }

    /**
     * 获取所有用户
     */

    public static List<UserBean> getAllMedicPlans() {
        return userBeanDao.loadAll();
    }


    /**
     * 通过用户id查询用户
     */
    public static UserBean getUserBeanByUserId(String userId) {
        return userBeanDao.queryBuilder().where(UserBeanDao.Properties.UId.eq(userId)).build().unique();
    }

}
