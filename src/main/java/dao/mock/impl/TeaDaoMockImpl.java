package dao.mock.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import entities.Tea;
import sitehei.dao.TeaDao;

public class TeaDaoMockImpl implements TeaDao{


	private TreeMap<Integer, Tea> teaList;

	public TeaDaoMockImpl() {
		teaList = new TreeMap<>();
		teaList.put(1, new Tea(2,"Salon Marseille",LocalDate.of(2020, 10, 12),240 ));

	}

	@Override
	public List<Tea> listTea() {
		return new ArrayList<>(teaList.values());
	}

	@Override
	public Tea getTea(Integer id) {
		return teaList.get(id);
	}

	@Override
	public Tea addTea(Tea tea) {
		Integer id = teaList.lastKey() + 1;
		tea.setId(id);
		teaList.put(id, tea);
		return tea;
	}
	@Override
	public Tea getRandomTea() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
