package com.learning.lvtn_backend.dto.response.dtoSaved;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoSaveVocabulary {
    String word;
    String meaning;
    String audio_url;
    String pronunciation;
    Timestamp saved_at;
}

