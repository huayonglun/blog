package boke.service;

import java.util.List;

import boke.po.ResourceType;

public interface ResourceTypeManager {
	
	//����һ����Դ����
	boolean insertResourceType(String rtname);
	
	//������Դ����
	boolean updateResourceType(String old_rtname,String new_rtname);
	
	//ɾ����ǰ��Դ����
	boolean deleteResourceType(String rtname);
	
	//��ȡ��Դ�����б�
	List<ResourceType> getAll();
	
	//��ȡָ����Դ������Դ����
	ResourceType getResourceType(String rname);
	
	

}
