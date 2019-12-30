package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Province;
import com.baizhi.entity.Scenic;

public interface ProvinceDAO {
	//查询所有省份的信息
	List<Province> showAllPro();
	int CountProvince(int p_id);
	boolean addProvince(Province pro);
	//删除省份，先将属于该省份的景点对应的id置空
	boolean ScniceIdNull(int id);
	boolean deleteProvince(int id);
	boolean updateProvince(Province pro);
	//查询省份对应的所有景点
	List<Scenic> ScenicList(int p_id);
	//根据景点id删除
	boolean deleteScenic(int s_id);
	//添加景点，查询所有的省份信息
	List<Province> allScenicPro();
	//添加景点
	boolean addScenic(Scenic scenic);
	//根据景点id查询景点所有信息
	Scenic selectById(int s_id);
	boolean updateScenic(Scenic scenic);
	
}
