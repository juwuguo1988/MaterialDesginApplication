package cn.jwg.materialdesgin.core.common.bean;

import java.util.List;

/**
 * Created by Juwuguo on 2017/8/15.
 */

public class JsonBean {


    /**
     * doctor : {"id":"8KKVP8","name":"愚人节哈哈哈","title":"副主任医师","avatar":"https://s3.cn-north1.amazonaws.com
     * .cn/staff-avatars-dev/de676e1a-8953-4686-8f87-b19564d12711"}
     * recordOperations : []
     * plans : [{"id":"8VXK0r","takeAt":960,"medicineId":"a8V4rK","medicineName":"卡托普利","medicineHash":"YThWNHJLfOWNoeaJmOaZruWIqQ==",
     * "medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500449075789,
     * "ended":null,"remindFirstAt":1500451200000,"boxUuid":null,"planSeqWithBox":null},{"id":"l91m1l","takeAt":975,
     * "medicineId":"a8V4rK","medicineName":"卡托普利","medicineHash":"YThWNHJLfOWNoeaJmOaZruWIqQ==","medicineVia":2,"count":1000,
     * "dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500449075789,"ended":null,
     * "remindFirstAt":1500452100000,"boxUuid":null,"planSeqWithBox":null},{"id":"lLXPGl","takeAt":1020,"medicineId":"a8V4rK",
     * "medicineName":"卡托普利","medicineHash":"YThWNHJLfOWNoeaJmOaZruWIqQ==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,
     * "zone":2,"positionNo":0,"dosageUnit":"mg","started":1500449075789,"ended":null,"remindFirstAt":1500454800000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"8PXD18","takeAt":1080,"medicineId":"a8V4rK","medicineName":"卡托普利",
     * "medicineHash":"YThWNHJLfOWNoeaJmOaZruWIqQ==","medicineVia":2,"count":4000,"dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,
     * "dosageUnit":"mg","started":1500449075789,"ended":null,"remindFirstAt":1500458400000,"boxUuid":null,"planSeqWithBox":null},
     * {"id":"rwAgM8","takeAt":1095,"medicineId":"a8V4rK","medicineName":"卡托普利","medicineHash":"YThWNHJLfOWNoeaJmOaZruWIqQ==",
     * "medicineVia":2,"count":4000,"dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500449075789,
     * "ended":null,"remindFirstAt":1500459300000,"boxUuid":null,"planSeqWithBox":null},{"id":"8gBoDl","takeAt":1260,
     * "medicineId":"a8V4rK","medicineName":"卡托普利","medicineHash":"YThWNHJLfOWNoeaJmOaZruWIqQ==","medicineVia":2,"count":4000,
     * "dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500449075789,"ended":null,
     * "remindFirstAt":1500469200000,"boxUuid":null,"planSeqWithBox":null},{"id":"l91myl","takeAt":960,"medicineId":"a8V4rK",
     * "medicineName":"厄贝沙坦","medicineHash":"YThWNHJLfOWOhOi0neaymeWdpg==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,
     * "zone":2,"positionNo":0,"dosageUnit":"mg","started":1500446663470,"ended":null,"remindFirstAt":1500451200000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"rq9gWr","takeAt":975,"medicineId":"a8V4rK","medicineName":"厄贝沙坦",
     * "medicineHash":"YThWNHJLfOWOhOi0neaymeWdpg==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,
     * "dosageUnit":"mg","started":1500446663470,"ended":null,"remindFirstAt":1500452100000,"boxUuid":null,"planSeqWithBox":null},
     * {"id":"rwAg48","takeAt":1020,"medicineId":"a8V4rK","medicineName":"厄贝沙坦","medicineHash":"YThWNHJLfOWOhOi0neaymeWdpg==",
     * "medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500446663470,
     * "ended":null,"remindFirstAt":1500454800000,"boxUuid":null,"planSeqWithBox":null},{"id":"l1VBn8","takeAt":1050,
     * "medicineId":"a8V4rK","medicineName":"厄贝沙坦","medicineHash":"YThWNHJLfOWOhOi0neaymeWdpg==","medicineVia":2,"count":1000,
     * "dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500446663470,"ended":null,
     * "remindFirstAt":1500456600000,"boxUuid":null,"planSeqWithBox":null},{"id":"lOXwk8","takeAt":1320,"medicineId":"a8V4rK",
     * "medicineName":"厄贝沙坦","medicineHash":"YThWNHJLfOWOhOi0neaymeWdpg==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,
     * "zone":2,"positionNo":0,"dosageUnit":"mg","started":1500446663470,"ended":null,"remindFirstAt":1500472800000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"8PXGj8","takeAt":480,"medicineId":"rqyqKr","medicineName":"复方熊胆滴眼液",
     * "medicineHash":"cnF5cUtyfOWkjeaWueeGiuiDhua7tOecvOa2sg==","medicineVia":1,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,
     * "positionNo":0,"dosageUnit":"mg","started":1501578761785,"ended":null,"remindFirstAt":1501632000000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"l3PRd8","takeAt":480,"medicineId":"a8V4rK","medicineName":"尼群地平",
     * "medicineHash":"YThWNHJLfOWwvOe+pOWcsOW5sw==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,"positionNo":0,
     * "dosageUnit":"mg","started":1500359997626,"ended":null,"remindFirstAt":1500422400000,"boxUuid":null,"planSeqWithBox":null},
     * {"id":"5xKzZ8","takeAt":720,"medicineId":"a8V4rK","medicineName":"尼群地平","medicineHash":"YThWNHJLfOWwvOe+pOWcsOW5sw==",
     * "medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":1,"positionNo":0,"dosageUnit":"mg","started":1500359997626,
     * "ended":null,"remindFirstAt":1500436800000,"boxUuid":null,"planSeqWithBox":null},{"id":"lQDvMr","takeAt":1080,
     * "medicineId":"a8V4rK","medicineName":"尼群地平","medicineHash":"YThWNHJLfOWwvOe+pOWcsOW5sw==","medicineVia":2,"count":1000,
     * "dosage":20000,"cycleDays":0,"zone":2,"positionNo":0,"dosageUnit":"mg","started":1500359997626,"ended":null,
     * "remindFirstAt":1500372000000,"boxUuid":null,"planSeqWithBox":null},{"id":"8yEz28","takeAt":1320,"medicineId":"a8V4rK",
     * "medicineName":"尼群地平","medicineHash":"YThWNHJLfOWwvOe+pOWcsOW5sw==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,
     * "zone":2,"positionNo":0,"dosageUnit":"mg","started":1500359997626,"ended":null,"remindFirstAt":1500386400000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"reBj7l","takeAt":360,"medicineId":"a8V4rK","medicineName":"欣康",
     * "medicineHash":"YThWNHJLfOaso+W6tw==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,"positionNo":0,
     * "dosageUnit":"mg","started":1502078575965,"ended":null,"remindFirstAt":1502143200000,"boxUuid":null,"planSeqWithBox":null},
     * {"id":"lGXRe8","takeAt":480,"medicineId":"a8V4rK","medicineName":"欣康","medicineHash":"YThWNHJLfOaso+W6tw==","medicineVia":2,
     * "count":1000,"dosage":20000,"cycleDays":0,"zone":0,"positionNo":0,"dosageUnit":"mg","started":1502078575965,"ended":null,
     * "remindFirstAt":1502150400000,"boxUuid":null,"planSeqWithBox":null},{"id":"8N6Oa8","takeAt":540,"medicineId":"a8V4rK",
     * "medicineName":"泰嘉","medicineHash":"YThWNHJLfOazsOWYiQ==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,
     * "positionNo":0,"dosageUnit":"mg","started":1502086801484,"ended":null,"remindFirstAt":1502154000000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"5bBYX5","takeAt":480,"medicineId":"a8V4rK","medicineName":"蒙诺",
     * "medicineHash":"YThWNHJLfOiSmeivug==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,"positionNo":0,
     * "dosageUnit":"mg","started":1500446750151,"ended":null,"remindFirstAt":1500508800000,"boxUuid":null,"planSeqWithBox":null},
     * {"id":"5AMm05","takeAt":495,"medicineId":"a8V4rK","medicineName":"蒙诺","medicineHash":"YThWNHJLfOiSmeivug==","medicineVia":2,
     * "count":1000,"dosage":20000,"cycleDays":0,"zone":0,"positionNo":0,"dosageUnit":"mg","started":1500446750151,"ended":null,
     * "remindFirstAt":1500509700000,"boxUuid":null,"planSeqWithBox":null},{"id":"8K6LJl","takeAt":510,"medicineId":"a8V4rK",
     * "medicineName":"蒙诺","medicineHash":"YThWNHJLfOiSmeivug==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,
     * "positionNo":0,"dosageUnit":"mg","started":1500446750151,"ended":null,"remindFirstAt":1500510600000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"ldJWX5","takeAt":480,"medicineId":"a8V4rK","medicineName":"阿司匹林肠溶片",
     * "medicineHash":"YThWNHJLfOmYv+WPuOWMueael+iCoOa6tueJhw==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":0,
     * "positionNo":0,"dosageUnit":"mg","started":1499246443177,"ended":null,"remindFirstAt":1499299200000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"rYB4xl","takeAt":840,"medicineId":"a8V4rK","medicineName":"阿司匹林肠溶片",
     * "medicineHash":"YThWNHJLfOmYv+WPuOWMueael+iCoOa6tueJhw==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":1,
     * "positionNo":0,"dosageUnit":"mg","started":1499246443177,"ended":null,"remindFirstAt":1499320800000,"boxUuid":null,
     * "planSeqWithBox":null},{"id":"8XXxo8","takeAt":960,"medicineId":"a8V4rK","medicineName":"阿司匹林肠溶片",
     * "medicineHash":"YThWNHJLfOmYv+WPuOWMueael+iCoOa6tueJhw==","medicineVia":2,"count":1000,"dosage":20000,"cycleDays":0,"zone":2,
     * "positionNo":0,"dosageUnit":"mg","started":1499246443177,"ended":null,"remindFirstAt":1499328000000,"boxUuid":null,
     * "planSeqWithBox":null}]
     * advice : {"id":"8KKVP8","name":"愚人节哈哈哈","avatar":"https://s3.cn-north-1.amazonaws.com
     * .cn/staff-avatars-dev/de676e1a-8953-4686-8f87-b19564d12711","title":"副主任医师","message":"uuuuuuuuuuuu","sentAt":1498043114178}
     * user : {"name":"张三","area":"河北省 张家口市 崇礼县","address":"，？B-)土楼MSN给哦累","avatar":"https://s3.cn-north-1.amazonaws.com
     * .cn/patient-avatars-dev/1c958592-410e-487f-b758-870d24f046ca","tel":"17710189466","birthday":1246377600000,"sex":0,"status":1,
     * "type":1,"height":"134","weight":"119","waistline":"52","marriage":1,"education":2,"bindingDoctor":[{"doctorId":"8KKVP8"}],
     * "ethnicity":"汉族"}
     */

