package com.team3.itability.recruitment.service;

import com.team3.itability.mypage.dao.SkillDAO;
import com.team3.itability.mypage.dto.SkillDTO;
import com.team3.itability.recruitment.dao.RecruitCateRepo;
import com.team3.itability.recruitment.dao.RecruitRepo;
import com.team3.itability.recruitment.dto.RecruitCategoryDTO;
import com.team3.itability.recruitment.dto.RecruitDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruitService {

    private final ModelMapper mapper;
    private final RecruitRepo recruitRepo;
    private final RecruitCateRepo recruitCateRepo;
    private final SkillDAO skillRepo;

    @Autowired
    public RecruitService(ModelMapper mapper, RecruitRepo recruitRepo, RecruitCateRepo recruitCateRepo, SkillDAO skillRepo) {
        this.mapper = mapper;
        this.recruitRepo = recruitRepo;
        this.recruitCateRepo = recruitCateRepo;
        this.skillRepo = skillRepo;
    }

    // 모집군 카테고리 조회
    @Transactional(readOnly = true)
    public List<RecruitCategoryDTO> findAllRecruitCategory() {
        List<RecruitCategoryDTO> recruitCategoryList = recruitCateRepo.findAll();

        return recruitCategoryList.stream().map(recruit -> mapper.map(recruit, RecruitCategoryDTO.class)).collect(Collectors.toList());
    }

    // 기술 카테고리 조회
    // mypage SkillDAO 사용
    @Transactional(readOnly = true)
    public List<SkillDTO> findAllSkill() {
        List<SkillDTO> skillList = skillRepo.findAll();

        return skillList.stream().map(recruit -> mapper.map(recruit, SkillDTO.class)).collect(Collectors.toList());
    }

    // 모집글 등록
    @Transactional
    public void registRecruit(RecruitDTO recruit) {
        recruitRepo.save(mapper.map(recruit, RecruitDTO.class));
    }

    // 모집글 수정
    @Transactional
    public void modifyRecruit(RecruitDTO recruit) {
        RecruitDTO foundRecruit = recruitRepo.findById(recruit.getRecruitId()).orElseThrow(IllegalAccessError::new);

        foundRecruit.setRecruitType(recruit.getRecruitType());
        foundRecruit.setRecruitTitle(recruit.getRecruitTitle());
        foundRecruit.setRecruitContent(recruit.getRecruitContent());
    }

    // 모집글 삭제
    @Transactional
    public void deleteRecruit(int recruitId) {
        recruitRepo.deleteById(recruitId);
    }

    // 모집글 목록
    @Transactional(readOnly = true)
    public List<RecruitDTO> findRecruitList() {
        List<RecruitDTO> recruitList = recruitRepo.findAll();

        return recruitList.stream().map(recruit -> mapper.map(recruit, RecruitDTO.class)).collect(Collectors.toList());
    }

    // 모집글 필터

    // 모집글 상세 페이지
    @Transactional(readOnly = true)
    public RecruitDTO findRecruitById(int recruitId) {
        RecruitDTO recruit = recruitRepo.findById(recruitId).orElseThrow(IllegalArgumentException::new);

        return mapper.map(recruit, RecruitDTO.class);
    }

}
