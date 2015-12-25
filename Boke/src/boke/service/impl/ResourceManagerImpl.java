package boke.service.impl;

import java.util.List;

import boke.po.Resource;
import boke.po.ResourceType;
import boke.service.ResourceManager;
import boke.service.util.ManagerTemplate;

public class ResourceManagerImpl extends ManagerTemplate implements ResourceManager {

	/**
	 * ������Դ��Ϣ
	 * @param rname ��Դ��
	 * @param uploader �ϴ���
	 * @param uploaddate �ϴ�����
	 * @param rtname ��Դ��������
	 */
	@Override
	public boolean insertResource(String rname, String uploader, String uploaddate, String rtname) {
		ResourceType rt=this.resourceTypeDao.get(rtname);
		if(rt!=null){
			Resource resource=new Resource();
			resource.setRname(rname);
			resource.setUploader(uploader);
			resource.setUploaddate(uploaddate);
			resource.setResourcetype(rt);
			this.resourceDao.save(resource);
			return true;
		}
		return false;
	}

	/**
	 * ɾ��ָ����Դ������Դ
	 * @param rname ��Դ��
	 */
	@Override
	public boolean deleteResource(String rname) {
		Resource r=this.resourceDao.get(rname);
		if(r!=null){
			this.resourceDao.delete(r);
			return true;
		}
		
		return false;
	}

	/**
	 * ��ȡȫ����Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getAll() {
		
		return this.resourceDao.getAll();
	}

	/**
	 * ��ȡָ���ϴ��ߵ���Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getResourcesByUploader(String uploaderName) {
		
		return this.resourceDao.getResourcesByUploader(uploaderName);
	}

	/**
	 * ��ȡ�ӽ���Դ������Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getResourcesByName(String searchName) {
		
		return this.resourceDao.getResourcesByName(searchName);
	}
	
	
	/**
	 * ��ȡָ�����͵���Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getResourcesByType(String typeName) {
		
		ResourceType rt=this.resourceTypeDao.get(typeName);
		if(rt!=null)
			return this.resourceDao.getResourcesByType(rt);
		return null;
	}

	

}
