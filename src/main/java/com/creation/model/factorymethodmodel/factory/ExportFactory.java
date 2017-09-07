package com.creation.model.factorymethodmodel.factory;

import java.io.Serializable;

import com.creation.model.factorymethodmodel.file.ExportFile;

public interface ExportFactory extends Serializable {
	public ExportFile factory(String type);
}
