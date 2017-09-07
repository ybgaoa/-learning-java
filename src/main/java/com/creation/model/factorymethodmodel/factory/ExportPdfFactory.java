package com.creation.model.factorymethodmodel.factory;

import com.creation.model.factorymethodmodel.file.ExportFile;
import com.creation.model.factorymethodmodel.file.ExportFinancialPdfFile;
import com.creation.model.factorymethodmodel.file.ExportStandardPdfFile;

public class ExportPdfFactory implements ExportFactory {

	public ExportFile factory(String type) {
		// TODO Auto-generated method stub
		if("standard".equals(type)){  
            return new ExportStandardPdfFile();          
        }else if("financial".equals(type)){      
            return new ExportFinancialPdfFile();       
        }else{
            throw new RuntimeException("没有找到对象");
        }
	}

}
