package com.creation.model.factorymethodmodel;

import com.creation.model.factorymethodmodel.factory.ExportFactory;
import com.creation.model.factorymethodmodel.factory.ExportHtmlFactory;
import com.creation.model.factorymethodmodel.file.ExportFile;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "";
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory("financial");
        ef.export(data);
	}

}
