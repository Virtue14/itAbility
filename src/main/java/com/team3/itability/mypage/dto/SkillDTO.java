package com.team3.itability.mypage.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "skill_dto")
@Table(name = "skill")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SkillDTO {
    @Id
    @Column(name = "skill_id")
    private Integer skillId;
    @Column(name = "skill_name")
    private String skillName;
}
