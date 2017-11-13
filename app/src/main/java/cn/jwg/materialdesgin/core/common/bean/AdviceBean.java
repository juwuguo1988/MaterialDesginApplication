package cn.jwg.materialdesgin.core.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juwuguo on 2017/8/15.
 *
 * 两个方案，至于选哪个，看你自己。二者各有优势：

 Serializable：简单，实现个接口即可，但序列化、反序列化效率相对较低；
 Parcelable：序列化、反序列化效率更高，但实现起来复杂；
 */

public  class AdviceBean  implements Parcelable{

    /**
     * id : 8KKVP8
     * name : 愚人节哈哈哈
     * avatar : https://s3.cn-north-1.amazonaws.com.cn/staff-avatars-dev/de676e1a-8953-4686-8f87-b19564d12711
     * title : 副主任医师
     * message : uuuuuuuuuuuu
     * sentAt : 1498043114178
     */

    private String id;
    private String name;
    private String avatar;
    private String title;
    private String message;
    private long sentAt;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getSentAt() {
        return sentAt;
    }

    public void setSentAt(long sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.avatar);
        dest.writeString(this.title);
        dest.writeString(this.message);
        dest.writeLong(this.sentAt);
    }

    public AdviceBean() {
    }

    protected AdviceBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.avatar = in.readString();
        this.title = in.readString();
        this.message = in.readString();
        this.sentAt = in.readLong();
    }

    public static final Creator<AdviceBean> CREATOR = new Creator<AdviceBean>() {
        @Override
        public AdviceBean createFromParcel(Parcel source) {
            return new AdviceBean(source);
        }

        @Override
        public AdviceBean[] newArray(int size) {
            return new AdviceBean[size];
        }
    };
}
