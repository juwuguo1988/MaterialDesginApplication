package cn.jwg.materialdesgin.core.database.sqlite.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Juwuguo on 2017/10/13.
 */

@Entity
public class UserBean {

    /**
     * name : 张三
     * area : 河北省 张家口市 崇礼县
     * address : ，？B-)土楼MSN给哦累
     * avatar : https://s3.cn-north-1.amazonaws.com.cn/patient-avatars-dev/1c958592-410e-487f-b758-870d24f046ca
     * tel : 17710189466
     * birthday : 1246377600000
     * sex : 0
     * status : 1
     * type : 1
     * height : 134
     * weight : 119
     * waistline : 52
     * marriage : 1
     * education : 2
     * ethnicity : 汉族
     */

    private String uId;
    private String name;
    private String area;
    private String address;
    private String avatar;
    private String tel;
    private long birthday;
    private int sex;
    private int status;
    private int type;
    private String height;
    private String weight;
    private String waistline;
    private int marriage;
    private int education;
    private String ethnicity;





    @Generated(hash = 2135521761)
    public UserBean(String uId, String name, String area, String address, String avatar, String tel,
            long birthday, int sex, int status, int type, String height, String weight, String waistline,
            int marriage, int education, String ethnicity) {
        this.uId = uId;
        this.name = name;
        this.area = area;
        this.address = address;
        this.avatar = avatar;
        this.tel = tel;
        this.birthday = birthday;
        this.sex = sex;
        this.status = status;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.waistline = waistline;
        this.marriage = marriage;
        this.education = education;
        this.ethnicity = ethnicity;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public int getMarriage() {
        return marriage;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getUId() {
        return this.uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }
}
