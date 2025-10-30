package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_saved_vocabulary")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSavedVocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Saved")
    int idSaved;

    @Column(name = "id_User")
    int idUser;

    @Column(name = "id_Vocab")
    int idVocab;

    @Column(name = "saved_at")
    LocalDateTime savedAt;
}
