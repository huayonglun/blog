package boke.service.impl;

import java.util.List;

import boke.po.ResourceType;
import boke.service.ResourceTypeManager;
import boke.service.util.ManagerTemplate;

public class ResourceTypeManagerImpl extends ManagerTemplate implements ResourceTypeManager {


	/**
	 * ������Դ����
	 * @param rtname  ������
	 * @return 
	 */
	@Override
	public boolean insertResourceType(String rtname) {
	
		try{
			ResourceType rt=new ResourceType();
			rt.setRtname(rtname);
			this.resourceTypeDao.save(rt);
			return true;
		}catch(Exception e){
			return false;
		}
		

	}

	/**
	 * ������������ȡ��Դ����
	 * @param rtname  ������
	 */
	@Override
	public ResourceType getResourceType(String rname) {
		
		return this.resourceTypeDao.get(rname);
	}
	
	/**
	 * ������Դ����
	 * @param old_rtname  ��������
	 * @param new_rtname  ��������
	 */
	@Override
	public boolean updateResourceType(String old_rtname, String new_rtname) {
		if(deleteResourceType(old_rtname)&&insertResourceType(new_rtname))
			return true;
		return false;
		

	}

	/**
	 * ɾ����Դ����
	 * @param rtname  ������
	 */
	@Override
	public boolean deleteResourceType(String rtname) {
		try{
			ResourceType rt=getResourceType(rtname);
			this.resourceTypeDao.delete(rt);
			return true;
		}catch(Exception e){
			return false;
		}
		

	}

	/**
	 * ��ȡ��Դ�����б�
	 * 
	 */
	@Override
	public List<ResourceType> getAll() {
		
		return this.resourceTypeDao.getAll();
	}

	

}
