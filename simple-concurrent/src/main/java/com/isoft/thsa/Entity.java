package com.isoft.thsa;

class Entity {
	private int num;

	public Entity(){
		
	}
	public Entity(int num){
		this.num=num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void addone(){
		int temp=this.getNum();
		temp++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setNum(temp);
	}
	
	
	public void minone(){
		int temp=this.getNum();
		temp--;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setNum(temp);
	}

}

class OperatorEntity implements Runnable{
	private Entity entity;
	
	public OperatorEntity(Entity entity){
		this.entity=entity;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(entity){
			entity.addone();
			entity.minone();
		}
		
	}
	
	
}

