package test.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import test.entity.Info;
import test.service.InfoEntityService;

//implements InfoEntityService
public class InfoEntityServiceImp implements InfoEntityService {

	public LazyDataModel<Info> getData(final String queryKey) {// 注意修饰符是final
		// TODO Auto-generated method stub

		LazyDataModel<Info> lazyModel = new LazyDataModel<Info>() {
			public List<Info> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				System.out.println("load...\tfirst:" + first + "\tpageSize:" + pageSize + "\tsortField:" + sortField
						+ "\tfilters" + filters);
				List<Info> list = new ArrayList<Info>();
				
				//checksize     比较这次参数和上次参数是否一样，若果不是则 checksize=true
				// if checksize == true 
				//     setRowCount
				
				setRowCount(78);
				
				for (int i = first; i < getRowCount(); i++) {
					Info ins = new Info();
					ins.setId(i);
					ins.setTitle(queryKey + i);
					ins.setTime(new Date());
					list.add(ins);
				}

				return list;

			}

		};

		//lazyModel.setPageSize(20);
		// lazyModel.setRowCount(23);
		return lazyModel;

	}

}