    private DoctorBean doctor;
    private AdviceBean advice;
    private UserBean user;
    private List<?> recordOperations;
    private List<PlansBean> plans;

    public DoctorBean getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorBean doctor) {
        this.doctor = doctor;
    }

    public AdviceBean getAdvice() {
        return advice;
    }

    public void setAdvice(AdviceBean advice) {
        this.advice = advice;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<?> getRecordOperations() {
        return recordOperations;
    }

    public void setRecordOperations(List<?> recordOperations) {
        this.recordOperations = recordOperations;
    }

    public List<PlansBean> getPlans() {
        return plans;
    }

    public void setPlans(List<PlansBean> plans) {
        this.plans = plans;
    }

    public static class DoctorBean {

        /**
         * id : 8KKVP8
         * name : 愚人节哈哈哈
         * title : 副主任医师
         * avatar : https://s3.cn-north1.amazonaws.com.cn/staff-avatars-dev/de676e1a-8953-4686-8f87-b19564d12711
         */

        private String id;
        private String name;
        private String title;
        private String avatar;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }



    public static class UserBean {

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
         * bindingDoctor : [{"doctorId":"8KKVP8"}]
         * ethnicity : 汉族
         */

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
        private List<BindingDoctorBean> bindingDoctor;

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

        public List<BindingDoctorBean> getBindingDoctor() {
            return bindingDoctor;
        }

        public void setBindingDoctor(List<BindingDoctorBean> bindingDoctor) {
            this.bindingDoctor = bindingDoctor;
        }

        public static class BindingDoctorBean {

            /**
             * doctorId : 8KKVP8
             */

            private String doctorId;

            public String getDoctorId() {
                return doctorId;
            }

            public void setDoctorId(String doctorId) {
                this.doctorId = doctorId;
            }
        }
    }

    public static class PlansBean {

        /**
         * id : 8VXK0r
         * takeAt : 960
         * medicineId : a8V4rK
         * medicineName : 卡托普利
         * medicineHash : YThWNHJLfOWNoeaJmOaZruWIqQ==
         * medicineVia : 2
         * count : 1000
         * dosage : 20000
         * cycleDays : 0
         * zone : 2
         * positionNo : 0
         * dosageUnit : mg
         * started : 1500449075789
         * ended : null
         * remindFirstAt : 1500451200000
         * boxUuid : null
         * planSeqWithBox : null
         */

        private String id;
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
        private long started;
        private Object ended;
        private long remindFirstAt;
        private Object boxUuid;
        private Object planSeqWithBox;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public long getStarted() {
            return started;
        }

        public void setStarted(long started) {
            this.started = started;
        }

        public Object getEnded() {
            return ended;
        }

        public void setEnded(Object ended) {
            this.ended = ended;
        }

        public long getRemindFirstAt() {
            return remindFirstAt;
        }

        public void setRemindFirstAt(long remindFirstAt) {
            this.remindFirstAt = remindFirstAt;
        }

        public Object getBoxUuid() {
            return boxUuid;
        }

        public void setBoxUuid(Object boxUuid) {
            this.boxUuid = boxUuid;
        }

        public Object getPlanSeqWithBox() {
            return planSeqWithBox;
        }

        public void setPlanSeqWithBox(Object planSeqWithBox) {
            this.planSeqWithBox = planSeqWithBox;
        }
    }
}
