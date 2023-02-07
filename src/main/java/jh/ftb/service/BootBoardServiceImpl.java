package jh.ftb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jh.ftb.entity.BootBoard;
import jh.ftb.repository.BootBoardRepository;

@Service
public class BootBoardServiceImpl implements BootBoardService{

	@Autowired
	BootBoardRepository bootBoardRepository;
	
	@Override
	public List<BootBoard> getLists() {
		List<BootBoard> list = bootBoardRepository.findAll();
		return list;
	}
	
	@Override
	public void register(BootBoard vo) {
		bootBoardRepository.save(vo);
	}
	
	@Override
	public BootBoard get(Long idx) {
		Optional<BootBoard> vo = bootBoardRepository.findById(idx);
		return vo.get();
	}
	
	@Override
	public void delete(Long idx) {
		bootBoardRepository.deleteById(idx);
		
	}
	
	@Override
	public void modify(BootBoard vo) {
		bootBoardRepository.save(vo);  // insert  vo가 있으면 insert 없으면 update로
	}
	
}
