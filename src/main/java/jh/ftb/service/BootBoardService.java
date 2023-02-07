package jh.ftb.service;

import java.util.List;

import jh.ftb.entity.BootBoard;

public interface BootBoardService {

	public List<BootBoard> getLists();
	
	public void register(BootBoard vo);
	
	public BootBoard get(Long idx);
	
	public void delete(Long idx);
	
	public void modify(BootBoard vo); //수정
}
