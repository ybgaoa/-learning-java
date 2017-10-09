package com.creation.model.prototypemodel.registrationprototypemodel.prototype;

public interface Prototype {
	public Prototype clone();
    public String getName();
    public void setName(String name);
}
