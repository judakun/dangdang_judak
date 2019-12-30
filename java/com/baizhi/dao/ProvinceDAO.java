package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Province;
import com.baizhi.entity.Scenic;

public interface ProvinceDAO {
	//��ѯ����ʡ�ݵ���Ϣ
	List<Province> showAllPro();
	int CountProvince(int p_id);
	boolean addProvince(Province pro);
	//ɾ��ʡ�ݣ��Ƚ����ڸ�ʡ�ݵľ����Ӧ��id�ÿ�
	boolean ScniceIdNull(int id);
	boolean deleteProvince(int id);
	boolean updateProvince(Province pro);
	//��ѯʡ�ݶ�Ӧ�����о���
	List<Scenic> ScenicList(int p_id);
	//���ݾ���idɾ��
	boolean deleteScenic(int s_id);
	//��Ӿ��㣬��ѯ���е�ʡ����Ϣ
	List<Province> allScenicPro();
	//��Ӿ���
	boolean addScenic(Scenic scenic);
	//���ݾ���id��ѯ����������Ϣ
	Scenic selectById(int s_id);
	boolean updateScenic(Scenic scenic);
	
}
