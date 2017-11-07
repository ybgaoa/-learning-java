package com.behavioral.model.mementomodel;
/*发起者对象：负责创建一个备忘录来记录当前对象的内部状态，并可使用备忘录恢复内部状态。 */
public class MemoRole {
	private int useTime;// 使用时间
	private String deviceName;// 设备名称
	private int stateLevel;// 状态

	public MemoRole(String deviceName, int useTime, int stateLevel) {
		super();
		this.useTime = useTime;
		this.deviceName = deviceName;
		this.stateLevel = stateLevel;
	}

	public MemoRole() {
	}

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

	public MemoBean createMemoObject() {
		MemoBean memento = new MemoBean();
		memento.setDeviceName(deviceName);
		memento.setStateLevel(stateLevel);
		memento.setUseTime(useTime);
		return memento;
	}

	public void setMemento(MemoBean memento) {
		this.deviceName = memento.getDeviceName();
		this.stateLevel = memento.getStateLevel();
		this.useTime = memento.getUseTime();
	}

	/**
	 * 获取对象当前状态
	 * @description：
	 * @author ldm
	 * @date 2016-1-22 下午12:15:09
	 */
	public void getCurrentState() {
		System.out.println("当前设备名称：" + this.deviceName + "当前使用时间：" + this.useTime + "当前工作状态：" + this.stateLevel);
	}
}
