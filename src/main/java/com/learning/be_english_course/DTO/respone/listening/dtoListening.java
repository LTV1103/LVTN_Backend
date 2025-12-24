package com.learning.be_english_course.DTO.respone.listening;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dtoListening {
    private Long listeningId;
    private String audioUrl;
    private String transcrip;
}
