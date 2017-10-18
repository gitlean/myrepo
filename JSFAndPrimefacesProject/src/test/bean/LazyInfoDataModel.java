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
        //��������������ʵ�ַ�ҳ��Ҳ����ʵ�ֹ���������
        /*������ʱֻʵ�ּ򵥵ķ�ҳ��
          first������ʼλ�ã�pageSize�����ѯ��������������������ʱ���ܣ������������Ϳ���ʵ�ַ�ҳ����Ҫ��ѯ������������
        */
    	//firstҪ��ʾ�ļ�¼�±꣬��0��ʼ��pagesize�Ǳ�ҳҪ��ʾ�ļ�¼��
    	
    	
    	int rowsCount=100;
        setRowCount(rowsCount); //�������һ��Ҫִ��! ����չʾ������  �ܹ�
        
        list = new ArrayList<Info>();
        
        
        //����ģ��������ݿ�
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
