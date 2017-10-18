package test.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.LazyDataModel;

import test.entity.Info;
import test.service.InfoEntityService;
import test.service.imp.InfoEntityServiceImp;

@ManagedBean(name="infoBean")
@SessionScoped
public class InfoBean implements Serializable
{
    private LazyDataModel<Info> lazyModel = new LazyInfoDataModel();
   
	//private LazyDataModel<Info> lazyModel =null;
    
    //һ����ע���
    private InfoEntityService service=new InfoEntityServiceImp();
    
    private String keyword;
    
    
    public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public LazyDataModel<Info> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Info> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    
    // service
    public void queryAction(){
    	System.out.println("queryAction"+"\t keyword:"+this.keyword);
    	
    	//������Bean�ж���һ��MAP�����ڽ���View�����Ĳ���
    	
    	
    	//SECS�˴����˷�װ 
    	//lazyModel=new PageableData<Info>("serviceIMP","Method","map");
    	
    	
    	
    	
    	lazyModel=service.getData(keyword);
    	
    	
    }
  
}
