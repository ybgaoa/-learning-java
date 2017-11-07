package com.behavioral.model.mementomodel;
/*备忘录对象：负责存储发起者对象的内部状态，并防止其他对象访问备忘录。 */
public class MemoBean {
	private int useTime;//使用时间
    private String deviceName;//设备名称
    private int stateLevel;//状态
    public int getUseTime() {
        return useTime;
    }
    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public int getStateLevel() {
        return stateLevel;
    }
    public void setStateLevel(int stateLevel) {
        this.stateLevel = stateLevel;
    }
}
