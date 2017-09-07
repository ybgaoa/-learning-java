package com.creation.model.factorymethodmodel.factory;

import com.creation.model.factorymethodmodel.file.ExportFile;
import com.creation.model.factorymethodmodel.file.ExportFinancialHtmlFile;
import com.creation.model.factorymethodmodel.file.ExportStandardHtmlFile;

public class ExportHtmlFactory implements ExportFactory {

	public ExportFile factory(String type) {
		// TODO Auto-generated method stub
		if("standard".equals(type)){
			return new ExportStandardHtmlFile();
		}else if("financial".equals(type)){
			return new ExportFinancialHtmlFile();
		}else{
            throw new RuntimeException("没有找到对象");
        }
	}

}
