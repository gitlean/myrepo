package test.bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import test.entity.Info;

public class LazyInfoDataModel extends LazyDataModel<Info>
{ 
    private List<Info> list;
    
    public LazyInfoDataModel(){}
    
    @Override
    public List<Info> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters)
    {
    	
    	System.out.println("load...\tfirst:"+first+"\tpageSize:"+pageSize+"\tsortField:"+sortField+"\tfilters"+filters);
        //这个方法不光可以实现分页，也可以实现过滤与排序
        /*我们暂时只实现简单的分页，
          first代表起始位置，pageSize代表查询数量，其他参数可以暂时不管，这两个参数就可以实现分页功能要查询出数据与数量
        */
    	//first要显示的记录下标，从0开始；pagesize是本页要显示的记录数
    	
    	
    	int rowsCount=100;
        setRowCount(rowsCount); //这个方法一定要执行! 设置展示的行数  总共
        
        list = new ArrayList<Info>();
        
        
        //这里模拟访问数据库
        for(int i=first;i<=(first+pageSize);i++){
        	Info ins=new Info();
        	ins.setId(i);
        	ins.setTitle("title"+i);
        	ins.setTime(new Date());
        	list.add(ins);
        }
        
        
        return list;
    }
    
    @Override  
    public Info getRowData(String rowKey) 
    {  
        for(Info info : list) 
        {  
            if(info.getId().toString().equals(rowKey))  
            {
                return info; 
            }   
        }  
  
        return null;  
    }  
    
    @Override  
    public Object getRowKey(Info info) 
    {  
        return info.getId();  
    } 
}
