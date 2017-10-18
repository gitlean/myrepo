package test.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import test.bean.LazyInfoDataModel;
import test.entity.Info;
import test.service.InfoEntityService;

//implements InfoEntityService
public class InfoEntityServiceImp implements InfoEntityService {


	public LazyDataModel<Info> getData(String queryKey) {
		// TODO Auto-generated method stub

		LazyDataModel<Info> lazyModel = new LazyDataModel<Info>() {
			public List<Info> load(int first, int pageSize, String sortField,
					SortOrder sortOrder, Map<String, Object> filters) {
				System.out.println("load...\tfirst:"+first+"\tpageSize:"+pageSize+"\tsortField:"+sortField+"\tfilters"+filters);
				List<Info>  list = new ArrayList<Info>();
				  for(int i=first;i<=(first+pageSize);i++) {
					Info ins = new Info();
					ins.setId(i);
					ins.setTitle(queryKey + i);
					ins.setTime(new Date());
					list.add(ins);
				}

				return list;

			}

		};
		lazyModel.setPageSize(10);
		lazyModel.setRowCount(23);
		return lazyModel;

	}

}
