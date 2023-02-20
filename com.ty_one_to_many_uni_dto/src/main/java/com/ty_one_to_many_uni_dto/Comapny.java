package com.ty_one_to_many_uni_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Comapny {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	public int getCid() {
		return cid;
	}
	@Override
	public String toString() {
		return "Comapny [cid=" + cid + ", company_name=" + company_name + ", gst=" + gst + ", list=" + list + "]";
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
	private String company_name;
	private String gst;
	@OneToMany
	private List<Employee>list;
	
}
