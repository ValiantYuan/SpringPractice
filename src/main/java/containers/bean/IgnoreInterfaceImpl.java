package containers.bean;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class IgnoreInterfaceImpl {
	@Resource
	private ArrayList<String> list;
	
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public void print() {
		System.out.println(list);
	}
}
