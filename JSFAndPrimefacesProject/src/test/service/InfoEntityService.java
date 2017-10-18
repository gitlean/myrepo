package test.service;

import java.util.List;

import org.primefaces.model.LazyDataModel;

import test.bean.LazyInfoDataModel;
import test.entity.Info;

public interface InfoEntityService {
	public LazyDataModel<Info> getData(String queryKey);

}
