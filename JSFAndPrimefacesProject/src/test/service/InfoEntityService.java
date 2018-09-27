package test.service;

import org.primefaces.model.LazyDataModel;

import test.entity.Info;

public interface InfoEntityService {
	public LazyDataModel<Info> getData(String queryKey);

}
