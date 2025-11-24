package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.dto.response.dtoSaved.dtoSaveVocabulary;
import com.learning.lvtn_backend.entity.UserSavedVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedVocabularyRepository extends JpaRepository<UserSavedVocabulary, Integer> {
   @Query(value = """
        SELECT lv.word AS word,
        lv.meaning AS meaning,
        lv.audio_url AS audio_url,
        lv.pronunciation AS pronunciation,
        sa.saved_at AS saved_at
        FROM user_saved_vocabulary sa 
        JOIN  lesson_vocabulary lv ON sa.id_Vocab = lv.id_Vocabulary
        WHERE sa.id_User = :userId
        """,nativeQuery = true)
    List<dtoSaveVocabulary> findVocabByUserID(@Param("userId") int userId);

}
